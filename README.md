# Monitoring Demo

A simple Spring Boot based application to demonstrate the power of Elasticsearch, Kibana, Elastic APM and Elastic Beats

## Requirements

- Java 11
- Docker

## Build docker image

- Windows: `gradlew.bat jibDockerBuild`
- Linux/Mac:`./gradlew jibDockerBuild`

## Set up

```
$ cd misc/docker/full
$ docker-compose up -d    
```

This will start all the necessary services also create volumes and networks. The services will be available following urls:

|       Service       |                                   url                                   | user    | password |
|:-------------------:|:-----------------------------------------------------------------------:|---------|----------|
| Kibana              | http://kibana.localhost:8080/                                           | elastic | password |
| Elasticsearch       | http://elasticsearch.localhost:8080/                                    | elastic | password |
| Monitoring Demo api | http://api.localhost:8080/swagger-ui/ http://localhost:8080/swagger-ui/ |    -    |     -    |
| Postgres            | jdbc:postgresql://localhost:5432/me                                     | me      | password |

## Test with JMeter

Just simple download and start JMeter and open the `misc/MonitoringAppTest.jmx` file with it, and hit run. This will create a lot of transaction that will be visible in Elastic APM

## Some reading material

- https://www.elastic.co/apm
- https://www.elastic.co/guide/en/apm/agent/java/current/index.html
- https://www.elastic.co/beats/
- https://www.elastic.co/guide/en/beats/metricbeat/current/metricbeat-modules.html