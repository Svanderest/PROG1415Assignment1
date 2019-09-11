package prog1415;
import java.util.*;
import javax.swing.*;

public class TestProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test Savings Account
		SavingsAccount save = new SavingsAccount(3333,new Date());
		save.setRate(0.02);
		save.makeDeposit(300);
		save.applyInterest();
		save.makeWithdrawal(25);
		JOptionPane.showMessageDialog(null, save.toString());
		
		ChequingAccount ch = new ChequingAccount(5555, new Date());
		ch.setFee(5.55);
		ch.makeDeposit(100);
		ch.applyFee();
		ch.makeWithdrawal(350);
		JOptionPane.showMessageDialog(null, ch.toString());
		
		//test SuperChequingAccount
		SuperChequingAccount super = new SuperChequingAccount(5555,new Date());
		super.setFee(3.25);
		super.setOverdraft(200);
		super.makeDeposit(200);
		super.applyFee();
		super.makeWithdrawal(350);
		JOptionPane.showMessageDialog(null, super.toString());

		//Polymorphic programming - use a base class reference
		BankAccount b = new ChequingAccount(7777,new Date());
		b.makeDeposit(100);
		b.makeWithdrawal(50);
		JOptionPane.showMessageDialog(null, b.toString());

		//Polymorphic programming - use a base class array to
		//store and retrieve any derived bank account type
		BankAccount accounts[] = new BankAccount[3];
		accounts[0] = new ChequingAccount(1234,new Date());
		accounts[1] = new SuperChequingAccount(5678,new Date());
		accounts[2] = new SavingsAccount(9876,new Date());
		for(int i = 0; i < accounts.Length; i++)		
			JOptionPane.showMessageDialog(null, accounts[0].toString());
			
		if(accounts[0] instanceof ChequingAccount)
		{
			//cast the object to its correct type
			ChequingAccount temp = (ChequingAccount) accounts[0];
			//access specific derived class members
			temp.applyFee();
			JOptionPane.showMessageDialog(null, temp.toString());
		}

	}

}
