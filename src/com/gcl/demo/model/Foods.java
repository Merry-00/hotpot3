package com.gcl.demo.model;


public class Foods {
    //成员变量
    private int id;//菜编号
    private String name;//菜名
    private float price;//价格
    private int num;//购买数量
    private String info;//评论信息
    //构造方法
    public Foods(){}
    public Foods(int id,String name,float price,int num,String info){
        this.id=id;
        this.name=name;
        this.price=price;
        this.num=num;
        this.info=info;
    }

    public Foods(String name, float price, int num, String info) {
        this.name = name;
        this.price = price;
        this.num = num;
        this.info = info;
    }
    //getter方法和setter方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    //重写toString()方法
    public String toString(){
        return "菜名："+this.name+"\t"+"价格："+this.price+"\t"+"订餐编号:"+this.id+"\t"+
                "顾客评论："+this.info;
    }

}
