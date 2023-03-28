package com.company.panels;

import com.company.Database.DatabseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllMedicine {
    private JPanel showAllMedicinePanel;
    private JTable table1;
    private JButton homeButton;

    public JPanel getShowAllMedicinePanel() {
        return showAllMedicinePanel;
    }

    public ShowAllMedicine() throws SQLException {

//        String[][] data = {{"1","one","11.2"},{"2","two","11.3"},{"1","one","11.2"},{"2","two","11.3"},{"1","one","11.2"},{"2","two","11.3"}};
        DatabseService ds = new DatabseService();
        String[][] data = ds.showAllMedicines();
        ds.closeConnection();

        String[] columnName ={"ID","Name","Price"};
        table1 = new JTable(data,columnName);
        table1.setBackground(Color.gray);
        JScrollPane sp = new JScrollPane(table1);

        showAllMedicinePanel.add(sp);
//        showAllMedicinePanel.add(table1);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicalStore.getFrame().remove(showAllMedicinePanel);
                MedicalStore.getFrame().add(new MedicalStore().getPanel1());
                MedicalStore.getFrame().pack();
            }
        });
    }
}
