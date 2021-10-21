package com.perennial.sme_payroll.entity;


import com.perennial.sme_payroll.exceptions.InvalidInputException;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Entity
public class Employee {

    @Id
    private int id;
    private String uEN;
    private String name;
    private String email;
    private long mobileNumber;
    private long AadharNumber;
    private String dOJ;
    private String gender;
    private String designation;
    private String depositeType;
    private int monthlySalary;


    @ManyToOne
    private Sme employeeToSme;

    @OneToOne(mappedBy = "cardToEmployee")
    private Card cards;

    @OneToOne(mappedBy = "walletToEmployee")
    private Wallet wallets;

    public String getuEN() {
        return uEN;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public long getAadharNumber() {
        return AadharNumber;
    }

    public String getdOJ() {
        return dOJ;
    }

    public String getGender() {
        return gender;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepositeType() {
        return depositeType;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }


    public void setuEN(String uEN){
        this.uEN = uEN;
    }


    public void setId(int id){

            this.id = id;
    }


    public void setName(String name){
        this.name = name;
    }


    public void setEmail(String email){
        this.email = email;
    }


    public void setMobileNumber(long mobileNumber){
        this.mobileNumber =mobileNumber;
    }


    public void setAadharNumber(long aadharNumber){
        this.AadharNumber = aadharNumber;
    }


    public void setdOJ(String dOJ){
        this.dOJ = dOJ;
    }


    public void setGender(String gender){
        this.gender = gender;
    }


    public void setDesignation(String designation){
        this.designation = designation;
    }


    public void setDepositeType(String depositeType){
        this.depositeType = depositeType;
    }


    public void setMonthlySalary(int monthlySalary){
            this.monthlySalary = monthlySalary;

    }
}
