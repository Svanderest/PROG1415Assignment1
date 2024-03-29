package prog1415;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.swing.*;

public class ATM extends JFrame {
	
	private static final long serialVersionUID = 4517103375856486687L;
	BankAccount currentAccount;
	ArrayList<BankAccount> bankAccounts;
	
	JButton btnExit = new JButton("Exit"); 		
	JPanel south = new JPanel(new BorderLayout()); 	
	JPanel east = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel center = new JPanel(new GridLayout(5, 1));
	
	JPanel accountNo = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JTextField txtAccountNo = new JTextField();
	JLabel lblAccountNo = new JLabel("Account Number");

	JPanel login = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton btnLogin = new JButton("Login");
	
	JPanel balance = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel lblBalance = new JLabel("Balance: ");
	JLabel lblAmount = new JLabel("");

	JPanel action = new JPanel(new BorderLayout());
	JPanel actionEast = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel actionCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel actionWest = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JTextField txtAction = new JTextField();
	JButton btnWithdraw = new JButton("Withdraw");
	JButton btnDeposit = new JButton("Deposit");
	
	JPanel logout = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton btnLogout = new JButton("Logout");
	
	public ATM() {
		bankAccounts = new ArrayList<BankAccount>();	
		bankAccounts.add(new ChequingAccount(0, new Date()));
		bankAccounts.add(new SavingsAccount(1, new Date()));
		bankAccounts.add(new SuperChequingAccount(2, new Date()));
		int heightOfBtn = (int)btnExit.getPreferredSize().getHeight();
		this.setTitle("My Atm"); 
		this.setBounds(100, 100, 400, 400);
		
		btnExit.addActionListener(new Exit());		
		btnLogin.addActionListener(new Login());
		btnDeposit.addActionListener(new Deposit());
		btnWithdraw.addActionListener(new Withdraw());
		btnLogout.addActionListener(new Logout());
	
		this.getContentPane().add(south, BorderLayout.SOUTH); 
		this.getContentPane().add(center, BorderLayout.CENTER);
		
		south.add(east, BorderLayout.EAST);
		east.add(btnExit);
		
		center.add(accountNo);
		txtAccountNo.setPreferredSize(new Dimension(250,heightOfBtn));		
		accountNo.add(lblAccountNo);
		accountNo.add(txtAccountNo);

		center.add(login);
		login.add(btnLogin);			

		center.add(balance);
		balance.add(lblBalance);
		balance.add(lblAmount);

		center.add(action);
		action.add(actionEast, BorderLayout.EAST);
		action.add(actionCenter, BorderLayout.CENTER);
		action.add(actionWest, BorderLayout.WEST);
	
		txtAction.setPreferredSize(new Dimension(180,heightOfBtn));
		actionCenter.add(txtAction);
		actionWest.add(btnWithdraw);
		actionEast.add(btnDeposit);
		
		center.add(logout);
		logout.add(btnLogout);

		//	display the UI
		this.setVisible(true);
	}
	
	class Exit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ATM.this.setVisible(false);
			System.exit(0);
		}
		
	}

	class Login implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String accountNo = ATM.this.txtAccountNo.getText();
			try
			{
				int acNo = Integer.parseInt(accountNo);
				ATM.this.currentAccount = null;
				for(int i = 0; i < ATM.this.bankAccounts.size(); i++)
				{
					if(ATM.this.bankAccounts.get(i).getAccountNumber() == acNo)
					{
						ATM.this.currentAccount = ATM.this.bankAccounts.get(i);
						break;
					}
				}
				if(ATM.this.currentAccount == null)
				{
					JOptionPane.showMessageDialog(null, "Account not found", "Invalid input",1);
					ATM.this.lblAmount.setText("");
				}
				else
				{
					ATM.this.lblAmount.setText(Double.toString(ATM.this.currentAccount.getBalance()));
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Please enter a numeric value", "Invalid input",0);
				ATM.this.lblAmount.setText("");
			}			
		}
	}

	class Deposit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(ATM.this.currentAccount == null)
				JOptionPane.showMessageDialog(null, "Please login", "Login required",1);
			else
			{
				try
				{
					double amount = Double.parseDouble(ATM.this.txtAction.getText());
					ATM.this.currentAccount.makeDeposit(amount);
					ATM.this.lblAmount.setText(Double.toString(ATM.this.currentAccount.getBalance()));
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a numeric value", "Invalid input",0);					
				}
			}
			ATM.this.txtAction.setText("");
		}
	}

	class Withdraw implements ActionListener
	{		
		// TODO Auto-generated method stub
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(ATM.this.currentAccount == null)
				JOptionPane.showMessageDialog(null, "Please login", "Login required",1);
			else
			{
				try
				{
					double amount = Double.parseDouble(ATM.this.txtAction.getText());
					ATM.this.currentAccount.makeWithdrawal(amount);
					ATM.this.lblAmount.setText(Double.toString(ATM.this.currentAccount.getBalance()));
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a numeric value", "Invalid input",0);					
				}
			}
			ATM.this.txtAction.setText("");			
		}
	}
	
	class Logout implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(ATM.this.currentAccount == null)
				JOptionPane.showMessageDialog(null, "Cannot log out when not logged in", "Login required",1);
			else
			{
				ATM.this.txtAction.setText("");
				ATM.this.lblAmount.setText("");
				ATM.this.currentAccount = null;
			}
		}
		
	}
}	

