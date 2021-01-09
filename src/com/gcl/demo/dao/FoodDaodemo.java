package com.gcl.demo.dao;

import com.gcl.demo.model.Food;
import com.gcl.demo.model.Foods;

import java.util.ArrayList;
import java.util.List;

public class FoodDaodemo {
    public static void insertFoods(Foods foods) {
    FoodDaoIplm foodDaoIplm = new FoodDaoIplm();
        List<Foods> list = new ArrayList<>();
        list = foodDaoIplm.selectAll();
        for(Foods f:list){
            /*遍历集合中的对象，id为主码，通过与集合中的对象匹配是否有相同的id
            如果有，则不能插入，插入失败。
            */
            if(foods.getId()!=(f.getId())){
                String sql="insert into food(name,price,num,info) values(?,?,?,?);";
                foodDaoIplm.insert(foods,sql);
                System.out.println("插入成功！");
                break;
            }
            else{
                System.out.println("插入失败！");
                break;
            }
        }
    }
    public static void main(String[] args) {
        FoodDaoIplm foodDaoIplm=new FoodDaoIplm();
    Foods foods=new Foods("生菜",5,10,"perfect");
    Foods foods1= new Foods ("鱼香肉丝饭", 16, 100, "good");
    Foods foods2=new Foods ("香菇滑鸡饭", 10, 100, "perfect");
    Foods foods3=new Foods ("黑椒牛排饭", 20, 100, "perfect");
    Foods foods4= new Foods ("梅菜扣肉饭", 30, 100, "good");
    Foods foods5= new Foods ("糖醋里脊饭", 30, 100, "good");
        List<Foods> foodsList=new ArrayList<> ();
        foodsList.add (foods);
        foodsList.add (foods1);
        foodsList.add (foods2);
        foodsList.add (foods3);
        foodsList.add (foods4);
        foodsList.add (foods5);
        for(Foods p:foodsList){
            String sql="insert into food(name,price,num,info) values (?,?,?,?);";
            foodDaoIplm.insert(p,sql);
            System.out.println (foods);
        }
     //insertFoods(foods);


        //测试删除数据
       /*int fid=161;
        FoodDaoIplm foodDaoIplm=new FoodDaoIplm();
        //foodDaoIplm.delete(fid);
        if(foodDaoIplm.delete(fid)!=0){
            System.out.println("删除成功！");
        }
*/
        //测试修改数据
        /*FoodDaoIplm foodDaoIplm=new FoodDaoIplm();
        Foods foods1=new Foods("白菜",10,100,"不错");
       foodDaoIplm.update(foods1,123);*/
       //测试单个查询数据
//        ♭

    }
}
