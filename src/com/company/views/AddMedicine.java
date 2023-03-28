package com.company.views;

import com.company.Database.DatabseService;
import com.company.Database.MedicineRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class AddMedicine {
    public AnchorPane addMedicinePane;
    public Label idLabel;
    public TextField idText;
    public TextField nameText;
    public Label nameLabel;
    public TextField priceText;
    public Label priceLabel;
    public Button addMedicineButton;
    public Button homeButton;

    public void addMedicineButtonListner(ActionEvent actionEvent) {
        try{
            int id = Integer.parseInt(idText.getText());
            String name = nameText.getText();
            Double price = Double.parseDouble(priceText.getText());
            //throw new NumberFormatException("double");
            MedicineRecord md = new MedicineRecord(id,name,price.toString());
            DatabseService db = new DatabseService();
            String res =db.addMedicine(md);
            if(res.equals("true")){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Medicine Added");
                a.setContentText(id+","+name+","+price);
                a.show();
            }
            else if(res.equals("Duplicate")){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Medicine Already Added");
                a.setContentText("You can update medicine from dashboard");
                a.show();
            }
            db.closeConnection();
        }
        catch(NumberFormatException n){
            System.out.println(n.getMessage());
            Alert a = new Alert(Alert.AlertType.WARNING);
//            String mm = n.getMessage();
            if(n.getMessage().contains(priceText.getText())) {
                a.setHeaderText("Price Warning");
                a.setContentText("Enter a valid price");
            }
            else {
                a.setHeaderText("ID Warning");
                a.setContentText("Enter a valid id");
            }
            a.show();
        } catch (SQLException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("SQL Error");
            a.show();
            e.printStackTrace();
        }

    }

    public void homeButtonListner(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        addMedicinePane.getChildren().setAll(pane);

    }
}
