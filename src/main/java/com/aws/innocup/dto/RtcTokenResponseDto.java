package com.aws.innocup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RtcTokenResponseDto {

    private String channelName;
    private String token;
    private int uid;
    private int expireAt;

}
