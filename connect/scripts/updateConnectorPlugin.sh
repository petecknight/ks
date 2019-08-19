#!/bin/bash -e

if [ $# -eq 0 ]
  then
    echo "Usage: updateConnectorPlugin <<connector>>"
    exit 1
fi

echo "CONNECT_REST_HOST_NAME = $CONNECT_REST_HOST_NAME"
echo "CONNECT_REST_ADVERTISED_PORT = $CONNECT_REST_ADVERTISED_PORT"


CONNECTOR_NAME=$1
CONNECTOR_CONFIG_DIR=connector-config
CONNECTOR_ENDPOINT=http://$CONNECT_REST_HOST_NAME:$CONNECT_REST_ADVERTISED_PORT/connectors/$CONNECTOR_NAME/config

echo "CONNECTOR_ENDPOINT = $CONNECTOR_ENDPOINT"

curl --silent --write-out "HTTPSTATUS:%{http_code}" -X PUT $CONNECTOR_ENDPOINT -H 'Content-Type: application/json' -H 'Accept: application/json' --data '@/'"$CONNECTOR_CONFIG_DIR"'/'"$CONNECTOR_NAME"'.json'