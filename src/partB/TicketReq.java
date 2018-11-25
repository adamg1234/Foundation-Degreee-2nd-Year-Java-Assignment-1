package partB;

import partA.MyDate;
import partA.MyTime;

public class TicketReq 
{

	private String name, telNo, email;
	private MyDate dateOfRequest;
	private int loyaltyPoints, noTicketsRequested, noAllocated, priority;
	
	public TicketReq()
	{
		this.name="";
		this.telNo="";
		this.email="";
		this.dateOfRequest=new MyDate();
		this.loyaltyPoints=0;
		this.noTicketsRequested=0;
		this.noAllocated=0;
		this.priority=0;
		
	}
	
	public TicketReq(String name, String telNo, String email, MyDate dateOfRequest, int loyaltyPoints,
			int noTicketsRequested, int noAllocated,int priority)
			{
				this.name=name;
				this.telNo=telNo;
				this.email=email;
				this.dateOfRequest=dateOfRequest;
				this.loyaltyPoints=loyaltyPoints;
				this.noTicketsRequested=noTicketsRequested;
				this.noAllocated=noAllocated;
				this.priority=priority;
			}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MyDate getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(MyDate dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public int getNoTicketsRequested() {
		return noTicketsRequested;
	}

	public void setNoTicketsRequested(int noTicketsRequested) {
		this.noTicketsRequested = noTicketsRequested;
	}

	public int getNoAllocated() {
		return noAllocated;
	}

	public void setNoAllocated(int noAllocated) {
		this.noAllocated = noAllocated;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	
	public String toString() 
	{
		String out;
		out = String.format("%-10s  %-13s  %-17s  %-20s %15d %15d %5d\n", this.name,this.telNo,this.email,this.dateOfRequest.toShortDate(),this.loyaltyPoints,this.noTicketsRequested,this.noAllocated);
		return out;
	}
	
	
	
	
}
