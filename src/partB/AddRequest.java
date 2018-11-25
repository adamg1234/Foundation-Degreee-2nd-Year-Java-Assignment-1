package partB;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import partA.MyDate;


public class AddRequest extends JFrame implements ActionListener
{
	private ApplicantList list;
	
	private ApplicantList currList = new ApplicantList();

	
	private JLabel lblTitle,lblName, lblTelNo,lblEmail, lblYears, lblMember,
	lblTicketsReq,lblNoAllocated;
	
	private JComboBox cboMember;
	
	private JTextField txtName, txtTelNo, txtEmail,txtYears,txtTicketsRequest;
	
	private JButton btnAdd, btnReset, btnExit;
	
	private int points=0;
	
	public AddRequest(ApplicantList list)
	{
		currList = list;
		
		String[] memberType = {"Full Member", "Weekday Member", "Juvenile Member"};
		
		lblTitle = new JLabel("Add Ticket Request",JLabel.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD,14));
		
		lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblTelNo = new JLabel("Tel No: ");
		lblTelNo.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblYears = new JLabel("Number of years a Member: ");
		lblYears.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblMember = new JLabel("Member Type: ");
		lblMember.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblTicketsReq = new JLabel("Tickets Request: ");
		lblTicketsReq.setFont(new Font("Arial", Font.PLAIN,12));
		
		txtName = new JTextField(10);
		
		txtTelNo = new JTextField(10);
		txtEmail = new JTextField(10);
		txtYears = new JTextField(10);
		
		cboMember= new JComboBox(memberType);
		
		txtTicketsRequest = new JTextField(10);
	
		btnAdd = new JButton("Add Request");
		btnAdd.addActionListener(this);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this); 
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this); 
		
		//1st Column
		getContentPane().setLayout(new GridBagLayout());
		
		addComp(lblTitle,0,0,4,1,1,2);
		
		addComp(lblName,0,1,1,1,1,1);
		
		addComp(lblTelNo,0,2,1,1,1,1);
		
		addComp(lblEmail,0,3,1,1,1,1);
		
		addComp(lblYears,0,4,1,1,1,1);
		
		addComp(lblMember,0,5,2,1,1,1);
		
		addComp(lblTicketsReq,0,6,1,1,1,1);
		
		addComp(btnAdd,0,7,1,1,1,1);
		
		//2nd Column
		addComp(txtName,1,1,1,1,1,1);
		
		addComp(txtTelNo,1,2,1,1,1,1);
		
		addComp(txtEmail,1,3,1,1,1,1);
		
		addComp(txtYears,1,4,1,1,1,1);
		
		addComp(cboMember,1,5,1,1,1,1);
		
		addComp(txtTicketsRequest,1,6,1,1,1,1);
		
		addComp(btnReset,1,7,1,1,1,1);
		
		//3rd Column
		addComp(btnExit,2,7,1,1,1,1);
	}
	

	
	private void addComp(Component c, int gridx, int gridy, int width, int height, int weightx, int weighty)
	{
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(5,5,5,5);
		gc.gridx = gridx;
		gc.gridy = gridy;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.weightx=weightx;
		gc.weighty=weighty;
		
		getContentPane().add(c,gc);
		
	}
			
	
	@Override
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource()==btnAdd)
		{
			
				MyDate dateReq = new MyDate(0,0,0);
			
				LocalDateTime ldt = LocalDateTime.now(); 
				
				TicketReq newRequest = new TicketReq();
				newRequest.setName(My.stringValName(txtName.getText()));
				newRequest.setTelNo(My.stringTelNo(txtTelNo.getText()));
				newRequest.setEmail(My.stringTelNo(txtEmail.getText()));
				
				int day = ldt.getDayOfMonth();
				int month = ldt.getMonthValue();
				int year=ldt.getYear();
				
				dateReq.setDay(day);
				dateReq.setMonth(month);
				dateReq.setYear(year);
				
				newRequest.setDateOfRequest(dateReq);
				
				My.intVal(Integer.parseInt(txtYears.getText()));
				
				String Years = txtYears.getText();
				
				try
				{
					points += Integer.parseInt(Years); 
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a number in the years text box");
					
				}
				
				if(cboMember.getSelectedItem()=="Full Member")
					points+=10;
				else if (cboMember.getSelectedItem()=="Weekday Member")
					points+=7;
				else if (cboMember.getSelectedItem()=="Juvenile Member")
					points+=5;
				
				newRequest.setLoyaltyPoints(points);
				
				My.intValTicket(Integer.parseInt(txtTicketsRequest.getText()));
				
				String tickets = txtTicketsRequest.getText();
				
				if(newRequest.getLoyaltyPoints()>=20)
					newRequest.setPriority(1);
				else if(newRequest.getLoyaltyPoints()>=12)
					newRequest.setPriority(2);
				else if(newRequest.getLoyaltyPoints()>=8)
					newRequest.setPriority(3);
				else 
					newRequest.setPriority(0);
				
				newRequest.setNoTicketsRequested(Integer.parseInt(tickets));
				newRequest.setNoAllocated(0);
				
				currList.add(newRequest);
				
				JOptionPane.showMessageDialog(null, "Your request has been added to the queue. You will be notified if you will receive your tickets, Thank you");
				
				
				txtName.setText("");
				txtTelNo.setText("");
				txtEmail.setText("");
				txtYears.setText("");
				txtTicketsRequest.setText("");
		}
		
		if(ev.getSource()== btnReset)
		{
			txtName.setText("");
			txtTelNo.setText("");
			txtEmail.setText("");
			txtYears.setText("");
			txtTicketsRequest.setText("");
		}
		
		if(ev.getSource()==btnExit)
		{
			this.setVisible(false);
		}
	}
	
	
	
}
