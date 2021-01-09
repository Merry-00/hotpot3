package com.gcl.demo.model;

import java.util.Date;

public class Record {
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    private String account;//下单账号
    private int ordernum;//下单编号，唯一的，是主键
    private String id;//菜编号
    private String name;//菜名
    private float price;//菜单价
    private float total;//支付金额
    private int num;//下单数量
    private Date time;

    //构造方法
    public Record() {
    }

    public Record(String account, int ordernum, String id, String name, float price, float total, int num, Date time) {
        this.account = account;
        this.ordernum = ordernum;
        this.id = id;
        this.name = name;
        this.price = price;
        this.total = total;
        this.num = num;
        this.time = time;
    }

    public Record(String account,String id, String name, float price, float total, int num, Date time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.total = total;
        this.num = num;
        this.time = time;
        this.account=account;
    }

    @Override
    public String toString() {
        return "订单记录：[" +
                "账号：'" + account + '\'' +
                ", 订单编号：" + ordernum +
                ", 菜编号：'" + id + '\'' +
                ", 菜名：'" + name + '\'' +
                ", 价格" + price +
                ", 总金额：" + total +
                ",订餐数量：" + num +
                ']';
    }
}




