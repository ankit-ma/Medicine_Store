package com.company.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MedicalStore {
    private JPanel panel1;

    private JButton addmedicinebtn;
    private JButton deleteMedicinebtn;
    private JButton updateMedicinebtn;
    private JButton showAllbtn;
    private static JFrame frame;

    public MedicalStore() {
        addmedicinebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel1);
                frame.add(new AddMedicine().getAddPanel());
                frame.pack();
//                frame.dispose();
            }
        });
        deleteMedicinebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel1);
                frame.add(new DeleteMedicine().getDeletePanel());
                frame.pack();
            }
        });
        updateMedicinebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel1);
                frame.add(new UpdateMedicine().getUpdateMedicine());
                frame.pack();
            }
        });
        showAllbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel1);
                try {
                    frame.add(new ShowAllMedicine().getShowAllMedicinePanel());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(MedicalStore.getFrame(),"SQL Error");
                    ex.printStackTrace();
                }
                frame.pack();
            }
        });
    }

    public static JFrame getFrame() {
        return frame;
    }
    public JPanel getPanel1(){
        return panel1;
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        frame = new JFrame("Medical Store");
//        frame.setContentPane(new MedicalStore().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(536,300));
        frame.setMaximumSize(new Dimension(536,300));
        frame.add(new MedicalStore().panel1);
        frame.pack();
        frame.setVisible(true);

    }
}
