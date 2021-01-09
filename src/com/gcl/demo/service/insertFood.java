package com.gcl.demo.service;

import com.gcl.demo.control.loginControl;
import com.gcl.demo.dao.UserDaoIplm;
import com.gcl.demo.model.User;
import com.gcl.demo.utils.Dialoginfo;
import com.gcl.demo.dao.FoodDaoIplm;
import com.gcl.demo.model.Foods;


public class insertFood {
    public boolean insertFood(){
        Foods foods=new Foods ();
        Dialoginfo dialoginfo=new Dialoginfo ();
//        String idinfo="请输入菜的编号";
//        String id=dialoginfo.dialog (idinfo);
        String nameinfo="请输入菜名";
        String name=dialoginfo.dialog (nameinfo);
        String priceinfo="请输入菜的价格";
        String p=dialoginfo.dialog (priceinfo);
        if(p!=null) {
            Float price = Float.parseFloat (p);//类型转换，将字符串转换成float型

            int num = 0;
            String info = "blank";
            //foods.setId (id);
            foods.setName (name);
            foods.setPrice (price);
            foods.setNum (num);
            foods.setInfo (info);
            FoodDaoIplm foodDaoIplm = new FoodDaoIplm ();
            String sql = "insert into food(name,price,num,info) values(?,?,?,?);";
            int x = foodDaoIplm.insert (foods, sql);
            if (x == 1) {
                dialoginfo.dialogReform ("插入成功");
                return true;
            } else {
                dialoginfo.dialogReform ("插入失败");
            }
        }
        return false;
    }

    //顾客---SystemViewUserCustomer--修改密码
    public void updatePassword(){
        UserDaoIplm userDaoIplm=new UserDaoIplm ();
        User user=new User ();
        Dialoginfo dialoginfo=new Dialoginfo ();
        String account= loginControl.acc;
        String password=dialoginfo.dialog ("请输入您要修改的密码");
        user.setAccount (account);
        int x=userDaoIplm.update (user,password);
        if(x==1){
            dialoginfo.dialogReform ("修改密码成功");
        }
        else{
            dialoginfo.dialogReform ("修改密码失败！可能原因为账号不存在！");
        }
    }
}
