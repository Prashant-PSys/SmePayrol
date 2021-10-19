package com.perennial.sme_payroll.helper;

import com.perennial.sme_payroll.entity.Employee;
import com.perennial.sme_payroll.entity.Error;

import java.util.List;

public class ErrorEmployeeMap {
    private List<Employee> employees;
    private List<Error> errors;

    public ErrorEmployeeMap(List<Employee> employees, List<Error> errors) {
        this.employees = employees;
        this.errors = errors;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
