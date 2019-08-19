FROM confluentinc/cp-kafka-connect:5.2.1

# Copy connector templates
COPY connector-config /connector-config

# Copy libraries
COPY build/drivers-download/ /usr/share/java/kafka-connect-jdbc/
COPY build/drivers-download/ /usr/share/java/kafka-connect-couchbase/

# Copy custom connector scripts
COPY scripts/entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh
COPY scripts/updateConnectorPlugin.sh updateConnectorPlugin.sh
RUN chmod +x updateConnectorPlugin.sh

# Setup prometheus exporter configuration
RUN mkdir -p /prometheus-config
COPY config/prometheus-config.yml /prometheus-config/prometheus-config.yml
COPY config/prometheus-logging.properties /prometheus-config/prometheus-logging.properties

ENTRYPOINT ["/entrypoint.sh"]
