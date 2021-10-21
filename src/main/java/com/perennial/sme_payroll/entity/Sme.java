package com.perennial.sme_payroll.entity;

import com.perennial.sme_payroll.exceptions.InvalidInputException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Sme {

    @Id
    private String uEN;
    private String name;
    private String address;
    private long mobileNumber;
    private long accountNumber;

    @OneToMany(mappedBy = "employeeToSme")
    private List<Employee> employees;

    @OneToMany(mappedBy = "payrollToSme")
    private List<Payroll> payrolls;

    public String getuEN() {
        return uEN;
    }

    public void setuEN(String uEN) throws InvalidInputException {
        Pattern p = Pattern.compile("^((S|T)([a-zA-Z0-9]{9})|([0-3])(\\d{8})([A-Z]))$");
        Matcher m = p.matcher(uEN);
        boolean check=m.matches();


        if(!check)
        {
            throw new InvalidInputException("Invalid UEN number.");
        }

        this.uEN = uEN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidInputException {
        Pattern p = Pattern.compile("^[a-zA-Z\\ ]+$");
        Matcher m = p.matcher(name);
        boolean check=m.matches();

        if(!check)
        {
            throw new InvalidInputException("Invalid name.");
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws InvalidInputException {
        Pattern p = Pattern.compile("^[a-zA-Z\\ ]+$");
        Matcher m = p.matcher(address);
        boolean check=m.matches();

        if(!check)
        {
            throw new InvalidInputException("Invalid name.");
        }
        this.address = address;

    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) throws InvalidInputException {
        try {
            this.mobileNumber = Long.parseLong(mobileNumber);
        }
        catch (Exception e)
        {
            throw new InvalidInputException("Invalid mobile number");
        }

    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) throws InvalidInputException {
        try {
            this.accountNumber = Long.parseLong(accountNumber);
        }
        catch (Exception e)
        {
            throw new InvalidInputException("Invalid account number");
        }

    }
}
