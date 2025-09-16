
## What is the ELK Stack?
The ELK stack consists of three primary components:

* **Elasticsearch:** A distributed, RESTful search and analytics engine that stores and indexes log data, making it searchable.
* **Logstash:** A data processing pipeline that ingests, transforms, and forwards log data from various sources to Elasticsearch.
* **Kibana:** A visualization and exploration tool that provides a web-based interface to search, view, and analyze logs stored in Elasticsearch.

## How ELK Stack Works
- **Log Generation:** The Spring Boot application generates logs, which are then formatted and transmitted to Logstash.
- **Log Ingestion by Logstash:** Logstash collects and processes the logs, then forwards them to Elasticsearch.
- **Log Storage in Elasticsearch:** Elasticsearch indexes and stores the logs, making them searchable.
- **Log Visualization in Kibana:** Kibana provides a web interface to explore and visualize the logs, creating dashboards and visualizations for better insights.​

# Implementing ELK Stack for Spring Boot Logs

## Step 1: Set Up ELK Stack Using Docker Compose


Create a `docker-compose.yml` file:

```yaml
version: '3.8'
services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.8.2
    environment:
      - discovery.type=single-node
      - xpack.security.enabled=false       # Disable security for local/dev
      - xpack.security.http.ssl.enabled=false
      - xpack.security.transport.ssl.enabled=false
    ports:
      - "9200:9200"
    volumes:
      - esdata:/usr/share/elasticsearch/data

  logstash:
    image: docker.elastic.co/logstash/logstash:8.8.2
    ports:
      - "5044:5044"
    volumes:
      - ./logstash/config/logstash.yml:/usr/share/logstash/config/logstash.yml
      - ./logstash/pipeline:/usr/share/logstash/pipeline

  kibana:
    image: docker.elastic.co/kibana/kibana:8.8.2
    ports:
      - "5601:5601"
    environment:
      ELASTICSEARCH_HOSTS: http://elasticsearch:9200
      XPACK_SECURITY_ENABLED: "false"

volumes:
  esdata:
```

Run the stack:

```bash
docker-compose up -d
```

***

## Step 2: Configure Logstash

Create directory structure for Logstash:

```bash
mkdir logstash
```

### Create logstash.conf
In the logstash directory, create a logstash.conf file with the following content:

```conf
input {
  tcp {
    port => 5044
    codec => json
  }
}

filter {
 
}

output {
  elasticsearch {
    hosts => ["http://elasticsearch:9200"]
    index => "spring-boot-logs-%{+YYYY.MM.dd}"
  }
  stdout {
    codec => rubydebug
  }
}
```

***

## Step 3: Configure Spring Boot Logging

Add Logstash Logback Encoder dependency to `pom.xml`:

```xml
<dependency>
    <groupId>net.logstash.logback</groupId>
    <artifactId>logstash-logback-encoder</artifactId>
    <version>8.1</version>
</dependency>
```

Create or replace `src/main/resources/logback-spring.xml`:

```xml
<configuration>
  <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
    <destination>localhost:5044</destination>
    <encoder class="net.logstash.logback.encoder.LogstashEncoder" />
  </appender>

  <root level="INFO">
    <appender-ref ref="LOGSTASH" />
  </root>
</configuration>
```

***

## Step 4: Start Spring Boot Application

Run your Spring Boot app normally.

Logs will be sent in **JSON format** over TCP to Logstash on port `5044`.

***

## Step 5: Access Logs in Kibana

- Open Kibana in browser: `http://localhost:5601`
- Go to **Management** > **Stack Management** > **Index Patterns**.
- Create an index pattern for:

  ```
  springboot-logs-*
  ```

- Set `@timestamp` as the time filter field.
- Navigate to **Discover** and select this pattern to view logs in real-time.

***

## Additional Recommendations

- **For production:** Enable Elasticsearch and Kibana security and use encrypted transport.
- Configure persistent volumes for Elasticsearch data.
- Use Filebeat or Logstash agents if you need more advanced log shipping.
- Set up alerting and dashboards in Kibana for monitoring.

***
