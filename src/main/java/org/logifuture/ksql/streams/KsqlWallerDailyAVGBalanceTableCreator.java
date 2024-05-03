package org.logifuture.ksql.streams;


import org.logifuture.ksql.StreamCreator;


public class KsqlWallerDailyAVGBalanceTableCreator extends StreamCreator {
    public void create() {
        String walletBalanceTable = "CREATE TABLE WALLET_DAILY_AVG_BALANCE_STREAM WITH (KAFKA_TOPIC='WALLET_DAILY_AVG_BALANCE_STREAM', PARTITIONS=1, REPLICAS=1) AS SELECT "
                + "walletID, AVG(absoluteAmount) AS avgDailyBalance "
                + "FROM WALLET_ABS_BALANCE_STREAM "
                + "WINDOW TUMBLING (SIZE 1 DAY)"
                + "GROUP BY walletID EMIT CHANGES;";

        executeKsqlQueries(walletBalanceTable);
    }
}