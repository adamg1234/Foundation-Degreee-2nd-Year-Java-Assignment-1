package partB;



import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class My 
{
	static Scanner key = new Scanner(System.in);
	static Scanner key2 = new Scanner(System.in);
	public static void p(String s)
	{
		
		System.out.print(s);
		
	}
	
	public static int intValTicket (int ticket)
	{
		
		int value=0;
		
		do
		{
			value= ticket;
			
			if(value > 4)
			{
				
				JOptionPane.showMessageDialog(null, "You can oly order 4 ticekets or less");
				break;
				
			}
			
		}while(value > 4);
		
		return value;
		
	}
	
	public static int intVal (int years)
	{
		
		int value=0;
		
		do
		{
			value= years;
			
			if(value > 20)
			{
				
				JOptionPane.showMessageDialog(null, "The years entered must be less than or equal to 20");
				break;
				
			}
			
		}while(value > 20);
		
		return value;
		
	}
	
	public static double doubleVal (double min, double max)
	{
		
		double value=0;
		while(value < min || value > max)
		{
			value= key.nextDouble();
			
			if(value < min || value > max)
			{
	
				JOptionPane.showMessageDialog(null, "You value must be between " +min + " & " + max+". Please re-enter");
			}
		}
		
		return value;
		
	}
	
	public static String stringValName (String text)
	{
		
		String value=" ";

		
		do
		{
			value= text;
			
			if(value.length() < 7)
			{
				
				JOptionPane.showMessageDialog(null, "The name must be more than 7 characters");
				text="";
				break;
				
			}
			
		}while(value.length() < 7);
		
		return value;
	}
	
	public static String stringTelNo (String text)
	{
		
		String value=" ";

		
		do
		{
			value= text;
			
			if(value.length() < 6)
			{
				
				JOptionPane.showMessageDialog(null, "This must be more than 6 digits");
				text="";
				break;
				
			}
			
		}while(value.length() < 6);
		
		return value;
	}
	
	
}
