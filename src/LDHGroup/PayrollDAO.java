package LDHGroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/majupayrollsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public List<Payroll> getPayrollByName(String payrollName) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Payroll> payrollList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM payroll WHERE fullname = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, payrollName);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String staffNumber = resultSet.getString("staffnumber");
                String fullName = resultSet.getString("fullname");
                String month = resultSet.getString("month");
                String year = resultSet.getString("year");
                String icNumber = resultSet.getString("icnumber");
                String accountNumber = resultSet.getString("accountnumber");
                double totalAmount = resultSet.getDouble("totalamount");
                int numCarSold = resultSet.getInt("numcarsold");

                Payroll payroll = new Payroll(fullName, staffNumber, month, year, icNumber, accountNumber, totalAmount, numCarSold);
                payrollList.add(payroll);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return payrollList;
    }

    public List<Payroll> getAllPayrollFilter(String month, String year) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Payroll> payrollList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM payroll WHERE (month = ? AND year = ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, month);
            statement.setString(2, year);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String staffNumber = resultSet.getString("staffnumber");
                String fullName = resultSet.getString("fullname");
                String month1 = resultSet.getString("month");
                String year1 = resultSet.getString("year");
                String icNumber = resultSet.getString("icnumber");
                String accountNumber = resultSet.getString("accountnumber");
                double totalAmount = resultSet.getDouble("totalamount");
                int numCarSold = resultSet.getInt("numcarsold");

                Payroll payroll = new Payroll(fullName, staffNumber, month1, year1, icNumber, accountNumber, totalAmount, numCarSold);
                payrollList.add(payroll);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return payrollList;
    }

    public Payroll getPayrollbyNameEdit(String PayrollName, String month, String year) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Payroll payroll = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM payroll WHERE (fullname = ? AND month = ? AND year = ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, PayrollName);
            statement.setString(2, month);
            statement.setString(3, year);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String staffNumber = resultSet.getString("staffnumber");
                String fullName = resultSet.getString("fullname");
                String month1 = resultSet.getString("month");
                String year1 = resultSet.getString("year");
                String icNumber = resultSet.getString("icnumber");
                String accountNumber = resultSet.getString("accountnumber");
                double totalAmount = resultSet.getDouble("totalamount");
                int numCarSold = resultSet.getInt("numcarsold");

                payroll = new Payroll(fullName, staffNumber, month1, year1, icNumber, accountNumber, totalAmount, numCarSold);

            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return payroll;

    }

    public List<Payroll> getAllPayroll() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Payroll> payrolls = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM payroll";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String staffNumber = resultSet.getString("staffnumber");

                String fullName = resultSet.getString("fullname");
                String month = resultSet.getString("month");
                String year = resultSet.getString("year");
                String icNumber = resultSet.getString("icnumber");
                String accountNumber = resultSet.getString("accountnumber");
                double totalAmount = resultSet.getDouble("totalamount");
                int numCarSold = resultSet.getInt("numcarsold");
                Payroll payroll = new Payroll(fullName, staffNumber, month, year, icNumber, accountNumber, totalAmount, numCarSold);
                payrolls.add(payroll);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return payrolls;
    }

    public void addPayroll(Payroll payroll) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "INSERT INTO payroll (staffnumber, fullname, month, year, icnumber, accountnumber, totalamount, numcarsold, carbodycommission, incentivecommission, incometax, epf, grosssalary , netsalary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, payroll.getStaffnumber());
            statement.setString(2, payroll.getFullname());
            statement.setString(3, payroll.getMonth());
            statement.setString(4, payroll.getYear());
            statement.setString(5, payroll.getIcnumber());
            statement.setString(6, payroll.getAccnum());
            statement.setDouble(7, payroll.getTotalamount());
            statement.setInt(8, payroll.getNumcar());
            statement.setDouble(9, payroll.getCbcom());
            statement.setDouble(10, payroll.getIncom());
            statement.setDouble(11, payroll.getIntax());
            statement.setDouble(12, payroll.getEpf());
            statement.setDouble(13, payroll.getGrossSalary());
            statement.setDouble(14, payroll.getNetSalary());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void updatePayroll(Payroll payroll) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "UPDATE payroll SET accountnumber = ?, totalamount = ?, numcarsold = ?, carbodycommission = ?, incentivecommission = ?, incometax = ?, epf = ?, grosssalary = ?, netsalary = ? WHERE fullname = ? AND month = ? AND year = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, payroll.getAccnum());
            statement.setDouble(2, payroll.getTotalamount());
            statement.setInt(3, payroll.getNumcar());
            statement.setDouble(4, payroll.getCbcom());
            statement.setDouble(5, payroll.getIncom());
            statement.setDouble(6, payroll.getIntax());
            statement.setDouble(7, payroll.getEpf());
            statement.setDouble(8, payroll.getGrossSalary());
            statement.setDouble(9, payroll.getNetSalary());
            statement.setString(10, payroll.getFullname());
            statement.setString(11, payroll.getMonth());
            statement.setString(12, payroll.getYear());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void deletePayroll(String Payrollname, String month, String year) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "DELETE FROM payroll WHERE (fullname = ? AND month = ? AND year = ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, Payrollname);
            statement.setString(2, month);
            statement.setString(3, year);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void deletePayrollName(String Payrollname) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "DELETE FROM payroll WHERE (fullname = ? )";
            statement = connection.prepareStatement(query);
            statement.setString(1, Payrollname);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
