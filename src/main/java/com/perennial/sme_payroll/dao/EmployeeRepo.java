package com.perennial.sme_payroll.dao;

import com.perennial.sme_payroll.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
}
