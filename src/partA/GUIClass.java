package partA;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;






public class GUIClass extends JFrame implements ActionListener 
{
	Queue myQueue = new Queue();
	
	
	private JLabel lblTitle, lblburgerType,lblMeal,lblMealType,lblDrink,lblOrder,lblMealsOrdered;
	
	private JButton btnAdd, btnRemove, btnTotal;
	
	private JComboBox cboBurger,cboDrink;

	private JRadioButton rbYes, rbNo, rbRegular,rbLarge,rbSupersize;
	
	private JTextArea txtMeals,txtOrders;
	
	private JScrollPane spScroller;
	
	private double burgerPrice=0,mealPrice=0,totalPrice=0;
	
	private int noOfItems=0;
	
	int counter=1000;
	
	public GUIClass()
	{
	
		String txt = "";

		
		//Populating ComboBox
		String[] burgers = {"Barbecue Bacon Cheddar", "Philly Cheese Steak", "Cheesy Bacon",
		"Smokehouse Smoky Barbecue", "Big Kahuna Hawaiian", "Spicy Buffalo Chicken"};
		
		String[] drinks = {"Coke", "Sprite","Fanta","Water"};
	
		lblTitle = new JLabel("Gourmet Burgers",JLabel.LEFT);
		lblTitle.setFont(new Font("Arial", Font.BOLD,14));
	
		lblburgerType = new JLabel("Burger Type: ");
		lblburgerType.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblMeal = new JLabel("Part of Meal: ");
		lblMeal.setFont(new Font("Arial", Font.PLAIN,12));
	
		lblMealType = new JLabel("Meal Type: ");
		lblMealType.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblDrink = new JLabel("Drink Type: ");
		lblDrink.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblOrder = new JLabel("Order ");
		lblOrder.setFont(new Font("Arial", Font.PLAIN,12)); 
		
		txtOrders = new JTextArea(20,20);
		
		spScroller = new JScrollPane(txtOrders);
		
		cboBurger = new JComboBox(burgers);
		
		rbYes = new JRadioButton("Yes");
		rbNo = new JRadioButton("No");

		ButtonGroup bgMeal = new ButtonGroup();
		bgMeal.add(rbYes);
		bgMeal.add(rbNo);
		
		rbYes.addActionListener(this);
		rbNo.addActionListener(this);
		
		Box boxMeal = new Box(1);
		boxMeal = Box.createHorizontalBox();
		boxMeal.add(rbYes);
		boxMeal.add(rbNo);
		
		rbRegular = new JRadioButton("Regular");
		rbSupersize = new JRadioButton("Supersize");
		rbLarge = new JRadioButton("Large");
		
		ButtonGroup bgMealType = new ButtonGroup();
		bgMealType.add(rbRegular);
		bgMealType.add(rbLarge);
		bgMealType.add(rbSupersize);
		
		rbRegular.addActionListener(this);
		rbLarge.addActionListener(this);
		rbSupersize.addActionListener(this);
		
		Box boxMealType = new Box(1);
		boxMealType = Box.createHorizontalBox();
		boxMealType.add(rbRegular);
		boxMealType.add(rbLarge);
		boxMealType.add(rbSupersize);
		
		rbRegular.setEnabled(false);
		
		rbLarge.setEnabled(false);
		rbSupersize.setEnabled(false);
		cboDrink = new JComboBox(drinks);
		
		cboDrink.setEnabled(false);
		
		lblMealsOrdered = new JLabel("Meals Ordered: ");
		lblMealsOrdered.setFont(new Font("Arial", Font.BOLD,12)); 
		
		txtMeals = new JTextArea(20,20);
		
		btnAdd = new JButton("Add Item");
		btnAdd.addActionListener(this);
		
		btnRemove = new JButton("Remove Item");
		btnRemove.addActionListener(this);
		
		btnTotal = new JButton("Total Order");
		btnTotal.addActionListener(this);
		
		
		//1st column
		getContentPane().setLayout(new GridBagLayout());
		
		addComp(lblTitle,0,0,1,1,1,1);
		
		addComp(lblburgerType,0,1,1,1,1,1);
		
		addComp(lblMeal,0,2,1,1,1,1);
		
		addComp(boxMeal,0,3,1,1,1,1);
		
		addComp(lblMealType,0,4,1,1,1,1);
		
		addComp(boxMealType,0,5,2,1,1,1);
		
		addComp(lblDrink,0,6,1,1,1,1);
		
		addComp(btnAdd,0,7,1,1,1,1);
		
		addComp(lblOrder,0,8,1,1,1,1);
		
		addComp(spScroller,0,9,10,3,1,1);
		
		
		
		//2nd Column
		addComp(cboBurger,1,1,1,1,1,1);
		
		addComp(cboDrink,1,6,1,1,1,1);
		
		addComp(btnRemove,1,7,1,1,1,1);
		
		//3rd Column
		addComp(lblMealsOrdered,2,0,3,1,1,1);
		
		addComp(txtMeals,2,1,5,5,1,1);
		
		addComp(btnTotal,2,7,1,1,1,1);
		
		try
		{
			
			
			
			File in = new File("Orders.dat");
			RandomAccessFile rd = new RandomAccessFile(in, "rw");
			boolean eof=false;
			
			txtOrders.setText("OrderNo\t" + "Date Purchased\t" + "Time Purchased\t" + "Meals Ordered\t\t" + "Total Price\n"
			+ "_________________________________________________________________________________________________________\n");
			
			if(rd.length() > 0)
			{
				do
				{
					try
					{
						txtOrders.append(rd.readInt()+"\t" + rd.readUTF()+"\t\t" + rd.readUTF()+"\t\t"+rd.readInt()
						+"\t\t£" + rd.readDouble()+"\n");
						
						counter++;
						
					}
					catch(EOFException ex)
					{
						eof = true;
					}
					
				}while(!eof);
				rd.close();
					
			}
		}
		catch(FileNotFoundException fEx)
		{
			JOptionPane.showMessageDialog(null, "The order file could not be found");
		}
		
		catch(IOException ioEx)
		{
			JOptionPane.showMessageDialog(null, "There was a problem with the file");
		}
		
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

	public static void main(String[] args) 
	{

		GUIClass frm = new GUIClass();
		frm.setSize(650,500);
		frm.setVisible(true);
		

	}


	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource()==rbYes)
		{
			cboDrink.setEnabled(true);
			rbRegular.setEnabled(true);
			rbLarge.setEnabled(true);
			rbSupersize.setEnabled(true);
			

		}
		
