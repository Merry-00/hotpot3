package com.gcl.demo.service;

import com.gcl.demo.dao.FoodDaoIplm;
import com.gcl.demo.model.Food;
import com.gcl.demo.model.Foods;

import java.util.ArrayList;
import java.util.List;
/*
将List<Foods>---转换成List<Food>
即将从数据库的food表中查询到的结果集封装成List<Foods>===
再把它转换成TableView能够显示的类型---List<Food>
 */
public class orderFood {
      public List<Food> orderFoodView(){
      FoodDaoIplm foodDaoIplm=new FoodDaoIplm ();
      //调用selectAll()方法会返回一个类型为Foods的list集合，里面存放的是对象
      List<Foods> foodsList= foodDaoIplm.selectAll ();
     //定义一个可以被TableView显示的Food类型的list集合
      List<Food> foodListV=new ArrayList<> ();
      //遍历从数据库查询到的并返回一个类型为Foods的list集合，将它重新封装成List<Food>
      for(Foods foods:foodsList){
         int fid=foods.getId ();
         String id=String.valueOf(fid);//将int类型转换成String类型
         //id=new SimpleStringProperty (s);//将String类型转换成TableView可以显示的类型
         String name=foods.getName ();
         float fprice=foods.getPrice ();
         String price=Float.toString (fprice);
         String num=String.valueOf (foods.getNum ());
         String info=foods.getInfo ();
         Food food=new Food (id,name,price,num,info);
         foodListV.add (food);
     }
      return foodListV;
  }


}
