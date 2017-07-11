package Railway;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Payment extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b;
	F_Cust fcust;
	Train train;
	String s1,s2,s3,s4,s5;
	
	Payment() 
	{
		setTitle("Payment");
		System.out.println("Pay through Credit Card or Debit Card");
		l1=new JLabel();
		l1.setText("Card No.");
		l1.setBounds(400, 100, 200, 20);
		t1=new JTextField();
		t1.addActionListener(this);
		t1.setBounds(650, 100, 200, 20);
		l2=new JLabel();
		l2.setText("CVV");
		l2.setBounds(400, 150, 200, 20);
		t2=new JTextField();
		t2.addActionListener(this);
		t2.setBounds(650, 150, 200, 20);
		l3=new JLabel();
		l3.setText("Card No.");
		l3.setBounds(400, 200, 200, 20);
		t3=new JTextField();
		t3.addActionListener(this);
		t3.setBounds(400, 200, 200, 20);
		l4=new JLabel();
		l4.setText("Card No.");
		l4.setBounds(400, 250, 200, 20);
		t4=new JTextField();
		t4.addActionListener(this);
		t4.setBounds(650, 250, 200, 20);
		l5=new JLabel();
		l5.setText("Card No.");
		l5.setBounds(400, 300, 200, 20);
		t5=new JTextField();
		t5.addActionListener(this);
		t5.setBounds(400, 300, 200, 20);
		b=new JButton("Pay");
		b.addActionListener(this);
		b.setBounds(600, 380, 250, 30);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(b);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		s1=t1.getText().toString();
		s2=t2.getText().toString();
		s3=t3.getText().toString();
		s4=t4.getText().toString();
		s5=t5.getText().toString();
		
		if(ae.getSource()==b)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_project", "root", "");
				Statement st = con.createStatement();
				st.executeUpdate("Insert into passenger_details (Card_no, CH_name, Bank, Amount) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
							} 
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
			fcust=new F_Cust();
			fcust.setVisible(true);

		}
	}
}
