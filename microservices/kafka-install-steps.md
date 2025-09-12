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