package com.perennial.sme_payroll.entity;

import com.perennial.sme_payroll.exceptions.InvalidInputException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Wallet {

    @Id
    private int employeeId;
    private long mobileNumber;
    private String provider;

    @OneToOne
    private Employee walletToEmployee;


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

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String  mobileNumber) throws InvalidInputException {
        Pattern p = Pattern.compile("^[789]\\d{9}$");
        Matcher m = p.matcher(mobileNumber);
        boolean check=m.find() && m.group().equals(mobileNumber);

        if(!check)
        {
            throw new InvalidInputException("Invalid mobile number.");
        }

        this.mobileNumber = Long.parseLong(mobileNumber);
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) throws InvalidInputException {
        Pattern p = Pattern.compile("^[a-zA-Z\\ ]+$");
        Matcher m = p.matcher(provider);
        boolean check=m.matches();

        if(!check)
        {
            throw new InvalidInputException("Invalid card type");
        }
        this.provider = provider;
    }
}
