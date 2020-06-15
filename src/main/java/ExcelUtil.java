
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtil {

    public static String[] STRS = {"first","second","three","four","five","six"};

    public static List<Map<String,String>> reaFile(String filePath,boolean flag) throws IOException {
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            return null;
        }
        List<Map<String,String>> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(inputStream);
        Sheet sheet = wb.getSheetAt(0);
        int firstRow = sheet.getFirstRowNum();
        int lastRow = sheet.getLastRowNum();
        for (int i=firstRow;i<lastRow;i++){
            Map<String,String> map = new HashMap<>();
            Row row = sheet.getRow(i);
            int firstCellIndex = row.getFirstCellNum();
            int lastCellIndex = row.getLastCellNum();
            for (int index = firstCellIndex;index < lastCellIndex;index ++){
                Cell cell = row.getCell(index);
                if(cell != null){
                    map.put(STRS[index],cell.toString());
                    if(flag && index == 3){
                       short color = cell.getCellStyle().getFillForegroundColor();
                       map.put("color",color +"00");
                    }
                }
            }
            list.add(map);
        }
        return  list;
    }

    public static  void main(String[] args) throws IOException {
        String filePath= "C:\\Users\\caojiong\\Desktop\\新建文件夹\\新建 Microsoft Excel 工作表.xls" ;
        List<Map<String,String>> sourceList  = reaFile(filePath,false);
        String filePath1 = "C:\\Users\\caojiong\\Desktop\\新建文件夹\\新建 Microsoft Excel 工作表.xlsx";
        List<Map<String,String>> tarList = reaFile(filePath1,true);

    }

//    public static List<Map<String,String>>  fillCell(List<Map<String,String>> sourceList,List<Map<String,String>> targetList){
//        for (Map<String,String> map : sourceList){
//            for (Map.Entry<String,String> entry : map.entrySet()){
//
//
//
//
//
//            }
//        }
//
//
//    }
}
