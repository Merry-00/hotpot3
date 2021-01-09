package com.gcl.demo.dao;

import com.gcl.demo.model.User;

public class UserDaodemo {
    public static void main(String[] args) {
        UserDaoIplm userDaoIplm=new UserDaoIplm();
        User user=new User("3143357880",109,"jack","m",20,"12345678901");
        //userDaoIplm.insert(user);
        int x=userDaoIplm.delete ("3143357880","delete from user where account=?");
        if(x==1){
            System.out.println ("删除成功");
        }
        else{
            System.out.println ("删除失败");
        }
    }
}
