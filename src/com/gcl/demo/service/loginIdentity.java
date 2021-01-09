package com.gcl.demo.service;

import com.gcl.demo.dao.UserDaoIplm;

public class loginIdentity {
    /*
    实现登录功能
    1.先在数据库中根据输入的账号，查找对应的password,
    1.1如果没有查找到结果，说明没有注册，先去注册；
    1.2如果查询到结果，就将password与输入的密码进行 匹配
    2.判断：
    匹配成功，说明账号，密码正确；
    匹配失败，说明密码不正确。
     */
    public String login(String account) {
        UserDaoIplm userDaoIplm = new UserDaoIplm();
        String password=userDaoIplm.selectGp(account);
        return password;

    }
    public boolean isManager(String account){
        UserDaoIplm userDaoIplm = new UserDaoIplm();
        int id=userDaoIplm.selectIsM(account);
        if(id==0){
            System.out.println("她不是管理员喔");
            return true;
        }
        else{
            System.out.println("她是管理员");
        }
        return false;
    }
}