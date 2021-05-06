/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author ali
 */
public class Database {
    private Connection conn;
    private String url = "jdbc:sqlite:C:\\Users\\ali\\Documents\\NetBeansProjects\\Dataa\\chinook.db";
    
    public void connectDB() {
     conn = null;
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection(url);
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    
  }
    public void createTable(){
    
        try {
            String sql = "CREATE TABLE excelInfo("
                    + "id INTEGER PRIMARY KEY, "
                    + "minD VARCHAR(10), "
                    + "maxD VARCHAR(10),"
                    + "speed REAL,"
                    + "code VARCHAR(10))";
            
            conn = DriverManager.getConnection(url);
            conn.createStatement().executeUpdate(sql);
            System.out.println(conn.createStatement().executeUpdate(sql));
        } catch (SQLException ex) {
            
        }
    }
    public void insertRow(int id , String minD , String maxD , float speed , String code){
    
        try {
            String sql ="INSERT INTO excelInfo(id,minD,maxD,speed,code) VALUES('"+id+"','"+minD+"','"+maxD+"','"+speed+"','"+code+"' )";
            
            conn = DriverManager.getConnection(url);
            conn.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            String sql ="UPDATE excelinfo SET minD='"+minD+"' , maxD='"+maxD+"' , speed='"+speed+"' , code='"+code+"' WHERE id='"+id+"'  ";
            
            try {
                conn.createStatement().executeUpdate(sql);
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
    }
    
   


}
    

