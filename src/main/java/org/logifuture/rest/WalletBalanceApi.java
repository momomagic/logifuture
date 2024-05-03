package org.logifuture.rest;

import io.confluent.ksql.api.client.StreamedQueryResult;
import org.logifuture.ksql.query.KsqlQueryReadOnly;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/balance/wallet/")
public class WalletBalanceApi {
    private final KsqlQueryReadOnly ksqlQueryReadOnly;

    public WalletBalanceApi(KsqlQueryReadOnly ksqlQueryReadOnly) {
        this.ksqlQueryReadOnly = ksqlQueryReadOnly;
    }

    @GetMapping("/{id}")
    public CompletableFuture<StreamedQueryResult> getBalance(@PathVariable String id) {
        return ksqlQueryReadOnly.executeKsqlQuery("SELECT avgDailyBalance FROM WALLET_BALANCE_STREAM WHERE walletID = " + id + ";");
    }
}
