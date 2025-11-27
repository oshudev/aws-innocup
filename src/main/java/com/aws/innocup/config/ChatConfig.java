package com.aws.innocup.config;

import org.springframework.ai.bedrock.converse.BedrockChatOptions;
import org.springframework.ai.bedrock.converse.api.BedrockCacheOptions;
import org.springframework.ai.bedrock.converse.api.BedrockCacheStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    @Bean
    public BedrockChatOptions bedrockChatOptions() {
        return BedrockChatOptions.builder()
                .cacheOptions(BedrockCacheOptions.builder()
                        .strategy(BedrockCacheStrategy.SYSTEM_ONLY)
                        .build())
                .maxTokens(1000)
                .build();
    }

}
