package com.company;

import com.company.panels.MedicalStore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
	// write your code here
//        MedicalStore mm = new MedicalStore();
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./views/dashboard.fxml"));
        primaryStage.setTitle("Medicine Record");
        primaryStage.setScene(new Scene(root, 580, 360));
        primaryStage.setMaxWidth(580);
        primaryStage.setMaxHeight(360);
        primaryStage.setMinHeight(360);
        primaryStage.setMinWidth(580);
        primaryStage.show();
    }
}
