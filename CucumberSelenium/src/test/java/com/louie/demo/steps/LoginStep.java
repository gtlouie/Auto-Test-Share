package com.louie.demo.steps;

import com.louie.demo.flows.LoginFlow;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;

public class LoginStep {
    private LoginFlow loginFlow;

    public LoginStep(){
        loginFlow=new LoginFlow();
    }

    @Given("^I am on Baidu page$")
    public void OnBaiduPage() {
        //自动化操作：访问百度页面
        loginFlow.onBaiduPage();
    }

    @When("^I input content$")
    public void enterData(DataTable table){
        //自动化操作：取Feature文件的值，并输入
        List<List<String>> data = table.raw();
        String searchContent=data.get(1).get(1);
        loginFlow.search(searchContent);

    }

    @And("^I click the button$")
    public void click() {
        //自动化操作：点击百度一下，等待10s ，关闭浏览器
        loginFlow.click();
    }
}
