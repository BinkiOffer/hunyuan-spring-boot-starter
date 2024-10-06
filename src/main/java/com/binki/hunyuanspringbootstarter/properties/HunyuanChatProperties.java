package com.binki.hunyuanspringbootstarter.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author 11093
 * @description: Configuration keys
 * @Date 2024/10/6
 */
@ConfigurationProperties(HunyuanChatProperties.CONFIG_PREFIX)
public class HunyuanChatProperties extends HunyuanParentProperties{
    public static final String CONFIG_PREFIX = "spring.ai.hunyuan.chat";
}
