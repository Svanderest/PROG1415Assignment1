package prog1415;
import java.util.Date;

public class ChequingAccount extends BankAccount {

	//instance data member for storing the monthly fee
			private double fee;
			
			//class member for storing the default fee
			private static double defaultFee = 5;

			//constructors
			public ChequingAccount(int accountNumber, Date dateOpen)				
			{
				super(accountNumber, dateOpen);
				this.fee = defaultFee;
			}
			
			public ChequingAccount(int accountNumber, Date dateOpen, String first, String last)				
			{
				super(accountNumber, dateOpen, first, last);
				this.fee = defaultFee;
			}
			
			public ChequingAccount(int accountNumber, Date dateOpen, String first, String last, double fee)				
			{
				super(accountNumber, dateOpen, first, last);
				this.fee = fee;
			}

			//object property
			public double getFee()			
			{
				return this.fee;
			}
	
			public void setFee(double newValue)
			{
				this.fee = (newValue >= 0) ? newValue : defaultFee;
			}
			
			//class property
			public static double getDefaultFee()			
			{
				return defaultFee;
			}
	
			public static void setDefaultFee(double newValue)
			{
				defaultFee = (newValue > 0) ? newValue : defaultFee;
			}
		
			//public method to apply the fee charged to the account and return the balance
			//Note:  balance field is protected so that the derived class can have direct access.
			//       cannot use the Balance property because it is read only and
			//       cannot use the WithDraw method because it will not allow a negative balance
			public double applyFee()
			{
				this.balance -= this.fee;
				return this.balance;
			}

			//override base class ToString method to return account information and fee
			public String toString()
			{
				return super.toString() + String.format("\n\tFee: $%.2f",this.fee);
			}

			//must implement the abstract WithDraw method
			public double makeWithdrawal(double amount)
			{
				if(amount > 0 && this.balance >= amount)
				{
					this.balance -= amount;
					return amount;
				}
				else
					return 0;
			}
}
