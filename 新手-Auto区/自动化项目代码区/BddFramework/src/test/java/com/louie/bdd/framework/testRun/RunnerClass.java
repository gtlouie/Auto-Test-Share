package com.louie.bdd.framework.testRun;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //运行生成的报告json
        plugin ={"pretty",
                "html:target/cucumber-report/",
                "json:target/cucumber-report/cucumber.json"
        },
        //测试点文件路径
        features={"src/test/resources/features"},
        //反射feature 文件的路径
        glue ={"com.louie.bdd.framework.steps"},
        //运行指定的场景
        tags = {"@Mock"}
        )

public class RunnerClass {

}