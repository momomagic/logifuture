package org.logifuture.ksql.streams;

import org.logifuture.ksql.StreamCreator;

public class KsqlWalletTransactionsStreamCreater extends StreamCreator {
    public void create() {
        String walletTransactionsTable = "CREATE STREAM WALLET_TRANSACTIONS ("
                + "transactionID STRING  KEY, "
                + "walletID STRING, "
                + "amount DOUBLE, "
                + "TIMESTAMP STRING, "
                + "type STRING,  "
                + "productID STRING, "
                + "currency STRING) "
                + "WITH (KAFKA_TOPIC='wallet_transactions', "
                + "VALUE_FORMAT='JSON');";

        executeKsqlQueries(walletTransactionsTable);
    }
}
