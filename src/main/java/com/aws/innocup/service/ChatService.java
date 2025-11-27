package com.aws.innocup.service;

import com.aws.innocup.common.services.Query;
import org.springframework.ai.bedrock.converse.BedrockChatOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService implements Query<String, String> {

    private final ChatClient chatClient;
    private final BedrockChatOptions chatOptions;

    public ChatService(ChatClient.Builder chatClientBuilder, BedrockChatOptions chatOptions) {
        this.chatClient = chatClientBuilder.build();
        this.chatOptions = chatOptions;
    }

    @Override
    public String execute(String prompt) {
        return chatClient.prompt()
                .options(chatOptions)
                .user(prompt)
                .call()
                .content();
    }

}
