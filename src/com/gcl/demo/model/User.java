package com.gcl.demo.model;
/*
1.account;
2.password
3.id;
4.nickname;
5.sex;
6.age;
phone;
 */
public class User {
    //成员变量
    private String account;
    private int id;
    private String nickname;
    private String sex;
    private int age;
    private String phone;
    //构造方法
    //1.空构造方法
    public User(){}
    //2.账号密码的构造方法

    //3.id,nickname,sex,age,phone的构造方法

    public User(String account, int id, String nickname, String sex, int age, String phone) {
        this.account = account;
        this.id = id;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
    }

    public User(int id, String nickname, String sex, int age, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
    }

    //4.getter方法和setter方法

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //重写toString()方法
    public String toString(){
        return "账号："+this.account+"\t"+"昵称："+this.nickname+"\t"+"性别："+this.sex+"年龄："+this.age+
                "\t"+"电话号码："+this.phone;
    }
}
