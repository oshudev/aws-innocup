package com.aws.innocup.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatHistoryDto {

    private String userName;
    private String prompt;
    private String response;

}
