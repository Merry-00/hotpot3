package com.gcl.demo.control;

import com.gcl.demo.service.registerIdentity;
import com.gcl.demo.service.sendEmail;
import com.gcl.demo.utils.Dialoginfo;
import com.gcl.demo.view.loginMain;
import com.gcl.demo.view.registerMsgMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class registerControl implements Initializable {
    public TextField getAccount() {
        return Account;
    }

    public PasswordField getRpassword() {
        return Rpassword;
    }

    public PasswordField getRepassword() {
        return Repassword;
    }

    //数据成员
    @FXML
    private TextField Account;
    @FXML
    private PasswordField Rpassword;
    @FXML
    private PasswordField Repassword;
    @FXML
    private Button aboutClose;
    @FXML
    private Button login;
    @FXML
    private TextField code;
    //getter方法
    public TextField getCode(){
        return code;
    }
    public String str=random ();
    //1.判断输入的格式是否正确
    public boolean isRight() {
        //第一次注册时使用QQ邮箱账号
        String Regex1 = "[1-9][0-9]{4,}@qq.com";
        //密码的格式
        String Regex2 = "^[a-zA-Z]\\w{5,17}$";
        Pattern pattern1 = Pattern.compile (Regex1);
        Pattern pattern2 = Pattern.compile (Regex2);
        if (Pattern.matches (Regex1, Account.getText ()) && Pattern.matches (Regex2, Rpassword.getText ())) {
            if (Rpassword.getText ().equals (Repassword.getText ())) {
                return true;
            } else {
                System.out.println ("两次输入的密码不正确！请重新输入");
            }
        } else if (!Pattern.matches (Regex1, Account.getText ())) {
            System.out.println ("QQ邮箱格式错误！请重新输入");
        } else if (!Pattern.matches (Regex2, Rpassword.getText ())) {
            System.out.println ("密码格式错误！密码只能由6-18位的数字，字母和下划线组成");
        }
        return false;
    }

    /*
    做一个提示框
     */
    public void dialog() {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Information Dialog");
        alert.setHeaderText ("注册成功");
        alert.setContentText ("快去登录吧");
        alert.showAndWait ();
    }

    //    @FXML
//    private Button aboutClose;
//    //关闭当前窗口，通过监听对象来关闭
//    public  void closeWindow() {
//        aboutClose.setOnAction(event ->
//                ((Stage) (aboutClose.getScene().getWindow())).close());
//    }
    public void registerControl() throws Exception {
        registerIdentity registerIdentity = new registerIdentity ();
        if (isRight ()) {
            if (registerIdentity.isExist (getAccount ().getText (), getRpassword ().getText ())) {
                {
                    if(getCode ().getText ().equals (str)){
                       // System.out.println ("注册成功!");
                        dialog ();
                        closeWindow ();
                        ChangeWindow ();
                    }
                    else{
                       // System.out.println ("验证码错误！");
                        Dialoginfo dialoginfo=new Dialoginfo ();
                        dialoginfo.dialogReform ("验证码错误！");

                    }

                }

            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /*
      用于跳转界面，当触发注册按钮时（动作事件），跳转到登录界面。
     */
    public static void ChangeWindow() throws Exception {
        registerMsgMain registerMsgMain = new registerMsgMain ();
        registerMsgMain.showWindow ();
    }

    public static void ChangeWindowLogin() throws Exception {
        loginMain loginMain = new loginMain ();
        loginMain.showWindowLogin ();
    }

    public void closeWindow() {
        aboutClose.setOnAction (event ->
                ((Stage) (aboutClose.getScene ().getWindow ())).close ());
    }

    public void loginControl(ActionEvent actionEvent) {
        try {
            closeWindow ();
            ChangeWindowLogin ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
/*
点击获取验证码按钮之后，发送验证码
 */
public String random(){
    //创建6位发验证码
    Random random = new Random ();
    String str = "";
    for (int i = 0; i < 6; i++) {
        int n = random.nextInt (6);
        str += n;
    }
    return str;
}
    public void getEmailCode(String str) {
        sendEmail sendEmail = new sendEmail ();
        //设置要发送的邮箱
        String email = getAccount ().getText ();
        sendEmail.setReceiveMailAccount (email);
        sendEmail.setInfo (str);
        try {
            sendEmail.Send ();

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void getEmailCodeR(ActionEvent actionEvent) {
        getEmailCode (str);
    }
}
