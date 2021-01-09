package com.gcl.demo.service;

import com.gcl.demo.utils.Dialoginfo;
import com.gcl.demo.dao.FoodDaoIplm;
import com.gcl.demo.model.Foods;

public class updateFood {
    public void updateFood(){
        FoodDaoIplm foodDaoIplm=new FoodDaoIplm ();
        Foods foods=new Foods ();
       Dialoginfo dialoginfo=new Dialoginfo ();
       String idinfo="请输入菜的编号";
        String id=dialoginfo.dialog (idinfo);
        int idf=Integer.parseInt(id);
        String nameinfo="请输入菜名";
        String name=dialoginfo.dialog (nameinfo);
        String priceinfo="请输入菜的价格";
        String p=dialoginfo.dialog (priceinfo);
        float price=Float.parseFloat(p);//类型转换，将字符串转换成float型
        int num=0;
        String info="blank";
       // foods.setId (id);
        foods.setName (name);
        foods.setPrice (price);
        foods.setNum (num);
        foods.setInfo (info);
        int x=foodDaoIplm.update (foods,idf);
        if(x==1){
            dialoginfo.dialogReform ("修改成功");
        }
        else{
            dialoginfo.dialogReform ("修改失败,可能原因是该菜的编号不存在！");
        }
    }
}
