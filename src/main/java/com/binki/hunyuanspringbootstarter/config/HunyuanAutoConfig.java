package com.binki.hunyuanspringbootstarter.config;

import com.binki.hunyuanspringbootstarter.properties.HunyuanChatProperties;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.hunyuan.v20230901.HunyuanClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author 11093
 * @description:
 * @Date 2024/10/6
 */
@AutoConfiguration
@EnableConfigurationProperties(HunyuanChatProperties.class)
public class HunyuanAutoConfig {
    private HunyuanChatProperties hunyuanChatProperties;

    public HunyuanAutoConfig (HunyuanChatProperties hunyuanChatProperties) {
        this.hunyuanChatProperties = hunyuanChatProperties;
    }

    @Bean
    HunyuanClient getHunyuanClient() {
        String secretId = hunyuanChatProperties.getSecretId();

        // 从系统环境变量中获取腾讯云密钥
        String tencentKey = System.getenv("Tencent_key");
        String tencentValue = System.getenv("Tencent_value");

        // 创建凭证
        Credential credential = new Credential(tencentKey, tencentValue);

        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("hunyuan.tencentcloudapi.com");

        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        // clientProfile不可以为null，必须实例化
        // region 是地域信息，可以直接填写字符串ap-guangzhou，或者引用预设的常量
        HunyuanClient client = new HunyuanClient(credential, "", clientProfile);

        return client;
    }
}
