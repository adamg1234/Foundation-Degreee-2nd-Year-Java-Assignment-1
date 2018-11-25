
package partA;

public class MyTime {
	private int hrs,mins,secs;
	
	public MyTime()
	{
		this.hrs =0; this.mins=0;this.secs=0;
	}
	public MyTime(int hrs, int mins,int secs)
	{
		this.hrs =hrs; this.mins=mins;this.secs=secs;
	}
	public int getHrs() {
		return hrs;
	}
	public void setHrs(int hrs) {
		this.hrs = hrs;
	}
	public int getMins() {
		return mins;
	}
	public void setMins(int mins) {
		this.mins = mins;
	}
	public int getSecs() {
		return secs;
	}
	public void setSecs(int secs) {
		this.secs = secs;
	}
	
	public String toTime()
	{
		return String.format("%2d:%2d", this.hrs,this.mins);
	}
}