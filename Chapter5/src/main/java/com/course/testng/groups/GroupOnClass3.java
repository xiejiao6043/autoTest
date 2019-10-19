package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupOnClass3 {
    public void stu1(){
        System.out.println("  tea1 group3");
    }
    public void stu2(){
        System.out.println("  tea2 group3");
    }

}
