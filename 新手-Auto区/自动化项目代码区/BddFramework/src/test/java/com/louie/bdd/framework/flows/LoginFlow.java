package com.louie.bdd.framework.flows;


import com.louie.bdd.framework.pages.LoginPage;

import java.util.Map;

public class LoginFlow {
    private LoginPage loginPage;
    //初始化
    public LoginFlow(){
         loginPage=new LoginPage();
    }


    public void startDriver(){
        loginPage.startDriver();
    }

    public void onLoginPage(){

        loginPage.onLoginPage();
    }

    //输入内容
    public void inputData(Map<String,String> dataMap){
        loginPage.timeSleep(1000);
        loginPage.inputData(dataMap);
    }

    //点击
    public void click(){
        loginPage.click();
        loginPage.timeSleep(1000);
//
    }

    //验证信息
    public void checkValue(Map<String,String> dataMap){
         loginPage.checkValue(dataMap);

    }

    public void closeDriver(){
        loginPage.closeDriver();
    }

}
