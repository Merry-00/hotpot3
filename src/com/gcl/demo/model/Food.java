package com.gcl.demo.model;

import com.gcl.demo.utils.checkbox;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Food {
    private SimpleBooleanProperty check = new SimpleBooleanProperty();
    private SimpleStringProperty id;//菜编号
    private SimpleStringProperty name;//菜名
    private SimpleStringProperty price;//价格
    private SimpleStringProperty num;//购买数量
    private SimpleStringProperty info;//评论信息
    public checkbox cb=new checkbox();
//构造方法
public Food(String id,String name,String price,String num,String info){
    this.id=new SimpleStringProperty(id);
    this.name=new SimpleStringProperty(name);
    this.price=new SimpleStringProperty(price);
    this.num=new SimpleStringProperty(num);
    this.info=new SimpleStringProperty(info);
}
public Food(SimpleBooleanProperty check){
    this.check=check;
}
    //getter方法和setter方法
    public boolean getCheck(){
    return this.check.get();
    }
    public void setCheck(boolean check) {
        this.check.set(check);
    }
    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getNum() {
        return num.get();
    }

    public SimpleStringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public String getInfo() {
        return info.get();
    }

    public SimpleStringProperty infoProperty() {
        return info;
    }

    public void setInfo(String info) {
        this.info.set(info);
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", num=" + num +
                ", info=" + info +
                '}';
    }
}
