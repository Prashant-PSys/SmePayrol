package com.perennial.sme_payroll.service;

import com.perennial.sme_payroll.dao.EmployeeRepo;
import com.perennial.sme_payroll.entity.Employee;
import com.perennial.sme_payroll.entity.Error;
import com.perennial.sme_payroll.helper.DataValidation;
import com.perennial.sme_payroll.helper.ErrorEmployeeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CRUDEmployee {
    @Autowired
    private DataValidation employeeValidation;
    @Autowired
    private EmployeeRepo empRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    public void post(List<List<String>> rows) {
        ErrorEmployeeMap map = employeeValidation.validate(rows);

        for (Employee e : map.getEmployees()) {
            empRepo.save(e);
        }

        for (Error e : map.getErrors()) {
            System.out.println(e);
        }
    }


    public Optional<Employee> get(String id) {
        try {
            return employeeRepo.findById(Integer.parseInt(id));
        } catch (Exception e) {
            return null;
        }
    }

    public String delete(String id) {
        try {
            employeeRepo.deleteById(Integer.parseInt(id));
            return "Employee removed from table.";
        } catch (EmptyResultDataAccessException e) {
            return "For given Id, there is no employee available in the database";
        } catch (Exception e) {
            return "Invalid Id";
        }
    }

    public String update(String id, Map<Object, Object> fields) {
        try {
            Optional<Employee> employee = employeeRepo.findById(Integer.parseInt(id));
            if (employee.isPresent()) {
                fields.forEach((key, value) -> {
                            Field field = ReflectionUtils.findField(Employee.class, (String) key);
                            field.setAccessible(true);
                            ReflectionUtils.setField(field, employee.get(), value);
                        });
             employeeRepo.save(employee.get());
            }
            return "update the data.";
        } catch (EmptyResultDataAccessException e) {
            return "There is not data to update in database";
        } catch (Exception e) {
            return "invalid data";
        }
    }
}
