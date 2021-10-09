public  class Manager  implements Employee
{
     private int salaryManager ;
    private Company myCompany;
     private int cod = (int) ((Math.random() * (140000 - 115000)) + 115000);

   public Manager(Company company) {
       myCompany = company;
       salaryManager = 25000 + ((5 * cod) / 100);
   }


    @Override
    public int getMonthSalary()
    {
        return salaryManager;
    }

}
