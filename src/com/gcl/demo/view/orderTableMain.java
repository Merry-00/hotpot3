package com.gcl.demo.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class orderTableMain extends Application {
    Stage stage=new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("orderTable.fxml"));
        primaryStage.setTitle("Hotpot");
        primaryStage.setScene(new Scene (root, 800, 600));
        primaryStage.show();
    }
    //关闭当前窗口，通过监听对象来关闭
    public static void main(String[] args) {
        launch(args);
    }
    public void  showWindoworderTable() throws Exception {
        start(stage);
    }
}
