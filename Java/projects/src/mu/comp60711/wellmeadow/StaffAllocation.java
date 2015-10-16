package mu.comp60711.wellmeadow;

/**
 * A form of allocation information about staff and ward.
 */
public class StaffAllocation
{
    private Ward ward;
    private Staff chargeNurse;
    private Staff staff;
    private String shift;

    // constructor
    public StaffAllocation(){}
    public StaffAllocation(Ward ward, Staff chargeNurse, Staff staff, String shift)
    {
        this.ward=ward;
        this.chargeNurse=chargeNurse;
        this.staff=staff;
        this.shift=shift;
    }

    // getter
    public Ward getWard() { return ward; }
    public Staff getChargeNurse() { return chargeNurse; }
    public Staff getStaff() { return staff; }
    public String getShift() { return shift; }

    // setter
    public void setWard(Ward value) { this.ward=value; }
    public void setChargeNurse(Staff value) { this.chargeNurse=value; }
    public void setStaff(Staff value) { this.staff=value; }
    public void setShift(String value) { this.shift=value; }

    public void toString()
    {
        System.out.println("Ward = "+ward+"\nchargeNurse is "+chargeNurse.getFistName()+" "+chargeNurse.getLastName()
                            +"\nStaff information: "+staff.toString()+"\nshift = "+shift);
    }
}
