package com.course.testng.MutilThread;

import org.testng.annotations.Test;

public class MutilThreadOnXml {
    @Test
    public void test1(){
        System.out.printf("Thread1: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("Thread2: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("Thread3: %s%n",Thread.currentThread().getId());
    }
}
