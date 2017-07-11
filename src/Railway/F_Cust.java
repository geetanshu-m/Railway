package Railway;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class F_Cust extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public F_Cust() 
	{
		JLabel l=new JLabel("Congratulations! Tickets Booked.");
		l.setBounds(400, 200, 800, 50);
		//setBackground();
		setLayout(null);
		setVisible(true);
		setTitle("Bookings Done");
		add(l);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
