import java.util.TreeSet;
import java.util.zip.CheckedOutputStream;

public class Main implements Employee {
    public static void main(String[] args) {
        Company com = new Company();
        Company Nestle = new Company();

        com.hire(new Manager(com));
        com.hire(new Manager(com));
        com.hire(new Manager(com));
        com.hire(new TopManager((com)));
        Nestle.hire(new Operator(Nestle));
        Nestle.hire(new TopManager(Nestle));


//        com.hireAll("Manager",80);
//        com.hireAll("TopManager",10);
//        com.hireAll("Operator",180);
        com.getTopSalaryStaff(6);
        System.out.println("\n");
        com.getLowestSalaryStaff(6);
        System.out.println("\n");
        Nestle.getTopSalaryStaff(2);
        System.out.println("\n");
        Nestle.getLowestSalaryStaff(2);

//        System.out.println("\n");
//
//
//
//        com.getTopSalaryStaff(15);
//        System.out.println("\n");
//
//        com.getLowestSalaryStaff(30);
    }

    @Override
    public int getMonthSalary() {
        return 0;
    }
}