		if(ev.getSource()==rbNo)
		{
			cboDrink.setEnabled(false);
			rbRegular.setEnabled(false);
			rbLarge.setEnabled(false);
			rbSupersize.setEnabled(false);
			
		}
		if(ev.getSource()==rbRegular)
		{

			mealPrice=1.00;
		}
		
		if(ev.getSource()==rbLarge)
		{

			mealPrice=2.00;
		}
		if(ev.getSource()==rbSupersize)
		{

			mealPrice=3.50;
		}
		
		if(ev.getSource()==btnAdd)
		{
			Meal mealOrder = new Meal();
			
			mealOrder.setBurger(cboBurger.getSelectedItem().toString());
			
			if(cboBurger.getSelectedItem()=="Barbecue Bacon Cheddar")
			{
				burgerPrice=2.25;
			}
			if(cboBurger.getSelectedItem()=="Philly Cheese Steak")
			{
				burgerPrice=3.00;
			}
			if(cboBurger.getSelectedItem()=="Cheesy Bacon")
			{
				burgerPrice=2.00;
			}
			if(cboBurger.getSelectedItem()=="Smokehouse Smoky Barbecue")
			{
				burgerPrice=3.25;
			}
			if(cboBurger.getSelectedItem()== "Big Kahuna Hawaiian")
			{
				burgerPrice=3.75;
			}
			if(cboBurger.getSelectedItem()== "Spicy Buffalo Chicken")
			{
				burgerPrice=4.00;
			}
	
			
			if(rbYes.isSelected()==true)
			{
				mealOrder.setMeal(rbYes.getText());
				mealOrder.setDrink(cboDrink.getSelectedItem().toString());
				noOfItems++;
				if(rbRegular.isSelected()==true)
				{
					mealOrder.setMeal(rbRegular.getText());
				}
				
				else if(rbLarge.isSelected()==true)
				{
					mealOrder.setMeal(rbLarge.getText());
				}
				
				else if(rbSupersize.isSelected()==true)
				{
					mealOrder.setMeal(rbSupersize.getText());
				}
				
			}			
			if(rbNo.isSelected()==true)
			{
				mealOrder.setMeal(rbNo.getText()+" meal");
				
				mealOrder.setDrink("No Drink");
				
				if(rbRegular.isSelected()==true)
				{
					mealOrder.setMeal("No meal");
				}
				
				else if(rbLarge.isSelected()==true)
				{
					mealOrder.setMeal("No meal");
				}
				
				else if(rbSupersize.isSelected()==true)
				{
					mealOrder.setMeal("No meal");
				}
				
			}
			
			myQueue.join(mealOrder);		
			txtMeals.setText(myQueue.display());
			noOfItems++;
			totalPrice+=(burgerPrice+mealPrice);

		}
		
		if(ev.getSource()==btnRemove)
		{
			if(myQueue.empty() == false)
			{
				
				txtMeals.setText("");
				myQueue.leave();
				txtMeals.setText(myQueue.display());
			}
			else
				JOptionPane.showMessageDialog(null,"No meals left");
		}
		
		if(ev.getSource()==btnTotal)
		{
			
			MyDate newdatePurchased = new MyDate(0,0,0);
			MyTime newtimePurchased = new MyTime(0,0,0);
			
			LocalDateTime ldt = LocalDateTime.now(); 

			
			int hour = ldt.getHour();
			int minute = ldt.getMinute();
			int seconds = ldt.getSecond();
			
			int day = ldt.getDayOfMonth();
			int month = ldt.getMonthValue();
			int year=ldt.getYear();
			
			
			Order newOrder = new Order();
			
			newtimePurchased.setHrs(hour);
			newtimePurchased.setMins(minute);
			newtimePurchased.setSecs(seconds);
			
			newdatePurchased.setDay(day);
			newdatePurchased.setMonth(month);
			newdatePurchased.setYear(year);
			
			
			newOrder.setOrderNo(counter);	
			newOrder.setDatePurchased(newdatePurchased);
			newOrder.setTimePurchase(newtimePurchased);
			newOrder.setNoItems(noOfItems);
			newOrder.setTotalPrice(totalPrice);
			
			try{
				
				File out = new File("Orders.dat");
				RandomAccessFile rd = new RandomAccessFile(out,"rw");
				
				
				if(out.exists())
				{
					rd.seek(rd.length());
					
				
					
					rd.writeInt(newOrder.getOrderNo());
					rd.writeUTF(newOrder.getDatePurchased().toShortDate());
					rd.writeUTF(newOrder.getTimePurchase().toTime());
					rd.writeInt(newOrder.getNoItems());
					rd.writeDouble(newOrder.getTotalPrice());
				}

					
					rd.close();
					
			}
			catch(IOException ex)
			{
				System.out.print("\n\n\t Unable to save data");
			}
		
			counter++;
			
			JOptionPane.showMessageDialog(null, "Thank you for completing your order. Please order from us again soon");
			System.exit(0);
			
		}
	}

}
