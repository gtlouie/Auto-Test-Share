package com.louie.demo.testRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumBrowserDemo {

    public static void main(String[] args) {
        System.out.println("start selenium");
        //设置chrondriver的路径
        System.setProperty("webdriver.chrome.driver","/Users/gttester/Documents/workScript/Webdriver/chromedriver");
        //初始化浏览器
        WebDriver driver = new ChromeDriver();
        //打开一个站点
        driver.get("http://www.baidu.com");
        //输入selenium
        driver.findElement(By.id("kw")).sendKeys("selenium");
        //点击百度一下
        driver.findElement(By.id("su")).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        //关闭浏览器
        driver.quit();
    }
}
