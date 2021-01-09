package com.gcl.demo.dao;

import com.gcl.demo.model.User;
import com.gcl.demo.utils.DBUtil;
import com.gcl.demo.model.Record;
import com.gcl.demo.utils.getNowTime;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RecordDaoIplm {
    /*
    实现对销售记录的增，查操作
    private String account;
    private String id;//菜编号
    private String name;
    private float price;
    private double total;//支付金额
    private int num;//下单数量
    private Date time;
     */
    @Test
    public int insertBuy(Record record){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="insert into orderrecord(account,id,name,price,total,num,time) values (?,?,?,?,?,?,?);";
        try {

            //1.获取数据库的连接对象
            connection= DBUtil.getConnection();
            System.out.println("conn的值"+connection);
            //2.获取对数据库操作的对象
            preparedStatement=connection.prepareStatement(sql);
            //将Date类型的数据转换成String类型，写入到表中
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            Date time = record.getTime ();
            String timestring= format.format(time);
            //3.设置values中的值
            preparedStatement.setString(1,record.getAccount ());
            preparedStatement.setString(2,record.getId ());
            preparedStatement.setString (3,record.getName ());
            preparedStatement.setFloat (4,record.getPrice ());
            preparedStatement.setFloat (5,record.getTotal ());
            preparedStatement.setInt (6,record.getNum ());
            preparedStatement.setString(7,timestring);
            /*
            Date类型的数据写入数据库要转换才能插入
             */

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
    @Test
    //根据某人的账号将他的订餐记录按时间顺序保存到一个对象list集合中
    public List<Record> selectBuy(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from orderrecord where account=? ORDER BY time ASC ";//将订餐记录按时间排序
        //建一个订餐结果表，把查询到的每一行数据都封装成对象，再创建一个list保存对象
        List<Record> recordList=new ArrayList<> ();
        try {
            connection = DBUtil.getConnection ();
            preparedStatement = connection.prepareStatement (sql);
            preparedStatement.setString (1, account);
            resultSet = preparedStatement.executeQuery ();
           while(resultSet.next ()) {
                String accountbuy = resultSet.getString (1);
                int ordernum = resultSet.getInt (2);
                String id=resultSet.getString(3);
                String name=resultSet.getString (4);
                float price=resultSet.getFloat (5);
                float total=resultSet.getFloat (6);
                int num=resultSet.getInt (7);
                //将String类型转换成Date类型
                String s= resultSet.getString(8);
                System.out.println ("表中的时间："+s);
                java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINA);
                Date time =  formatter.parse(s);
                Record record=new Record (accountbuy,ordernum,id,name,price,total,num,time);
                recordList.add(record);
            }
            return recordList;
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace ();
        } finally {
            DBUtil.closeAll (connection, preparedStatement, resultSet);
        }
      return null;
    }
    @Test
    //获取orderrecord表中的所有记录=====
    public List<Record> selectAllRecord(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from orderrecord ORDER BY time ASC ";//将订餐记录按时间排序
        //建一个订餐结果表，把查询到的每一行数据都封装成对象，再创建一个list保存对象
        List<Record> recordList=new ArrayList<> ();
        try {
            connection = DBUtil.getConnection ();
            preparedStatement = connection.prepareStatement (sql);
            resultSet = preparedStatement.executeQuery ();
            while(resultSet.next ()) {
                String accountbuy = resultSet.getString (1);
                int ordernum = resultSet.getInt (2);
                String id=resultSet.getString(3);
                String name=resultSet.getString (4);
                float price=resultSet.getFloat (5);
                float total=resultSet.getFloat (6);
                int num=resultSet.getInt (7);
                //将String类型转换成Date类型
                String s= resultSet.getString(8);
                System.out.println ("表中的时间："+s);
                java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINA);
                Date time =  formatter.parse(s);
                Record record=new Record (accountbuy,ordernum,id,name,price,total,num,time);
                recordList.add(record);
            }
            //测试输出orderrecord表中的记录=====
            return recordList;
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace ();
        } finally {
            DBUtil.closeAll (connection, preparedStatement, resultSet);
        }
        return null;
    }
}
