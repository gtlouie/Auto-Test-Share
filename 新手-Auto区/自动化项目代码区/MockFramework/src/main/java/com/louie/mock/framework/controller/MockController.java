package com.louie.mock.framework.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@RestController
public class MockController {
        //启动wiremock 服务
        public  MockController(){
            //配置WireMock 服务端服务， 启动端口8085
            WireMockServer wireMockServer=new WireMockServer(wireMockConfig().port(8085));
            //启动服务
            wireMockServer.start();


        }
        //模拟服务器 先接收BDD 的模拟请求参数，再解析url 与预期返回值，最后将其发送到wireMock 使其能够动态修改接口返回值
        @ResponseBody
        @RequestMapping("/mock/api")
        public void mock(@RequestBody String request) throws IOException {
            System.out.println(request);
            JSONObject jsonObject= JSON.parseObject(request);
            JSONObject requestJson=JSON.parseObject(jsonObject.get("request").toString());
            String url=requestJson.get("url").toString();
            String responseStr=jsonObject.get("response").toString();
            System.out.println(url);
            System.out.println(responseStr);
            mock(url,responseStr);

        }

        public static void mock(String url,String jsonStr){
                //启动WireMock 客户端 ，连接服务端口8085
                WireMock.configureFor(8085);
                //将模拟请求发送到本地WireMock 服务端 ，以便可以访问接口
                stubFor(get(urlPathEqualTo(url))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Access-Control-Allow-Origin","*")
                                .withBody(jsonStr)));

        }

}