package prog1415;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9130785213335296281L;	
	private Thread t;
	JLabel label = new JLabel("My ATM");
		
	JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	public Splash()
	{
		
		label.setForeground(Color.WHITE);
		label.setFont (label.getFont ().deriveFont (64.0f));
				
		//label
		this.setBounds(100, 100, 500, 400);
		center.setBackground(Color.BLUE);	
		center.add(label);		
		
		this.setUndecorated(true);

		this.getContentPane().add(center, BorderLayout.CENTER);
		

		t = new Thread(new Runnable(){
			public void run()
			{
				try
				{
					Thread.sleep(500);
					Splash.this.setVisible(false);					
					new ATM();	
					Splash.this.dispose();
				}
				catch (Exception e) {
          		  System.out.println(e);
         		}				
			}
		});

		this.setVisible(true);
		t.start();
	}

}
