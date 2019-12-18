package com.louie.demo.flows;

import com.louie.demo.pages.LoginPage;

public class LoginFlow {
    private LoginPage loginPage;
    //初始化
    public LoginFlow(){
         loginPage=new LoginPage();
    }

    public void onBaiduPage(){
        loginPage.startDriver();
        loginPage.onBaiduPage();
    }

    //输入查询内容
    public void search(String content){
        loginPage.timeSleep(1000);
        loginPage.searcher(content);
    }

    //点击百度搜索
    public void click(){
        loginPage.click();
        loginPage.timeSleep(1000);
        loginPage.closeDriver();
    }


}
