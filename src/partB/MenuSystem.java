package partB;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;






public class MenuSystem extends JFrame implements ActionListener
{
	private ApplicantList list = new ApplicantList();
	 
	private static int counter =0;
	
	private JMenuBar jmb;
	
	private JMenu applicationsMenu,allocationMenu,exitMenu;

	private JMenuItem addReq,removeReq,updateReq,displayAll,allocateTick,confirmedList,
	exitSystem;
	
	private AddRequest add;
	
	DisplayRequest display;
	
	RemoveRequest remove;
	
	UpdateRequest update;
	
	AllocateRequest allocate;
	
	public MenuSystem()
	{
		JPanel imagePanel  = new JPanel()
		{
		
		
	
		public void paint(Graphics g)
		{
			try
			{
				BufferedImage image = ImageIO.read(new File("Open.jpg"));
				g.drawImage(image, 1, 1,null);
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			
		}
	
		
	};
		imagePanel.setPreferredSize(new Dimension(990,660));
		getContentPane().add(imagePanel);
		
		add= new AddRequest(list);
		display = new DisplayRequest(list);
		remove = new RemoveRequest(list);
		update = new UpdateRequest(list);
		allocate = new AllocateRequest(list);

		
		jmb = new JMenuBar();		
		setJMenuBar(jmb);	
		
		applicationsMenu = new JMenu("Applications");
		
		addReq = new JMenuItem("Add Request");
		addReq.addActionListener(this);
		
		removeReq = new JMenuItem("Remove Request");
		removeReq.addActionListener(this);
		
		updateReq = new JMenuItem("Update Request");
		updateReq.addActionListener(this);
		
		displayAll = new JMenuItem("Display All Requests");
		displayAll.addActionListener(this);
		
		
		allocationMenu = new JMenu("Allocation");
		allocateTick = new JMenuItem("Allocate Tickets");
		allocateTick.addActionListener(this);
		
		confirmedList = new JMenuItem("Confirmed List");
		confirmedList.addActionListener(this);
		
		exitMenu = new JMenu("Exit");
		
		exitSystem = new JMenuItem("Exit System");
		exitSystem.addActionListener(this);
		
		
		applicationsMenu.add(addReq);
		applicationsMenu.add(removeReq);
		applicationsMenu.add(updateReq);
		applicationsMenu.add(displayAll);
		
		allocationMenu.add(allocateTick);
		allocationMenu.add(confirmedList);
		
		exitMenu.add(exitSystem);
		
		jmb.add(applicationsMenu);
		jmb.add(allocationMenu);
		jmb.add(exitMenu);

		
	}
	

	public static void main(String[] args) 
	{
		MenuSystem frm = new MenuSystem();
		frm.setSize(610,400);
		frm.setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(ev.getSource()==addReq)
		{
			add.setTitle("Add Request");
			add.setSize(500,450);
			add.setLocation(100,100);
			add.setVisible(true);
			
		}
		
		if(ev.getSource()==displayAll)
		{
			display.setTitle("Display Request");
			display.setSize(700,450);
			display.setLocation(100,100);
			display.setVisible(true);
			
		}
		
		if(ev.getSource()==removeReq)
		{
			remove.setTitle("Remove Request");
			remove.setSize(700,450);
			remove.setLocation(100,100);
			remove.setVisible(true);
			
		}
		
		if(ev.getSource()==updateReq)
		{
			update.setTitle("Update Request");
			update.setSize(700,450);
			update.setLocation(100,100);
			update.setVisible(true);
			
		}
		
		if(ev.getSource()==allocateTick)
		{
			allocate.setTitle("Allocate Request");
			allocate.setSize(700,450);
			allocate.setLocation(100,100);
			allocate.setVisible(true);
			
		}
		
		if(ev.getSource()==confirmedList)
		{
			try
			{
				// write to file
				FileWriter inFile = new FileWriter("Allocated_List.txt");
				PrintWriter in = new PrintWriter(inFile);
						
				in.println("\r\n\t\t\tA L L O C A T E D  L I S T \n");
				in.println("\t\t\t------------------------------------\n");
						
				in.println("");
				in.println("Name:	     Tel No:      Email:	    Date Requested:  		Points:        No Requested:  No Allocated:");
				in.println("----------------------------------------------------------------------------------------------------------------------------");
				
				in.println(list.display());
						
				JOptionPane.showMessageDialog(null, "Printed");
						
				in.close();
			}
			catch(IOException ex2)
			{
				JOptionPane.showMessageDialog(null, "Cannot Open File");
			}

		}
	}

}
