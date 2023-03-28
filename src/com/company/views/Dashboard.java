package com.company.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {
    public Button addMedicine;
    public Button deleteMedicine;
    public Button updateMedicine;
    public Button showAllMedicine;
    public AnchorPane dashboardPane;
    public Label heading;

    public void addmedicinelistner(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AddMedicine.fxml"));
        dashboardPane.getChildren().setAll(pane);
    }

    public void deleteMedicineListner(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("DeleteMedicine.fxml"));
        dashboardPane.getChildren().setAll(pane);
    }

    public void updateMedicineListner(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("UpdateMedicine.fxml"));
        dashboardPane.getChildren().setAll(pane);
    }

    public void showAllMedicineListner(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Showall.fxml"));
        dashboardPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //heading.setRotate(-90);
    }
}
