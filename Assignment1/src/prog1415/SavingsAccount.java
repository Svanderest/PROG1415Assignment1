package prog1415;
import java.util.Date;

public class SavingsAccount extends BankAccount {
	//instance data member for storing the interest rate
			private double rate;

			//class member for storing the default interest rate
			private static double defaultRate = 0.04;

			//class member for storing the default transaction charge
			private static double charge = 0.50;

			//constructors
			public SavingsAccount(int accountNumber, Date dateOpen)
			{
				super (accountNumber, dateOpen);
				this.rate = defaultRate;
			}
			
			public SavingsAccount(int accountNumber, Date dateOpen, String first, String last)
			{
				super(accountNumber, dateOpen, first, last);
				this.rate = defaultRate;
			}
			
			public SavingsAccount(int accountNumber, Date dateOpen, String first, String last, double rate) 
			{
				super(accountNumber, dateOpen, first, last);
				this.rate = rate;
			}

			//object properties
			public double  getRate()
			{				
				return this.rate;
			}
			
			public void	setRate(double newValue)
			{
				this.rate = (newValue >= 0) ? newValue : defaultRate;			
			}
			
			//class properties
			public static double getDefaultRate()
			{
				return defaultRate;
			}
			
			public static void setDefaultRate(double newValue)
			{
				defaultRate = (newValue > 1) ? (newValue / 100) : (newValue > 0) ? newValue : defaultRate;
			}
			
			public static double getCharge()			
			{
				return charge;
			}
			
			public static void setCharge(double newValue)
			{
				charge = (newValue > 0) ? newValue : charge;
			}			

			//public method to calculate the interest earned and add to the account balance
			//Note:  balance field is protected so that the derived class can have direct access.
			//       cannot use the Balance property because it is read only
			public double applyInterest()
			{
				double interest = this.balance * this.rate;
				this.balance += interest;
				return interest;
			}

			//override base class ToString method to return account information and fee
			public String toString()
			{
				return super.toString() + String.format("\n\tRate: %f",this.rate);
			}

			//must implement the abstract WithDraw method
			public double makeWithdrawal(double amount)
			{
				if(amount > 0 && this.balance >= (amount + charge))
				{
					this.balance -= (amount += charge);
					return amount;
				}
				else
					return 0;
			}
}
