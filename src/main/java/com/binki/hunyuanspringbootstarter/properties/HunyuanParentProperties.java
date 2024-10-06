package com.binki.hunyuanspringbootstarter.properties;

/**
 * @author 花花Binki
 *
 * @description: 混元配置基类
 * @Date 2024/10/6
 */
public class HunyuanParentProperties {

    /**
     * 密钥id
     */
    private String secretId;

    /**
     * 密钥
     */
    private String secretKey;

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
}
