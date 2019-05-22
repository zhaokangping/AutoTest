package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1(){

        System.out.println("这是测试用例1");
        System.out.printf("Thread id  : %s%n ",Thread.currentThread().getId());
    }
    @Test
    public void testCase2(){

        System.out.println("这是测试用例2");
        System.out.printf("Thread id  : %s%n ",Thread.currentThread().getId());
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before方法");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after方法");
    }
    @BeforeClass
    public void beforeClasses(){
        System.out.println("beforeClass在类运行前运行");
    }
    @AfterClass
    public void afterClasses(){
        System.out.println("afterClass在类运行后运行");
    }
    @BeforeSuite
    public void beforSuits(){
        System.out.println("beforSuits在类运行前,beforClass前运行");
    }
    @AfterSuite
    public void afterSuits(){
        System.out.println("afterSuits在类运行后afterClass后运行");
    }
}
