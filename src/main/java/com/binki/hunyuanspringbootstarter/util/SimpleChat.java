package com.binki.hunyuanspringbootstarter.util;

import com.binki.hunyuanspringbootstarter.common.constant.Model;
import com.binki.hunyuanspringbootstarter.common.constant.Role;
import com.tencentcloudapi.common.AbstractModel;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.hunyuan.v20230901.HunyuanClient;
import com.tencentcloudapi.hunyuan.v20230901.models.ChatCompletionsRequest;
import com.tencentcloudapi.hunyuan.v20230901.models.ChatCompletionsResponse;
import com.tencentcloudapi.hunyuan.v20230901.models.Message;

/**
 * @author 花花Binki
 * @description:
 * @Date 2024/10/6
 */
public class SimpleChat {

    public String send(HunyuanClient client, String msg){
        // 实例化一个请求对象,每个接口都会对应一个request对象
        ChatCompletionsRequest req = new ChatCompletionsRequest();
        req.setModel(Model.LITE);
        Message message = new Message();
        message.setRole(Role.USER);
        message.setContent(msg);
        req.setMessages(new Message[]{message});

        // 返回的resp是一个ChatCompletionsResponse的实例，与请求对象对应
        ChatCompletionsResponse resp = null;
        try {
            resp = client.ChatCompletions(req);
        } catch (TencentCloudSDKException e) {
            throw new RuntimeException(e);
        }

        return AbstractModel.toJsonString(resp);
    }
}
