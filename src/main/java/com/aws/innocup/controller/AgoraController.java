package com.aws.innocup.controller;

import com.aws.innocup.dto.RtcTokenRequestDto;
import com.aws.innocup.dto.RtcTokenResponseDto;
import com.aws.innocup.service.AgoraRtcTokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/voice")
public class AgoraController {

    private final AgoraRtcTokenService agoraRtcTokenService;

    public AgoraController(AgoraRtcTokenService agoraRtcTokenService) {
        this.agoraRtcTokenService = agoraRtcTokenService;
    }

    @GetMapping("/token")
    public RtcTokenResponseDto getToken(
            @RequestParam String channelName,
            @RequestParam int uid
    ) {
        RtcTokenRequestDto dto = new RtcTokenRequestDto();
        dto.setChannelName(channelName);
        dto.setUid(uid);

        return agoraRtcTokenService.execute(dto);
    }

}
