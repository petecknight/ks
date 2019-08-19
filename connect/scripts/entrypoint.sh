#!/bin/bash -e

echo "Configuring and installing Connectors..."
echo "CONNECT_REST_HOST_NAME = $CONNECT_REST_HOST_NAME"
echo "CONNECT_REST_ADVERTISED_PORT = $CONNECT_REST_ADVERTISED_PORT"

HTTP_201_CREATED=201
HTTP_200_UPDATED=200

function push_config {

    until $(curl --output /dev/null --silent --head --fail http://$CONNECT_REST_HOST_NAME:$CONNECT_REST_ADVERTISED_PORT); do
        printf '.'
        sleep 5
    done

    CONNECTOR_CONFIG_DIR=connector-config

    for CONNECTOR in /"$CONNECTOR_CONFIG_DIR"/*
    do

        FILENAME=$(basename "$CONNECTOR")
        echo "Filename = $FILENAME"

        CONNECTOR_NAME="${FILENAME%.*}"
        echo "Connector Name = $CONNECTOR_NAME"

        CONNECTOR_ENDPOINT=http://$CONNECT_REST_HOST_NAME:$CONNECT_REST_ADVERTISED_PORT/connectors/$CONNECTOR_NAME/config
        echo "CONNECTOR_ENDPOINT = $CONNECTOR_ENDPOINT.."
        echo "Setting up $CONNECTOR_NAME.."

        PREFIX=$(echo $CONNECTOR_NAME | tr [a-z] [A-Z])

        CONNECTION=$(echo $"$PREFIX"_CONNECTION)
        USERNAME=$(echo "$PREFIX"_USERNAME)
        PASSWORD=$(echo "$PREFIX"_PASSWORD)
        TOPIC=$(echo "$PREFIX"_TOPIC)
        CONSUMER=$(echo "$PREFIX"_CONSUMER)
        BUCKET=$(echo "$PREFIX"_BUCKET)

        CONNECTION_TO_REPLACE=$(echo ${!CONNECTION})
        USERNAME_TO_REPLACE=$(echo ${!USERNAME})
        PASSWORD_TO_REPLACE=$(echo ${!PASSWORD})
        TOPIC_TO_REPLACE=$(echo ${!TOPIC})
        CONSUMER_TO_REPLACE=$(echo ${!CONSUMER})
        BUCKET_TO_REPLACE=$(echo ${!BUCKET})

        echo "Connection to be replaced is:  $CONNECTION_TO_REPLACE"
        echo "Username to be replaced is:  $USERNAME_TO_REPLACE"
        echo "Password to be replaced is:  $PASSWORD_TO_REPLACE"
        echo "Topic to be replaced is:  $TOPIC_TO_REPLACE"
        echo "Consumer to be replaced is:  $CONSUMER_TO_REPLACE"
        echo "Bucket to be replaced is:  $BUCKET_TO_REPLACE"

        awk -v connection="$CONNECTION_TO_REPLACE" \
            -v username="$USERNAME_TO_REPLACE" \
            -v password="$PASSWORD_TO_REPLACE" \
            -v topic="$TOPIC_TO_REPLACE" \
            -v consumer="$CONSUMER_TO_REPLACE" \
            -v bucket="$BUCKET_TO_REPLACE" \
            '{gsub("_connection_", connection, $0); \
            gsub("_username_", username, $0); \
            gsub("_password_", password, $0); \
            gsub("_topic_", topic, $0); \
            gsub("_consumer_", consumer, $0); \
            gsub("_bucket_", bucket, $0); \
            print}' /$CONNECTOR_CONFIG_DIR/$CONNECTOR_NAME.tpl > /$CONNECTOR_CONFIG_DIR/$CONNECTOR_NAME.json

        echo "Printing $CONNECTOR_NAME.json ...."
        echo "$(cat /$CONNECTOR_CONFIG_DIR/$CONNECTOR_NAME.json)"

        HTTP_RESPONSE=$(curl --silent --write-out "HTTPSTATUS:%{http_code}" -X PUT $CONNECTOR_ENDPOINT -H 'Content-Type: application/json' -H 'Accept: application/json' --data '@/'"$CONNECTOR_CONFIG_DIR"'/'"$CONNECTOR_NAME"'.json')
        rm -f /$CONNECTOR_CONFIG_DIR/$CONNECTOR_NAME.tpl

        HTTP_BODY=$(echo $HTTP_RESPONSE | sed -e 's/HTTPSTATUS\:.*//g')

        HTTP_STATUS=$(echo $HTTP_RESPONSE | tr -d '\n' | sed -e 's/.*HTTPSTATUS://')

        if [[ "$HTTP_STATUS" == $HTTP_201_CREATED ]] ; then
            echo "Created $CONNECTOR_NAME successfully.. [HTTP status: $HTTP_STATUS]"
        elif [[ "$HTTP_STATUS" == $HTTP_200_UPDATED ]] ; then
            echo "Updated $CONNECTOR_NAME successfully.. [HTTP status: $HTTP_STATUS]"
        else
            echo "Unable to configure $CONNECTOR_NAME, [HTTP status: $HTTP_STATUS]"
        fi

        echo "$HTTP_BODY"

    done
}

# Install Kafka Connect in the background
push_config &
exec /etc/confluent/docker/run