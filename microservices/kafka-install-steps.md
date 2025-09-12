## Kafka Install

- Setup user permission(Docker)

```bash
sudo usermod -aG docker $USER && newgrp docker

```

- Pull docker image
```bash

docker pull apache/kafka:4.1.0  

```

- Run Kafka Container

```bash

docker run -p 9092:9092 -d --name kafka-container apache/kafka:4.1.0

```

- From next time 

```bash

docker start kafka-container

```

## Create a topic

```bash 

kafka-topics --create --topic order-events \
    --partitions 3 \
    --bootstrap-server localhost:9092

```

## Create a Producer

```bash

kafka-console-producer --topic order-events \
                      --bootstrap-server localhost:9092

```

## Create a Consumer

```bash

kafka-console-consumer --topic order-events \
                      --bootstrap-server localhost:9092

```


## Kafka docker with custom configuration

```bash

docker run -d --name kafka-container \
  -p 30092:9092 -p 30093:9093 \
  -e KAFKA_PROCESS_ROLES=broker,controller \
  -e KAFKA_NODE_ID=1 \
  -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092,CONTROLLER://0.0.0.0:9093 \
  -e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT \
  -e KAFKA_CONTROLLER_LISTENER_NAMES=CONTROLLER \
  -e KAFKA_CONTROLLER_QUORUM_VOTERS=1@localhost:9093 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:30092 \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  apache/kafka:4.1.0


```

```bash

docker run -d --name kafka-container2 \
  -p 30095:9092 -p 30094:9094 \
  -e KAFKA_PROCESS_ROLES=broker,controller \
  -e KAFKA_NODE_ID=1 \
  -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092,CONTROLLER://0.0.0.0:9093 \
  -e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT \
  -e KAFKA_CONTROLLER_LISTENER_NAMES=CONTROLLER \
  -e KAFKA_CONTROLLER_QUORUM_VOTERS=1@localhost:9093 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:30092 \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  apache/kafka:4.1.0

```


## Kubernetes Deployment

```yaml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: kafka-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: kafka
  template:
    metadata:
      labels:
        app: kafka
    spec:
      containers:
        - name: kafka
          image: apache/kafka:4.1.0
          ports:
            - containerPort: 9092
          env:
            - name: KAFKA_PROCESS_ROLES
              value: "broker,controller"
            - name: KAFKA_NODE_ID
              value: "1"
            - name: KAFKA_LISTENERS
              value: "PLAINTEXT://0.0.0.0:9092,CONTROLLER://0.0.0.0:9093"
            - name: KAFKA_LISTENER_SECURITY_PROTOCOL_MAP
              value: "CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT"
            - name: KAFKA_CONTROLLER_LISTENER_NAMES
              value: "CONTROLLER"
            - name: KAFKA_CONTROLLER_QUORUM_VOTERS
              value: "1@localhost:9093"
            - name: KAFKA_ADVERTISED_LISTENERS
              value: "PLAINTEXT://localhost:30092"
            - name: KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR
              value: "1"

```


## Kubernetes Service

```yaml
apiVersion: v1
kind: Service
metadata:
  name: kafka-service
spec:
  selector:
    app: kafka
  ports:
    - protocol: TCP
      port: 9092
      targetPort: 9092
      nodePort: 30092
      
  type: LoadBalancer

```