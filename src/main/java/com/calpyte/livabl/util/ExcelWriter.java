package com.calpyte.livabl.util;

import com.calpyte.livabl.dto.ExcelDTO;
import com.itextpdf.io.source.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class ExcelWriter {

    private static DecimalFormat df = new DecimalFormat("#.##");

    private static final short TWIPS_PER_PIXEL = 15;

    private Integer detailRowCount = 1;

    public static short pixel2PoiHeight (int pixel) {
        return (short) (pixel * TWIPS_PER_PIXEL);
    }

    public static ByteArrayOutputStream downloadExcel(ExcelDTO excelDTO) throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("name","Dinesh");
        map.put("age","18");
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);
        excelDTO.setData(list);
        List<String> headers = new ArrayList<>();
        headers.add("Name");
        headers.add("Age");
        excelDTO.setHeader(headers);
        excelDTO.setName("Testing");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(excelDTO.getName());
        AtomicReference<Integer> rowCount = new AtomicReference<>(1);
        try {
            Row titleRow = sheet.createRow(rowCount.getAndSet(rowCount.get() + 1));
            titleRow.setHeight(pixel2PoiHeight(30));
            Cell titleRowCell = titleRow.createCell(1);
            titleRowCell.setCellValue(excelDTO.getName());
            Row headerRow = sheet.createRow(rowCount.getAndSet(rowCount.get() + 1));
            headerRow.setHeight(pixel2PoiHeight(30));
            if(excelDTO.getHeader()!=null && excelDTO.getHeader().size() > 0){
                Integer count = 1;
                for (String header : excelDTO.getHeader()){
                    Cell cell = headerRow.createCell(count++);
                    cell.setCellValue(header);
                }
            }
            excelDTO.getData().forEach(data  ->{
                AtomicReference<Integer> cellCount = new AtomicReference<>(1);
                Row dataRow = sheet.createRow(rowCount.getAndSet(rowCount.get() + 1));
                data.forEach((key,value)->{
                    Cell cell = dataRow.createCell(cellCount.getAndSet(cellCount.get() + 1));
                    cell.setCellValue(value!=null ? value.toString() : "");
                });
            });
            Integer cellCount = 0;
            for(String header : excelDTO.getHeader()){
                sheet.setColumnWidth(cellCount++, (30 * 256) + 200);
            }
            workbook.write(out);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                out.close();
                workbook.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return out;
    }


}
