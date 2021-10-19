package com.perennial.sme_payroll.helper;

import java.util.List;
import java.util.Map;

public interface DataValidation {
    public ErrorEmployeeMap validate(List<List<String>> data);
}
