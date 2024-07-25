/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LDHGroup;

import java.util.List;
import java.util.function.Function;

public class PayrollView {

public String printPayrollDetails(Payroll payroll) {
    Function<Payroll, String> formatPayrollDetails = p -> {
        if (p != null) {
            return p.m(); 
        } else {
            return "Payroll not found !!";
        }
    };

    return formatPayrollDetails.apply(payroll);
}


    public void printAllPayroll(List<Payroll> payrolls) {
        for (Payroll payroll : payrolls) {
            System.out.println(payroll);
        }
    }

    public String printMessage(String message) {
        return message ;
    }
}

