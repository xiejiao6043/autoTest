package com.course.testng.MutilThread;

import org.testng.annotations.Test;

public class MutilThreadOnAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test1(){
        System.out.println("1");
    }
}
