package com.perennial.sme_payroll.helper;

import com.perennial.sme_payroll.exceptions.InvalidInputException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    public List<List<String>> read(MultipartFile file) throws IOException, InvalidInputException;
}
