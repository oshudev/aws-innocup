package com.aws.innocup.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Data
@Configuration
@ConfigurationProperties(prefix = "agora")
public class AgoraConfig {

    private String appId;
    private String customerId;
    private String customerSecret;
    private String ttsKey;
    private String ttsRegion;
    private String voiceName;
    private String joinUrl;

    public String getAuthHeader() {
        String plain = this.customerId + ":" + this.customerSecret;
        String base64 = Base64.getEncoder().encodeToString(plain.getBytes());
        return "Basic " + base64;
    }

}
