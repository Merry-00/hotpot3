package com.gcl.demo.control;

import com.gcl.demo.service.loginIdentity;
import com.gcl.demo.utils.Dialoginfo;
import com.gcl.demo.view.systemViewUserCustomerMain;
import com.gcl.demo.view.systemViewUserMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class loginControl implements Initializable {
    @FXML
    private Button loginbutton;

   @FXML
    private PasswordField password;

    public PasswordField getPassword() {
        return password;
    }

    public TextField getAccount() {
        return account;
    }
   public static String acc;

    @FXML
    private TextField account;

    public void loginControl() throws Exception {
        loginIdentity loginIdentity=new loginIdentity();
        String account=getAccount().getText();
        String password=getPassword().getText();
        String Spassword=loginIdentity.login(account);
        if(Spassword!=null){
            if(password.equals(Spassword)){
                System.out.println("登录成功");
                 acc=account;
                if(loginIdentity.isManager(account)){
                    System.out.println("进入用户订餐界面======");
                    closeWindow ();
                    changeWindowUserCustomer();
                }
                else{
                    System.out.println("进入管理界面=====");
                    closeWindow ();
                    changeWindowsym ();
                }

                //changeWindowsym();


            }
        }
        else{
            Dialoginfo dialoginfo=new Dialoginfo ();
            dialoginfo.dialogReform ("登录失败！账号有误或者密码错误！");
        }
        closeWindow();
    }
    public void changeWindowsym() throws Exception {
        systemViewUserMain systemViewUserMain=new systemViewUserMain ();
        systemViewUserMain.showWindowLogin ();
    }
    public void changeWindowUserCustomer() throws Exception {
        systemViewUserCustomerMain systemViewUserCustomerMain=new systemViewUserCustomerMain ();
        systemViewUserCustomerMain.showWindowUserCustomer ();
    }
    public  void closeWindow() {
        loginbutton.setOnAction(event ->
                ((Stage) (loginbutton.getScene().getWindow())).close());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
