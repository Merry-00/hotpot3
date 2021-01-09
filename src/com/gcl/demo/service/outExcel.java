package com.gcl.demo.service;
import java.io.File;
import java.util.List;

import com.gcl.demo.dao.RecordDaoIplm;
import com.gcl.demo.model.Record;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class outExcel {
    // 创建可写入的Excel工作薄
    private static String fileName = "D:\\Hotpop订餐系统.xlsx";

    public static void toWriteExcel() {
        try {
            WritableWorkbook excelBook = null;
            // 打开文件
            File file = new File(fileName);
            // 查看文件是否存在
            if(!file.exists()) {
                // 不存在创建
                file.createNewFile();
            }

            //以fileName为文件名来创建一个Workbook
            excelBook = Workbook.createWorkbook(file);

            //创建工作表
            WritableSheet excelSheet = excelBook.createSheet("Test 1", 0);

            //导出数据中所有数据
            String sqlTableName = "hotpopuser";
            RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();

            List<Record> list = recordDaoIplm.selectAllRecord ();

            //要插入到的Excel表格的行号，默认从0开始
            Label labelAccount = new Label(0, 0 , "account");
            Label labelOrdernum = new Label(1, 0 , "ordernum");
            Label labelId = new Label(2, 0 , "id");
            Label labelName=new Label (3,0,"name");
            Label labelPrice=new Label (4,0,"price");
            Label labelTotal=new Label (5,0,"total");
            Label labelNum=new Label (6,0,"num");
            //Label labelTime=new Label (7,0,"time");


            //添加第一列到单元格
            excelSheet.addCell(labelAccount);
            excelSheet.addCell(labelOrdernum);
            excelSheet.addCell(labelId);
            excelSheet.addCell (labelName);
            excelSheet.addCell (labelPrice);
            excelSheet.addCell (labelTotal);
            excelSheet.addCell (labelNum);
            //excelSheet.addCell (labelTime);
            // 导入
            for(int i = 0; i < list.size(); i++) {
                //要插入到的Excel表格的行号，默认从0开始
                Label label_Account = new Label(0, i+1 , list.get(i).getAccount ());
                Label label_Ordernum = new Label(1, i+1 , Integer.toString (list.get(i).getOrdernum ()));
                Label label_Id = new Label(2, i+1 , list.get(i).getId ());
                Label label_Name=new Label (3,i+1,list.get (i).getName ());
                Label label_Price=new Label (4,i+1,Float.toString (list.get (i).getPrice ()));
                Label label_Total=new Label (5,i+1,Float.toString (list.get (i).getTotal ()));
                Label label_Num=new Label (6,i+1,Integer.toString (list.get (i).getNum ()));
                //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");//注意月份是MM
               // Date date = simpleDateFormat.parse("yyyy年MM月dd日 HH时mm分ss秒");
               // date=list.get (i).getTime ();
               // Label label_Time=new Label (7,i+1,simpleDateFormat.format(date));



                //添加第一列到单元格
                excelSheet.addCell(label_Account);
                excelSheet.addCell(label_Ordernum);
                excelSheet.addCell(label_Id);
                excelSheet.addCell(label_Name);
                excelSheet.addCell(label_Price);
                excelSheet.addCell(label_Total);
                excelSheet.addCell(label_Num);
                //excelSheet.addCell(label_Time);
            }

            //写入文档
            excelBook.write();
            //关闭Excel工作薄对象
            excelBook.close();
            System.out.println("A");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        toWriteExcel();
    }
}
