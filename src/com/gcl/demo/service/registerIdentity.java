package com.gcl.demo.service;

import com.gcl.demo.model.User;
import com.gcl.demo.dao.UserDaoIplm;



public class registerIdentity {
    UserDaoIplm userDaoIplm = new UserDaoIplm ();

    public boolean isExist(String account, String password) {
        //查询数据库中是否有这个账号，如果没有则返回true
        if (!userDaoIplm.select (account)) {
            System.out.println ("注册失败！已有账号，请登录！");
            return false;
        } else {
            userDaoIplm.insertR (account, password);
        }
        return true;
    }

    public boolean isInsertAll(String account, int id, String nickname, String sex, int age, String phone) {
        User user = new User (account, id, nickname, sex, age, phone);
        //getNowTime getNowTime=new getNowTime ();
        //  Date time=getNowTime.getNowTime ();
        //RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();
        int x = userDaoIplm.insert (user);
        if (x == 1) {
            return true;
        }
        return false;
    }


        /*
        注册过程分五步：
        1.先判断格式是否输入正确
        输入错误要给出提示
        2.输入正确之后将输入框的数据获取到；
        3.先进行查询操作，查询数据库中有没有account重复的
          3.1如果有，则说明已经注册过了，重新登录
          3.2如果没有则进行注册
        4.满足条件的用户将输入框中的数据保存在一个对象中
        调用insert(对象 对象名)方法
        5.判断是否插入成功
          5.1如果返回的值为1则说明插入成功；提示注册成功，请登录
          5.2如果返回的值为0则说明注册失败；

         */
    //1.判断是否输入正确


}

