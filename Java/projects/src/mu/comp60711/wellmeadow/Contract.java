package mu.comp60711.wellmeadow;

/**
 * Depict the contract type of a staff, a component of staff's information.
 */
enum SalaryType{WEEKLY, YEARLY};
enum ContractType {PERMANENT, TEMPORARY};

public class Contract
{
    private float workHour;
    private SalaryType salaryType;
    private ContractType contractType;
    private int salaryScale;
    private float salary;

    // constructor
    public Contract(float workHour, ContractType ctype, SalaryType stype, int scale, float salary)
    {
        this.workHour=workHour;
        this.contractType=ctype;
        this.salaryType=stype;
        this.salaryScale=scale;
        this.salary=salary;
    }

    // getter
    public float getWorkHour() { return workHour; }
    public ContractType getContractType() { return contractType; }
    public SalaryType getSalaryType() { return salaryType; }
    public int getSalaryScale() { return salaryScale; }
    public float getSalary() { return salary; }

    // setter
    public void setWorkHour(float value) { this.workHour=value; }
    public void setContractType(ContractType value) { this.contractType=value; }
    public void setSalaryType(SalaryType value) { this.salaryType=value; }
    public void setSalaryScale(int value) { this.salaryScale=value; }
    public void setSalary(float value) { this.salary=value; }
}
