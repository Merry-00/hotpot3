package com.gcl.demo.dao;

import com.gcl.demo.model.User;
import com.gcl.demo.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
 private String account;
    private String password;
    private int id;
    private String nickname;
    private String sex;
    private int age;
    private String phone;
 */
public class UserDaoIplm {
    /*
    user表中把账号设置为主键，所以不能插入重复的账号，
     */
    public int insert(User user){

        Connection connection=null;
        PreparedStatement preparedStatement=null;

        String sql="insert into user(account,id,nickname,sex,age,phone) values (?,?,?,?,?,?)";
        try {
            //1.获取连接对象
            connection= DBUtil.getConnection();
            //2.获取数据库操作对象
            preparedStatement= connection.prepareStatement(sql);
            //3.设置通配符的值
            preparedStatement.setString(1,user.getAccount());
            //preparedStatement.setString(2,user.getPassword());
           preparedStatement.setInt(2,user.getId());
            preparedStatement.setString(3,user.getNickname());
            preparedStatement.setString(4,user.getSex());
            preparedStatement.setInt(5,user.getAge());
            preparedStatement.setString(6,user.getPhone());
            //4.返回结果
            System.out.println ("123");
            System.out.println(preparedStatement);
            int x=preparedStatement.executeUpdate();
            return x;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            //5.关闭释放数据库
            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return 0;
    }
    public int insertR(String account,String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="insert into userregister(account,password) values (?,?)";

        try {
            //1.获取连接对象
            connection=DBUtil.getConnection();
            //2.获取数据库操作对象
            preparedStatement= connection.prepareStatement(sql);
            //3.设置通配符的值
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);

            //4.返回结果

            System.out.println(preparedStatement);
            int x=preparedStatement.executeUpdate();
            return x;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            //5.关闭释放数据库
            DBUtil.closeAll(connection,preparedStatement,null);
        }
        return 0;
    }
    public int delete(String account,String sql){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
       //String sql="delete from user where account=?";

        try {
            //1.获取连接对象
            connection=DBUtil.getConnection();
            //2.获取操作数据库对象
            preparedStatement=connection.prepareStatement(sql);
            //3.设置通配符的值
            preparedStatement.setString(1,account);
            //4.返回结果
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
    public int update(User user,String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="update  userregister set password = ? where account = ?";

        try {
            //1.获取连接数据库对象
            connection=DBUtil.getConnection();
            //2.获取操作数据库对象
            preparedStatement=connection.prepareStatement(sql);
            //3.设置通配符的值
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,user.getAccount());
            //4.返回结果
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
    public boolean select(String account){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from userregister where account=?";

        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            resultSet=preparedStatement.executeQuery();
           if(resultSet.next()){
               //System.out.println("您已经注册了账号为"+account+"的用户");
               return false;
           }
           else{
               return true;
           }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return false;
    }
    /*
    根据用户从界面输入框中输入的账号，查询到他的密码，与他输入的密码进行匹配，匹配成功，说明登录成功，否则
    可能是账号不存在或者密码错误
     */
    public String selectGp(String account){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from userregister where account=?";

        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                //System.out.println("您已经注册了账号为"+account+"的用户");
                String password=resultSet.getString(2);
                System.out.println("密码："+password);
                return password;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return null;
    }
    /*
    根据用户的账号在数据库中查询到他的id,如果id=0则说明她是管理员，否则他就是顾客
     */
    public int selectIsM(String account){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from user where account=?";

        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                //System.out.println("您已经注册了账号为"+account+"的用户");
                int id=resultSet.getInt(2);
                System.out.println("id："+id);
                return id;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return -1;
    }


    public User selectAllinfo(String account){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from user where account=?;";
        List<User> userList=new ArrayList<> ();//创建一个存User类型的对象list

        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString (1,account);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next ()){
                /*每一次循环获取user表中的一行，把它存到一个对象中，
                再将对象存在一个list<User>数组中
                 */
                String accountuser=resultSet.getString (1);
                int id=resultSet.getInt (2);
                String nickname=resultSet.getString (3);
                String sex=resultSet.getString (4);
                int age=resultSet.getInt (5);
                String phone=resultSet.getString (6);
                User user=new User (accountuser,id,nickname,sex,age,phone);
                return user;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.closeAll(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
