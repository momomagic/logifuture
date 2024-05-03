package org.logifuture.ksql.query;

import io.confluent.ksql.api.client.StreamedQueryResult;
import org.logifuture.ksql.StreamCreator;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KsqlQueryReadOnly extends StreamCreator {
    public CompletableFuture<StreamedQueryResult> executeKsqlQuery(final String query) {
        return getKsClient().streamQuery(query);
    }
}
