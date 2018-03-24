import java.util.Date;

public class Meeting {

	private Date startdate;
	private Date enddate;
	private String Description;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
	
}
