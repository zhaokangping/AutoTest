package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMehtod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组得测试方法11111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组得测试方法22222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组得测试方法33333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组得测试方法44444");
    }

    @BeforeGroups("server")
    public void beforeGroupOnServer(){
        System.out.println("这是服务端组运行之前运行得方法");
    }
    @AfterGroups("server")
    public void afterGroupOnServer(){
        System.out.println("这是服务端组运行之后运行得方法");
    }
}
