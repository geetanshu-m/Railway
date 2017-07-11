package Railway;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Train extends JFrame implements ActionListener,ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JRadioButton male,female;
	Choice nat;
	Payment payment;
	JButton b1,b2;
	String radioVal,name,age,nationality;
	
	Train()
	{
		System.out.println("Passenger Details");
		l1=new JLabel();
		l1.setText("Name");
		l1.setBounds(350, 200, 300, 30);
		t1=new JTextField();
		t1.setBounds(750, 200, 300, 30);
		t1.addActionListener(this);
		l2=new JLabel();
		l2.setText("Age");
		l2.setBounds(350, 250, 300, 30);
		t2=new JTextField();
		t2.setBounds(750, 250, 300, 30);
		t2.addActionListener(this);
		l3=new JLabel();
		l3.setText("Gender");
		l3.setBounds(350, 300, 300, 30);
		male=new JRadioButton("Male");
		male.setBounds(750, 300, 100, 30);
		male.addItemListener(this);
		female=new JRadioButton("Female");
		female.setBounds(860, 300, 100, 30);
		female.addItemListener(this);
		l4=new JLabel();
		l4.setText("Nationality");
		l4.setBounds(350, 350, 200, 30);
		nat=new Choice();
		nat.add("Indian");
		nat.add("Other");
		nat.setBounds(750, 350, 200, 30);
		nat.addItemListener(this);
		b1=new JButton("Go To Payment");
		b1.addActionListener(this);
		b1.setBounds(420, 420, 150, 30);
		b2=new JButton("Add Another Passenger");
		b2.addActionListener(this);
		b2.setBounds(590, 420, 250, 30);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(male);
		add(female);
		add(l4);
		add(nat);
		add(b2);
		add(b1);
		setTitle("Passenger Information");
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public String radioText(ButtonGroup btngrp)
	{
		for (Enumeration buttons=btngrp.getElements();
				buttons.hasMoreElements();)
		{
			if(((AbstractButton)buttons).isSelected())
			{
				return ((AbstractButton)buttons).getText();
			}
		}
		return null;
	}

	public void itemStateChanged(ItemEvent ie) 
	{
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
			radioVal=radioText(null);
			nationality=nat.getItem(nat.getSelectedIndex());
		}
			
	}

	public void actionPerformed(ActionEvent ae) 
	{
		name=t1.getText().toString();
		age=t2.getText().toString();
		
		if(ae.getSource()==b1)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_project", "root", "");
				Statement st = con.createStatement();
				st.executeUpdate("Insert into passenger_details Name, Age, Gender, Nationality values('"+name+"','"+age+"','"+radioVal+"','"+nationality+"')");
				

			} 
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
			Payment payment=new Payment();
			payment.setVisible(true);
			
		}
		else if(ae.getSource()==b2)
		{
			try 
			{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_project", "root", "");
				Statement st = con.createStatement();
				st.executeUpdate("Insert into passenger_details Name, Age, Gender, Nationality values('"+name+"','"+age+"','"+radioVal+"','"+nationality+"')");
			} 
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
			Train train=new Train();
			train.setVisible(true);
		}
	}
}
