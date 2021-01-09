package com.gcl.demo.control;

import com.gcl.demo.dao.RecordDaoIplm;
import com.gcl.demo.model.Record;
import com.gcl.demo.model.RecordTable;
import com.gcl.demo.utils.Dialoginfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class orderTableControl implements Initializable {
    @FXML
    private javafx.scene.control.TableColumn<RecordTable, String> ordernum;
    @FXML
    private javafx.scene.control.TableColumn<RecordTable, String> id;
    @FXML
    private javafx.scene.control.TableColumn<RecordTable, String> name;
    @FXML
    private javafx.scene.control.TableColumn<RecordTable, Float> price;
    @FXML
    private javafx.scene.control.TableColumn<RecordTable, Integer> total;
    @FXML
    private javafx.scene.control.TableColumn<RecordTable, Integer> num;
    @FXML
    private javafx.scene.control.TableColumn<RecordTable, String>  time;
    @FXML
    private TableView tableview;
    public TableView getTableview() {
        return tableview;
    }
    //里面填写的是RecordTable里面的对象-----从orderrecord表中查询
    public List<Record> selectRecord(){
        Dialoginfo dialoginfo=new Dialoginfo ();
        String account=loginControl.acc;
        RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();
        System.out.println ("为什么");
        if(recordDaoIplm.selectBuy (account)==null){
            dialoginfo.dialogReform ("您还没有订餐记录，快去点餐吧！");
        }
        List<Record> recordList=new ArrayList<> ();
        recordList=recordDaoIplm.selectBuy (account);
        //测试recordList====从orderrecord表中获取到的===
        for(Record record:recordList){
            System.out.println ("从orderrecord获取到的====");
            System.out.println (record);
        }
        return recordList;
    }
    //====将List<Record>===转换成-----List<RecordTable>
    public List<RecordTable> getRecordTable(){
        //RecordTable recordTable=new RecordTable();
        List<RecordTable> recordTables=new ArrayList<> ();
        List<Record> recordList=selectRecord();
        for(Record record:recordList){
            String account=record.getAccount ();
            String ordernum=String.valueOf (record.getOrdernum ());
            String id=record.getId ();
            String name=record.getName ();
            String price=Float.toString(record.getPrice ());
            String total=Float.toString (record.getTotal ());
            int numb=1;
            String num=String.valueOf (numb);
            Date date = record.getTime ();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINA);
            String time=sdf.format(date);
            RecordTable recordTable=new RecordTable (account,ordernum,id,name,price,total,num,time);
            recordTables.add (recordTable);
        }

        //测试输出recordTable-----将record--转换成----recordTable
        for (RecordTable re:recordTables){
            System.out.println ("输出转换成TableView可以显示的====RecordTable类型数据");
            System.out.println (re);
        }
        return recordTables;
    }
    ObservableList<RecordTable> obList = FXCollections.observableArrayList(getRecordTable());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ordernum.setCellValueFactory (new PropertyValueFactory<> ("ordernum"));
        id.setCellValueFactory(new PropertyValueFactory<> ("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        total.setCellValueFactory (new PropertyValueFactory<> ("total"));
        num.setCellValueFactory(new PropertyValueFactory<>("num"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        getTableview().setItems(obList);
        //checkCol.setCellValueFactory(cellData ->cellData.getValue().cb.getCheckBox());
        getTableview().setEditable(true);
    }
    //显示一个刷新tableView 界面的方法

}
