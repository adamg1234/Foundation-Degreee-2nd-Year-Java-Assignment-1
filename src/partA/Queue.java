package partA;


public class Queue 
{

private ListNode front,rear;
	
	public Queue()
	{
		front = null;
	}
	
	public void join(Meal meal)
	{
		ListNode current = new ListNode(meal);
		
		if(front==null)
		{
			rear = current;
			front = current;
			
		}
		else
		{
			rear.setLink(current);
			rear=current;
		}
	}
	
	public void leave()
	{
		if(front !=null)
		{
			ListNode current = front;
			front=front.getLink();
			current =null;
		}
		
	}
	
	public Meal peek()
	{
		return front.getMeal();

	}
	
	public String display()
	{
		String stDisplay = "";
		ListNode current = front;
		
		while(current != null)
		{
			stDisplay += current.getMeal().toString() + "\n";
			current = current.getLink();
			
		}
		
		return stDisplay;
			
	}
	

	
	public boolean empty()
	{
		if(front == null)
			return true;
		else
			return false;
		
	}
	
	
	
	
	
}
