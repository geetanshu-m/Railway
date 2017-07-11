package Railway;

import java.awt.Color;
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

public class Login1 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JLabel fname,lname,dob,address,email,password,mob;
	final JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton button;
	
	Login login;
	Login1()
	{   setSize(600, 600);
		setTitle("Sign up");
		setLayout(null);
		setBackground(Color.blue);
		fname=new JLabel();
		fname.setText("First Name");
		fname.setBounds(50, 50, 100, 30);
		lname=new JLabel();
		lname.setText("Last Name");
		lname.setBounds(50, 100, 100, 30);
		dob=new JLabel();
		dob.setText("Date Of Birth");
		dob.setBounds(50, 150, 100, 30);
		address=new JLabel();
		address.setText("Address");
		address.setBounds(50, 200, 100, 30);
		email=new JLabel();
		email.setText("Email Id");
		email.setBounds(50, 250, 100, 30);
		password=new JLabel();
		password.setText("Password");
		password.setBounds(50, 300, 100, 30);
		mob=new JLabel();
		mob.setText("Mobile");
		mob.setBounds(50, 350, 100, 30);
		t1=new JTextField();
		t1.setBounds(180, 50, 230, 30);
		t2=new JTextField();
		t2.setBounds(180, 100, 230, 30);
		t3=new JTextField("yyyy-mm-dd");
		t3.setBounds(180, 150, 230, 30);
		t4=new JTextField();
		t4.setBounds(180, 200, 230, 30);
		t5=new JTextField();
		t5.setBounds(180, 250, 230, 30);
		t6=new JTextField();
		t6.setBounds(180, 300, 230, 30);
		t7=new JTextField();
		t7.setBounds(180, 350, 230, 30);
		button=new JButton("Sign Up");
		button.setBounds(120, 400, 170, 30);
		button.addActionListener(this);
				
		add(fname);
		add(t1);
		add(lname);
		add(t2);
		add(dob);
		add(t3);
		add(address);
		add(t4);
		add(email);
		add(t5);
		add(password);
		add(t6);
		add(mob);
		add(t7);
		add(button);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent ae) 
	{
		String value1=t1.getText();
		String value2=t2.getText();
		String value3=t3.getText();
		String value4=t4.getText();
		String value5=t5.getText();
		String value6=t6.getText();
		String value7=t7.getText();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_project", "root", "");
			Statement st = con.createStatement();
			st.executeUpdate("Insert into login (fname,lname,dob,address,email,password,mob) values('"+value1+"','"+value2+"','"+value3+"','"+value4+"','"+value5+"','"+value6+"','"+value7+"')");	
		} 
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}		
	}
}
