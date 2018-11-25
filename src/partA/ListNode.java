package partA;

public class ListNode 
{
	private Meal meal;
	
	private ListNode link = null;

	public ListNode(Meal meal) 
	{
		this.meal = meal;
		link = null;
	}

	public Meal getMeal() 
	{
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public ListNode getLink() {
		return link;
	}

	public void setLink(ListNode link) {
		this.link = link;
	}
	
	

}
