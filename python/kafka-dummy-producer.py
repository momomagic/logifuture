import json
from confluent_kafka import SerializingProducer
import socket
import random
import time


def json_serializer(msg, s_obj):
    return json.dumps(msg).encode('utf-8')


conf = {'bootstrap.servers': 'localhost:9092',
        'client.id': socket.gethostname(),
        'value.serializer': json_serializer}

topic = 'WALLET_TRANSACTIONS'

producer = SerializingProducer(conf)
transaction_types = ['debit', 'credit', 'cancelCredit', 'cancelDebit']


def create_dummy_transaction():
    for i in range(1000):
        producer.produce(topic, key=str(i), value={"transactionID": str(i), "walletID": str(random.randint(1, 50)),
                                                   "amount": str(random.uniform(1, 10000)),
                                                   "type": random.choice(transaction_types),
                                                   "productID": str(random.randint(1, 10)),
                                                   "currency": "USD"})
        time.sleep(1)


if __name__ == "__main__":
    create_dummy_transaction()
