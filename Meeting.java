import java.util.Date;

/**
 * AC12001 Group Assignment.
 * 
 * @author Patryk Jakubek
 * Class to store meeting details.
 * Allows one to set/get the fields.
 *	   
 * @version v1.0
 */
public class Meeting {

	// Fields to store Meeting information.
	private Date startdate;
	private Date enddate;
	private String desciption;
	private int capacity;
	
	
	/**
     * Getter method for StartDate.
     *
     * @return Date for the start of the meeting.
     * 
     */
	public Date getStartDate() 
	{
		
		return startdate;
		
	}
	
	
	/**
     * Setter method for StartDate.
     *
     * @param startdate The newstart date for the meeting.
     * 
     */
	public void setStartDate(Date startdate)
	{
		
		this.startdate = startdate;
		
	}
	
	
	/**
     * Getter method for EndDate.
     *
     * @return Date for the end of the meeting.
     * 
     */
	public Date getEndDate() 
	{
		
		return enddate;
		
	}
	
	
	/**
     * Setter method for EndDate.
     *
     * @param enddate The new end date for the meeting.
     * 
     */
	public void setEndDate(Date enddate) 
	{
		
		this.enddate = enddate;
		
	}
	
	
	/**
     * Getter method for Description.
     *
     * @return Description of the meeting..
     * 
     */
	public String getDescription() 
	{
		
		return desciption;
		
	}
	
	
	/**
     * Setter method for Description.
     *
     * @param sescription The new Description for the meeting.
     * 
     */
	public void setDescription(String desciption) 
	{
		
		this.desciption = desciption;
		
	}
	
	
	/**
     * Getter method for Capacity.
     *
     * @return Capacity of the meeting.
     * 
     */
	public int getCapacity() 
	{
		
		return capacity;
		
	}
	
	
	/**
     * Setter method for Capacity.
     *
     * @param capacity The new capacity for the meeting.
     * 
     */
	public void setCapacity(int capacity) 
	{
		
		this.capacity = capacity;
		
	}
	
}
