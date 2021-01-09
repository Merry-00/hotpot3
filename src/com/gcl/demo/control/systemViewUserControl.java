package com.gcl.demo.control;

import com.gcl.demo.model.Food;
import com.gcl.demo.service.*;
import com.gcl.demo.utils.Dialoginfo;
import com.gcl.demo.view.orderRecordAllTableMain;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class systemViewUserControl implements Initializable {
    @FXML
    private javafx.scene.control.TableColumn<Food, String> id;
    @FXML
    private javafx.scene.control.TableColumn<Food, String> name;
    @FXML
    private javafx.scene.control.TableColumn<Food, Float> price;
    @FXML
    private javafx.scene.control.TableColumn<Food, Integer> num;
    @FXML
    private javafx.scene.control.TableColumn<Food, String>  info;
    @FXML
    private TableView tableview;
    @FXML
    private MenuItem exit;

    public MenuItem getExit() {
        return exit;
    }
    //List<Food>
    ObservableList<Food> obList = FXCollections.observableArrayList (new orderFood ().orderFoodView ());

    //定义弹出窗口的对象
    Dialoginfo dialoginfo = new Dialoginfo ();

    //第一个菜单的子菜单
//1.上架新品
    public void insertFoodControl(ActionEvent actionEvent) {
        insertFood insertFood = new insertFood ();
        insertFood.insertFood ();
    }

    //2.修改菜单
    public void updateFoodControl(ActionEvent actionEvent) {
        updateFood updateFood = new updateFood ();
        updateFood.updateFood ();
    }

    //3.下架宝贝
    public void deleteFoodControl(ActionEvent actionEvent) {
        deleteFood deleteFood = new deleteFood ();
        deleteFood.deleteFood ();

    }

    //4.销售记录


    //第二个菜单---账号管理
    //1.修改密码
    public void updatePasswordControl(ActionEvent actionEvent) {
        insertFood insertFood=new insertFood ();
        insertFood.updatePassword ();
    }

    //2.注销账号
    public void deleteAccountControl(ActionEvent actionEvent) {
        deleteAccount deleteAccount = new deleteAccount ();
        deleteAccount.deleteAccount ();
    }

    //第三个菜单的子菜单-----帮助
    //1.关于软件
    public void aboutsoftControl(ActionEvent actionEvent) {
        dialoginfo.dialogReform ("此软件是为Hotpop餐厅实现可以订餐的系统软件，欢迎您的使用！");
    }

    //2.退出系统
    public void exitControl(ActionEvent actionEvent) {
        System.exit (0);
        //不能通过点击子菜单关闭系统
    }
//订餐记录按钮====
    public void recordAllControl(ActionEvent actionEvent)
    {
        //切换到所有订单记录的表
        orderRecordAllTableMain o=new orderRecordAllTableMain ();
        try {
            o.showRecordAll ();
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }
//退出按钮======
    public void returnControl(ActionEvent actionEvent) {
    }

    public TableView getTableview() {
        return tableview;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory (new PropertyValueFactory<> ("id"));
        name.setCellValueFactory (new PropertyValueFactory<> ("name"));
        price.setCellValueFactory (new PropertyValueFactory<> ("price"));
        num.setCellValueFactory (new PropertyValueFactory<> ("num"));
        info.setCellValueFactory (new PropertyValueFactory<> ("info"));
        //将一个List<Food>类型数据---设置tableView的元素

        getTableview ().setItems (obList);
        //绑定复选框所在列的属性
        getTableview ().setEditable (true);
    }
    //刷新表格记录：
   /* public void frashControl(ActionEvent actionEvent) {
        final Label selected = new Label();
        tableview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                selected.setText("");
                return;
            }

            selected.setText("Selected Number: " + newValue.getId());
        });

    }*/



}

