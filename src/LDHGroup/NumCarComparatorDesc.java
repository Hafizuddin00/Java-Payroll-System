/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LDHGroup;
import java.util.Comparator ; 
public class NumCarComparatorDesc implements Comparator <Payroll>{
    //descending
    @Override
    public int compare(Payroll o1, Payroll o2) {
         return Integer.compare( o2.getNumcar(),o1.getNumcar());
    }
    
}
