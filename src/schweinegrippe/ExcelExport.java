package schweinegrippe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jan-Ove
 */
public class ExcelExport {
   
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet worksheet;
    short zaehlerZeile = 0;
    int zaehlerZeit= 0;
    
    void initWorkbook(String name){
        worksheet = workbook.createSheet(name);
                zaehlerZeile = 0;
    }
    //Zwei spaltige Tabelle
    void writeheader(String rowEins, String rowZwei) {
        HSSFRow row = worksheet.createRow(zaehlerZeile++);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(rowEins);
        cell = row.createCell(1);
        cell.setCellValue(rowZwei);        
    }
    
    void writeRow(double zaehler, double schuldenStand) {
        HSSFRow row = worksheet.createRow(zaehlerZeile++);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(zaehler);
        cell = row.createCell(1);
        cell.setCellValue(schuldenStand);
        
    }
    
    //drei spaltige Tabelle
       void writeheader(String rowEins, String rowZwei, String rowDrei) {
        HSSFRow row = worksheet.createRow(zaehlerZeile++);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(rowEins);
        cell = row.createCell(1);
        cell.setCellValue(rowZwei);
        cell = row.createCell(2);
        cell.setCellValue(rowDrei); 
    }
    
    void writeRow(double rowEins, double rowZwei, double rowDrei) {
        HSSFRow row = worksheet.createRow(zaehlerZeile++);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(zaehlerZeit);
        cell = row.createCell(1);
        cell.setCellValue(rowEins);
        cell = row.createCell(2);
        cell.setCellValue(rowZwei);
        cell = row.createCell(3);
        cell.setCellValue(rowDrei);
        zaehlerZeit++;
    }
    
    void close() {
        try {
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.home") + File.separator + "schweinegrippe.xls");
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
  
 
}
