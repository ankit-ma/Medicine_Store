package com.company.panels;

import com.company.Database.DatabseService;
import com.company.Database.MedicineRecord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateMedicine {
    private JPanel updateMedicine;
    private JTextField id;
    private JTextField name;
    private JTextField price;
    private JButton updateButton;
    private JButton homeButton;

    public JPanel getUpdateMedicine() {
        return updateMedicine;
    }

    public UpdateMedicine() {
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicalStore.getFrame().remove(updateMedicine);
                MedicalStore.getFrame().add(new MedicalStore().getPanel1());
                MedicalStore.getFrame().pack();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DatabseService ds = new DatabseService();
                    MedicineRecord md = new MedicineRecord(Integer.parseInt(id.getText()),name.getText(),price.getText());
                    String res = ds.updateMedicine(md);
                    if(res.equals("true")){
                        JOptionPane.showMessageDialog(MedicalStore.getFrame(),"Updated Successfully");
                    }
                    ds.closeConnection();
                }
                catch(NumberFormatException nm){
                    JOptionPane.showMessageDialog(MedicalStore.getFrame(),"Enter digit in ID field");
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(MedicalStore.getFrame(),"SQL Error");
                }

            }
        });
    }
}
