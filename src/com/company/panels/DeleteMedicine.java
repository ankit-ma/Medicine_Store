package com.company.panels;

import com.company.Database.DatabseService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteMedicine {
    private JTextField id;
    private JButton homeButton;
    private JButton deleteMedicineButton;
    private JPanel deletePanel;

    public JPanel getDeletePanel() {
        return deletePanel;
    }

    public DeleteMedicine() {
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicalStore.getFrame().remove(deletePanel);
                MedicalStore.getFrame().add(new MedicalStore().getPanel1());
                MedicalStore.getFrame().pack();
            }
        });
        deleteMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DatabseService ds = new DatabseService();
                    int idd= Integer.parseInt(id.getText());
                    String result = ds.deleteMedicine(idd);
                    if(result.equals("true"))
                        JOptionPane.showMessageDialog(MedicalStore.getFrame(),"Deleted Successfully");
                    ds.closeConnection();
                }
                catch (NumberFormatException n){
                    JOptionPane.showMessageDialog(MedicalStore.getFrame(),"Enter a digit");
                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(MedicalStore.getFrame(),"SQL Error");
                    ex.printStackTrace();
                }


            }
        });
    }
}
