
package LDHGroup;
import java.util.Comparator ; 
public class NumCarComparator implements Comparator <Payroll> {
//ascending
    @Override
    public int compare(Payroll o1, Payroll o2) {
        return Integer.compare( o1.getNumcar(),o2.getNumcar());
    }
    
}
