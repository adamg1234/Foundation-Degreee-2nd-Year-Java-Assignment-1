package partA;

public class Order 
{
	
	private int orderNo;
	private MyTime timePurchase;
	private MyDate datePurchased;
	private int noItems;
	private double totalPrice;
	
	public Order()
	{
		this.orderNo=0;
		this.timePurchase= new MyTime();
		this.datePurchased= new MyDate();
		this.noItems=0;
		this.totalPrice= 0;
	}
	
	public Order(int orderNo, MyTime timePurchase, MyDate datePurchased, int noItems,
	double totalPrice)
	{
		this.orderNo=orderNo;
		this.timePurchase=timePurchase;
		this.datePurchased= datePurchased;
		this.noItems= noItems;
		this.totalPrice= totalPrice;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public MyTime getTimePurchase() {
		return timePurchase;
	}

	public void setTimePurchase(MyTime timePurchase) {
		this.timePurchase = timePurchase;
	}

	public MyDate getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(MyDate datePurchased) {
		this.datePurchased = datePurchased;
	}

	public int getNoItems() {
		return noItems;
	}

	public void setNoItems(int noItems) {
		this.noItems = noItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		String out;
		out = String.format("%4d  %-10s  %-10s  %-2d  %-.2f\n", this.orderNo,this.timePurchase.toTime(),this.datePurchased.toShortDate(),
		this.noItems,this.totalPrice);
		return out;
	}
	
	
	

}
