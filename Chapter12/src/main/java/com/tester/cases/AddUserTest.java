package com.tester.cases;

import com.tester.config.TestConfig;
import com.tester.model.AddUserCase;
import com.tester.model.User;
import com.tester.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口接口")
    public void addUser() throws IOException, InterruptedException {

        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);

        String result = getResult(addUserCase);

        Thread.sleep(2000);
        User user = session.selectOne("addUser",addUserCase);
        System.out.println(user.toString());

        Assert.assertEquals(addUserCase.getExpected(),result);


    }


    private String getResult(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("age",addUserCase.getAge());
        param.put("sex",addUserCase.getSex());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
//      设置请求头信息,设置header
        post.setHeader("content-type","application/json");
//        将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
//      设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
//      声明一个对象来进行响应结果的存储
        String result ;
//        执行post方法
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
//         获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        return result;


    }


}
