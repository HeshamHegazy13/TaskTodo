/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;


/**
 *
 * @author ali
 */
public class main {
    
    
    
    public static void main (String[] args){
        
        ArrayList<RowData> table = new ArrayList() ;
        
        Excel excel = new Excel();
        Database db = new Database();
        
        excel.loadExcel("C:\\Users\\ali\\Documents\\NetBeansProjects\\Dataa\\speedVsDiameter.xlsx");
        table = excel.loadData();
     
        db.connectDB();
        db.createTable();
                
        for(int z = 0 ; z < table.size() ; z ++){
        System.out.println(
                  "id -> "+table.get(z).getId() + " MinD -> "
                + table.get(z).getMinD() +" MaxD -> " 
                + table.get(z).getMaxD() +" Speed -> " 
                + table.get(z).getSpeed() +" Code -> " 
                + table.get(z).getCode() );
        }
    
    }
    
    
    
}
