package com.louie.bdd.framework.mock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.louie.bdd.framework.util.FileUtil;
import com.louie.bdd.framework.util.HttpClientUtil;

import java.util.Map;

public class LoginMock {
    //发送数据到Mock服务
    public  void sendMockService(Map<String,String> dataMap){
        //mock 服务的地址
        String mockUrl="http://localhost:8083/mock/api/";

        //获取login 接口返回模板
        String jsonPath="/Users/gttester/Documents/workScript/BddFramework/src/test/resources/json/login.json";
        String readContent= FileUtil.readJsonFile(jsonPath);
        JSONObject responseJson= JSON.parseObject(readContent);

        //将预期值重新组装到模板中
        responseJson.put("code",dataMap.get("code"));


        //接口请求体
        JSONObject requestJson=new JSONObject();
        requestJson.put("url","/api/login");
        requestJson.put("method","GET");

        //发送给mock 服务的json 包括接口请求体与接口请求返回体
        JSONObject sendJson=new JSONObject();
        sendJson.put("request",requestJson);
        sendJson.put("response",responseJson);

        //将重新组装的数据发给mock 服务器，使其重新部署新的重新组装的接口返回值
        HttpClientUtil.sendPost(mockUrl,sendJson.toJSONString());


    }

}
