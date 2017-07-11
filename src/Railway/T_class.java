package Railway;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import java.util.Date;


import javax.swing.table.DefaultTableModel;

public class T_class extends JFrame implements ActionListener,ItemListener{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final Choice tr,c4;
	JLabel l;
	int id;
	String str,radio,s1,s2,s3;
	public JTable table;
	String[] columnNames={"Train No","Train Name","From","Departure Time","To","Arrival Time","Distance","Travel Time","Quota"};

	
	Railway railway;
	Train train;
	JButton b;
	T_class()
	{
		l=new JLabel("Select Quota");
		l.setBounds(175, 200, 200, 30);
		

		c4=new Choice();
		c4.add("General");
		c4.add("Physically Handicapped");
		c4.add("Ladies");
		c4.setBounds(400, 200, 200, 30);
		c4.addItemListener(this);
		b=new JButton("Book Now");
		b.addActionListener(this);
		b.setBounds(400, 300, 200, 30);

		tr=new Choice();
		tr.setBounds(400, 250, 200, 30);
		tr.setVisible(false);
		

		
		setLayout(null);
		setTitle("Train Class");
		add(c4);
		add(b);
		add(tr);
		setSize(1100, 1300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}
		
		
		public void itemStateChanged(ItemEvent ie) 
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				
								
				try 
				{
					tr.removeAll();
					tr.setVisible(true);
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_project", "root", "");
					Statement st = con.createStatement();
					
					java.sql.ResultSet r2=st.executeQuery("Select max(sno) from journey_details order by sno desc");
					
					while(r2.next()){
		                
		                id=r2.getInt("max(sno)");
		                
		                System.out.println(id);
		            }
					
					
					
		            java.sql.ResultSet r1=st.executeQuery("Select * from journey_details where sno = "+id);
		           
		            while(r1.next()){
		                
		            	s1=r1.getString("from_station");
		                s2=r1.getString("to_station");
		                s3=c4.getSelectedItem();
		                System.out.println(s1);
		                System.out.println(s2);
		                System.out.println(s3);
		            }
					
	                
		            String sql = "Select Train_no from train_detail where From1 ='"+s1+"' and To1 = '"+s2+"' and Quota = '"+s3+"';";
					
		            java.sql.ResultSet r=st.executeQuery(sql);
		            
		            System.out.println(sql);
		            
		            while(r.next()){
		                
		                String id=r.getString("Train_no");
		                tr.add(id);
		                
		                System.out.println(id);
		            }
					
					
				} 
				catch(Exception ex) 
				{
					ex.printStackTrace();
				}
				showTableData();
			}
		}
		 public void showTableData() {
			 	JFrame frame1 = new JFrame("Database Search Result");
		        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame1.setLayout(new BorderLayout());
			 
		        DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(columnNames);
		        table = new JTable();
		        table.setModel(model);
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        table.setFillsViewportHeight(true);
		        JScrollPane scroll = new JScrollPane(table);
		        scroll.setHorizontalScrollBarPolicy(
		                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		        scroll.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 
		        try {
		        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_project", "root", "");
					Statement st = con.createStatement();
		            PreparedStatement pst = con.prepareStatement("Select * from train_detail where From1 ='"+s1+"' and To1 = '"+s2+"' and Quota = '"+s3+"';");
		            ResultSet rs = pst.executeQuery();
		            int i = 0;
		            while (rs.next()) {
		            	String tno=rs.getString("Train_no");
						String tname=rs.getString("Train_name");
						String f_st=rs.getString("From1");
						Date d_time=rs.getTime("Dep_time");
						String t_st=rs.getString("To1");
						Date  a_time=rs.getTime("Arriv_time");
						String dist=rs.getString("Dist");
						Date  t_time=rs.getTime("Travel_time");
						String quota=rs.getString("Quota");
						//String price=rs.getString("Price");;
						model.addRow(new Object[]{tno,tname,f_st,d_time,t_st,a_time,dist,t_time,quota});
		                i++;
		            }
		            if (i < 1) {
		                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		            if (i == 1) {
		                System.out.println(i + " Record Found");
		            } else {
		                System.out.println(i + " Records Found");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        frame1.add(scroll);
		        frame1.setVisible(true);
		        frame1.setSize(800,600);
		    }
			


		public void actionPerformed(ActionEvent ae) {
			train=new Train();
			train.setVisible(true);
			
		}
			
		public static void main(String args[])
		{
			new T_class();
		}
		
}