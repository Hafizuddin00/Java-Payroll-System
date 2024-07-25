/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LDHGroup;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PayrollController {

    private PayrollDAO model;
    private PayrollView view;
    String display;
    int index;
    int dindex;

    public PayrollController(PayrollDAO model, PayrollView view) {
        this.model = model;
        this.view = view;
    }

    public void getPayrollByName(String payrollName) {
        try {
            List<Payroll> payrolls = model.getPayrollByName(payrollName);

            if (payrolls.isEmpty()) {
                dindex = 1;
                display = view.printMessage("No payroll records found for " + payrollName);
            } else {
                dindex = -1;
                StringBuilder displayBuilder = new StringBuilder();
                index = 1;
                for (Payroll payroll : payrolls) {
                    displayBuilder.append(index).append(". ").append(view.printPayrollDetails(payroll)).append("\n\n\n\n\n\n\n\n\n\n\n- - - Scrolling for next slip until finish for " + payrollName + " - - -\n\n");
                    index++;
                }
                display = displayBuilder.toString();
            }
        } catch (SQLException e) {
            display = view.printMessage("Error fetching payroll: " + e.getMessage());
        }
    }

    public void getAllPayroll() {
        try {
            List<Payroll> payrolls = model.getAllPayroll();

            if (payrolls.isEmpty()) {
                dindex = 1;
                display = view.printMessage("No payroll records found.");
            } else {
                dindex = -1;
                StringBuilder displayBuilder = new StringBuilder();
                index = 1;
                for (Payroll payroll : payrolls) {
                    displayBuilder.append(index).append(". ").append(view.printPayrollDetails(payroll)).append("\n\n");
                    index++;
                }
                display = displayBuilder.toString();
            }
        } catch (SQLException e) {
            display = view.printMessage("Error fetching payroll: " + e.getMessage());
        }
    }

    public void addPayroll(Payroll payroll) {
        try {
            model.addPayroll(payroll);
            display = view.printMessage("Payroll added successfully.");
        } catch (SQLException e) {
            display = view.printMessage("Error adding payroll: " + e.getMessage());
        }
    }

    public void updatePayroll(Payroll payroll) {
        try {
            model.updatePayroll(payroll);
            display = view.printMessage("Payroll updated successfully.");
        } catch (SQLException e) {
            display = view.printMessage("Error updating author: " + e.getMessage());
        }
    }

    public void deletePayroll(String payrollName, String month, String year) {
        try {
            Payroll payroll1 = model.getPayrollbyNameEdit(payrollName, month, year);
            if (payroll1 != null) {
                model.deletePayroll(payrollName, month, year);
                display = view.printMessage("Payroll deleted successfully.");
            } else {
                display = view.printMessage("Payroll not found!");
            }
        } catch (SQLException e) {
            view.printMessage("Error deleting author: " + e.getMessage());
        }
    }

    public void deletePayrollName(String payrollName) {
        try {
            List<Payroll> payrolls = model.getPayrollByName(payrollName);

            Optional.ofNullable(payrolls)
                    .filter(list -> !list.isEmpty())
                    .ifPresentOrElse(
                            list -> {
                                try {
                                    model.deletePayrollName(payrollName);
                                    display = view.printMessage("Payroll deleted successfully.");
                                } catch (SQLException ex) {
                                    Logger.getLogger(PayrollController.class.getName()).log(Level.SEVERE, null, ex);
                                    display = view.printMessage("Error deleting payroll: " + ex.getMessage());
                                }
                            },
                            () -> display = view.printMessage("Payroll not found!")
                    );
        } catch (SQLException e) {
            view.printMessage("Error retrieving payrolls: " + e.getMessage());
        }
    }
}
