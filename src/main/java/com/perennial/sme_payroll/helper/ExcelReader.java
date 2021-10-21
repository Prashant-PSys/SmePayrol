package com.perennial.sme_payroll.helper;


import com.perennial.sme_payroll.exceptions.InvalidInputException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelReader implements FileReader {

    public Workbook getWorkBook(MultipartFile file) throws IOException {
        return  new XSSFWorkbook(file.getInputStream());
    }

    @Override
    public List<List<String>> read(MultipartFile file) throws IOException, InvalidInputException {


        DataFormatter df = new DataFormatter();
        Workbook workbook = getWorkBook(file);
        Sheet sheet = workbook.getSheetAt(0);


        int rows;
        rows = sheet.getPhysicalNumberOfRows();
        List<List<String>> employees = new ArrayList<>();
        for(int r=1;r<rows-1;r++) {
            Row row = sheet.getRow(r);
            boolean flag=false;

            List<String> employee = new ArrayList<>();

            for(int i=0;i<row.getPhysicalNumberOfCells();i++) {
                employee.add(df.formatCellValue(row.getCell(i)));
            }

            employees.add(employee);
        }

        return employees;
    }
}
