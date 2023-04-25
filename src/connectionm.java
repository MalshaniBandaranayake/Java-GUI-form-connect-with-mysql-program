/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author MALSHANI
 */
public class connectionm { // create a class to build connection
     static Connection con;  // create object for connection
     
 public static Connection getconnection()  {
     try {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","");//pass mysql connection use with database name
         
     }catch (Exception ex){
    System.out.println(""+ex);
    
 } 
return con;// we use this statement to return the connection
}
}
