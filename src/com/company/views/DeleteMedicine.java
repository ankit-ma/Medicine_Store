package com.company.views;

import com.company.Database.DatabseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteMedicine {
    public AnchorPane deletePane;
    public Button deleteButton;
    public Label idLabel;
    public TextField input;
    public Button homeButton;

    public void homeButtonListner(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        deletePane.getChildren().setAll(pane);
    }

    public void deleteButtonListner(ActionEvent actionEvent) {
        try{
            DatabseService db = new DatabseService();
            String res =db.deleteMedicine(Integer.parseInt(input.getText()));
            if(res.equals("true")){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Deleted");
                a.setContentText("Deleted Successfully ID= "+input.getText());
                a.show();
            }
            else if(res.equals("SQL Error")){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("SQL Error");
                a.setContentText("An Internal Error Occured\nShare a valuable Feedback");
                a.show();
            }
            db.closeConnection();
        }
        catch (NumberFormatException n){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Give Valid ID");
            a.setContentText("ID must be an integer");
            a.show();
        }
        catch(SQLException sq){

        }
    }
}
