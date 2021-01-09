package com.gcl.demo.control;

import com.gcl.demo.dao.RecordDaoIplm;
import com.gcl.demo.model.*;
import com.gcl.demo.service.insertFood;
import com.gcl.demo.service.orderFood;
import com.gcl.demo.utils.Dialoginfo;
import com.gcl.demo.utils.getNowTime;
import com.gcl.demo.view.orderTableMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class SystemViewUserCustomer implements Initializable  {
    @FXML
    private javafx.scene.control.TableColumn<Food, String> id;
    @FXML
    private javafx.scene.control.TableColumn<Food, String> name;
    @FXML
    private javafx.scene.control.TableColumn<Food, Float> price;
    @FXML
    private javafx.scene.control.TableColumn<Food, Integer> num;
    @FXML
    private javafx.scene.control.TableColumn<Food, String> info;
    @FXML
    private javafx.scene.control.TableColumn<Food, CheckBox> checkCol;   //选中框
    @FXML
    private TableView tableview;
    @FXML
    private Button buyFood;

    //"账号","编号","昵称","性别","年龄","手机号码"
   // ObservableList<Userv> usersList = FXCollections.observableArrayList();
    //从User表中查询所有信息======

    /*public void listview(){
        Userv userv=new Userv ();
        ObservableList<Userv> wordsList = FXCollections.observableArrayList();
        List<String> stringList= cellFactories.getUserinfo ();
        userv.setAccount (stringList.get (1));
        userv.setId (stringList.get (2));
        userv.setNickname (stringList.get (3));
        userv.setSex (stringList.get (4));
        userv.setAge (stringList.get (5));
        userv.setPhone (stringList.get (6));
        wordsList.add (userv);
        ListView<Userv> listViewOfWords = new ListView<>(wordsList);
        listViewOfWords.setCellFactory(param -> new ListCell<Userv> () {
            @Override
            protected void updateItem(Userv item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getAccount ()== null) {
                    setText(null);
                } else {
                    setText(item.getNickname ());
                }
            }
        });
        getListview ().setItems (wordsList);

    }*/

    public TableView getTableview() {
        return tableview;
    }
//  获取当前用户登录的账号-----

    orderFood orderFood = new orderFood ();
    /*
    调用一个返回类型为List<Food>的方法，通过new 类名.方法获取
     */
    ObservableList<Food> obList = FXCollections.observableArrayList (new orderFood ().orderFoodView ());

    /*
    用fxml代码创建一个复选框类型的数据成员----它在Food类中()
     public checkbox cb=new checkbox();
    复选框的一个方法----isSelected()可以捕获到用户是否选择了复选框所在的列
     */
    //check()获取选中的菜的应付金额
    @FXML
    public float check() {
        float sum = 0;
        int i = 0;
        ObservableList<Food> list = tableview.getItems ();
        for (Food o : list) {

            if (o.cb.isSelected ()) {

                String p = o.getPrice ();
                float x = Float.parseFloat (p);
                sum += x;
                i++;
            }
        }
        System.out.println ("购买的总数量为：" + i);
        return sum;
    }
    //checknum返回购买的数量
    @FXML
    public int checknum(){
        int i = 0;
        ObservableList<Food> list = tableview.getItems ();
        for (Food o : list) {

            if (o.cb.isSelected ()) {
                //String p = o.getPrice ();
               // float x = Float.parseFloat (p);
                i++;
            }
        }
        return i;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //通过fx:id绑定tableView中的对应列---
        id.setCellValueFactory (new PropertyValueFactory<> ("id"));
        name.setCellValueFactory (new PropertyValueFactory<> ("name"));
        price.setCellValueFactory (new PropertyValueFactory<> ("price"));
        num.setCellValueFactory (new PropertyValueFactory<> ("num"));
        info.setCellValueFactory (new PropertyValueFactory<> ("info"));
        //将一个List<Food>类型数据---设置tableView的元素
        getTableview ().setItems (obList);
        //绑定复选框所在列的属性
        checkCol.setCellValueFactory (cellData -> cellData.getValue ().cb.getCheckBox ());
        getTableview ().setEditable (true);
    }


    //第一个菜单---订餐
    //1.第一个菜单的子菜单----订单评价
    public void informationControl(ActionEvent actionEvent) {
      Dialoginfo dialoginfo=new Dialoginfo ();
      String info=dialoginfo.dialog ("给亲一个好评喔！");
      String infom="感谢您的评价！，您评价的内容为："+info;
      dialoginfo.dialogReform (infom);
    }

    //第二个菜单----我的
//  2===个人信息菜单
//  =======2.1子菜单===基本信息
    public void selectRecordControl(ActionEvent actionEvent) {
          Dialoginfo dialoginfo=new Dialoginfo ();
          dialoginfo.dialogReform ("账号为："+loginControl.acc);
    }


    //  ====2.2===子菜单===修改密码
    public void updatePasswordControl(ActionEvent actionEvent) {
        insertFood insertFood=new insertFood ();
        insertFood.updatePassword ();
    }

    //去结算按钮===点击去结算就计算当前订单的所有应支付金额
    /*
       通过获取checkCol列对应的复选框----
       调用check()方法---返回购买的信息---
       1.菜单编号,2.菜名 3,菜单价格 4,购买数量 5.应付金额
       需要改变的值---销售数量加1----修改food表中的销售数量
      之后将订单信息插入到orderrecord表中，插入成功，则说明购买成功，
      插入失败，说明购买失败。
     */
    public void buyfoodControl(ActionEvent actionEvent) {
        Dialoginfo dialoginfo=new Dialoginfo ();
        //1.将List<Record>插入到表中
        List<Record> recordList = new ArrayList<> ();
        //获取tableView复选框中的信息List<Food>---将它转换成List<Foods>---List<Record>
        recordList = getRecord ();
        RecordDaoIplm recordDaoIplm=new RecordDaoIplm ();
        int sum=0;
        for(Record record:recordList){
            int x=recordDaoIplm.insertBuy (record);
            sum+=x;
        }
        if(sum==checknum()){
            float total=check ();
            String t=Float.toString(total);
            dialoginfo.dialogReform ("您本次订餐需要支付的金额为："+t);
        }
        else{
            dialoginfo.dialogReform ("购买出错，请核实订单！");
        }
    }
        public List<Record> getRecord(){
            //1.获取选中的菜单---List<Foods>
            List<Foods> foodsList=new ArrayList<> ();
            foodsList=changeCheck ();
            //2.把它封装成Record类型对象的List集合----List<Record>
        /*
         String id,
        String name, float price, float total, int num, Date time
         */
            getNowTime getNowTime=new getNowTime ();
            List<Record> recordList=new ArrayList<> ();
            for(Foods foods:foodsList){
                String account= loginControl.acc;
                String id=String.valueOf(foods.getId ());
                String name=foods.getName ();
                float price=foods.getPrice ();
                float total=price;
                System.out.println ("得到的金额total:"+total);
                System.out.println ("check是否插入了呢："+total);
                System.out.println ("输出当前购买的时间："+getNowTime.getNowTime ());
                //将Foods中的销售数量+1
                int fnum=foods.getNum ();
                int num=1;
                Date time=getNowTime.getNowTime ();
                Record record=new Record (account,id,name,price,total,num,time);
                recordList.add (record);
            }
           for(Record record:recordList){
               System.out.println ("11111111111开始测试========");
               System.out.println ("测试将购买的foods----封装成---recordList");
               System.out.println (record);
           }
            return recordList;
        }

        //返回一个Foods类型的List集合
        //订单记录按钮
    /*
    点击订单记录按钮---跳转到orderTable界面
     */
        //将从tableView中获取的列表信息---<Food> 转换成----<Foods>类型
        public List<Foods> changeCheck() {
            //1.获取TableView中显示的所有行----List<Food>
            ObservableList<Food> list = tableview.getItems ();
            //2.建一个Foods类型的list集合，用于后面存对象
            List<Foods> foodsList = new ArrayList<> ();
            //3.通过遍历获取每一个对象的所有属性值
            for (Food o : list) {
                //每次遍历都new一个Foods类型的对象
                //Foods foods = new Foods ();
                if (o.cb.isSelected ()) {
                    String fid = o.getId ();
                    int id = Integer.parseInt (fid);
                    String name = o.getName ();
                    String p = o.getPrice ();
                    //将float类型转化成String类型
                    float price = Float.parseFloat (p);
                    String fnum = o.getNum ();
                    int num = Integer.parseInt (fnum)+1;
                    String info = o.getInfo ();
                    Foods foods = new Foods (id, name, price, num, info);
                    foodsList.add (foods);
                }
            }
        return foodsList;
        }
//订餐记录
    public void selectOrderControl(ActionEvent actionEvent) {
            orderTableMain orderTableMain=new orderTableMain ();
        try {
            //切换到显示订单记录界面-----orderTable
            orderTableMain.showWindoworderTable ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        System.out.println ("等下再看吧");
    }


    //===订单记录按钮-----显示查询所有的订单记录======
    /*
    当点击订餐记录时---跳转到一个有tableview的界面
    显示的信息为orderrecord表中的信息；

     */


}

