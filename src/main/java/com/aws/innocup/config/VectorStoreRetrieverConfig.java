package com.aws.innocup.config;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStoreRetriever;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
class VectorStoreRetrieverConfig {

    @Bean
    public VectorStoreRetriever vectorStoreRetriever() {
        return new VectorStoreRetriever() {
            @Override
            public List<Document> similaritySearch(SearchRequest searchRequest) {
                return Collections.emptyList();
            }
        };
    }

}