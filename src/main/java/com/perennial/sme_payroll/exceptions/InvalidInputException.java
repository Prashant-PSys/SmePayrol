package com.perennial.sme_payroll.exceptions;

public class InvalidInputException extends Throwable {
    public InvalidInputException()
    {
        super("Please provide valid book name");
    }

    public InvalidInputException(String message)
    {
        super(message);
    }
}
