package com.perennial.sme_payroll.entity;


import com.perennial.sme_payroll.exceptions.InvalidInputException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Card {

    @Id
    private int employeeId;
    private long cardNumber;
    private String type;
    private String date;

    @OneToOne
    private Employee cardToEmployee;

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

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) throws InvalidInputException {
        try {
            this.cardNumber = Long.parseLong(cardNumber);
        }
        catch (Exception e)
        {
            throw new InvalidInputException("Invalid card number");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws InvalidInputException {
        Pattern p = Pattern.compile("^[a-zA-Z\\ ]+$");
        Matcher m = p.matcher(type);
        boolean check=m.matches();

        if(!check)
        {
            throw new InvalidInputException("Invalid card type");
        }
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws InvalidInputException {
        Pattern p = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
        Matcher m = p.matcher(date);
        boolean check=m.matches();

        if(!check)
        {
            throw new InvalidInputException("Invalid Date");
        }
        this.date = date;
    }
}
