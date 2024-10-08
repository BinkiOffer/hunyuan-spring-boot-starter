# hunyuan-spring-boot-starter

[English](README.md) | [中文](README-zh_CN.md)

## Introduction

This project is privately maintained and not an official production. Intended to make the API for hybrid large models easier to use.



## Dependencies

- spring-boot 3.3.4
- tencentcloud-sdk-java-hunyuan 3.1.1110



## Guide

Use the following command in the project root directory:

```shell
mvn clean install
```



add follow to pom.xml

```xml
    <dependency>
    	<groupId>com.binki</groupId>
    	<artifactId>hunyuan-spring-boot-starter</artifactId>
    	<version>{根据最新版本}</version>
    </dependency>
```



quick start

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

