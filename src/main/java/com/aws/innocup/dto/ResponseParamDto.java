package com.aws.innocup.dto;

import com.aws.innocup.enums.ResCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseParamDto {
    private Integer code = ResCode.RES_OK.getCode();
    private String appKey;
    private String channel;
    private String userId;
    private String accessToken;
    private String token;
    private String errorInfo;
    private Long expireTimestamp;
    private String chatUserName;
    private String agoraUid;
}
