package com.company.panels;

import com.company.Database.DatabseService;
import com.company.Database.MedicineRecord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddMedicine {
    private JTextField name;
    private JTextField id;
    private JTextField price;
    private JPanel addPanel;
    private JLabel idLabel;
    private JButton addMedicineButton;
    private JButton homeButton;

    public AddMedicine() {
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicalStore.getFrame().remove(addPanel);
                MedicalStore.getFrame().add(new MedicalStore().getPanel1());
                MedicalStore.getFrame().pack();
            }
        });
        addMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int idd = Integer.parseInt(id.getText());
                    double priced = Double.parseDouble(price.getText());
                    MedicineRecord mr = new MedicineRecord(Integer.parseInt(id.getText()),name.getText(),price.getText());
                    DatabseService ds = new DatabseService();
                    String res = ds.addMedicine(mr);
                    if(res.equals("true")){
                        JOptionPane.showMessageDialog(MedicalStore.getFrame(),"Added medicine");
                    }
                    if(res.equals("Duplicate")){
                        JOptionPane.showMessageDialog(MedicalStore.getFrame(),"Enter other id,"+idd+"t is already exit");
                    }
                    ds.closeConnection();
                }catch(NumberFormatException n){
                    JOptionPane.showMessageDialog(MedicalStore.getFrame(),"Give int for id and double for price");
                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(MedicalStore.getFrame(),"SQL Error");
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getAddPanel(){
        return addPanel;
    }
}
