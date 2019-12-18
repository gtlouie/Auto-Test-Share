package com.louie.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {
    private WebDriver driver;

    //启动驱动
    public void startDriver(){
//        System.setProperty("webdriver.chrome.driver","/Users/gttester/Documents/workScript/Webdriver/chromedriver");
        driver=new ChromeDriver();
    }

    //访问百度页面
    public  void  onBaiduPage(){
        driver.get("http://www.baidu.com");
    }

    //页面等待时间
    public  void timeSleep(long ms){
        try{
            Thread.sleep(ms);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //输入查询内容
    public void searcher(String content){
        //输入selenium
        driver.findElement(By.id("kw")).sendKeys(content);
    }

    //点击百度一下
    public void click(){
        driver.findElement(By.id("su")).click();
    }

    //关闭驱动
    public void closeDriver(){
        driver.quit();
    }
}
