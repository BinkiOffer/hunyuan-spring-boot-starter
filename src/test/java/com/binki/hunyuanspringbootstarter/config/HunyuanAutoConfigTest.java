package com.binki.hunyuanspringbootstarter.config;

import com.tencentcloudapi.hunyuan.v20230901.HunyuanClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

/**
 * @author 11093
 * @description:
 * @Date 2024/10/6
 */
@SpringBootTest(classes = HunyuanAutoConfig.class)
public class HunyuanAutoConfigTest {

    @Resource
    private HunyuanClient client;

    @Test
    public void testHunyuanAutoConfigured() {
        assertNotNull("MyService should be auto-configured", client);
    }
}
