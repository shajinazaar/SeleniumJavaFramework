package util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {


    public static String getUsername(String filePath, String sheetName, int row) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        Row rowData = sheet.getRow(row);
        Cell cell = rowData.getCell(0);

        file.close();
        return cell.getStringCellValue();
    }

    public static String getPassword(String filePath, String sheetName, int row) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        Row rowData = sheet.getRow(row);
        Cell cell = rowData.getCell(1);

        file.close();
        return cell.getStringCellValue();
    }
}
