package com.course.testng.Param;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider="data")
    public void DataProviderTest(String name,int age){
        System.out.println("name="+name+" age="+age);
    }

    @DataProvider(name="data")
    public Object[][] ProviderDate(){
        Object[][] o =new Object[][]{
                {"zhangsan",11},
                {"lisi",10},
                {"wangwu",20}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1 name="+name+" age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2 name="+name+" age="+age);
    }
    @DataProvider(name="methodData")
    public Object[][] methodDataProvider(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result =new Object[][]{
                {"zhangsan",100},
                {"lisi",20}
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                {"wangwu",25},
            };
        }
        return result;

    }
}
