package com.perennial.sme_payroll.helper;

import com.perennial.sme_payroll.entity.*;
import com.perennial.sme_payroll.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParseData {


    public void parseEmployee(List<List<String>> stringEmployees) throws InvalidInputException {
        List<Employee> employees = new ArrayList<>();
        for (List<String> data : stringEmployees) {
         Employee employee=new Employee();

         try {
           /*  employee.setuEN(data.get(0));
             employee.setId(data.get(1));
             employee.setName(data.get(2));
             employee.setEmail(data.get(3));
             employee.setMobileNumber(data.get(4));
             employee.setAdharNumner(data.get(5));
             employee.setdOJ(data.get(6));
             employee.setGender(data.get(7));
             employee.setDesignation(data.get(8));
             employee.setDepositeType(data.get(9));
             employee.setMonthlySalary(data.get(10));
             employees.add(employee); */
         }
         catch (Exception e)
         {
             throw new InvalidInputException(e.getMessage());
         }

        }
        for (Employee e:employees)
        {
            System.out.println(e.getId());
        }
    }

    public void parseSme(List<List<String>> stringSme) throws InvalidInputException {
        List<Sme> smes = new ArrayList<>();
        for (List<String> data : stringSme) {
            Sme sme=new Sme();

            try {
                sme.setuEN(data.get(0));
                sme.setName(data.get(1));
                sme.setAddress(data.get(2));
                sme.setMobileNumber(data.get(3));
                sme.setAccountNumber(data.get(4));
                smes.add(sme);
            }
            catch (Exception e)
            {
                throw new InvalidInputException(e.getMessage());
            }

        }
        for (Sme s:smes)
        {
            System.out.println(s.getName());
        }
    }

    public void parseCard(List<List<String>> stringCard) throws InvalidInputException {
        List<Card> cards = new ArrayList<>();
        for (List<String> data : stringCard) {
            Card card=new Card();

            try {
                card.setEmployeeId(data.get(0));
                card.setCardNumber(data.get(1));
                card.setType(data.get(2));
                card.setDate(data.get(3));
                cards.add(card);
            }
            catch (Exception e)
            {
                throw new InvalidInputException(e.getMessage());
            }

        }
        for (Card s:cards)
        {
            System.out.println(s.getEmployeeId());
        }
    }

    public void parseWallet(List<List<String>> stringWallet) throws InvalidInputException {
        List<Wallet> wallets = new ArrayList<>();
        for (List<String> data : stringWallet) {
            Wallet wallet=new Wallet();

            try {
                wallet.setEmployeeId(data.get(0));
                wallet.setMobileNumber(data.get(1));
                wallet.setProvider(data.get(2));
                wallets.add(wallet);
            }
            catch (Exception e)
            {
                throw new InvalidInputException(e.getMessage());
            }

        }
        for (Wallet s:wallets)
        {
            System.out.println(s.getEmployeeId());
        }
    }


    public void parsePayroll(List<List<String>> stringWallet) throws InvalidInputException {
        List<Payroll> payrolls = new ArrayList<>();
        for (List<String> data : stringWallet) {
            Payroll payroll=new Payroll();

            try {
                payroll.setuIN(data.get(0));
                payroll.setEmployeeId(data.get(1));
                payroll.setMonthDays(data.get(2));
                payroll.setPayableDays(data.get(3));
                payroll.setPayableAmount(data.get(4));
                payrolls.add(payroll);
            }
            catch (Exception e)
            {
                throw new InvalidInputException(e.getMessage());
            }

        }
        for (Payroll s:payrolls)
        {
            System.out.println(s.getEmployeeId());
        }
    }

}
