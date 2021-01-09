package com.gcl.demo.service;

import com.gcl.demo.dao.UserDaoIplm;
import com.gcl.demo.utils.Dialoginfo;

/*
2.注销账号：
  2.1先删除在userregister表中的数据
  2.2再删除在user表中的数据
  2.3再删除在orderrecord表中的记录
 */
public class deleteAccount {
    public void deleteAccount(){
        String sql1="delete from userregister where account=?";
        String sql2="delete from user where account=?";
        String sql3="delete from orderrecord where account=?";
        Dialoginfo dialoginfo=new Dialoginfo ();
        String account=dialoginfo.dialog ("请输入要注销的账号");
        UserDaoIplm userDaoIplm=new UserDaoIplm ();
        //select()查询到了就返回false
        if(!userDaoIplm.select (account)){
            userDaoIplm.delete (account,sql3);
           if(userDaoIplm.delete (account,sql1)==1&& userDaoIplm.delete (account,sql2)==1 ){
               dialoginfo.dialogReform ("注销账号成功！");
           }
           else{
               dialoginfo.dialogReform ("注销账号失败");
           }
        }


    }

}
