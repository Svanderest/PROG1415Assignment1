package prog1415;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ATM extends JFrame {
	
	private static final long serialVersionUID = 4517103375856486687L;
	JButton exit = new JButton("Exit"); 
	JButton save = new JButton("Save");
	
	JPanel south = new JPanel(new BorderLayout()); 
	JPanel west = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
	JPanel east = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel center = new JPanel(new GridLayout(3,2));
	JLabel label = new JLabel("Hello world");
	JLabel label2 = new JLabel("Hello again");
	JTextField box = new JTextField();
	JTextField box2 = new JTextField();
	
	public ATM() {
		this.setTitle("My Atm"); 
		this.setBounds(100, 100, 500, 400);
		
		exit.addActionListener(new Exit());
		west.add(save); 
		east.add(exit); 
		south.add(west, BorderLayout.WEST); 
		south.add(east, BorderLayout.EAST);
		center.add(label);		
		center.add(box);
		center.add(label2);
		center.add(box2);
	
		this.getContentPane().add(south, BorderLayout.SOUTH); 
		this.getContentPane().add(center, BorderLayout.CENTER);
		
		//	display the UI
		this.setVisible(true);
	}
	
	class Exit implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ATM.this.setVisible(false);
			System.exit(1);
		}
		
	}	
}
