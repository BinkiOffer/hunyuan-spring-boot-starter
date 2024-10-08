# hunyuan-spring-boot-starter

[English](README.md) | [中文](README-zh_CN.md)

## 简介

本项目是个人维护，非官方出品。旨在让混元大模型的API使用更简单。



## 依赖

- spring-boot 3.3.4
- tencentcloud-sdk-java-hunyuan 3.1.1110



## 使用方法

在项目根目录使用如下命令：

```shell
mvn clean install
```



spring boot 工程引入

```xml
        <dependency>
        	<groupId>com.binki</groupId>
        	<artifactId>hunyuan-spring-boot-starter</artifactId>
        	<version>{根据最新版本}</version>
        </dependency>
```



简单上手

```java
@Controller
public class HelloController {

    @Resource
    private HunyuanClient client;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() throws TencentCloudSDKException {
        return new SimpleChat().send(client, "java 冒泡排序");
    }
}
```

