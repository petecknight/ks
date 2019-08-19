#!/bin/bash -e

# Enables job control
set -m

# Run the server and send it to the background
/entrypoint.sh couchbase-server &

# Check if couchbase server is up
check_db() {
  curl --silent http://127.0.0.1:8091/pools > /dev/null
  echo $?
}

# Variable used in echo
i=1
log() {
  echo "[${i}] [$(date +"%T")] $@"
  i=`expr ${i} + 1`
}

# Wait until it's ready
until [[ $(check_db) = 0 ]]; do
  >&2 log "Waiting for Couchbase Server to be available"
  sleep 1
done

# Setup index and memory quota
echo "$(date +"%T") Initializing cluster"
couchbase-cli cluster-init --cluster 127.0.0.1 --cluster-username ${USERNAME} --cluster-password ${PASSWORD} --cluster-name ofs-cluster --cluster-ramsize 1024 --cluster-index-ramsize 512 --services data,index,query,fts --index-storage-setting default

# Create the buckets
echo "$(date +"%T") Creating buckets"
couchbase-cli bucket-create --cluster 127.0.0.1 --username ${USERNAME} --password ${PASSWORD} --bucket-type couchbase --bucket-ramsize 250 --bucket ofs-data --enable-flush=0
couchbase-cli bucket-create --cluster 127.0.0.1 --username ${USERNAME} --password ${PASSWORD} --bucket-type couchbase --bucket-ramsize 250 --bucket tds-data --enable-flush=0

# Create user
echo "$(date +"%T") Creating users"
couchbase-cli user-manage --cluster 127.0.0.1 --user ${USERNAME} --password ${PASSWORD} --set --rbac-username ofs-owner --rbac-password ofs-owner --rbac-name "OFS Owner" --roles admin,bucket_full_access[ofs-data] --auth-domain local
couchbase-cli user-manage --cluster 127.0.0.1 --user ${USERNAME} --password ${PASSWORD} --set --rbac-username tds-owner --rbac-password tds-owner --rbac-name "TDS Owner" --roles admin,bucket_full_access[tds-data] --auth-domain local

# Need to wait until query service is ready to process N1QL queries
log "$(date +"%T") Waiting"
sleep 20

# Create indexes
echo "$(date +"%T") Creating indexes"
cbq --user ${USERNAME} --password ${PASSWORD} --script "CREATE PRIMARY INDEX \`tds-data_idx\` ON \`tds-data\`;"
cbq --user ${USERNAME} --password ${PASSWORD} --script "CREATE INDEX \`tds-data_type_idx\` ON \`tds-data\`(type);"

echo "$(date +"%T") Done"
fg 1