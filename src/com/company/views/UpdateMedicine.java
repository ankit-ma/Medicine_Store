package com.company.views;

import com.company.Database.DatabseService;
import com.company.Database.MedicineRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateMedicine {
    public AnchorPane updatePane;
    public Button homeButton;
    public TextField id;
    public TextField name;
    public TextField price;
    public Button updateButton;

    public void homeButtonListner(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        updatePane.getChildren().setAll(pane);
    }

    public void updateButtonListner(ActionEvent actionEvent) {
        try{
            DatabseService db = new DatabseService();
            MedicineRecord mr = new MedicineRecord(Integer.parseInt(id.getText()),name.getText(),price.getText());
            String res = db.updateMedicine(mr);
            if(res.equals("true")){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Updated");
                a.setContentText("Updated Medicine ID: "+id.getText());
                a.show();
            }
            else if(res.equals("SQL Error")){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Not Updated");
                a.setContentText("An Internal SQL Query/Connection Error\nGive Feedback");
                a.show();
            }
            db.closeConnection();
        }
        catch(SQLException sqlException){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Not Updated");
            a.setContentText("An Internal SQL Query/Connection Error\nGive Feedback");
            a.show();
        }
    }
}
