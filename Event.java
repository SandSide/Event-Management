import java.util.Date;

public class Event {

	private Date startdate;
	private Date enddate;
	private String desciption;
	private int capacity;
	
	
	public Date getStartDate() 
	{
		
		return startdate;
		
	}
	
	public void setStartDate(Date startdate)
	{
		
		this.startdate = startdate;
		
	}
	
	
	public Date getEndDate() 
	{
		
		return enddate;
		
	}
	
	public void setEndDate(Date enddate) {
		this.enddate = enddate;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
	
}
