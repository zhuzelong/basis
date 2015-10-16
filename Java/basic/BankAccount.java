/**
* A bank account class
*/
public class BankAccount
{
    private float balance;

    /**
    * constructor of the class
    */
    public BankAccount(float balance)
    {
        this.balance=balance;
    }
    
    /**
    * return the balance of the bank account
    */
    public float getBalance()
    {
        return balance; 
    }

    /**
    * change the balance
    */
    public void setBalance(float balanceAmount)
    {
        this.balance+=balanceAmount;
    }
    
    /**
    * the main function, start of the class
    */
    public static void main(String[] args)
    {
        BankAccount account1=new BankAccount(100);
        System.out.println(account1.getBalance());
        BankAccount account2=new BankAccount(400);
        System.out.println(account2.getBalance());
        account1.setBalance(300);
        account2.setBalance(-100);
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
    }
}
