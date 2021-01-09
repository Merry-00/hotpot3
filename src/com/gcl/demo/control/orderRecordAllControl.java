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

public class orderRecordAllControl implements Initializable {
    @FXML
    private javafx.scene.control.TableColumn<RecordTable, String> account;
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
    public List<Record> getAllRecord(){
        //从orderrecord表中获取所有订单记录======
        RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();
        Dialoginfo dialoginfo=new Dialoginfo ();
        List<Record> recordList=new ArrayList<> ();
        recordList=recordDaoIplm.selectAllRecord ();
        return recordList;

    }
    public List<RecordTable> getAllView() {
        List<RecordTable> recordTables = new ArrayList<> ();
        List<Record> recordList = getAllRecord ();
        for (Record record : recordList) {
            String account = record.getAccount ();
            String ordernum = String.valueOf (record.getOrdernum ());
            String id = record.getId ();
            String name = record.getName ();
            String price = Float.toString (record.getPrice ());
            String total = Float.toString (record.getTotal ());
            int numb = 1;
            String num = String.valueOf (numb);
            Date date = record.getTime ();
            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINA);
            String time = sdf.format (date);
            RecordTable recordTable = new RecordTable (account, ordernum, id, name, price, total, num, time);
            recordTables.add (recordTable);
        }
        return recordTables;
    }
    ObservableList<RecordTable> obList = FXCollections.observableArrayList(getAllView());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        account.setCellValueFactory (new PropertyValueFactory<> ("account"));
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

}
