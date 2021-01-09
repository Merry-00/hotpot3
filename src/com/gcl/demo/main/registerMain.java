package com.gcl.demo.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
   @author:gcl
   @date:2021.1.8
   @function:
   connection configuration for Hotpop
 */
public class registerMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

     Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
     primaryStage.setTitle("Hotpot Manager");//窗口名
     primaryStage.setScene(new Scene(root, 600, 400));
     primaryStage.show();
    }

    //调用launch(args)的同时会调用start()方法
    public static void main(String[] args) {
        launch(args);
    }

}
