#Prepare

If changes have been made to the schema, regenerate Avro
* generateAvro

* copyTask

* build

#Examples 

See each individual class named md file explaining how to run.

### Topology VM params

``` -Djava.util.logging.config.file=./prometheus-config/prometheus-logging.properties
  -Dcom.sun.management.jmxremote
  -Dcom.sun.management.jmxremote.authenticate=false
  -Dcom.sun.management.jmxremote.ssl=false
  -javaagent:./prometheus-config/jmx_prometheus_javaagent.jar=8080:./prometheus-config/prometheus-config.yml
```
