package com.gcl.demo.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class orderRecordAllTableMain extends Application {
    Stage stage=new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("orderRecordAllTable.fxml"));
        primaryStage.setTitle("Hotpot");
        primaryStage.setScene(new Scene (root, 600, 400));
        primaryStage.show();
    }
    //关闭当前窗口，通过监听对象来关闭
    public static void main(String[] args) {
        launch(args);
    }
    public void  showRecordAll() throws Exception {
        start(stage);
    }
}
