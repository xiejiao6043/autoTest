package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("sever1111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("sever2222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("client33333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("client444444");
    }
    @BeforeGroups("server")
    public void beforeGroupsSever(){
        System.out.println("severBefore");
    }
    @AfterGroups("server")
    public void AfterGroupsSever(){
        System.out.println("severAfter");
    }
    @BeforeGroups("client")
    public void beforeGroupsClient(){
        System.out.println("clientBefore");
    }
    @AfterGroups("client")
    public void AfterGroupsClient(){
        System.out.println("clientAfter");
    }



}
