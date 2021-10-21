package com.perennial.sme_payroll.entity;

import com.perennial.sme_payroll.exceptions.InvalidInputException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payroll {

    @Id
    private int employeeId;
    private String uIN;
    private int monthDays;
    private int payableDays;
    private int payableAmount;

    @ManyToOne
    private Sme payrollToSme;

    public String getuIN() {
        return uIN;
    }

    public void setuIN(String uIN) {
        this.uIN = uIN;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) throws InvalidInputException {
        try {
            this.employeeId = Integer.parseInt(employeeId);
        }
        catch (Exception e)
        {
            throw new InvalidInputException("Invalid Id");
        }

    }

    public int getMonthDays() {
        return monthDays;
    }

    public void setMonthDays(String monthDays) throws InvalidInputException {
        try {
            this.monthDays = Integer.parseInt(monthDays);
        }
        catch (Exception e)
        {
            throw new InvalidInputException("Invalid Id");
        }
    }

    public int getPayableDays() {
        return payableDays;
    }

    public void setPayableDays(String payableDays) throws InvalidInputException {
        try {
            this.payableDays = Integer.parseInt(payableDays);
        }
        catch (Exception e)
        {
            throw new InvalidInputException("Invalid Id");
        }
    }

    public int getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(String payableAmount) throws InvalidInputException {
        try {
            this.payableAmount = Integer.parseInt(payableAmount);
        }
        catch (Exception e)
        {
            throw new InvalidInputException("Invalid Id");
        }
    }
}
