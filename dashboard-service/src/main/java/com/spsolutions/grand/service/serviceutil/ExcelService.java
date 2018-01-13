package com.spsolutions.grand.service.serviceutil;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class ExcelService {
    public Map<String, Integer> getColoumNameMap(Row row) {
        Map<String, Integer> map = new HashMap<>();
        Iterator<Cell> cell = row.cellIterator();

        int emptyCount = 0;
        int i = 0;
        while (cell.hasNext()) {
            String next = cell.next().getStringCellValue().trim().toUpperCase();
            if (!next.equals("")) {
                map.put(next, i);
                emptyCount = 0;
            } else {
                emptyCount++;
                if (emptyCount > 10) {
                    break;
                }
            }
            i++;
        }
        return map;
    }

    public String getValue(Cell cell) {
        if (cell != null) {
            if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                double numericCellValue = cell.getNumericCellValue();
                return String.valueOf(numericCellValue);
            } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                return "";
            }
        }
        return "";
    }
}
