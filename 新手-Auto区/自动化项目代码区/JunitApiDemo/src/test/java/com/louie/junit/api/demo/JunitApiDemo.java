package com.louie.junit.api.demo;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class JunitApiDemo {

    @Test
    @Parameters(
            {
                    "测试正常流-用户信息正确, louie,123456"
            }
    )
    public void loginSuccess(String desc,String userName,String password){
        //伪代码,请求接口
        System.out.println("伪代码-请求登录接口 /api/login");
        //伪代码，请求返回值，json 解析 格式 {"code":"200","msg"："登录成功"}
        System.out.println("伪代码-json 解析接口返回值");
        String code="200";
        String msg="登录成功";
        Assert.assertEquals("200",code);
        Assert.assertEquals("登录成功",msg);

    }
    @Test
    @Parameters(
            {
                    "测试异常流-用户名为空, ,123456",
                    "测试异常流-密码为空,louie, ",
                    "测试异常流-密码为空, , "
            }
            )
    public void loginError(String desc,String userName,String password){
        //伪代码,请求接口
        System.out.println("伪代码-请求登录接口 /api/login");
        //伪代码，请求返回值，json 解析 格式 {"code":"Error_Null","msg"："登录用户名或密码不能为空"}
        System.out.println("伪代码-json 解析接口返回值");
        String code="Error_Null";
        String msg="登录用户名或密码不能为空";
        Assert.assertEquals("Error_Null",code);
        Assert.assertEquals("登录用户名或密码不能为空",msg);

    }
}
