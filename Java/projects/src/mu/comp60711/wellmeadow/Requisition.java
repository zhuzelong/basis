package mu.comp60711.wellmeadow;

/**
 * A record in a requisition form, several records composite a form.
 */
public class Requisition
{
    private String reqNum;
    private Ward // unsure
    private Staff // unsure
    private String reqDate;
    private Drug // unsure
    private String recvDate;

    // constructor
    public Requisition(String reqNum, Ward ward, Staff staff, Drug drug, String reqDate)
    {
        this.reqNum=reqNum;
        this.reqDate=reqDate;
        this.recvDate=null; // set in the confirmReq method
    }
        
