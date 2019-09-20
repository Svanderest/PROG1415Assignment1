package prog1415;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ATM extends JFrame {
	
	private static final long serialVersionUID = 4517103375856486687L;
	JButton exit = new JButton("Exit"); 	
	
	JPanel south = new JPanel(new BorderLayout()); 	
	JPanel east = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel center = new JPanel(new GridLayout(5, 1));
	
	JPanel accountNo = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JTextField txtAccountNo = new JTextField();
	JLabel lblAccountNo = new JLabel("Account Number");
		
	
	public ATM() {
		this.setTitle("My Atm"); 
		this.setBounds(100, 100, 500, 400);
		
		exit.addActionListener(new Exit());		
	
		this.getContentPane().add(south, BorderLayout.SOUTH); 
		this.getContentPane().add(center, BorderLayout.CENTER);
		
		south.add(east, BorderLayout.EAST);
		east.add(exit);
		
		center.add(accountNo);
		txtAccountNo.setPreferredSize(new Dimension(250,24));		
		accountNo.add(lblAccountNo);
		accountNo.add(txtAccountNo);
		
		
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
}
