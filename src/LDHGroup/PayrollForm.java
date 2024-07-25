package LDHGroup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class PayrollForm extends javax.swing.JFrame {

    Payroll payroll1;
    ManagePayroll frame2 = new ManagePayroll();
    Timer t;
    SimpleDateFormat st;

    public PayrollForm() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setSize(1080, 700);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        updateBtn.setVisible(false);
        dt();
        times();
    }

    public void dt() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dd = sdf.format(d);
        livedate.setText(dd);
    }

    public void times() {

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                String tt = st.format(dt);
                livetime.setText(tt);
            }
        });
        {

            t.start();

        }
    }

    PayrollDAO model = new PayrollDAO();
    PayrollView view = new PayrollView();
    PayrollController controller = new PayrollController(model, view);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        staffnumtxt = new javax.swing.JTextField();
        icnumtxt = new javax.swing.JTextField();
        accnumtxt = new javax.swing.JTextField();
        totalamountcar = new javax.swing.JTextField();
        numcar = new javax.swing.JTextField();
        Monthcb = new javax.swing.JComboBox<>();
        Yearcb = new javax.swing.JComboBox<>();
        calculateSave = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        buttonBack2 = new javax.swing.JButton();
        livedate = new javax.swing.JLabel();
        livetime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1080, 700));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setText("Staff Number");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Identification Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Account Number");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Month");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Year");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Amount Sold Car ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 210, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Number Sold Car");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Insert Payroll Information");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));
        jPanel1.add(nametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 700, -1));
        jPanel1.add(staffnumtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 700, -1));
        jPanel1.add(icnumtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 590, -1));
        jPanel1.add(accnumtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 590, -1));
        jPanel1.add(totalamountcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 700, -1));
        jPanel1.add(numcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 700, -1));

        Monthcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select Month ", "Jan", "Feb", "Mac", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        jPanel1.add(Monthcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 260, -1));

        Yearcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select Year", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        jPanel1.add(Yearcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 260, -1));

        calculateSave.setBackground(new java.awt.Color(255, 255, 255));
        calculateSave.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        calculateSave.setText("Calculate & Save");
        calculateSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateSaveActionPerformed(evt);
            }
        });
        jPanel1.add(calculateSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 160, 40));

        resetButton.setBackground(new java.awt.Color(255, 255, 255));
        resetButton.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel1.add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, 160, 40));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 90, 40));

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 3, 14)); // NOI18N
        jLabel11.setText("12 Digits Only");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, -1, 30));

        jLabel12.setFont(new java.awt.Font("Lucida Sans", 3, 14)); // NOI18N
        jLabel12.setText("14 Digits Only");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, -1, 30));

        edit.setBackground(new java.awt.Color(255, 255, 255));
        edit.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 90, 40));

        updateBtn.setBackground(new java.awt.Color(255, 255, 255));
        updateBtn.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        updateBtn.setText("Update Payroll");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 160, 40));

        buttonBack2.setBackground(new java.awt.Color(255, 255, 255));
        buttonBack2.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        buttonBack2.setText("Back to Manage Payroll Page");
        buttonBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBack2ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 220, 40));

        livedate.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        livedate.setText("0");
        jPanel1.add(livedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 200, -1));

        livetime.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        livetime.setText("0");
        jPanel1.add(livetime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 190, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LDHGroup/Maju Auto sales.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        SalesmanFormGUI frame1 = new SalesmanFormGUI();
        frame1.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        staffnumtxt.setText("");
        nametxt.setText("");
        Monthcb.setSelectedIndex(0);
        Yearcb.setSelectedIndex(0);
        icnumtxt.setText("");
        accnumtxt.setText("");
        totalamountcar.setText("");
        numcar.setText("");
//        calculatesave.setEnabled(true);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void calculateSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateSaveActionPerformed

        try {
            if (Monthcb.getSelectedItem().toString().equalsIgnoreCase(null) || Yearcb.getSelectedItem().toString().equalsIgnoreCase(null)
                    || nametxt.getText().equalsIgnoreCase("") || staffnumtxt.getText().equalsIgnoreCase("") || icnumtxt.getText().equalsIgnoreCase("")
                    || accnumtxt.getText().equalsIgnoreCase("") || totalamountcar.getText().equalsIgnoreCase("") || numcar.getText().equalsIgnoreCase("")) {
                throw new Exception("Please fullfill all the requirement before save and calculate !!");
            } else {
                String getmonth = Monthcb.getSelectedItem().toString();
                String getYear = Yearcb.getSelectedItem().toString();
                String icNumber = icnumtxt.getText().trim();
                if (icNumber.length() != 12 || !icNumber.matches("\\d{12}")) {
                    throw new Exception("IC number must be a 12-digit numeric value.");
                }
                String accountNumber = accnumtxt.getText().trim();
                if (accountNumber.length() != 14 || !accountNumber.matches("\\d{14}")) {
                    throw new Exception("Account number must be a 14-digit numeric value.");
                }
                double amountcar1 = Double.parseDouble(totalamountcar.getText());
                int numcar1 = Integer.parseInt(numcar.getText());
                payroll1 = new Payroll(nametxt.getText(), staffnumtxt.getText(), getmonth, getYear, icNumber, accountNumber, amountcar1, numcar1);
                try {
                    controller.addPayroll(payroll1);
                    JOptionPane.showMessageDialog(null, controller.display, "Success", JOptionPane.INFORMATION_MESSAGE);
                    staffnumtxt.setText("");
                    nametxt.setText("");
                    Monthcb.setSelectedIndex(0);
                    Yearcb.setSelectedIndex(0);
                    icnumtxt.setText("");
                    accnumtxt.setText("");
                    totalamountcar.setText("");
                    numcar.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_calculateSaveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Do you really want to edit payroll?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            try {
                String[] months = {"Jan", "Feb", "Mac", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                String[] years = {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};

                // Create combo boxes
                JComboBox<String> monthComboBox = new JComboBox<>(months);
                JComboBox<String> yearComboBox = new JComboBox<>(years);

                // Create text field for name
                JTextField nameTextField = new JTextField(15);

                // Create panel to hold text field and combo boxes
                JPanel panel = new JPanel();
                panel.add(new JLabel("Name:"));
                panel.add(nameTextField);
                panel.add(Box.createHorizontalStrut(15)); // Add spacing
                panel.add(new JLabel("Month:"));
                panel.add(monthComboBox);
                panel.add(Box.createHorizontalStrut(15)); // Add spacing
                panel.add(new JLabel("Year:"));
                panel.add(yearComboBox);

                // Show input dialog with text field and combo boxes
                int option = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Enter Name, Select Month and/or Year",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                // Process user input
                if (option == JOptionPane.OK_OPTION) {
                    String selectedName = nameTextField.getText().trim();
                    String selectedMonth = (String) monthComboBox.getSelectedItem();
                    String selectedYear = (String) yearComboBox.getSelectedItem();

                    if (!selectedName.isEmpty() && selectedMonth != null && selectedYear != null) {
                        payroll1 = model.getPayrollbyNameEdit(selectedName, selectedMonth, selectedYear);
                        if (payroll1 == null) {
                            JOptionPane.showMessageDialog(null, "Payroll not found for " + selectedName + " in " + selectedMonth + " " + selectedYear + " !!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // Proceed with updating payroll information
                            updateBtn.setVisible(true);
                            calculateSave.setVisible(false);
                            calculateSave.setVisible(false);
                            int monthIndex = -1;
                            int yearIndex = -1;
                            for (int i = 0; i < Monthcb.getItemCount(); i++) {
                                if (Monthcb.getItemAt(i).equals(selectedMonth)) {
                                    monthIndex = i;
                                    break;
                                }
                            }

                            for (int i = 0; i < Yearcb.getItemCount(); i++) {
                                if (Yearcb.getItemAt(i).equals(selectedYear)) {
                                    yearIndex = i;
                                    break;
                                }
                            }
                            System.out.println(payroll1.getFullname());
                            nametxt.setText(payroll1.getFullname());
                            staffnumtxt.setText(payroll1.getStaffnumber());
                            staffnumtxt.setEditable(false);
                            nametxt.setEditable(false);
                            icnumtxt.setEditable(false);
                            Monthcb.setEnabled(false);
                            Yearcb.setEnabled(false);
                            staffnumtxt.setBackground(Color.gray);
                            nametxt.setBackground(Color.gray);
                            icnumtxt.setBackground(Color.gray);
                            Monthcb.setBackground(Color.gray);
                            Yearcb.setBackground(Color.gray);
                            icnumtxt.setText(payroll1.getIcnumber());
                            accnumtxt.setText(payroll1.getAccnum());
                            Monthcb.setSelectedIndex(monthIndex);
                            Yearcb.setSelectedIndex(yearIndex);
                            totalamountcar.setText(String.valueOf(payroll1.getTotalamount()));
                            numcar.setText(String.valueOf(payroll1.getNumcar()));
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter name, select month and year.", "Selection", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operation canceled", "Selection", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error updating message: " + e.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Payroll Update Canceled", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_editActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            if (Monthcb.getSelectedItem().toString().equalsIgnoreCase(null) || Yearcb.getSelectedItem().toString().equalsIgnoreCase(null)
                    || nametxt.getText().equalsIgnoreCase("") || staffnumtxt.getText().equalsIgnoreCase("") || icnumtxt.getText().equalsIgnoreCase("")
                    || accnumtxt.getText().equalsIgnoreCase("") || totalamountcar.getText().equalsIgnoreCase("") || numcar.getText().equalsIgnoreCase("")) {
                throw new Exception("Please fullfill all the requirement before save and calculate !!");
            } else {
                String getmonth = Monthcb.getSelectedItem().toString();
                String getYear = Yearcb.getSelectedItem().toString();
                String icNumber = icnumtxt.getText().trim();
                if (icNumber.length() != 12 || !icNumber.matches("\\d{12}")) {
                    throw new Exception("IC number must be a 12-digit numeric value.");
                }
                String accountNumber = accnumtxt.getText().trim();
                if (accountNumber.length() != 14 || !accountNumber.matches("\\d{14}")) {
                    throw new Exception("Account number must be a 14-digit numeric value.");
                }
                double amountcar1 = Double.parseDouble(totalamountcar.getText());
                int numcar1 = Integer.parseInt(numcar.getText());
                payroll1 = new Payroll(nametxt.getText(), staffnumtxt.getText(), getmonth, getYear, icNumber, accountNumber, amountcar1, numcar1);
                try {
                    controller.updatePayroll(payroll1);
                    JOptionPane.showMessageDialog(null, controller.display, "Success", JOptionPane.INFORMATION_MESSAGE);
                    staffnumtxt.setText("");
                    nametxt.setText("");
                    Monthcb.setSelectedIndex(0);
                    Yearcb.setSelectedIndex(0);
                    icnumtxt.setText("");
                    accnumtxt.setText("");
                    totalamountcar.setText("");
                    numcar.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            updateBtn.setVisible(false);
            calculateSave.setVisible(true);
            calculateSave.setEnabled(true);
            staffnumtxt.setEditable(true);
            staffnumtxt.setBackground(Color.WHITE);
            nametxt.setEditable(true);
            icnumtxt.setEditable(true);
            Monthcb.setEnabled(true);
            Yearcb.setEnabled(true);
            nametxt.setBackground(Color.WHITE);
            icnumtxt.setBackground(Color.WHITE);
            Monthcb.setBackground(Color.WHITE);
            Yearcb.setBackground(Color.WHITE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void buttonBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBack2ActionPerformed
        ManagePayroll frame3 = new ManagePayroll();
        frame3.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonBack2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PayrollForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayrollForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayrollForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayrollForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Monthcb;
    private javax.swing.JComboBox<String> Yearcb;
    private javax.swing.JTextField accnumtxt;
    private javax.swing.JButton backButton;
    private javax.swing.JButton buttonBack2;
    private javax.swing.JButton calculateSave;
    private javax.swing.JButton edit;
    private javax.swing.JTextField icnumtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel livedate;
    private javax.swing.JLabel livetime;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField numcar;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField staffnumtxt;
    private javax.swing.JTextField totalamountcar;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
