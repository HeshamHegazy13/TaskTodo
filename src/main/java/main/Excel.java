/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author ali
 */
public class Excel {
    XSSFSheet sheet;
    
    public void loadExcel(String path){
        try{
        File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            sheet = wb.getSheetAt(0); 
        }catch(Exception e){
        e.printStackTrace(); }
        
    
    }
    
    public ArrayList loadData(){
        ArrayList<RowData> table = new ArrayList() ;
        
             Iterator<Row> itr = sheet.iterator(); 
            itr.next();
            int rowId =0;
            while(itr.hasNext()){
                RowData rowData;
                rowData = new RowData() ;
            
            Row row = itr.next();
            
            Iterator<Cell> cellIterator = row.cellIterator();   
              outer:
            while(cellIterator.hasNext()){
                rowData.setId(rowId); 
                
                 Cell cell = cellIterator.next();
                 CellType type =cell.getCellType();
                 
                 if(rowId == 0){
            
            for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
                CellRangeAddress region = sheet.getMergedRegion(i); 

                int colIndex = region.getFirstColumn(); 
                int rowNum = region.getFirstRow();      
                
                 Cell resultCell=(Cell) sheet.getRow(rowNum).getCell(colIndex);

                 
            for(int f= rowNum ; f < region.getNumberOfCells()+rowNum ; f++ ){
                    Cell sCell =(Cell) sheet.getRow(f).getCell(2) ; 
                    sCell.setCellValue(resultCell.getStringCellValue());            
                }
                
            }}
            

            if(type == CellType.STRING){
                 

                    
                    Pattern regex = Pattern.compile("(\\d?.\\d?\\d?)(<D<=)(\\d\\d?\\d?.\\d?\\d?)");
                    Matcher matcher = regex.matcher(cell.getStringCellValue());
                    while(matcher.find()){

                        
                        rowData.setMinD(matcher.group(1));
                        rowData.setMaxD(matcher.group(3));
                         }
                    if(cell.getStringCellValue().contains("A1") )
                        {
                        rowData.setCode(cell.getStringCellValue());
                        }
                                                                           
                }
                else {

                if(cell.getNumericCellValue() !=0 ){
                rowData.setSpeed((float) cell.getNumericCellValue());}
                
                }
                
               
               
          }
              if( rowData.getCode() == null){
                  continue;}
              else{
              table.add(rowData);
              }
              
              rowId++;
              
  }
            
            return table;
    
    
    }
    
    
}
