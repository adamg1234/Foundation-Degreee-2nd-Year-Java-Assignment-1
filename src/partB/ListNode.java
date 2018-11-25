package partB;

public class ListNode 
{
	private TicketReq request;
	
	private ListNode link = null;

	public ListNode(TicketReq request) 
	{
		this.request = request;
		link = null;
	}

	public TicketReq getTiceketReq() 
	{
		return request;
	}

	public void setRequest(TicketReq request) {
		this.request = request;
	}

	public ListNode getLink() {
		return link;
	}

	public void setLink(ListNode link) {
		this.link = link;
	}
	
	

}
