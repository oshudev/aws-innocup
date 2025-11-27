package com.aws.innocup.service;

import com.aws.innocup.common.services.Query;
import com.aws.innocup.dto.ChatHistoryDto;
import com.aws.innocup.dto.ChatRequestDto;
import com.aws.innocup.dto.ChatResponseDto;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RagService implements Query<ChatRequestDto, ChatResponseDto> {

    private final DocumentRetrievalService docService;
    private final ChatService chatService;
    private final ChatHistoryService historyService;

    public RagService(DocumentRetrievalService docService,
                      ChatService chatService,
                      ChatHistoryService historyService) {
        this.docService = docService;
        this.chatService = chatService;
        this.historyService = historyService;
    }

    @Override
    public ChatResponseDto execute(ChatRequestDto input) {
        List<Document> docs = docService.execute(input.getPrompt());

        String augmentedPrompt = buildAugmentedPrompt(input.getPrompt(), docs);
        String answer = "";

        try {
            answer = chatService.execute(augmentedPrompt);
        } catch (Exception e) {
            ChatResponseDto errorResponse = new ChatResponseDto();
            errorResponse.setResponse("Sorry, we could not generate an answer at this time.");

            return errorResponse;
        }

        ChatHistoryDto chatHistoryDto = new ChatHistoryDto();
        chatHistoryDto.setPrompt(input.getPrompt());
        chatHistoryDto.setUserName(input.getUserName());
        chatHistoryDto.setResponse(answer);

        historyService.execute(chatHistoryDto);

        ChatResponseDto responseDto = new ChatResponseDto();
        responseDto.setResponse(answer);

        return responseDto;
    }

    private String buildAugmentedPrompt(String prompt, List<Document> docs) {
        StringBuilder sb = new StringBuilder();
        sb.append("You are a legal assistant. Use ONLY the following retrieved documents to answer the question.\n\n");
        sb.append("Retrieved Documents\n");

        for (Document doc : docs) {
            sb.append("- ").append(doc.getText()).append("\n");
        }

        sb.append("\nUser Question:\n");
        sb.append(prompt);

        return sb.toString();
    }

}
