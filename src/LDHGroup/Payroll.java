package LDHGroup;

public class Payroll {

    private String fullname;
    private String staffnumber;
    private String month;
    private String year;
    private String icnumber;
    private String accnumber;
    private double totalamount;
    private int numcar;
    private double cbcom; // card body commision 
    private double incom; // incentivecommision 
    private double intax; // monthly income tax
    private double epf;
    private double grosssalary;
    private double netsalary;

    public Payroll(String fullname, String staffnumber, String month, String year, String icnumber,
            String accnumber, double totalamount, int numcar) {
        this.fullname = fullname;
        this.staffnumber = staffnumber;
        this.icnumber = icnumber;
        this.accnumber = accnumber;
        this.month = month;
        this.year = year;
        this.totalamount = totalamount;
        this.numcar = numcar;
        calculateComission();
        calculateGrosssalary();
        calculateTax();
        calculateEPF();
        calculateNetSalary();

    }

    public Payroll(String fullname, String staffnumber, String icnumber,
            String accnumber) {
        this.fullname = fullname;
        this.staffnumber = staffnumber;
        this.icnumber = icnumber;
        this.accnumber = accnumber;
    }

    public Payroll(String fullname, String month, String year, double totalamount, int numcar) {
        this.fullname = fullname;
        this.month = month;
        this.year = year;
        this.totalamount = totalamount;
        this.numcar = numcar;
    }

    public String getFullname() {
        return fullname;
    }

    public String getStaffnumber() {
        return staffnumber;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getIcnumber() {
        return icnumber;
    }

    public String getAccnum() {
        return accnumber;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public int getNumcar() {
        return numcar;
    }

    public double getCbcom() {
        return cbcom;
    }

    public double getIncom() {
        return incom;
    }

    public double getIntax() {
        return intax;
    }

    public double getEpf() {
        return epf;
    }

    public double getGrossSalary() {
        return grosssalary;
    }

    public double getNetSalary() {
        return netsalary;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setStaffnumber(String staffnumber) {
        this.staffnumber = staffnumber;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setIcnumber(String icnumber) {
        this.icnumber = icnumber;
    }

    public void setAccnumber(String accnumber) {
        this.accnumber = accnumber;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public void setNumcar(int numcar) {
        this.numcar = numcar;
    }

    public void calculateComission() {
        cbcom = 0.01 * totalamount;
        if (numcar >= 5 && numcar <= 9) {
            incom = 200 * numcar;
        } else if (numcar >= 10 && numcar <= 14) {
            incom = 400 * numcar;
        } else if (numcar > 14) {
            incom = 600 * numcar;
        }
        cbcom = Math.round(cbcom * 100.0) / 100.0;
        incom = Math.round(incom * 100.0) / 100.0;
    }

    public void calculateGrosssalary() {
        grosssalary = 1500 + cbcom + incom;
        grosssalary = Math.round(grosssalary * 100.0) / 100.0;
    }

    public void calculateTax() {
        if (grosssalary >= 0 && grosssalary < 416.68) {
            intax = grosssalary * 0;
        } else if (grosssalary >= 416.68 && grosssalary < 1666.68) {
            intax = grosssalary * 0.01;
        } else if (grosssalary >= 1666.68 && grosssalary < 2916.68) {
            intax = grosssalary * 0.03;
        } else if (grosssalary >= 2916.68 && grosssalary < 4166.68) {
            intax = grosssalary * 0.08;
        } else if (grosssalary >= 4166.68 && grosssalary < 5833.34) {
            intax = grosssalary * 0.13;
        } else if (grosssalary >= 5833.34 && grosssalary < 8333.34) {
            intax = grosssalary * 0.21;
        } else if (grosssalary >= 8333.34 && grosssalary < 20833.34) {
            intax = grosssalary * 0.24;
        } else if (grosssalary >= 20833.34 && grosssalary < 33333.34) {
            intax = grosssalary * 0.245;
        } else if (grosssalary >= 33333.34 && grosssalary < 50000.01) {
            intax = grosssalary * 0.25;
        } else if (grosssalary >= 50000.01 && grosssalary < 83333.34) {
            intax = grosssalary * 0.26;
        } else if (grosssalary >= 83333.34 && grosssalary < 166666.68) {
            intax = grosssalary * 0.28;
        } else if (grosssalary >= 166666.68) {
            intax = grosssalary * 0.30;
        }
        intax = Math.round(intax * 100.0) / 100.0;
    }

    public void calculateEPF() {
        epf = 0.11 * grosssalary;
        epf = Math.round(epf * 100.0) / 100.0;
    }

    public void calculateNetSalary() {
        netsalary = grosssalary - epf - intax;
        netsalary = Math.round(netsalary * 100.0) / 100.0;
    }

    public String m() {
        return String.format(
                "Payroll Slip \n\n"
                + "Staff name                     : %-20s\n"
                + "Staff number                 : %-10s\n"
                + "Month                            : %-10s\n"
                + "Year                               : %-4s\n"
                + "Identification Number : %-20s\n"
                + "Account number           : %-20s\n"
                + "Total Amount               : RM %-10.2f\n"
                + "Number Car Sold          : %-10d\n\n----------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------\n\n"
                + "Calculation:\n\n"
                + "Car body commission  : RM %210.2f\n"
                + "Incentive commission  : RM %210.2f\n"
                + "Monthly Income Tax    : RM %210.2f\n"
                + "EPF                                 : RM %210.2f\n"
                + "Gross salary                  : RM %210.2f\n\n----------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------\n"
                + "Net salary                     : RM %210.2f\n\n----------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------\n"
                + "Push Reset Button to enter or search other information !!",
                fullname, staffnumber, month, year, icnumber, accnumber, totalamount, numcar,
                cbcom, incom, intax, epf, grosssalary, netsalary
        );

    }

}
