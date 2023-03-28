package com.company.views;

import com.company.Database.DatabseService;
import com.company.Database.MedicineRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowAll implements Initializable {
    public AnchorPane showallPane;
    public Button homebtn;
    public TableView<MedicineRecord> table;
    public TableColumn<MedicineRecord,Integer> id;
    public TableColumn<MedicineRecord,String> name;
    public TableColumn<MedicineRecord,String> price;

    public void homeButtonListner(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        showallPane.getChildren().setAll(pane);
    }
    public ShowAll(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            DatabseService db = new DatabseService();
            ArrayList<MedicineRecord> res = db.showAllMedicines2();
//            for(MedicineRecord m:res){
//                table.getItems().add(m);
//                System.out.println(m.toString());
//            }
            ObservableList<MedicineRecord> data = FXCollections.observableArrayList(res);

            table.getItems().addAll(data);
            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
