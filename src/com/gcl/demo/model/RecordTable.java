package com.gcl.demo.model;

import com.gcl.demo.utils.checkbox;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class RecordTable {
    private SimpleBooleanProperty check = new SimpleBooleanProperty();
    private SimpleStringProperty account;//账号
    private SimpleStringProperty ordernum;//订单编号---为主键---唯一

    @Override
    public String toString() {
        return "RecordTable{" +
                "账号" + account +
                ", 订单编号=" + ordernum +
                ", id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", 应付金额=" + total +
                ", 下单数量=" + num +
                ", 下单时间=" + time +
                '}';
    }

    private SimpleStringProperty id;//菜编号
    private SimpleStringProperty name;//菜名
    private SimpleStringProperty price;//价格
    private SimpleStringProperty total;//应付金额
    private SimpleStringProperty num;//购买数量
    private SimpleStringProperty time;//下单时间
     public checkbox cb=new checkbox();

    public RecordTable() {
    }

    //构造方法
    /*
    将String类型的数据全部转换成SimpleStringProperty类型=====这样tableView才能显示出
     */
    public RecordTable(String account, String ordernum,String id, String name, String price, String total, String num, String time) {
        this.account = new SimpleStringProperty (account);
        this.ordernum = new SimpleStringProperty (ordernum);
        this.id = new SimpleStringProperty (id);
        this.name = new SimpleStringProperty (name);
        this.price = new SimpleStringProperty (price);
        this.total = new SimpleStringProperty (total);
        this.num = new SimpleStringProperty (num);
        this.time = new SimpleStringProperty (time);
    }

    public String getAccount() {
        return account.get ();
    }

    public SimpleStringProperty accountProperty() {
        return account;
    }

    public void setAccount(String account) {
        this.account.set (account);
    }

    public String getOrdernum() {
        return ordernum.get ();
    }

    public SimpleStringProperty ordernumProperty() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum.set (ordernum);
    }

    public String getId() {
        return id.get ();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set (id);
    }

    public String getName() {
        return name.get ();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set (name);
    }

    public String getPrice() {
        return price.get ();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set (price);
    }

    public String getTotal() {
        return total.get ();
    }

    public SimpleStringProperty totalProperty() {
        return total;
    }

    public void setTotal(String total) {
        this.total.set (total);
    }

    public String getNum() {
        return num.get ();
    }

    public SimpleStringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set (num);
    }

    public String getTime() {
        return time.get ();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set (time);
    }
}
