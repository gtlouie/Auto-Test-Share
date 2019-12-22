package com.louie.wiremock.demo;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WireMockDemo {

    public static void main(String[] args) {
        //配置WireMock 服务端服务， 启动端口8085
        WireMockServer wireMockServer=new WireMockServer(wireMockConfig().port(8085));
        //启动服务
        wireMockServer.start();

        //启动WireMock 客户端 ，连接服务端口8085
        WireMock.configureFor(8085);


        //将模拟请求发送到本地WireMock 服务端 ，以便可以访问接口
        stubFor(get(urlPathEqualTo("/api/test"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("{\"id\":1,\"name\":\"Jack\"}")));

    }

}
