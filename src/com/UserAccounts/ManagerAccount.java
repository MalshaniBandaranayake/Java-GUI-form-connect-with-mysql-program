/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserAccounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author MALSHANI
 */
       //make a inheritance with cashier account
public class ManagerAccount extends CashierAccount{
      //overide cashier class abstract methods
    @Override
    public void Add(Mobilephone ManagerAccount) { // create add button 
     try{
           Class.forName("com.mysql.cj.jdbc.Driver"); // provide database connection
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","");// connect with relevent databse
           String sql = "INSERT INTO mobilephones (Registerid,phonename,brand,category,price)VALUES(?,?,?,?,?)";// use innsert query to insert data
           PreparedStatement pst = con.prepareStatement(sql);
           //use getter and setter methods to add data to manager page abstract methods
           pst.setInt(1,ManagerAccount.getRegisterid() ); 
           pst.setString(2, ManagerAccount.getPhonename());
           pst.setString(3,ManagerAccount.getBrand() );
           pst.setString(4,ManagerAccount.getCategory());
           pst.setInt(5, ManagerAccount.getPrice());
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Successfully Added");// use joptionpane to show data adding correctness
          
             
     }  catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManagerAccount.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "some feilds are empty");// use joptionpane to show failier in data adding
        }
     
     
    }

      // view method overiding
    @Override
    public List<Mobilephone> viewAll() {
        List<Mobilephone> list = new ArrayList<Mobilephone>();//use array to import data to the list
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","");
           String sql = "SELECT * FROM mobilephones ";  // use select query to get suitable data from the relevent table
           PreparedStatement pst = con.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
           Mobilephone md = new Mobilephone() {};// create object for cashier account
           //use setter and getter methods to set and get values
           md.setRegisterid(rs.getInt("registerid"));
           md.setPhonename(rs.getString("phonename"));
           md.setBrand(rs.getString("brand"));
           md.setCategory(rs.getString("category"));
           md.setPrice(rs.getInt("price"));
           
           list.add(md);  // cashier accounts method's details add to list use above cashier class object
           }
           
           
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManagerAccount.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list; // return the list's data to mobile phone dash board
     
    }


    }

  
    

    

   

   
   
    

