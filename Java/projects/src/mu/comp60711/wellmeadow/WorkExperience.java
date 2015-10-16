package mu.comp60711.wellmeadow;

/**
 * Working experience of staff, a component of a staff's information.
 */
public class WorkExperience
{
    private String organization;
    private String position;
    private String startDate;
    private String endDate;

    // constructor
    public WorkExperience(String organ, String position, String startDate, String endDate)
    {
        this.organization=organ;
        this.position=position;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    // getter
    public String getOrganization() { return organization; }
    public String getPosition() { return position; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    
    // setter
    public void setOrganization(String value) { this.organization=value; }
    public void setPosition(String value) { this.position=value; }
    public void setStartDate(String value) { this.startDate=value; }
    public void setEndDate(String value) { this.endDate=value; }
}
