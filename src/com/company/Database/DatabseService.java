package com.company.Database;

import com.company.panels.MedicalStore;

import java.sql.*;
import java.util.ArrayList;

public class DatabseService {
    private Connection con;
    public DatabseService() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Medical_store", "root", "Ankitkumar1@");
    }
    public void closeConnection() throws SQLException {
        con.close();
    }
    public String addMedicine(MedicineRecord mr){
        try {
            Statement sm = con.createStatement();
            String query = "INSERT into DrugsRecord Values("+mr.getId()+
                    ",'"+mr.getName()+
                    "','"+mr.getPrice()+
                    "')";
            sm.execute(query);
            System.out.println("Added sucessfully");
        }
        catch(SQLException sq){
            System.out.println(sq);
            if(sq.toString().contains("Duplicate")) return "Duplicate";
            return "SQL Error";
        }
        catch (Exception e){
            System.out.println(e);
            return "false";
        }
        return "true";
    }
    public String deleteMedicine(int id){
        try{
            Statement sm = con.createStatement();
            String query = "Delete from DrugsRecord where id="+id;
            sm.execute(query);
            System.out.println("Deleted successfully");
        }
        catch (SQLException sq){
            System.out.println(sq);
            return "SQL Error";
        }
        catch (Exception e){
            System.out.println(e);
            return "false";
        }
        return "true";
    }
    public String updateMedicine(MedicineRecord mr){
        try{
            Statement sm = con.createStatement();
            String query= "Update DrugsRecord set name ='"+mr.getName()+"', price='"+mr.getPrice()+"' where id="+mr.getId();
            sm.execute(query);
            System.out.println("Updated Successfully");
        }
        catch(SQLException sq){
            System.out.println(sq);
            return "SQL Error";
        }
        catch(Exception e){
            System.out.println(e);
            return "Unknown error";

        }
        return "true";
    }
    public String[][] showAllMedicines(){

        try{
            Statement sm = con.createStatement();
            String query="Select * from DrugsRecord";
            ResultSet rs = sm.executeQuery(query);
            int size = 10;
//            System.out.println(size);
            String[][] res = new String[10][3];
            int i=0;
            rs.setFetchSize(10);
            while (rs.next()){
                res[i][0]=Integer.toString(rs.getInt(1));
                res[i][1]=rs.getString(2);
                res[i][2]=rs.getString(3);
                i++;
            }
//            System.out.println("Shows successfully");
            return res;
        }
        catch(SQLException sq ){
            System.out.println(sq);

        }
        catch (Exception e){
            System.out.println(e);

        }
        return null;
    }
    public ArrayList<MedicineRecord> showAllMedicines2(){
        ArrayList<MedicineRecord> res = new ArrayList<>();
        try{
            Statement sm = con.createStatement();
            String query="Select * from DrugsRecord";
            ResultSet rs = sm.executeQuery(query);
            int size = 10;
//            System.out.println(size);
            //String[][] res = new String[10][3];
            int i=0;
            rs.setFetchSize(10);
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
               String price=rs.getString(3);
                MedicineRecord mr = new MedicineRecord(id,name,price);
                res.add(mr);
            }
//            System.out.println("Shows successfully");
            return res;
        }
        catch(SQLException sq ){
            System.out.println(sq);

        }
        catch (Exception e){
            System.out.println(e);

        }
        return null;
    }
    public static void main(String[] args) throws SQLException {
        MedicineRecord mr = new MedicineRecord(3,"crocin3","12.74");
        DatabseService ds = new DatabseService();
//        ds.addMedicine(mr);
//        ds.deleteMedicine(2);
      //  MedicineRecord mr1 = new MedicineRecord(3,"crocin4","14.00");
        //ds.updateMedicine(mr1);
        System.out.println(ds.showAllMedicines().toString());

        ds.closeConnection();
    }
}
