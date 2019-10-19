package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteConfig {
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }
}
