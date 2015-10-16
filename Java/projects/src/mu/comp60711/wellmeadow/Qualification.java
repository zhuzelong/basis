package mu.comp60711.wellmeadow;

/**
 * Qualifications of a staff, a component of a staff's information.
 */
public class Qualification
{
    private String type;
    private String qualiDate;
    private String institute;

    // constructor
    public Qualification(String type, String qualiDate, String institute)
    {
        this.type=type;
        this.qualiDate=qualiDate;
        this.institute=institute;
    }

    // getter
    public String getQualiType() { return type; }
    public String getQualiDate() { return qualiDate; }
    public String getQualiInstitute() { return institute; }

    // setter
    public void setQualiType(String value) { this.type=value; }
    public void setQualiDate(String value) { this.qualiDate=value; }
    public void setQualiInstitute(String value) { this.institute=value; }
}
