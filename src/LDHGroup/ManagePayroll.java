/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LDHGroup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ManagePayroll extends javax.swing.JFrame {

    int searchindex = 0;    //sign for implement what method 
    int tableindex = 0;     //searchindex implement search name and display at table but tableindex means sorting the data following the month and year
    List<Payroll> payrolls = null;
    List<Payroll> payrollsearch = null;
    List<Payroll> payrolls2 = null;
    Timer t;
    SimpleDateFormat st;

    public ManagePayroll() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setSize(1080, 700);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        tabledisplay.setVisible(true);
        cbsort1.setVisible(false);
        runTask.setVisible(false);
        sortDate.setVisible(false);
        areaTxtbtn.setVisible(false);
        dt();
        times();
        numcarsoldtotal.setVisible(false);
        numcarsoldtotalamount.setVisible(false);
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

    public List<Payroll> sortData() throws SQLException {
        if (tableindex == 1) {
            if (cbsort1.getSelectedItem().toString().equalsIgnoreCase("Ascending Amount Total")) {
                Collections.sort(payrolls, new PayrollComparatorAsc());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Descending Amount Total"))) {
                Collections.sort(payrolls, new PayrollComparatorDesc());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Ascending Num Car Sold"))) {
                Collections.sort(payrolls, new NumCarComparator());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Descending Num Car Sold"))) {
                Collections.sort(payrolls, new NumCarComparatorDesc());
            }
            payrolls2 = payrolls;
        } else if (searchindex == 1) {
            if (cbsort1.getSelectedItem().toString().equalsIgnoreCase("Ascending Amount Total")) {
                Collections.sort(payrollsearch, new PayrollComparatorAsc());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Descending Amount Total"))) {
                Collections.sort(payrollsearch, new PayrollComparatorDesc());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Ascending Num Car Sold"))) {
                Collections.sort(payrollsearch, new NumCarComparator());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Descending Num Car Sold"))) {
                Collections.sort(payrollsearch, new NumCarComparatorDesc());
            }
            payrolls2 = payrollsearch;
        } else {
            payrolls2 = model.getAllPayroll();
            if (cbsort1.getSelectedItem().toString().equalsIgnoreCase("Ascending Amount Total")) {
                Collections.sort(payrolls2, new PayrollComparatorAsc());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Descending Amount Total"))) {
                Collections.sort(payrolls2, new PayrollComparatorDesc());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Ascending Num Car Sold"))) {
                Collections.sort(payrolls2, new NumCarComparator());
            } else if ((cbsort1.getSelectedItem().toString().equalsIgnoreCase("Descending Num Car Sold"))) {
                Collections.sort(payrolls2, new NumCarComparatorDesc());
            }
        }
        return payrolls2;
    }

    public void insertTableDisplayAll() throws SQLException {
        List<Payroll> payrolls5 = model.getAllPayroll();
        if (payrolls5.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No data found!!", "Information message", JOptionPane.INFORMATION_MESSAGE);
        } else {
//                tabledisplay.setRowCount(payrolls.size()); // Ensure the table has enough rows
            DefaultTableModel tableModel = (DefaultTableModel) tabledisplay.getModel();
            tableModel.setRowCount(0); // Clear the table
            for (int i = 0; i < payrolls5.size(); i++) {
                Payroll payroll = payrolls5.get(i);
                Object[] rowData = {
                    i + 1,
                    payroll.getStaffnumber(),
                    payroll.getFullname(),
                    payroll.getTotalamount(),
                    payroll.getNumcar(),
                    payroll.getGrossSalary(),
                    payroll.getNetSalary(),
                    payroll.getMonth() + " " + payroll.getYear()
                };
                tableModel.addRow(rowData);
            }
            JOptionPane.showMessageDialog(null, "The table display all data !!", "Information Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        labelim = new javax.swing.JLabel();
        searchnametxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        displayBtn = new javax.swing.JButton();
        tableBtn = new javax.swing.JButton();
        saveTxtbtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        indextxt = new javax.swing.JLabel();
        runTask = new javax.swing.JButton();
        areaTxtbtn = new javax.swing.JButton();
        desktoppane = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayarea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledisplay = new javax.swing.JTable();
        cbsort1 = new javax.swing.JComboBox<>();
        sortDate = new javax.swing.JButton();
        livedate = new javax.swing.JLabel();
        livetime = new javax.swing.JLabel();
        searchForTable = new javax.swing.JButton();
        numcarsoldtotal = new javax.swing.JLabel();
        numcarsoldtotalamount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1080, 700));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 80, 30));

        labelim.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        labelim.setText("Search Full name");
        jPanel1.add(labelim, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 30));
        jPanel1.add(searchnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 670, -1));

        searchBtn.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 72, 25));

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel1.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 72, 25));

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 72, 25));

        displayBtn.setBackground(new java.awt.Color(255, 255, 255));
        displayBtn.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        displayBtn.setText("Display All Data");
        displayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBtnActionPerformed(evt);
            }
        });
        jPanel1.add(displayBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 210, 25));

        tableBtn.setBackground(new java.awt.Color(255, 255, 255));
        tableBtn.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        tableBtn.setText("Manage Report");
        tableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableBtnActionPerformed(evt);
            }
        });
        jPanel1.add(tableBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 120, 25));

        saveTxtbtn.setBackground(new java.awt.Color(255, 255, 255));
        saveTxtbtn.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        saveTxtbtn.setText("Save to Txt File");
        saveTxtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTxtbtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveTxtbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 120, 25));

        resetBtn.setBackground(new java.awt.Color(255, 255, 255));
        resetBtn.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        jPanel1.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 72, 25));

        indextxt.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        indextxt.setText("0 Slips");
        jPanel1.add(indextxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 30));

        runTask.setBackground(new java.awt.Color(255, 255, 255));
        runTask.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        runTask.setText("Run");
        runTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runTaskActionPerformed(evt);
            }
        });
        jPanel1.add(runTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 50, 25));

        areaTxtbtn.setBackground(new java.awt.Color(255, 255, 255));
        areaTxtbtn.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        areaTxtbtn.setText("Display Slip");
        areaTxtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaTxtbtnActionPerformed(evt);
            }
        });
        jPanel1.add(areaTxtbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 120, 25));

        desktoppane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        displayarea.setEditable(false);
        displayarea.setColumns(20);
        displayarea.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        displayarea.setRows(5);
        displayarea.setAutoscrolls(false);
        displayarea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 14))); // NOI18N
        displayarea.setCaretColor(new java.awt.Color(255, 204, 0));
        displayarea.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        displayarea.setFocusTraversalPolicyProvider(true);
        displayarea.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        displayarea.setSelectionColor(new java.awt.Color(255, 204, 0));
        jScrollPane2.setViewportView(displayarea);

        desktoppane.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 540));

        tabledisplay.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        tabledisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Staff number", "Full Name", "Total Amount", "Num Car Sold", "Gross Salary", "Net Salary", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabledisplay.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tabledisplay.setSelectionForeground(new java.awt.Color(255, 255, 51));
        tabledisplay.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tabledisplay);
        if (tabledisplay.getColumnModel().getColumnCount() > 0) {
            tabledisplay.getColumnModel().getColumn(0).setResizable(false);
            tabledisplay.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabledisplay.getColumnModel().getColumn(1).setResizable(false);
            tabledisplay.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabledisplay.getColumnModel().getColumn(2).setResizable(false);
            tabledisplay.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabledisplay.getColumnModel().getColumn(3).setResizable(false);
            tabledisplay.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabledisplay.getColumnModel().getColumn(4).setResizable(false);
            tabledisplay.getColumnModel().getColumn(4).setPreferredWidth(30);
            tabledisplay.getColumnModel().getColumn(5).setResizable(false);
            tabledisplay.getColumnModel().getColumn(5).setPreferredWidth(50);
            tabledisplay.getColumnModel().getColumn(6).setResizable(false);
            tabledisplay.getColumnModel().getColumn(6).setPreferredWidth(50);
            tabledisplay.getColumnModel().getColumn(7).setResizable(false);
            tabledisplay.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        desktoppane.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 530));

        jPanel1.add(desktoppane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 950, 530));

        cbsort1.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        cbsort1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sorting", "Ascending Amount Total", "Descending Amount Total", "Ascending Num Car Sold", "Descending Num Car Sold" }));
        jPanel1.add(cbsort1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 200, 25));

        sortDate.setBackground(new java.awt.Color(255, 255, 255));
        sortDate.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        sortDate.setText("Sort With Date");
        sortDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDateActionPerformed(evt);
            }
        });
        jPanel1.add(sortDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 120, 25));

        livedate.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        livedate.setForeground(new java.awt.Color(255, 255, 255));
        livedate.setText("0");
        jPanel1.add(livedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, -1));

        livetime.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        livetime.setForeground(new java.awt.Color(255, 255, 255));
        livetime.setText("0");
        jPanel1.add(livetime, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 170, -1));

        searchForTable.setBackground(new java.awt.Color(255, 255, 255));
        searchForTable.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        searchForTable.setText("Search");
        searchForTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchForTableActionPerformed(evt);
            }
        });
        jPanel1.add(searchForTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 72, 25));

        numcarsoldtotal.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        numcarsoldtotal.setText("Num Car");
        jPanel1.add(numcarsoldtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, -1, -1));

        numcarsoldtotalamount.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        numcarsoldtotalamount.setForeground(new java.awt.Color(51, 51, 51));
        numcarsoldtotalamount.setText("0");
        jPanel1.add(numcarsoldtotalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 190, 40, 20));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LDHGroup/Maju Auto sales.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            controller.getPayrollByName(searchnametxt.getText());
            if (controller.display.equalsIgnoreCase("Payroll not found !!")) {
                JOptionPane.showMessageDialog(null, controller.display, "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                displayarea.setText(controller.display);
                if (controller.dindex != 1) {
                    indextxt.setText(controller.index - 1 + " Slips");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed

        searchnametxt.setText("");
        displayarea.setText("");
        indextxt.setText("0 Slips");
        cbsort1.setSelectedIndex(0);
        sortDate.setEnabled(true);
        searchnametxt.setEnabled(true);
        searchForTable.setEnabled(true);
        runTask.setEnabled(true);
        sortDate.setEnabled(true);
        if (tableindex == 1 || searchindex == 1) {
            try {
                insertTableDisplayAll();
                numcarsoldtotal.setVisible(false);
                numcarsoldtotalamount.setVisible(false);
                numcarsoldtotalamount.setText("");
                tableindex = 0;
                searchindex = 0;
                areaTxtbtn.setEnabled(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error from sql: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        System.out.println("-- " + tableindex);
        System.out.println("-- " + searchindex);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void displayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBtnActionPerformed
        searchnametxt.setText("");
        try {
            controller.getAllPayroll();
            displayarea.setText(controller.display);
            if (controller.dindex != 1) {
                indextxt.setText(controller.index - 1 + " Slips");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_displayBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

        int response = JOptionPane.showConfirmDialog(null, "You just only can update the payroll in Enter Information Page ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            PayrollForm frame2 = new PayrollForm();
            frame2.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void saveTxtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTxtbtnActionPerformed
        if (displayarea.getText() != null && !displayarea.getText().trim().isEmpty()) {
            String fileName;
            int response = JOptionPane.showConfirmDialog(null, "Do you really want to save the data?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                if (!searchnametxt.getText().trim().isEmpty()) {
                    fileName = searchnametxt.getText().trim() + ".txt";
                } else {
                    fileName = "alldata.txt";
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                    if (fileName.equalsIgnoreCase("alldata.txt")) {
                        clearFileContents("alldata.txt");
                    }
                    writer.write(displayarea.getText());
                    JOptionPane.showMessageDialog(null, "Data has been successfully saved to " + fileName, "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No data to save!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveTxtbtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Do you really want to delete this payroll?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            String payrollName = searchnametxt.getText().trim();
            if (payrollName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No payroll name provided. No payroll deleted.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if no payroll name is provided
            }

            int response1 = JOptionPane.showConfirmDialog(null, "Do you really want to delete all payroll for this name?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response1 == JOptionPane.NO_OPTION) {
                String[] months = {"Jan", "Feb", "Mac", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                String[] years = {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};

                // Create combo boxes
                JComboBox<String> monthComboBox = new JComboBox<>(months);
                JComboBox<String> yearComboBox = new JComboBox<>(years);

                // Create panel to hold combo boxes
                JPanel panel = new JPanel();
                panel.add(new JLabel("Month:"));
                panel.add(monthComboBox);
                panel.add(Box.createHorizontalStrut(15)); // Add spacing
                panel.add(new JLabel("Year:"));
                panel.add(yearComboBox);

                // Show input dialog with combo boxes
                int option = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "Select Month and/or Year",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                // Process user input
                if (option == JOptionPane.OK_OPTION) {
                    displayarea.setText("");
                    String selectedMonth = (String) monthComboBox.getSelectedItem();
                    String selectedYear = (String) yearComboBox.getSelectedItem();

                    if (selectedMonth != null && selectedYear != null) {
                        controller.deletePayroll(searchnametxt.getText(), selectedMonth, selectedYear);

                        if (controller.display.equalsIgnoreCase("Payroll not found !!")) {
                            JOptionPane.showMessageDialog(null, controller.display, "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, controller.display, "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else if (selectedMonth != null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "You selected: " + selectedMonth,
                                "Selection",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (selectedYear != null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "You selected: " + selectedYear,
                                "Selection",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "No month or year selected",
                                "Selection",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Operation canceled",
                            "Selection",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                controller.deletePayrollName(searchnametxt.getText());

                if (controller.display.equalsIgnoreCase("Payroll not found !!")) {
                    JOptionPane.showMessageDialog(null, controller.display, "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, controller.display, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void tableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableBtnActionPerformed
        System.out.println(tableindex);
        System.out.println(searchindex);
        sortDate.setVisible(true);
        areaTxtbtn.setVisible(true);
        jScrollPane1.setVisible(true);
        jScrollPane2.setVisible(false);
        editBtn.setEnabled(false);
        editBtn.setBackground(Color.red);
        deleteBtn.setEnabled(false);
        deleteBtn.setBackground(Color.red);
        tableBtn.setVisible(false);
        areaTxtbtn.setVisible(true);
        cbsort1.setVisible(true);
        runTask.setVisible(true);
        displayBtn.setVisible(false);
        labelim.setText("Generate Report");
        indextxt.setVisible(false);
        saveTxtbtn.setVisible(false);
        searchnametxt.setText("");
        searchForTable.setVisible(true);
        searchBtn.setVisible(false);
        try {
            insertTableDisplayAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error from sql: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_tableBtnActionPerformed

    private void areaTxtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaTxtbtnActionPerformed
        displayarea.setText("");
        searchnametxt.setText("");
        sortDate.setVisible(false);
        areaTxtbtn.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(true);
        editBtn.setEnabled(true);
        editBtn.setBackground(Color.WHITE);
        deleteBtn.setEnabled(true);
        deleteBtn.setBackground(Color.WHITE);
        tableBtn.setVisible(true);
        areaTxtbtn.setVisible(false);
        cbsort1.setVisible(false);
        displayBtn.setVisible(true);
        runTask.setVisible(false);
        labelim.setText("Search Full name");
        indextxt.setVisible(true);
        saveTxtbtn.setVisible(true);
        searchForTable.setVisible(false);
        searchBtn.setVisible(true);
        cbsort1.setSelectedItem(0);
        tableindex = 0;
        searchindex = 0;
    }//GEN-LAST:event_areaTxtbtnActionPerformed

    private void runTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runTaskActionPerformed
        List<Payroll> payrolls4 = null;
        try {
            payrolls4 = sortData();

        } catch (SQLException ex) {
            Logger.getLogger(ManagePayroll.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel tableModel = (DefaultTableModel) tabledisplay.getModel();
        tableModel.setRowCount(0); // Clear the table
        for (int i = 0; i < payrolls4.size(); i++) {
            Payroll payroll = payrolls4.get(i);
            Object[] rowData = {
                i + 1,
                payroll.getStaffnumber(),
                payroll.getFullname(),
                payroll.getTotalamount(),
                payroll.getNumcar(),
                payroll.getGrossSalary(),
                payroll.getNetSalary(),
                payroll.getMonth() + " " + payroll.getYear()
            };
            tableModel.addRow(rowData);
        }
    }//GEN-LAST:event_runTaskActionPerformed

    private void sortDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDateActionPerformed
        int numcartotal = 0;
        numcarsoldtotal.setVisible(true);
        numcarsoldtotalamount.setVisible(true);
        areaTxtbtn.setEnabled(false);
        cbsort1.setSelectedIndex(0);
        searchnametxt.setEnabled(false);
        searchForTable.setEnabled(false);
        String[] months = {"Jan", "Feb", "Mac", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};

        // Create combo boxes
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        JComboBox<String> yearComboBox = new JComboBox<>(years);

        // Create panel to hold combo boxes
        JPanel panel = new JPanel();
        panel.add(new JLabel("Month:"));
        panel.add(monthComboBox);
        panel.add(Box.createHorizontalStrut(15)); // Add spacing
        panel.add(new JLabel("Year:"));
        panel.add(yearComboBox);

        // Show input dialog with combo boxes
        int option = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Select Month and Year For Get Report",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        // Process user input
        if (option == JOptionPane.OK_OPTION) {
            String selectedMonth = (String) monthComboBox.getSelectedItem();
            String selectedYear = (String) yearComboBox.getSelectedItem();
            List<Payroll> payrolls1 = null;
            if (selectedMonth != null && selectedYear != null) {
                try {
                    payrolls1 = model.getAllPayrollFilter(selectedMonth, selectedYear);
                    payrolls = payrolls1;
                    if (payrolls1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are no payroll for" + selectedMonth + " " + selectedYear + "\nPlease click reset button to find again !!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        runTask.setEnabled(false);
                        sortDate.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "The table shows the result for payroll within " + selectedMonth + " " + selectedYear + "!!\nPlease Click button reset to display all data back.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        sortDate.setEnabled(false);
                    }
                    tableindex = 1;
                    DefaultTableModel tableModel = (DefaultTableModel) tabledisplay.getModel();
                    tableModel.setRowCount(0); // Clear the table
                    for (int i = 0; i < payrolls.size(); i++) {
                        Payroll payroll = payrolls.get(i);
                        Object[] rowData = {
                            i + 1,
                            payroll.getStaffnumber(),
                            payroll.getFullname(),
                            payroll.getTotalamount(),
                            payroll.getNumcar(),
                            payroll.getGrossSalary(),
                            payroll.getNetSalary(),
                            payroll.getMonth() + " " + payroll.getYear()
                        };
                        numcartotal += payroll.getNumcar();
                        tableModel.addRow(rowData);

                    }
                    numcarsoldtotalamount.setText(Integer.toString(numcartotal));
                } catch (SQLException ex) {
                    Logger.getLogger(ManagePayroll.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else if (selectedMonth != null) {
                JOptionPane.showMessageDialog(
                        null,
                        "You selected: " + selectedMonth,
                        "Selection",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (selectedYear != null) {
                JOptionPane.showMessageDialog(
                        null,
                        "You selected: " + selectedYear,
                        "Selection",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No month or year selected",
                        "Selection",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Operation canceled",
                    "Selection",
                    JOptionPane.WARNING_MESSAGE);
            searchnametxt.setEnabled(true);
            searchForTable.setEnabled(true);
        }

        System.out.println(tableindex + " --");
    }//GEN-LAST:event_sortDateActionPerformed

    private void searchForTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchForTableActionPerformed
        areaTxtbtn.setEnabled(false);
        cbsort1.setSelectedIndex(0);
        searchindex = 1;
        if (searchindex == 1) {
            List<Payroll> displaysearch = null;
            try {
                displaysearch = model.getPayrollByName(searchnametxt.getText());

            } catch (SQLException ex) {
                Logger.getLogger(ManagePayroll.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel tableModel = (DefaultTableModel) tabledisplay.getModel();
            tableModel.setRowCount(0); // Clear the table
            for (int i = 0; i < displaysearch.size(); i++) {
                Payroll payroll = displaysearch.get(i);
                Object[] rowData = {
                    i + 1,
                    payroll.getStaffnumber(),
                    payroll.getFullname(),
                    payroll.getTotalamount(),
                    payroll.getNumcar(),
                    payroll.getGrossSalary(),
                    payroll.getNetSalary(),
                    payroll.getMonth() + " " + payroll.getYear()
                };
                tableModel.addRow(rowData);
            }
            sortDate.setEnabled(false);
            payrollsearch = displaysearch;
            if (displaysearch.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Payroll not found !!\nPlease click reset to implement function search again.", "Success", JOptionPane.INFORMATION_MESSAGE);
                searchForTable.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "The table show the data for the searching name!!\nPlease click reset button to display back all data.", "Success", JOptionPane.INFORMATION_MESSAGE);
                searchForTable.setEnabled(false);
            }
        }
        System.out.println(searchindex + " --");
    }//GEN-LAST:event_searchForTableActionPerformed

    public void clearFileContents(String fileName) {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            // Write nothing to the file to clear its contents
            fw.write("");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error clearing file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-foldTblDisplaytstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(ManagePayroll.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePayroll.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePayroll.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePayroll.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePayroll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton areaTxtbtn;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> cbsort1;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JDesktopPane desktoppane;
    private javax.swing.JButton displayBtn;
    private javax.swing.JTextArea displayarea;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel indextxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelim;
    private javax.swing.JLabel livedate;
    private javax.swing.JLabel livetime;
    private javax.swing.JLabel numcarsoldtotal;
    private javax.swing.JLabel numcarsoldtotalamount;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton runTask;
    private javax.swing.JButton saveTxtbtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchForTable;
    private javax.swing.JTextField searchnametxt;
    private javax.swing.JButton sortDate;
    private javax.swing.JButton tableBtn;
    private javax.swing.JTable tabledisplay;
    // End of variables declaration//GEN-END:variables
}
