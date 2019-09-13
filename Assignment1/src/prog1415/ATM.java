package prog1415;

import java.awt.*;
import javax.swing.*;

public class ATM extends JFrame {
	JButton exit = new JButton("Exit"); 
	JButton save = new JButton("Save");
	
	JPanel south = new JPanel(new BorderLayout()); 
	JPanel west = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
	JPanel east = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel center = new JPanel(new GridLayout());
	JLabel label = new JLabel("Hello world");
	JTextField box = new JTextField();
	
	public ATM() {
		this.setTitle("My Atm"); 
		this.setBounds(100, 100, 500, 400);
		
		west.add(save); 
		east.add(exit); 
		south.add(west, BorderLayout.WEST); 
		south.add(east, BorderLayout.EAST);
		center.add(label);
		center.add(box);
	
		this.getContentPane().add(south, BorderLayout.SOUTH); 
		this.getContentPane().add(center, BorderLayout.CENTER);
		
		//	display the UI
		this.setVisible(true);
	}
}
