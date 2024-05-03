package org.logifuture.ksql.streams;

public class Initializer {
    public static void main(String[] args) {
        KsqlWalletTransactionsStreamCreater ksqlWalletTransactionsTableCreater = new KsqlWalletTransactionsStreamCreater();
        ksqlWalletTransactionsTableCreater.create();
        KsqlWalletBalanceTableCreator ksqlWalletBalanceStreamCreator = new KsqlWalletBalanceTableCreator();
        ksqlWalletBalanceStreamCreator.create();
        System.out.println("Wallet balance stream created");
        KsqlWallerDailyAVGBalanceTableCreator ksqlWallerAverageBalanceStreamCreator = new KsqlWallerDailyAVGBalanceTableCreator();
        ksqlWallerAverageBalanceStreamCreator.create();
        System.out.println("Wallet average balance stream created");
        KsqlProductTopCreditsByProductIdStreamCreator ksqlProductTopCreditsByProductIdStreamCreator = new KsqlProductTopCreditsByProductIdStreamCreator();
        ksqlProductTopCreditsByProductIdStreamCreator.create();
        System.out.println("Product top credits by product id stream created");

    }
}
