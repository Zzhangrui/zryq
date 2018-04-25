package com.zryq.cms.common.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 锐 on 2017/4/28.
 */
public class ExcelImportUtil {
    public static List<Map<String, String>> parseExcel(InputStream fis, String fileType) {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        if (fileType.equals("xls")) {   //区别excel版本问题
            HSSFWorkbook book = null;
            try {
                book = new HSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HSSFSheet sheet = book.getSheetAt(0);
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            //除去表头和第一行
            for (int i = firstRow + 1; i < lastRow + 1; i++) {
                Map map = new HashMap();

                HSSFRow row = sheet.getRow(i);
                int firstCell = row.getFirstCellNum();
                int lastCell = row.getLastCellNum();


                for (int j = firstCell; j < lastCell; j++) {

                    HSSFCell cell2 = sheet.getRow(firstRow + 1).getCell(j);
                    String key = cell2.getStringCellValue();

                    HSSFCell cell = row.getCell(j);

                       /* if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        }*/
                    String val = getStringCellValue(cell);
                    //              System.out.println(val);

                    if (i == firstRow + 1) {
                        break;
                    } else {
                        map.put(key, val);

                    }
                    //              System.out.println(map);
                }
                if (i != firstRow + 1) {
                    data.add(map);
                }
            }
        } else {    //区别excel版本问题
            XSSFWorkbook book = null;
            try {
                book = new XSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            XSSFSheet sheet = book.getSheetAt(0);
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            //除去表头和第一行
            //          ComnDao dao = SysBeans.getComnDao();
            for (int i = firstRow + 1; i < lastRow + 1; i++) {
                Map map = new HashMap();

                XSSFRow row = sheet.getRow(i);
                int firstCell = row.getFirstCellNum();
                int lastCell = row.getLastCellNum();
                for (int j = firstCell; j < lastCell; j++) {
                    XSSFCell cell2 = sheet.getRow(firstRow + 1).getCell(j);
                    String key = cell2.getStringCellValue();
                    XSSFCell cell = row.getCell(j);
                   /* if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }*/
                    String val = getStringCellValue(cell);
                    // String val = cell.getStringCellValue();
                    if (i == firstRow + 1) {
                        break;
                    } else {
                        map.put(key, val);
                    }
                }
                if (i != firstRow + 1) {
                    data.add(map);
                }
            }
        }
        return data;



    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    public static String getStringCellValue(HSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }


    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    public static String getStringCellValue(XSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                NumberFormat f = new DecimalFormat("############");
                f.setMaximumFractionDigits(0);
                strCell = f.format(cell.getNumericCellValue());
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }
}
