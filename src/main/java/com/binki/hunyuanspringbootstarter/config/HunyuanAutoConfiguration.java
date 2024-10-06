package com.binki.hunyuanspringbootstarter.config;

import com.binki.hunyuanspringbootstarter.common.constant.URL;
import com.binki.hunyuanspringbootstarter.properties.HunyuanChatProperties;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.hunyuan.v20230901.HunyuanClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author 花花Binki
 * @description:
 * @Date 2024/10/6
 */
@AutoConfiguration
@EnableConfigurationProperties(HunyuanChatProperties.class)
public class HunyuanAutoConfiguration {
    // 属性注入
    private HunyuanChatProperties hunyuanChatProperties;

    // 构造方法注入
    public HunyuanAutoConfiguration(HunyuanChatProperties hunyuanChatProperties) {
        this.hunyuanChatProperties = hunyuanChatProperties;
    }

    /**
     * 获取混元Client
     *
     * @return 混元Client
     */
    @Bean
    HunyuanClient getHunyuanClient() {

        // 注入凭证信息
        Credential credential = setCredential();

        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(URL.BASE);

        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        // clientProfile不可以为null，必须实例化
        // region 是地域信息，可以直接填写字符串ap-guangzhou，或者引用预设的常量
        HunyuanClient client = new HunyuanClient(credential, "", clientProfile);

        return client;
    }

    /**
     * 设置凭证信息。
     * 优先从系统环境变量中获取腾讯云密钥，如果未设置，则使用配置文件中的密钥。
     *
     * @return 返回一个Credential对象，包含腾讯云的密钥信息。
     */
    private Credential setCredential() {
        String secretId = hunyuanChatProperties.getSecretId();
        String secretKey = hunyuanChatProperties.getSecretKey();

        // 从系统环境变量中获取腾讯云密钥
        String tencentKey = System.getenv("Tencent_key");
        String tencentValue = System.getenv("Tencent_value");

        // 如果系统环境变量中没有设置腾讯云密钥，则使用配置文件中的密钥
        if (tencentKey == null || tencentValue == null) {
            tencentKey = secretId;
            tencentValue = secretKey;
        }

        // 创建凭证
        Credential credential = new Credential(tencentKey, tencentValue);

        return credential;
    }
}
