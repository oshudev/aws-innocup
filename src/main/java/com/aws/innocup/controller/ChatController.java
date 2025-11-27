package com.aws.innocup.controller;

import com.aws.innocup.dto.ChatRequestDto;
import com.aws.innocup.dto.ChatResponseDto;
import com.aws.innocup.service.RagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ChatController {

    private final RagService ragService;

    public ChatController(RagService ragService) {
        this.ragService = ragService;
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatResponseDto> chat(@RequestBody ChatRequestDto chatRequest) {
        return ResponseEntity.ok(ragService.execute(chatRequest));
    }

}
