package prog1415;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9130785213335296281L;	
	private Thread t;
	
	public Splash()
	{
		this.setBounds(100, 100, 500, 400);
		this.getContentPane().setBackgroundColor(COLOR.BLACK);
		this.setUndecorated();
		t = new Thread(new Runnable(){
			public void run()
			{
				Thread.sleep(5000);
				new ATM();
				this.dispose();
			}
		});
		this.setVisible(true);
		t.start();
	}

}
