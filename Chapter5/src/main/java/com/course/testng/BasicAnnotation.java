package com.course.testng;

import org.testng.annotations.*;

import java.net.PortUnreachableException;

public class BasicAnnotation {
    //最基本的注解了，表明这是测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }

}
