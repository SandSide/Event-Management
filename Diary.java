import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


public class Diary {

	
	public LinkedList<Event> myEvents;
	
	
	public Diary() 
	{
		
		myEvents = new LinkedList<Event>();
		
	}
	
	

	public void findEvent(Date start, Date end) 
	{
		
		
		
		
	}
	
	
	public void addEvent() 
	{
		
		String startDate;
		String startTime;
		String endTime;
		String formatedDate;
		String desc;
		int capacity;
		
		Event E = new Event();
		
		Date date = null;
		
		
		Scanner S2 = new Scanner(System.in);
		
		System.out.print("Please enter the Event Date (dd/mm/yyyy): " );
		
		startDate = S2.nextLine();
		
		
		System.out.print("Please enter the Event Start Time (Hour:Minute): " );
		
		startTime = S2.nextLine();
		
		
		System.out.print("Please enter the Event End Time (Hour:Minute): " );
		
		endTime = S2.nextLine();
		
		
		System.out.println("Please enter description of the event: ");
		
		desc = S2.nextLine();
		
		System.out.println("Please enter the capacity for the event: ");
		
		capacity = S2.nextInt();
		
		
		String pattern = "dd/MM/yyyy kk:mm";
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		
	    try 
	    {
	    	
	    	formatedDate = (startDate + " " + startTime);
	    	E.setStartdate(format.parse(formatedDate));
	    	
	    	formatedDate = (startDate + " " + endTime);
	    	E.setEnddate(format.parse(formatedDate));
	    	
	    	E.setDesciption(desc);
	    	E.setCapacity(capacity);
	    	
	    	Date sd = E.getStartdate();
	    	
	    	System.out.println(format.format(sd));
	    	

	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }
	    
	    myEvents.add(E);
	    
	    
	    
	}
	
	
	/**
	* Main method
	* 
	* @param args N/A.
	*
	*/
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Diary D1 = new Diary();
		
		D1.addEvent();
		D1.addEvent();

	}
}
