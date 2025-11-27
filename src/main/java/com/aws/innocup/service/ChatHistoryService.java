package com.aws.innocup.service;

import com.aws.innocup.common.services.Command;
import com.aws.innocup.dto.ChatHistoryDto;
import com.aws.innocup.entity.ChatHistory;
import com.aws.innocup.entity.UserInfo;
import com.aws.innocup.exception.UserNotFoundException;
import com.aws.innocup.repository.ChatHistoryRepository;
import com.aws.innocup.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatHistoryService implements Command<ChatHistoryDto, ChatHistory> {

    private final ChatHistoryRepository repository;
    private final UserRepository userRepository;

    public ChatHistoryService(ChatHistoryRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public ChatHistory execute(ChatHistoryDto chatHistoryDto) {
        UserInfo user = userRepository.findByUserName(chatHistoryDto.getUserName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        ChatHistory history = ChatHistory.builder()
                .user(user)
                .prompt(chatHistoryDto.getPrompt())
                .response(chatHistoryDto.getResponse())
                .build();

        return repository.save(history);
    }

}
