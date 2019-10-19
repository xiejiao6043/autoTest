package com.course.testng.suite;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 30000)
    public void timeSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(timeOut = 2000)
    public void timeFail() throws InterruptedException {
        Thread.sleep(3000);
    }

}
