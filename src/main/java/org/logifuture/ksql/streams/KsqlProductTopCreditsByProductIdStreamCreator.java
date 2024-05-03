package org.logifuture.ksql.streams;

import org.logifuture.ksql.StreamCreator;

public class KsqlProductTopCreditsByProductIdStreamCreator extends StreamCreator {
    public void create() {
        String topProductsByCredit = "CREATE TABLE TOP_PRODUCTS_BY_CREDIT AS "
                + "SELECT productID,TOPk(amount,5) AS top5Credits "
                + "FROM WALLET_TRANSACTIONS "
                + "WHERE type = 'credit' "
                + "GROUP BY productID "

                + "LIMIT 5 "
                + "EMIT CHANGES;";

        executeKsqlQueries(topProductsByCredit);
    }
}
