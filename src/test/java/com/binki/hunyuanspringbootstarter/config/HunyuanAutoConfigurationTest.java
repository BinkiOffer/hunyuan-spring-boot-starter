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
@SpringBootTest(classes = HunyuanAutoConfiguration.class)
public class HunyuanAutoConfigurationTest {

    private HunyuanClient client;

    public HunyuanAutoConfigurationTest(HunyuanClient client) {
        this.client = client;
    }

    @Test
    public void testHunyuanAutoConfigured() {
        assertNotNull("MyService should be auto-configured", client);
    }
}
