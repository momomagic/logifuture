package org.logifuture.rest;

import io.confluent.ksql.api.client.StreamedQueryResult;
import org.logifuture.ksql.query.KsqlQueryReadOnly;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/avg-daily-balance/wallet/")
public class AvgDailyBalanceApi {

    private final KsqlQueryReadOnly ksqlQueryReadOnly;

    public AvgDailyBalanceApi(KsqlQueryReadOnly ksqlQueryReadOnly) {
        this.ksqlQueryReadOnly = ksqlQueryReadOnly;
    }

    @GetMapping("/{id}")
    public CompletableFuture<StreamedQueryResult> getAvgDailyBalance(@PathVariable String id) {
        return ksqlQueryReadOnly.executeKsqlQuery("SELECT avgDailyBalance FROM WALLET_DAILY_AVG_BALANCE_STREAM WHERE walletID = " + id + ";");
    }
}
