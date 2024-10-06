package com.binki.hunyuanspringbootstarter.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * @author 11093
 * @description:
 * @Date 2024/10/6
 */
@SpringBootTest(classes = HunyuanChatProperties.class)
@TestPropertySource("classpath:application.properties")
public class HunyuanChatPropertiesTest {

    @Autowired
    private HunyuanChatProperties hunyuanChatProperties;

    @Test
    public void testHunyuanProperties() {
        System.out.println(hunyuanChatProperties);
    }
}
