package com.opencart.readutilityfiles;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.Properties;

public class ReadExcelFile extends ReadPropertyFile {
    File file;
    private String excelFileName;
    ReadPropertyFile readPropertyFile;
    Properties prop;
    FileInputStream fileInputStream;

    public ReadExcelFile() throws IOException {
        readPropertyFile = new ReadPropertyFile();
        prop = readPropertyFile.getConfigPropertyFile();
    }

    @DataProvider(name = "excelTestData")
    public Object[][] getExcelFile() throws IOException {
        excelFileName = prop.getProperty("excelFileName");
        file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\" + excelFileName);
        fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int totalRowCountInSheet = sheet.getLastRowNum();
        //System.out.println("Total row count in sheet: "+totalRowCountInSheet);

        Row rowCells = sheet.getRow(totalRowCountInSheet);
        int totalColumnsInSheet = rowCells.getLastCellNum();
        //System.out.println("Total column in sheet: "+totalColumnsInSheet);

        /** To format the data coming from excel, we need to format the data.
         * In sheet there could be int, boolean, string ,
         * so when we pick the data from excel we need to format it in any one format lets say ,String,before using it in our script.
         */

        DataFormatter dataFormatter = new DataFormatter();
        String testData[][] = new String[totalRowCountInSheet][totalColumnsInSheet];
        for (int i = 1; i <= totalRowCountInSheet; i++) {
            for (int j = 0; j < totalColumnsInSheet; j++) {
                testData[i - 1][j] = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
                System.out.println(testData[i - 1][j]);
            }
        }
        return testData;
    }

}
