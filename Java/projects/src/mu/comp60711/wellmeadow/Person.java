ackage mu.comp60711.wellmeadow;

/**
 * A common person
 */
enum Gender {MALE, FEMALE};

public class Person
{
    private String firstName;
    private String lastName;
    private String address;
    private String dateBirth;
    private String telNum;
    private Gender gender;
    
    // constructor
    public Person(String firstName, String lastName, String address, String dateBirth, String telNum, Gender gender)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.dateBirth=dateBirth;
        this.gender=gender;
        this.telNum=telNum;
    }

    // getter
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getDateBirth() { return dateBirth; }
    public Gender getGender() { return gender; }
    public String getTelNum() { return telNum; }
    
    // setter
    public void setFirstName(String value) { firstName=value; }
    public void setLastName(String value) { lastName=value; }
    public void setAddress(String value) { address=value; }
    public void setDateBirth(String value) { dateBirth=value; }
    public void setGender(Gender value) { gender=value; }
    public void setTelNum(String value) { telNum=value; }
        
    // toString
    public String toString()
    {
        return "Person: "+firstName+" "+lastName+" Address="+address+" dateBirth="+dateBirth+" Tel="+telNum+" Gender="+gender;    
    }
}
