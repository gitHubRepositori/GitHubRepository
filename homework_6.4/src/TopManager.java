public class TopManager  implements Employee {
    private Company myCompany;
    private int stavkaTopManager = 60000;
    private int salaryTopManager;
    public TopManager(Company company){
        myCompany = company;
        if(myCompany.getIncome()>10000000){
            this.salaryTopManager = stavkaTopManager+90000;

        }else  {
            this.salaryTopManager = stavkaTopManager;
        }
    }


    @Override
    public int getMonthSalary()
    {

            return salaryTopManager;
    }

}
