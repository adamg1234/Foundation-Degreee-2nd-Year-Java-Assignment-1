package partB;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




public class DisplayRequest extends JFrame implements ActionListener
{

	private ApplicantList list;

	private ApplicantList currList = new ApplicantList();

	private JTextArea txtArea;
	
	private JButton btnExit, btnDisplay;
	
	private JScrollPane spScroller;
	
	private Container cPane;
	
	private int counter=0;

	public DisplayRequest(ApplicantList list)
	{
	
		currList = list;
		
		txtArea = new JTextArea(40,40);
		
		spScroller = new JScrollPane(txtArea);
		
		btnDisplay = new JButton("Display & Allocate");
		btnDisplay.addActionListener(this); 
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		
		
		getContentPane().setLayout(new GridBagLayout());
		
		addComp(spScroller,0,0,2,1,20,20);
		
		addComp(btnDisplay,0,1,1,1,1,1);
		
		addComp(btnExit,1,1,1,1,1,1);
		
		txtArea.setText("Name\t" + "Tel No\t" + "Email\t" + "                    Date of Request        " + "Loyalty Points\t" + "No tickets requested\n"
				+ "_________________________________________________________________________________________________________\n");
				
		
		
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
		if(ev.getSource()==btnDisplay)
		{
			
			txtArea.append(currList.display());
			
			
			
		}
		
	}
}