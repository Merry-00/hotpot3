package com.gcl.demo.service;

import com.gcl.demo.utils.Dialoginfo;
import com.gcl.demo.dao.FoodDaoIplm;

public class deleteFood {
    public void deleteFood(){
        FoodDaoIplm foodDaoIplm=new FoodDaoIplm ();
        Dialoginfo dialoginfo=new Dialoginfo ();
        String idinfo="请输入菜的编号";
        String id=dialoginfo.dialog (idinfo);
        int idf=Integer.parseInt (id);
        int x=foodDaoIplm.delete (idf);
        if(x==1){
            dialoginfo.dialogReform("删除成功");
        }
        else{
            dialoginfo.dialogReform ("删除失败");
        }
    }
}
