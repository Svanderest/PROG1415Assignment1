package prog1415;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

	private static final long serialVersionUID = 9130785213335296281L;	
	private Thread t;
	
	public Splash()
	{
		this.setBounds(100, 100, 500, 400);
		this.getContentPane().setBackground(Color.BLUE);
		this.setUndecorated(true);
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
