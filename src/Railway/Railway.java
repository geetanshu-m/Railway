package Railway;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Railway extends JFrame implements ActionListener,ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b1,b2;
	final Choice c1,c2,c3;
	final JLabel l1,l2,l3,l4;
	final JTextField t1;
	String s1,s2,s3,s4;
	
		Railway()
		{
			setTitle("Railway Booking");
			System.out.println("%100s"+""+"Centre for Railway Info System");
			setLayout(null);
		//	setLayout(new BorderLayout());
			l1=new JLabel();
			l1.setBounds(150, 150, 200, 30);
			l1.setText("From Station");			
			l2=new JLabel("To Station");
			l2.setBounds(150, 200, 200, 30);
			l3=new JLabel("Journey Date");
			l3.setBounds(150, 250, 200, 30);
			l4=new JLabel("Ticket Type");
			l4.setBounds(150, 300, 200, 30);
			b1=new JButton("Submit");
			b1.setBounds(170, 350, 120, 30);
			b1.addActionListener(this);
			b2=new JButton("Reset");
			b2.setBounds(240,450,120, 30);
			b2.addActionListener(this);
			c1=new Choice();
			c1.add("Jaipur");
			c1.add("Mumbai");
			c1.add("Chennai");
			c1.add("Bengaluru");
			c1.addItemListener(this);
			c1.setBounds(225, 300, 200, 30);
			c2=new Choice();
			c2.add("Jaipur");
			c2.add("Mumbai");
			c2.add("Chennai");
			c2.add("Bengaluru");
			c2.addItemListener(this);
			c2.setBounds(550, 350, 200, 30);
			c3=new Choice();
			c3.add("E-ticket");
			c3.add("I-ticket");
			c3.setBounds(550, 450, 200, 30);
			t1=new JTextField("1996-12-29");
			t1.addActionListener(this);
			t1.setBounds(550, 400, 200, 30);
			add(l1);
			add(c1);
			add(l2);
			add(c2);
			add(l3);
			add(t1);
			add(l4);
			add(c3);
			add(b1);
			add(b2);
			setVisible(true);
			setSize(600, 400);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		}
		
	public void itemStateChanged(ItemEvent ie) 
	{
		ie.getItemSelectable();
		s1=c1.getSelectedItem();
		s2=c2.getSelectedItem();
		s4=c3.getSelectedItem();
		//transfer(s1,s2,s4);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		
		s3=t1.getText();
		
		
		if(ae.getSource()==b1)
		{
			T_class t_class=new T_class();
			t_class.setVisible(true);
						
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_project", "root", "");
				Statement st = con.createStatement();
				//st.executeUpdate("Insert into table journey_details values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
				st.executeUpdate("Insert into journey_details(from_station,to_station,j_date,Ticket_type) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
				this.dispose();
			
			} 
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
		}
		else
		{
			repaint();
			//Railway railway=new Railway();
			//railway.setVisible(true);
		}	
	}
}

