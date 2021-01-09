package com.gcl.demo.control;
import com.gcl.demo.service.registerIdentity;
import com.gcl.demo.utils.Dialoginfo;
import com.gcl.demo.view.loginMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class loginslip implements Initializable {
    @FXML
   private TextField id;
    @FXML
    private TextField nickname;
    @FXML
    private TextField sex;
    @FXML
    private TextField age;
    @FXML
    private TextField phone;
    @FXML
    private TextField account;
    @FXML
    private Button loginBtn;
    public TextField getAccount() {
        return account;
    }

    //数据成员的getter方法和setter方法
    public TextField getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }
    public TextField getNickname() {
        return nickname;
    }

    public void setNickname(TextField nickname) {
        this.nickname = nickname;
    }

    public TextField getSex() {
        return sex;
    }

    public void setSex(TextField sex) {
        this.sex = sex;
    }

    public TextField getAge() {
        return age;
    }

    public void setAge(TextField age) {
        this.age = age;
    }

    public TextField getPhone() {
        return phone;
    }

    public void setPhone(TextField phone) {
        this.phone = phone;
    }
    //普通方法
    /*
    1.判断输入框是否为空
     */
    /*
    1.获取从注册界面得到的对象
    2.设置对象的基本信息，从上面的文本输入框获取；
    3.将这个对象插入到数据库中；
    4.插入成功则说明注册成功了，可以登录
     */
    public void loginslip (ActionEvent actionEvent) throws Exception {
        String account=getAccount().getText();
        int id=Integer.parseInt(getId().getText());
        String nickname=getNickname().getText();
        String sex=getSex().getText();
        int age=Integer.parseInt(getAge().getText());
        String phone=getPhone ().getText ();
        registerIdentity registerIdentity=new registerIdentity();
       // System.out.println("hhhhhhhh");
        boolean flag=registerIdentity.isInsertAll(account,id,nickname,sex,age,phone);
        if(flag){
            Dialoginfo dialoginfo=new Dialoginfo ();
            dialoginfo.dialogReform ("信息完善，请去登录体验Hotpop点餐系统吧！");
            closeWindow();
            ChangeWindowLogin();

        }

//
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public static void ChangeWindowLogin() throws Exception {
        loginMain loginMain=new loginMain();
        loginMain.showWindowLogin();
    }
    public  void closeWindow() {
        loginBtn.setOnAction(event ->
                ((Stage) (loginBtn.getScene().getWindow())).close());
    }


}
