package partB;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRequest extends JFrame implements ActionListener
{
	private ApplicantList list;
	
	ApplicantList currList = new ApplicantList();
	
	private TicketReq update;
	
	private JLabel lblTitle,lblNameSearch,lblName, lblTelNo,lblEmail,
	lblTicketsReq;
	

	
	private JTextField txtNameSearch,txtName, txtTelNo, txtEmail,txtTicketsRequest;
	
	private JButton btnEdit, btnExit;

	int counter=0;
	
	
	public UpdateRequest(ApplicantList list)
	{
		currList = list;
		
		
		lblTitle = new JLabel("Update Ticket Request",JLabel.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD,14));
		
		lblNameSearch = new JLabel("Enter the name you wish to update: ");
		lblNameSearch.setFont(new Font("Arial", Font.PLAIN,12));
		 
		lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblTelNo = new JLabel("Tel No: ");
		lblTelNo.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.PLAIN,12));
		
		
		lblTicketsReq = new JLabel("Tickets Request: ");
		lblTicketsReq.setFont(new Font("Arial", Font.PLAIN,12));
		
		txtNameSearch = new JTextField(10);
		
		txtName = new JTextField(10);
		
		txtTelNo = new JTextField(10);
		txtEmail = new JTextField(10);
		
		
		txtTicketsRequest = new JTextField(10);
	
		
		txtName.setEnabled(false);
		txtTelNo.setEnabled(false);
		txtEmail.setEnabled(false);
		txtName.setEnabled(false);
		txtTicketsRequest.setEnabled(false);
		
		btnEdit = new JButton("Edit Request");
		btnEdit.addActionListener(this);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this); 
		
		//1st Column
		getContentPane().setLayout(new GridBagLayout());
		
		addComp(lblTitle,0,0,4,1,1,2);
		
		addComp(lblNameSearch,0,1,1,1,1,1);
		
		addComp(lblName,0,3,1,1,1,1);
		
		addComp(lblTelNo,0,4,1,1,1,1);
		
		addComp(lblEmail,0,5,1,1,1,1);
		
		addComp(lblTicketsReq,0,8,1,1,1,1);
		
		addComp(btnEdit,0,9,1,1,1,1);
		
		//2nd Column		
		addComp(txtNameSearch,1,1,1,1,1,1);
		
		addComp(txtName,1,3,1,1,1,1);
		
		addComp(txtTelNo,1,4,1,1,1,1);
		
		addComp(txtEmail,1,5,1,1,1,1);
		
		
		addComp(txtTicketsRequest,1,8,1,1,1,1);
		
		addComp(btnExit,1,9,1,1,1,1);
		

		
	
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
		if(ev.getSource()==btnEdit)
		{
			
			TicketReq updateReq = currList.search(txtNameSearch.getText());
			
			if(counter ==0)
			{
				
				txtName.setEnabled(true);
				txtTelNo.setEnabled(true);
				txtEmail.setEnabled(true);
				txtTicketsRequest.setEnabled(true);
				
				btnEdit.setText("Save");
				
				JOptionPane.showMessageDialog(null, "You can begin to now update your request");	
				
				txtNameSearch.setEnabled(false);
				
				
				
				txtName.setText(updateReq.getName());
				txtTelNo.setText(updateReq.getTelNo());
				txtEmail.setText(updateReq.getEmail());
				txtTicketsRequest.setText(String.valueOf(updateReq.getNoTicketsRequested()));
			}	
			if(counter==1)
			{
				updateReq.setName(My.stringValName(txtName.getText()));
				updateReq.setTelNo(My.stringTelNo(txtTelNo.getText()));
				updateReq.setEmail(My.stringTelNo(txtEmail.getText()));
				updateReq.setNoTicketsRequested(My.intValTicket(Integer.parseInt(txtTicketsRequest.getText())));
				
				
				
				JOptionPane.showMessageDialog(null, "Request: " + txtNameSearch.getText() + " has been updated.");
			}
			
			counter++;
			
			
		}
		
		if(ev.getSource()==btnExit)
		{
			this.setVisible(false);
			
		}
		
	}
	
	
	
	
}
