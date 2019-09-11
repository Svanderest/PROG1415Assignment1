package prog1415;
import java.util.Date;

public abstract class BankAccount {
	
	private final int accountNumber;
	private String first;
	private String last;	
	protected double balance;
	
	private final Date dateOpen;
	
	private static int count = 0;
	
	private final String BANKNAME = "Bank Of Vanscoy";

	public BankAccount(int accountNumber, Date dateOpen)
	{
		setAccount();
		this.accountNumber = (accountNumber > 0) ? accountNumber : 0;
		this.dateOpen = (dateOpen.before(new Date())) ? dateOpen : new Date();		
	}
	
	public BankAccount(int accountNumber, Date dateOpen, String first, String last)
	{
		setAccount();
		this.accountNumber = (accountNumber > 0) ? accountNumber : 0;
		this.dateOpen = (dateOpen.before(new Date())) ? dateOpen : new Date();
		this.first = first;
		this.last = last;
	}
	
	private void setAccount()
	{
		this.first = "Unknown";
		this.last = "Unknown";
		this.balance = 0;
		count++;
	}
	
	public void close()
	{
		count--;
	}
	
	public String getFirst()
	{
		return this.first;
	}
	
	public void setFirst(String newValue)
	{
		this.first = newValue;
	}
	
	public String getLast()
	{
		return this.last;
	}
	
	public void setLast(String newValue)
	{
		this.last = newValue;
	}
	
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public Date getDateOpen()
	{
		return this.dateOpen;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public final String getBankName()
	{
		return this.BANKNAME;
	}
	
	public static int getCount() 
	{
		return count;
	}
	
	public double makeDeposit(double amount)
	{		
		if(amount > 0)
		{
			this.balance += amount;
			return this.balance;
		}
		else
			return 0;
	}
	
	public String toString()
	{				
		return String.format("\n\tAccount: %d\n\tName: %s %s\n\tBalance: $%.2f\n\tOpened: %s", this.accountNumber, this.first, this.last, this.balance, this.dateOpen.toString());
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof BankAccount)		
			return ((BankAccount)obj).accountNumber == this.accountNumber;		
		else
			return false;		
	}
	
	public int hashCode()
	{
		return super.hashCode();
	}
	
	
	public abstract double makeWithdrawal(double amount);
}
