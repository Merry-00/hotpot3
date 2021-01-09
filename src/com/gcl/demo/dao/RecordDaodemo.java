package com.gcl.demo.dao;

import com.gcl.demo.dao.RecordDaoIplm;
import com.gcl.demo.model.Record;
import com.gcl.demo.utils.getNowTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDaodemo {
    public static void main(String[] args) {
        //测试把订餐信息插入到orderrecord表中
        /*RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();
        getNowTime getNowTime=new getNowTime ();
        String account="314123456@qq.com";
        String id="111";
        String name="煲仔饭";
        float price=10;
        float total=10;
        int num=1;
        Date time=getNowTime.getNowTime ();
        Record record=new Record (account,id,name,price,total,num,time);
        int x=recordDaoIplm.insertBuy (record);
        if(x==1){
            System.out.println ("插入成功");
        }
        else{
            System.out.println ("插入失败");
        }
*/
        //2.测试查询所有订餐记录功能=====
      /*  RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();
        String account="314123456@qq.com";
        List<Record> recordList=new ArrayList<> ();
        recordList=recordDaoIplm.selectBuy (account);
        if(recordList!=null){
            for(Record record:recordList){
                System.out.println (record);
            }
        }*/
        //测试输出orderrecord表中的所有订单记录-----
        RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();
        List<Record> recordList=new ArrayList<> ();
        recordList=recordDaoIplm.selectAllRecord ();
        for(Record record:recordList){
            System.out.println (record);
        }


    }
}
