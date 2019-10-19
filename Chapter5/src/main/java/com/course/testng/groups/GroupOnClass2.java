package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {
    public void stu1(){
        System.out.println("  stu1 group2");
    }
    public void stu2(){
        System.out.println("  stu2 group2");
    }
}
