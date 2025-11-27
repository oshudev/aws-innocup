package com.aws.innocup.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStoreRetriever;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentRetrievalService {

    private final VectorStoreRetriever retriever;

    public DocumentRetrievalService(VectorStoreRetriever retriever) {
        this.retriever = retriever;
    }

    public List<Document> execute(String query) {
        SearchRequest searchRequest = SearchRequest.builder()
                .query(query)
                .topK(10)
                .build();
        return retriever.similaritySearch(searchRequest);
    }

}
