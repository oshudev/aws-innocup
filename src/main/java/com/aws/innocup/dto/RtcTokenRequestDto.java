package com.aws.innocup.dto;

import lombok.Data;

@Data
public class RtcTokenRequestDto {

    private String channelName;
    private int uid;
    private int expireSeconds;

}
