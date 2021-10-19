package com.perennial.sme_payroll.helper;

import com.perennial.sme_payroll.entity.Employee;
import com.perennial.sme_payroll.entity.Error;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeValidation implements DataValidation {


    private int row;
    private int col;
    boolean flag;
    private List<Employee> employees;
    private List<Error> errors;
    private ErrorEmployeeMap map;

    public EmployeeValidation()
    {
        row=0;
        col=0;
        employees = new ArrayList<>();
        errors =new ArrayList<>();
    }

    @Override
    public ErrorEmployeeMap validate(List<List<String>> rows) {

        row=0;
        for (List<String> r : rows) {
            Employee employee=new Employee();
            col=0;
            row++;
            flag=true;
                employee.setuEN(setuEN(r.get(col++)));
                employee.setId(setId(r.get(col++)));
                employee.setName(setName(r.get(col++)));
                employee.setEmail(setEmail(r.get(col++)));
                employee.setMobileNumber(setMobileNumber(r.get(col++)));
                employee.setAadharNumber(setAdharNumner(r.get(col++)));
                employee.setdOJ(setdOJ(r.get(col++)));
                employee.setGender(setGender(r.get(col++)));
                employee.setDesignation(setDesignation(r.get(col++)));
                employee.setDepositeType(setDepositeType(r.get(col++)));
                employee.setMonthlySalary(setMonthlySalary(r.get(col++)));

                if(flag)
                employees.add(employee);
        }
        map=new ErrorEmployeeMap(employees,errors);
        return map;
    }

    private String setuEN(String uEN){


        Pattern p = Pattern.compile("^((S|T)([a-zA-Z0-9]{9})|([0-3])(\\d{8})([A-Z]))$");
        Matcher m = p.matcher(uEN);
        boolean check = m.matches();


        if (!check) {
            errors.add(new Error(row,col,"Invalid UEN number"));
            flag=false;
            return null;
        }

        return uEN;
    }

    public int setId(String id){
        try {
              return Integer.parseInt(id);
        } catch (Exception e) {
            errors.add(new Error(row,col,"Invalid Id"));
            flag=false;
            return -1;
        }
    }

    public String setName(String name){

        Pattern p = Pattern.compile("^[a-zA-Z\\ ]+$");
        Matcher m = p.matcher(name);
        boolean check = m.matches();

        if (!check) {
            errors.add(new Error(row,col,"Invalid Employee name"));
            flag=false;
            return null;
        }
        return name;
    }

    public String setEmail(String email){
        Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher m = p.matcher(email);
        boolean check = m.matches();

        if (!check) {
            errors.add(new Error(row,col,"Invalid email id"));
            flag=false;
            return null;
        }
        return email;
    }

    public long setMobileNumber(String mobileNumber){


        Pattern p = Pattern.compile("^[789]\\d{9}$");
        Matcher m = p.matcher(mobileNumber);
        boolean check = m.find() && m.group().equals(mobileNumber);

        if (!check) {
            errors.add(new Error(row,col,"Invalid mobile number"));
            flag=false;
            return -1;
        }

        return Long.parseLong(mobileNumber);
    }

    public long setAdharNumner(String adharNumner){

        Pattern p = Pattern.compile("^\\d{12}$");
        Matcher m = p.matcher(adharNumner);
        boolean check = m.find() && m.group().equals(adharNumner);

        if (!check) {
            errors.add(new Error(row,col,"Invalid aadhar number"));
            flag=false;
            return -1;
        }

        return Long.parseLong(adharNumner);
    }

    public String setdOJ(String dOJ){


        Pattern p = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
        Matcher m = p.matcher(dOJ);
        boolean check = m.matches();

        if (!check) {
            errors.add(new Error(row,col,"Invalid date"));
            flag=false;
            return null;
        }
        return dOJ;
    }

    public String setGender(String gender){
        Pattern p = Pattern.compile("^[a-zA-Z\\ ]+$");
        Matcher m = p.matcher(gender);
        boolean check = m.matches();

        if (!check) {
            errors.add(new Error(row,col,"Invalid invalid gender"));
            flag=false;
            return null;
        }
        return gender;
    }

    public String setDesignation(String designation){
        Pattern p = Pattern.compile("^[a-zA-Z\\ ]+$");
        Matcher m = p.matcher(designation);
        boolean check = m.matches();

        if (!check) {
            errors.add(new Error(row,col,"Invalid designation"));
            flag=false;
            return null;
        }
        return designation;
    }

    public String setDepositeType(String depositeType){
        Pattern p = Pattern.compile("^[a-zA-Z\\ ]+$");
        Matcher m = p.matcher(depositeType);
        boolean check = m.matches();

        if (!check) {
            errors.add(new Error(row,col,"Invalid UEN number"));
            flag=false;
            return null;
        }
        return depositeType;
    }

    public int setMonthlySalary(String monthlySalary){
        try {
            return Integer.parseInt(monthlySalary);
        } catch (Exception e) {
            errors.add(new Error(row,col,"Invalid Salary"));
            flag=false;
            return -1;
        }
    }
}
