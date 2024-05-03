package org.logifuture.ksql.streams;

import org.logifuture.ksql.StreamCreator;

public class KsqlWalletBalanceTableCreator extends StreamCreator {
    public void create() {
        String walletBalanceTable = "CREATE TABLE WALLET_BALANCE_STREAM AS "
                + "SELECT walletID, SUM(absoluteAmount) AS totalBalance "
                + "FROM WALLET_ABS_BALANCE_STREAM "
                + "GROUP BY walletID;";

        executeKsqlQueries(walletBalanceTable);
    }

}
