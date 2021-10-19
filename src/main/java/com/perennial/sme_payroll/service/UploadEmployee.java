package com.perennial.sme_payroll.service;

import com.perennial.sme_payroll.dao.EmployeeRepo;
import com.perennial.sme_payroll.entity.Employee;
import com.perennial.sme_payroll.entity.Error;
import com.perennial.sme_payroll.helper.DataValidation;
import com.perennial.sme_payroll.helper.ErrorEmployeeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UploadEmployee {

    @Autowired
    DataValidation dataValidation;
    @Autowired
    EmployeeRepo empRepo;

    public void upload(List<List<String>> rows)
    {
        ErrorEmployeeMap map=dataValidation.validate(rows);

        for(Employee e: map.getEmployees())
        {
            empRepo.save(e);
        }

        for (Error e:map.getErrors())
        {
            System.out.println(e);
        }
    }

}
