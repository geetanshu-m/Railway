package Railway;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
JFrame j1;
JLabel l1,l2;
final JTextField t1;
final JPasswordField t2;
JButton b1,b2;
Railway railway;
Login1 login1;
String value1, value2;


	Login()
	{
		j1 = new JFrame();
		l1=new JLabel();
		l1.setText("UserName");
		l1.setBounds(100,100,100,30);
		
		t1=new JTextField();
		t1.setBounds(200,100,100,30);
		l2=new JLabel();
		l2.setText("Password");
		l2.setBounds(100,150,100,30);
		t2=new JPasswordField(100);
		t2.setBounds(200,150,100,30);
		b1=new JButton("Login");
		b1.addActionListener(this);
		b1.setBounds(120, 200, 100, 30);
		b2=new JButton("Register");
		b2.addActionListener(this);
		b2.setBounds(190, 200, 100, 30);
		
		j1.add(l1);
		j1.add(t1);
		j1.add(l2);
		j1.add(t2);
		j1.add(b1);
		j1.add(b2); 
		
		setLocationRelativeTo(null);
		j1.setVisible(true);
		j1.setSize(600, 400);
		j1.setLayout(null);
		j1.setTitle("LOGIN TO BOOK TRAIN");
	}

	public void actionPerformed(ActionEvent ae) 
	{
		value1=t1.getText();
		value2=new String(this.t2.getPassword());
		

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_project", "root", "");
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("Select * from login where email='"+value1+"' and password='"+value2+"'");
			if(ae.getSource()==b1)
			{
				if(value1.length()==0||value2.length()==0)
				{
					JOptionPane.showMessageDialog(null,"Fields are empty");
				}		
				int count=0;
		           while(rs.next())
		          {
		           count++;
		          }
		          if(count>0)
		          {
		           System.out.println("Welcome "+value1);
		           this.dispose();
		           this.setVisible(false);
		           railway=new Railway();
		           railway.setVisible(true);
		           
		           }
		          else
		          {
		        	  JOptionPane.showMessageDialog(null,"Invalid Username or Password");
		          }
			} 
			else if(ae.getSource()==b2)
			{
				login1=new Login1();
				login1.setVisible(true);		
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
		public static void main(String args[])
		{
			new Login();			
		}	
		
	
	
}
