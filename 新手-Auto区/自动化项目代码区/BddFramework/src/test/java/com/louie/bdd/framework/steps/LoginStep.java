package com.louie.bdd.framework.steps;

import com.louie.bdd.framework.flows.LoginFlow;
import com.louie.bdd.framework.mock.LoginMock;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginStep {
    private LoginFlow loginFlow;
    private LoginMock loginMock;

    public LoginStep(){

        loginFlow=new LoginFlow();
        loginMock=new LoginMock();
    }


    @Before	//performed before anything is done
    public void startDriver() {
        loginFlow.startDriver();

    }
    //初始化
    @Given("^Interface expected to return results$")
    public void interfaceExpectedToReturnResults(Map<String,String> dataMap) {
        //发送到mock
        loginMock.sendMockService(dataMap);
    }

    @Given("^I am on login page$")
    public void OnLoginPage() {
        //自动化操作：访问登录页面
        loginFlow.onLoginPage();
    }

    @When("^I input content$")
    public void inputDataData(Map<String,String> dataMap){
        //自动化操作：取Feature文件的值，并输入
        loginFlow.inputData(dataMap);

    }

    @And("^I click the button$")
    public void click() {
        //自动化操作：点击百度一下，等待10s ，关闭浏览器
        loginFlow.click();
    }

    @When("^I input content too long$")
    public void iInputContentTooLong() {
        Assert.assertEquals("1","2");
    }


    @Then("^I can see$")
    public void checkValue(Map<String,String> dataMap) {
        loginFlow.checkValue(dataMap);
    }

    @After
    public void closeDriver(){
        loginFlow.closeDriver();
    }
}
