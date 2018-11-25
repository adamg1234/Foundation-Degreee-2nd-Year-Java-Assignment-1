package partA;

public class Meal
{
private String burger, meal, mealType,drink;
	
	public Meal()
	{
		this.burger="";
		this.meal="";
		this.mealType= "";
		this.drink= "";
	}
	
	public Meal(String burger, String meal, String mealType, String drink)
	{
		this.burger=burger;
		this.meal=meal;
		this.mealType= mealType;
		this.drink= drink;
	}

	public String getBurger() {
		return burger;
	}

	public void setBurger(String burger) {
		this.burger = burger;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	@Override
	public String toString()
	{
		String out;
		out = String.format("%25s  %-10s  %-10s  %-10s\n", this.burger,this.meal,this.mealType,this.drink);
		return out;
	
	}

	
	
	
}
