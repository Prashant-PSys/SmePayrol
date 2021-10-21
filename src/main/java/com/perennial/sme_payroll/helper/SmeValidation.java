package com.perennial.sme_payroll.helper;

import com.perennial.sme_payroll.entity.Employee;
import com.perennial.sme_payroll.entity.Error;
import com.perennial.sme_payroll.entity.Sme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("smeValidation")
public class SmeValidation implements DataValidation{

    private int row;
    private int col;
    boolean flag;
    private List<Sme> smes;
    private List<Error> errors;
    private ErrorEmployeeMap map;

    public SmeValidation()
    {
        row=0;
        col=0;
        smes = new ArrayList<>();
        errors =new ArrayList<>();
    }


    @Override
    public ErrorEmployeeMap validate(List<List<String>> data) {

        return null;
    }
}
