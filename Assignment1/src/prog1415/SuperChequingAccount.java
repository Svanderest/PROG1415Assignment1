package prog1415;
import java.util.Date;

public final class SuperChequingAccount extends ChequingAccount {
	//instance data member for storing the over draft limit
			private double overDraft;

			//constructors
			public SuperChequingAccount(int accountNumber, Date dateOpen)				
			{
				super(accountNumber, dateOpen);
				this.overDraft = 0;
			}
			public SuperChequingAccount(int accountNumber, Date dateOpen, String first, String last)				
			{
				super(accountNumber, dateOpen, first, last);
				this.overDraft = 0;
			}
			public SuperChequingAccount(int accountNumber, Date dateOpen, String first, String last, double fee)			
			{
				super(accountNumber, dateOpen, first, last, fee);
				this.overDraft = 0;
			}
			public SuperChequingAccount(int accountNumber, Date dateOpen, String first, String last, double fee, double overDraft)				
			{
				super(accountNumber, dateOpen, first, last, fee);
				this.overDraft = overDraft;
			}

			//properties
			public double getOverDraft()			
			{
				return this.overDraft;
			}
			
			public void setOverDraft(double newValue)
			{
				this.overDraft = (newValue >= 0) ? newValue : 0;
			}
			
			//override base class ToString method to return account information and fee
			public String toString()
			{
				return super.toString() + String.format("\n\tDraft: %f",this.overDraft);
			}

			//implement the abstract withDraw method
			public double makeWithdrawal(double amount)
			{
				if(amount > 0 && (this.balance + this.overDraft) >= amount)
				{
					this.balance -= amount;
					return amount;
				}
				else
					return 0;
			}
}
