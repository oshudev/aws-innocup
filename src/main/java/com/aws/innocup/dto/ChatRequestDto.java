package com.aws.innocup.dto;

import lombok.Data;

@Data
public class ChatRequestDto {

    private String userName;
    private String prompt;
    private boolean voiceEnabled;
    private String channelName;
    private String rtcToken;

}
