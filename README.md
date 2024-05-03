# Wallet balance Data streamin

This is a git project for building a real time data pipeline
for storing and aggregating transactions to a betting wallet stored in Kafka

### Technologies used

* Kafka 7.3.2
* KsqlDB
    * KsqlDB is a SQL engine for Kafka which allows to query and process data in Kafka
    * Used in this project for creating following streams
        * Stream for absolute balance transactions to keep track of balance for each wallet regardless of type
        * Stream for daily balance average to keep track of daily average balance for each wallet
        * Stream for top credits to keep track of top credits for each product
        * Stream for current balance by the walletID
* Java 22 and maven
    * For managing java application
* Spring boot
    * For creating REST API for querying the data in Kafka
* Docker
* Docker compose
* python
    * For generating random transactions

### How to run the project

1. Clone the project
2. Run the following command to start docker compose architecture

```bash
docker-compose up
```

3. Run the following command to start the python script for generating random transactions

```bash
pip install confluent_kafka
python3 generate_transactions.py
```

4. Run the following Java class to initialize Ksqldb streams

```bash 
org.logifuture.ksql.streams.Initializer
```

5. Run the following command to start the spring boot application

```bash
mvn spring-boot:run
```