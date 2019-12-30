package com.louie.bdd.framework.pages;

import cucumber.api.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;


public class LoginPage {

    private WebDriver driver;
    private String url="file:///Users/gttester/Documents/workScript/TestDemo/login.html";

    //启动驱动
    public void startDriver(){
//        System.setProperty("webdriver.chrome.driver","/Users/gttester/Documents/workScript/Webdriver/chromedriver");
        driver=new ChromeDriver();
    }


    //访问页面
    public  void  onLoginPage(){
        driver.get(url);
//        driver.get("file:///Users/gttester/Documents/workScript/TestDemo/login.html");
    }

    //页面等待时间
    public  void timeSleep(long ms){
        try{
            Thread.sleep(ms);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //输入内容
    public void inputData(Map<String,String> dataMap){
        driver.findElement(By.id("account")).sendKeys(dataMap.get("account"));
        timeSleep(1000);
        driver.findElement(By.id("password")).sendKeys(dataMap.get("password"));
        timeSleep(1000);
        driver.findElement(By.id("code")).sendKeys(dataMap.get("code"));



    }

    //点击
    public void click(){
        driver.findElement(By.id("subBtn")).click();
    }

    //关闭驱动
    public void closeDriver(){
        driver.quit();
    }

    //验证
    public void checkValue(Map<String,String> dataMap){
        String loginMsg=driver.findElement(By.id("loginMsg")).getText();
        Assert.assertEquals(dataMap.get("loginMsg"),loginMsg);
    }
}
