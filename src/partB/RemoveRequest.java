package partB;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RemoveRequest extends JFrame implements ActionListener
{
	private ApplicantList list;
	
	public ApplicantList currList = new ApplicantList();

	DisplayRequest display;
	
	private JLabel lblTitle,lblName;
	
	private JTextField txtName;
	
	private JButton btnRemove, btnReset, btnExit;

	public RemoveRequest(ApplicantList list)
	{
		currList = list;
		
		lblTitle = new JLabel("Remove Ticket Request",JLabel.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD,14));
		
		lblName = new JLabel("Name you wish to remove: ");
		lblName.setFont(new Font("Arial", Font.PLAIN,12));
		
		txtName = new JTextField(10);
		
		btnRemove = new JButton("Remove Request");
		btnRemove.addActionListener(this);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this); 
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this); 
		
		
		
		//1st Column
		getContentPane().setLayout(new GridBagLayout());
		
		addComp(lblTitle,0,0,4,1,1,2);
		
		addComp(lblName,0,1,1,1,1,1);
		
		addComp(btnRemove,0,7,1,1,1,1);
		
		//2nd Column
		addComp(txtName,1,1,1,1,1,1);
		
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
		if(ev.getSource()==btnRemove)
		{
			
			if(currList.empty() == false)
			{
				currList.remove(txtName.toString());
			} 
			else
				JOptionPane.showMessageDialog(null,"The list is empty");
			
		}
		if(ev.getSource()== btnReset)
		{
			txtName.setText("");
		}
		
		if(ev.getSource()==btnExit)
		{
			this.setVisible(false);
		}
		
	}
	
	
}
