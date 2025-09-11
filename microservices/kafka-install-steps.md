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

