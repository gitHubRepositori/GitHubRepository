import java.util.Comparator;

public class salaryComparator implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getMonthSalary()-o1.getMonthSalary();
    }
}
