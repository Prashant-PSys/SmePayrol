package com.perennial.sme_payroll.controller;


import com.perennial.sme_payroll.exceptions.InvalidInputException;
import com.perennial.sme_payroll.helper.FileReader;
import com.perennial.sme_payroll.service.UploadEmployee;
import com.perennial.sme_payroll.service.UploadSme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class SmeController {

    @Autowired
    private FileReader fileReader;
    @Autowired
    private UploadEmployee uploadEmployee;
    @Autowired
    private UploadSme uploadSme;


    @PostMapping("/upload_employees")
    public void uploadEmployees(MultipartFile file) throws IOException, InvalidInputException {
        uploadEmployee.upload(fileReader.read(file));
    }

    @PostMapping("/upload_sme")
    public void uploadSme(MultipartFile file) throws IOException, InvalidInputException {
        uploadSme.upload(fileReader.read(file));
    }
}

