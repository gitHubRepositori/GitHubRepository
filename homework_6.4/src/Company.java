import java.util.*;

public  class Company  {
    private List<Employee> set = new ArrayList<>();

    public void hire(Employee position)
    {
        set.add(position);
    }

    public void hireAll(Employee position, int numberOfPersons) {

        for (int i = 0; i < numberOfPersons; i++) {
            set.add(position);
        }
    }

    public void fire(int count) {
        for (int i = 1;i<=count;i++){
            int rem = (int) ((Math.random() * ((set.size()-1) - 1)) + 1);
            set.remove(rem);
        }
    }


    public  int getIncome() {
        return (int) ((Math.random() * (20000000 - 1000000)) + 1000000);
    }

    public List<Employee> getTopSalaryStaff(int count)
    {
        if(count<=set.size()) {
            Collections.sort(set, new salaryComparator());
            List<Employee> getTPSSTaff = set.subList(0, count);
            for (Employee gai : getTPSSTaff) {
                System.out.println(gai.getMonthSalary());
            }
            return getTPSSTaff;
        }
        System.out.println("Указали неверное колличество работников, в этой компании работают: "+set);

        return null;
    }

    public List<Employee> getLowestSalaryStaff(int count)
    {

        if(count<=set.size()) {
            Collections.sort(set, new salaryComparator().reversed());
            List<Employee> getTPSSTaff = set.subList(0, count);
            for (Employee gai : getTPSSTaff) {
                System.out.println(gai.getMonthSalary());
            }
            return getTPSSTaff;
        }
        System.out.println("Указали неверное колличество работников, в этой компании работают: "+set);
        return null;
    }

}



