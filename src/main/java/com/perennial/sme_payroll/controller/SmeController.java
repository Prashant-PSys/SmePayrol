package com.perennial.sme_payroll.controller;


import com.perennial.sme_payroll.exceptions.InvalidInputException;
import com.perennial.sme_payroll.helper.DataValidation;
import com.perennial.sme_payroll.helper.FileReader;
import com.perennial.sme_payroll.service.UploadEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class SmeController {

    @Autowired
    FileReader fileReader;
    @Autowired
    UploadEmployee uploadEmployee;



    @PostMapping("/upload_employees")
    public void uploadEmployees(MultipartFile file) throws IOException, InvalidInputException {
            uploadEmployee.upload(fileReader.read(file));
    }
}

