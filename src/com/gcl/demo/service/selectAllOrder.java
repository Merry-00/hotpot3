package com.gcl.demo.service;

import com.gcl.demo.dao.RecordDaoIplm;
import com.gcl.demo.model.Record;
import com.gcl.demo.utils.Dialoginfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
在查询当前账号的所有订餐记录时调用======
 */
public class selectAllOrder {
    public void selectAll(){
        RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();
        Dialoginfo dialoginfo=new Dialoginfo ();
        String account=dialoginfo.dialog ("请输入您当前的账号以验证身份：");
        List<Record> recordList=new ArrayList<> ();
        recordList = recordDaoIplm.selectBuy (account);
        if(recordList==null){
            //System.out.println ("没有查询到相关订餐记录");
            dialoginfo.dialogReform ("没有查询到相关订餐记录");
        }
        else{
            for(Record record:recordList){
                System.out.println (record);
                Date date = record.getTime ();
               String pattern = "yyyy年MM月dd日 HH时mm分ss秒";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
                //System.out.println (date);
                System.out.println("订餐时间："+simpleDateFormat.format(date));
            }
        }

    }

}
