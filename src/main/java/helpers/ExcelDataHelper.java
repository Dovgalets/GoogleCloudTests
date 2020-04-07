package helpers;



import org.apache.commons.math3.util.Pair;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataHelper {

    public static List<Pair<String, String>> data(String filepath, String sheetName, int rawNumber) {
        List<Pair<String, String>> myData = new ArrayList<>();
        try (FileInputStream fs = new FileInputStream(filepath)){
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int parametersAmount = sheet.getRow(0).getPhysicalNumberOfCells();
            for (int j = 0; j < parametersAmount; j++) {
                String cell = new DataFormatter().formatCellValue(sheet.getRow(rawNumber).getCell(j));
                myData.add(new Pair<>(sheet.getRow(0).getCell(j).toString(), cell));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myData;
    }
}
