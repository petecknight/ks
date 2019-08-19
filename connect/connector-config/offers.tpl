{
  "connector.class": "com.couchbase.connect.kafka.CouchbaseSourceConnector",
  "dcp.message.converter.class": "com.couchbase.connect.kafka.handler.source.RawJsonSourceHandler",
  "value.converter": "org.apache.kafka.connect.converters.ByteArrayConverter",
  "tasks.max": 1,
  "topic.name": "_topic_",
  "connection.cluster_address": "_connection_",
  "connection.timeout.ms": "2000",
  "connection.bucket": "_bucket_",
  "connection.username": "_username_",
  "connection.password": "_password_",
  "use_snapshots": "false",
  "event.filter.class": "uk.sky.csp.connect.kafka.filter.TitleOffersFilter",
  "couchbase.stream_from": "SAVED_OFFSET_OR_BEGINNING",
  "couchbase.compression": "ENABLED",
  "couchbase.flow_control_buffer": "128m",
  "couchbase.persistence_polling_interval": "100ms",
  "errors.retry.timeout": "-1",
  "errors.retry.delay.max.ms": "30000",
  "errors.log.enable": "true",
  "errors.log.include.messages": "false",
  "errors.tolerance": "all"
}