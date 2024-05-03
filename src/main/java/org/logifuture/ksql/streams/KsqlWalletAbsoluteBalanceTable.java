package org.logifuture.ksql.streams;

import org.logifuture.ksql.StreamCreator;

public class KsqlWalletAbsoluteBalanceTable extends StreamCreator {
    public void create() {
        String walletBalanceTable = "CREATE TABLE WALLET_ABS_BALANCE_STREAM AS "
                + "SELECT walletID, transactionID,amount,currency,type,"
                + "CASE  "
                + "WHEN type = 'credit' THEN amount "
                + "WHEN type = 'debit' THEN -amount "
                + "WHEN type = 'cancelCredit' THEN -amount "
                + "WHEN type = 'cancelDebit' THEN amount "
                + "END AS absoluteAmount "
                + "FROM WALLET_TRANSACTIONS "
                + "EMIT CHANGES;";

        executeKsqlQueries(walletBalanceTable);
    }
}
