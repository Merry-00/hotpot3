package com.gcl.demo.dao;

import com.gcl.demo.model.Foods;
import com.gcl.demo.utils.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoIplm {

    @Test
    public int insert(Foods foods,String sql){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        //String sql="insert into food(id,name,price,num,info) values (?,?,?,?,?);";
        try {

            //1.获取数据库的连接对象
            connection= DBUtil.getConnection();
            System.out.println("conn的值"+connection);
            //2.获取对数据库操作的对象
            preparedStatement=connection.prepareStatement(sql);
            //3.设置values中的值
           // preparedStatement.setString(1,foods.getId());
            preparedStatement.setString(1,foods.getName());
            preparedStatement.setFloat(2,foods.getPrice());
            preparedStatement.setInt(3,foods.getNum());
            preparedStatement.setString(4,foods.getInfo());
            //4.返回执行结果
            int x=preparedStatement.executeUpdate();
            return x;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            //5.关闭释放资源
            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return 0;
    }
    public int delete(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="delete from food where id=?";

        try {
            //1.获取连接对象
            connection=DBUtil.getConnection();
            //2.获取预编译对象
            preparedStatement=connection.prepareStatement(sql);
            //3.设置values中的值
            preparedStatement.setInt(1,id);
            //4.返回执行结果
            int x=preparedStatement.executeUpdate();
            return x;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            //5.关闭释放资源-先开后关原则
            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return 0;
    }
    @Test
    public int update(Foods foods,int id){
      Connection connection=null;
      PreparedStatement preparedStatement=null;
      String sql="update food set name=?,price=? where id=?";

       //2.获取数据库操作对象
        try {
            //1.获取数据库连接对象
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            //3.设置通配符的值
            preparedStatement.setString(1,foods.getName());
            preparedStatement.setFloat(2,foods.getPrice());
            preparedStatement.setInt(3,id);
            //4.获取返回结果
            int x=preparedStatement.executeUpdate();
            return x;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            //关闭释放资源
            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return 0;
    }
    public Foods select(int id){

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from food where id=?";

        try {
            //1.获取连接数据库对象-connection
            connection=DBUtil.getConnection();
            //2.获取数据库操作对象-preparedStatement
            preparedStatement=connection.prepareStatement(sql);
            //3.设置通配符的值
            preparedStatement.setInt(1,id);
            //4.返回查询结果集
            resultSet=preparedStatement.executeQuery();
            //获取当id=?时的菜信息
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int num = resultSet.getInt("num");
                String info = resultSet.getString("info");
                Foods foods = new Foods(id, name, price, num, info);
                return foods;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            //5.关闭释放资源
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return null;
    }
    @Test
    public List<Foods> selectAll(){
        //获取连接数据库对象-connection
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Foods> list=new ArrayList<>();
/*
 private int fid;//菜编号
    private String name;//菜名
    private float price;//价格
    private int num;//购买数量
    private String info;//评论信息
 */
        String sql="select * from food";
        try {
            connection=DBUtil.getConnection();
            //获取数据库操作对象-preparedStatement
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                /*
                每从表中查询到一行数据，就把它写入对象中，直到没有数据。
                 */
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                float price=resultSet.getFloat("price");
                int num=resultSet.getInt("num");
                String info=resultSet.getString("info");
                //将从数据库中查到的结果保存在实体类Foods中，以便后面取出
                Foods foods=new Foods(id,name,price,num,info);
                list.add(foods);//将对象存在集合中
//                for(Foods f:list){
//                    System.out.println(f);
//                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return list;
    }

}
