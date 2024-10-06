package com.binki.hunyuanspringbootstarter.util;

import com.tencentcloudapi.hunyuan.v20230901.HunyuanClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

/**
 * @author 花花Binki
 * @description:
 * @Date 2024/10/6
 */
public class SimpleChatTest {
    private HunyuanClient client;

    public SimpleChatTest(HunyuanClient client) {
        this.client = client;
    }

    @Test
    public void testSimpleChat() {
        new SimpleChat().send(client, "java 冒泡排序");
    }
}
