package org.logifuture.rest;

import io.confluent.ksql.api.client.StreamedQueryResult;
import org.logifuture.ksql.query.KsqlQueryReadOnly;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/top-credits/product/")
public class TopCreditsByProductApi {
    private final KsqlQueryReadOnly ksqlQueryReadOnly;

    public TopCreditsByProductApi(KsqlQueryReadOnly ksqlQueryReadOnly) {
        this.ksqlQueryReadOnly = ksqlQueryReadOnly;
    }

    @GetMapping("/{id}")
    public CompletableFuture<StreamedQueryResult> getTopCredits(@PathVariable String id) {
        return ksqlQueryReadOnly.executeKsqlQuery("SELECT avgDailyBalance FROM TOP_PRODUCTS_BY_CREDIT WHERE productID = " + id + ";");
    }
}
