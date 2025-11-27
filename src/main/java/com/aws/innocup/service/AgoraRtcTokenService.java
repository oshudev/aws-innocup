package com.aws.innocup.service;

import com.aws.innocup.common.services.Query;
import com.aws.innocup.dto.RtcTokenRequestDto;
import com.aws.innocup.dto.RtcTokenResponseDto;
import io.agora.media.RtcTokenBuilder2;
import io.agora.media.RtcTokenBuilder2.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AgoraRtcTokenService implements Query<RtcTokenRequestDto, RtcTokenResponseDto> {

    @Value("${agora.app-id}")
    private String appId;

    @Value("${agora.app-cert}")
    private String appCert;

    @Override
    public RtcTokenResponseDto execute(RtcTokenRequestDto rtcTokenRequest) {
        int expirySeconds = 3600;
        int expireAt = Math.toIntExact(Instant.now().getEpochSecond() + expirySeconds);

        RtcTokenBuilder2 token = new RtcTokenBuilder2();
        String result = token.buildTokenWithUid(
                appId,
                appCert,
                rtcTokenRequest.getChannelName(),
                rtcTokenRequest.getUid(),
                Role.ROLE_SUBSCRIBER,
                expireAt,
                expireAt
        );

        return new RtcTokenResponseDto(rtcTokenRequest.getChannelName(), result, rtcTokenRequest.getUid(), expireAt);
    }

}
