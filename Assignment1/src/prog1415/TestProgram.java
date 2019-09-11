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
	}

}
