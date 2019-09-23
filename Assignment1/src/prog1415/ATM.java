package prog1415;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ATM extends JFrame {
	
	private static final long serialVersionUID = 4517103375856486687L;
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
	
	public ATM() {
		int heightOfBtn = (int)btnExit.getPreferredSize().getHeight();
		this.setTitle("My Atm"); 
		this.setBounds(100, 100, 400, 400);
		
		btnExit.addActionListener(new Exit());		
	
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
		txtAction.setPreferredSize(new Dimension(250,heightOfBtn));
		actionCenter.add(txtAction);
		actionWest.add(btnWithdraw);
		actionEast.add(btnDeposit);

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
		}
	}

	class Deposit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		}
	}

	class Withdraw implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		}
	}	
}
