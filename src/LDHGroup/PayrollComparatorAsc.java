/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LDHGroup;

import java.util.Comparator;
//highest to lowesr
public class PayrollComparatorAsc implements Comparator<Payroll> {

    @Override
    public int compare(Payroll o1, Payroll o2) {
       return Double.compare(o1.getTotalamount(),o2.getTotalamount());
    }
    
}