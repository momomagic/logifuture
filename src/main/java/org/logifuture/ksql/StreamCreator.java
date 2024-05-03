package org.logifuture.ksql;

import io.confluent.ksql.api.client.BatchedQueryResult;
import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;

import java.util.HashMap;
import java.util.Map;

public class StreamCreator {
    Map<String, Object> kafkaStreamsProperties = new HashMap<>();

    public StreamCreator() {
        kafkaStreamsProperties.put("auto.offset.reset", "earliest");
        kafkaStreamsProperties.put("commit.interval.ms", 1000);
    }

    public Client getKsClient() {
        return Client.create(ClientOptions.create().setHost("http://127.0.0.1:8088"));
    }

    public BatchedQueryResult executeKsqlQueries(final String query, final Map<String, Object> properties) {
        return getKsClient().executeQuery(query, properties != null ? properties : kafkaStreamsProperties);
    }

    public BatchedQueryResult executeKsqlQueries(final String query) {
        return executeKsqlQueries(query, null);
    }
}
