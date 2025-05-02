# simple-kafka-listener

This is a simple project demonstrating a Kafka listener using `spring-kafka`. It serves as an experimental setup to interact with a Kafka broker and its listener capabilities within a Spring Boot application.

The environment utilizes Docker Compose to easily set up:

- A Kafka broker running in **KRaft mode** (without ZooKeeper), configured with both `broker` and `controller` roles.
- **Kafka UI (by Provectus)** for visualizing Kafka topics, messages, consumers, and cluster information.

## Prerequisites

Before you begin, ensure you have the following installed:

- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/products/docker-desktop/)
- [Docker Compose](https://docs.docker.com/compose/install/) (Usually included with Docker Desktop)
- [Java Development Kit (JDK)](https://adoptium.net/) (Version compatible with the Spring Boot project, e.g., 17+)
- [Maven](https://maven.apache.org/download.cgi) or use the Maven Wrapper (`./mvnw`) included in the project.

## Getting Started

Follow these steps to get the project running:

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/prathmeshthorat/simple-kafka-listener.git
    cd simple-kafka-listener
    ```

2.  **Start Kafka and Kafka UI:**
    This command will build and start the Kafka broker (KRaft mode) and the Kafka UI service defined in the `docker-compose.yml` file.

    ```bash
    docker compose up -d
    ```

    _Wait a moment for the containers to initialize._

3.  **Start the Spring Boot Application:**
    Navigate to the root directory of the cloned project (where `pom.xml` or `build.gradle` is located) and run the application. This will start the Kafka listener.

    _Using Maven Wrapper:_

    ```bash
    ./mvnw spring-boot:run
    ```

    _Or using installed Maven:_

    ```bash
    mvn spring-boot:run
    ```

    _Alternatively, build and run the JAR:_

    ```bash
    # Build the project (e.g., using Maven)
    ./mvnw clean
    ```
## Usage

Once the Kafka cluster, Kafka UI, and the Spring Boot listener application are running:

1.  **Access Kafka UI:**
    Open your web browser and navigate to:
    [http://localhost:8088](http://localhost:8088)

2.  **Explore:**
    Use Kafka UI to:
    * View the Kafka cluster configuration.
    * Create or inspect topics.
    * Observe consumer groups (including the one used by the Spring Boot listener).
    * Produce and consume messages manually if needed.

## Technology Stack

* Spring Boot / Spring Kafka
* Apache Kafka (running in KRaft mode via Docker)
* Kafka UI (Provectus)
* Docker & Docker Compose
* Java
* Maven (or Gradle, depending on the project setup)
