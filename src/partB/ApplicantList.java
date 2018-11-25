package partB;



public class ApplicantList
{
	ListNode start=null;
	ListNode end=null;
	
	
	
	
	// Contructor creates two list node ssetting them to null
	ApplicantList()
	{
		start=null;
		end=null;
	}
	
	public void add (TicketReq request)
	{
		//Create a new listnode and pass in the data you want to store
		ListNode next = new ListNode(request);
		
		
		// if there is nothing in it make the new mode the start and end
		if(empty()==true) // or start == null
		{
			start=next;
			end=next;
			
		}
		else
		{
			// if the new number is smaller than the start put it first and
			// link it to the one that used to be first
			if(request.getPriority()<start.getTiceketReq().getPriority())
				{
					next.setLink(start); //puts it first
					start=next;
				}
			else
			{
				// if the new number is bigger than the end put it last and
				// link to the one that was used first
				if(request.getPriority()>end.getTiceketReq().getPriority())
				{
					end.setLink(next);
					end=next;
				}
				else // must be somewhere in the middle				
				{
					// create a pair of list node to remember the position
					// as we loop through the list
					ListNode prev;
					ListNode curr;
					prev=start; // prev refers to the first item
					curr=start.getLink(); // curr refers to the second
					
					// while new num is bigger than the current keep going
					while(curr.getTiceketReq().getPriority()<next.getTiceketReq().getPriority() && curr!=null)
					{
						prev=curr;
						curr=curr.getLink();
					}
					// puts the new num in between prev and curr
					prev.setLink(next);
					next.setLink(curr);
					
				}
			}
			
		}
		
	}
	
	public boolean remove (String name)
	{
		ListNode prev;
		ListNode curr=start;
		boolean removed=false;
		
		// checks if the number we want to remove is the first one
		if(curr.getTiceketReq().getName().compareTo(name)==0)
		{
			// set the start to be the item the first item pointed to
			start= start.getLink();
			curr=null;	// remove the first item
			removed=true;
		}
		else // goes to the middle
		{
			prev = start;		// prev refers to the first item
			curr=start.getLink(); // curr refers to the second
			
			// keep moving through the list while we haven't found the
			// number and we have got to the end of the list
			do
			{
				prev=curr;
				curr=curr.getLink();
			}while(curr.getTiceketReq().getName().compareTo(name)!=0 && curr !=null);
			
			// if we didn't get to the end of the list remove the one
			// we are on by setting the link of the previous to the next
			if(curr !=null)
			{
				prev.setLink(curr.getLink());
				removed=true;
			}
		}
		return removed;
	}
	
	
	public String display()
	{
		String s = "";
		ListNode current = start;
		
		while(current != null)
		{
			s += current.getTiceketReq().toString() + "\n";
			current = current.getLink();
			
		}
		
		return s;
			
	}
	
	public void allocate(int totalTickets)
	{
		ListNode current = start;
		
		while(current != null)
		{
			TicketReq tr = current.getTiceketReq();
			
			if(tr.getNoTicketsRequested()<=totalTickets)
			{
				tr.setNoAllocated(tr.getNoTicketsRequested());
				totalTickets-= tr.getNoAllocated();
			}
			else
			{
					if(tr.getNoTicketsRequested()>0)
					tr.setNoAllocated(totalTickets);
					totalTickets=0;
			}
			current = current.getLink();
		}
		
	}
	
	
	public boolean empty()
	{
		if(start == null)
			return true;
		else
			return false;
		
	}
	
	public TicketReq search(String name)
	{
		ListNode current = start;
		
		while(current != null)
		{
			
			if (current.getTiceketReq().getName().compareTo(name)==0)
			{
				return current.getTiceketReq();
			}
			else
			{
				current = current.getLink();
			}
		
		}
		return null;
		
		
	}
	
	
	
}
