package com.binki.hunyuanspringbootstarter.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author 11093
 * @description: Configuration keys
 * @Date 2024/10/6
 */
@ConfigurationProperties(HunyuanChatProperties.CONFIG_PREFIX)
public class HunyuanChatProperties {
    public static final String CONFIG_PREFIX = "spring.ai.hunyuan.chat";
    /**
     * Enable hunyuan chat model.
     */
    private boolean enabled = true;

    private String secretId;

    private String secretKey;

    private String region;

    private String host;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "HunyuanProperties{" +
                "secretId='" + secretId + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", region='" + region + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
