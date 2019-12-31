/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.jar.Attributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import java.util.*;
/**
 *
 * @author manjeet
 */

class connect {
    Connection con =null;  
    public void sqlCon() throws SQLException, ClassNotFoundException{
              

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    String connectionURL="jdbc:sqlserver://mj:1433;databaseName=first_data_12/03/2019;user=admin;password=manjeet";  

    try{

    con=DriverManager.getConnection(connectionURL);
    System.out.println("Connection is successfull");
    
        Statement st = con.createStatement();
//      st.executeUpdate("INSERT INTO lg VALUES (1,'manjeet')");


    }

    catch(SQLException e){

     System.out.println(e);

   
    }
    
    }
    
    public void rc(){
        System.out.println("yes");
    }
    
    
    public void rr() throws SQLException{
        
        Statement st = con.createStatement();
        
        PreparedStatement stmt=con.prepareStatement("insert into lg values(?,?)");  
stmt.setString(1,"sdflkdf");//1 specifies the first parameter in the query  
stmt.setString(2,"Ratan");  
  
int i=stmt.executeUpdate();  
System.out.println(i+" records inserted");  
    }
    
    
    public void ch(){
        Scanner sc = new Scanner(System.in);
        ArrayList arry=new ArrayList();
        int in = sc.nextInt();
        while(in!=0){
            arry.add(in);
            in=sc.nextInt();
        }
        
        System.out.println("--------------------------------------------");
        for(Object i : arry){
            System.out.println(i);
        }
    }
    public void fd(){
        try{
            String st;
            ArrayList arl = new ArrayList();
            sqlCon();
              String sql = "SELECT * FROM studR ";
                    
//                    PreparedStatement stmt = con.prepareStatement("select * from studR ");                   
//                    ResultSet rs = stmt.executeQuery();
                    java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
                    while(rs.next()){
                        String Name = rs.getString(1);
                        String Add = rs.getString(2);
                        String Contact = rs.getString(3);
                        String mail = rs.getString(4);
                        String Fee = rs.getString(7);
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
                        
            }

            if(rs.next()){
                System.out.println("yes");
            }
           
        }
        catch(Exception ex){
            
        }
    }

    public void rj(){
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       Calendar cal = Calendar.getInstance();
       System.out.println(dateFormat.format(cal.getTime()));
    }
    
}



public class Project_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
//        connect c = new connect();
        connect ct = new connect();
        ct.rj();
        
        
        
    }
    
}
