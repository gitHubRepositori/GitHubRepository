public class Operator  implements Employee
{
    private Company myCompany;
    public Operator(Company company){
        myCompany = company;
    }
    private int salaryOperator = 25000;
    @Override
    public int getMonthSalary()
    {
        return salaryOperator;
    }

}

