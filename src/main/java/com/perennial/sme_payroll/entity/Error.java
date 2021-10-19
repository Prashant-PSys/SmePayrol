package com.perennial.sme_payroll.entity;

public class Error {
    private int row;
    private int column;
    private String description;

    public Error(int row, int column, String description)
    {
        this.row=row;
        this.column=column;
        this.description=description;
    }

    @Override
    public String toString() {
        return "Error{" +description + " in " +
        "row=" + row + ", column=" + column + "}";
    }
}
