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
	
	

	public Event findEvent() 
	{
		
		
		return myEvents.getFirst();
		
	}
	
	public void addToEvent() 
	{
		
		String date;
		String startTime;
		String endTime;
		String formatedDate;
		int capacity;
		String desc;
		
		Scanner S2 = new Scanner(System.in);
		
		System.out.print("Please enter the Event Date (dd/mm/yyyy): " );
		
		date = S2.nextLine();
		
		System.out.print("Please enter the Event Start Time (Hour:Minute): " );
		
		startTime = S2.nextLine();
		
		
		System.out.print("Please enter the Event End Time (Hour:Minute): " );
		
		endTime = S2.nextLine();
		
		
		System.out.println("Please enter description of the event: ");
		
		desc = S2.nextLine();
		
		System.out.println("Please enter the capacity for the event: ");
		
		capacity = S2.nextInt();
		
		this.addEvent(date, startTime, endTime, desc, capacity);
		
	}
	
	
	public void addEvent(String day, String start, String end, String description, int cap) 
	{
		
		String startDate = day;
		String startTime = start;
		String endTime = end;;
		String formatedDate;
		String desc = description;
		int capacity = cap;
		
		Event E = new Event();
		
		Date date = null;
		
		
		String pattern = "dd/MM/yyyy kk:mm";
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		
	    try 
	    {
	    	
	    	formatedDate = (startDate + " " + startTime);
	    	E.setStartDate(format.parse(formatedDate));
	    	
	    	formatedDate = (startDate + " " + endTime);
	    	E.setEndDate(format.parse(formatedDate));
	    	
	    	E.setDesciption(desc);
	    	E.setCapacity(capacity);
	    	
	    	Date sd = E.getStartDate();
	    	
	    	System.out.println(format.format(sd));
	    	

	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }
	    
	    myEvents.add(E);
	    
	    
	    
	}
	
	/**
	* lineBreak
	* Displays a a dotted line.
	*
	*/
	public void lineBreak() {
		
		//Displays "---------------------------------------------------------------".
		System.out.print("---------------------------------------------------------------");
	}
	
	
	/**
	* displayMenu
	* Displays available choices.
	*
	*/
	public void displayMenu()
	{
		
		//Displays Choice Options.
		System.out.println("Please select what you want to edit.");
		System.out.println();
		System.out.println("1: Date.");
		System.out.println("2: Start Time.");
		System.out.println("3: End Time.");
		System.out.println("4: Desciption.");
		System.out.println("5: Capacity.");
		System.out.println("0: Exit.");
		System.out.println("");
		System.out.print("Enter: ");
	
	}
	
	
	public void editEvent() 
	{
		
		//Initialises variables
		int choice = 0;
			 
		try {
			
			//Does a do while loop.
			do{
				
				//Calls displayMenu method.
				this.displayMenu();
			
				//Creates an instance of a scanner, which records next int value entered.
				Scanner s1 = new Scanner(System.in);
				
				choice = s1.nextInt();
			
				//Checks the value of choice and does something based on that value.
				switch (choice)
				{
						
					//If choice = 1 then it calls method testAutomated().
					//Calls lineBreak method.
					case 1:
						automatedRun();
						lineBreak();
						break;
						
					//If choice = 2 then it calls method singlePlayer().
					//Calls lineBreak method.
					case 2:
						singlePlayer();
						lineBreak();
						break;
		
					//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 3:
						multiplayer();
						lineBreak();
						break;
								
					//If choice = 0 then displays exit message.
					//Calls lineBreak method.
					case 0:
						System.out.println("Stopping Program.");
						lineBreak();
						break;
							
					//If it does not meet the previous cases, it displays that the choice does not exist.
					//Calls lineBreak method.
					default:
						System.out.println("The Choice [" + choice + "] does not exist.");
						lineBreak();
						break;
				}
					
				System.out.println();
					
			} 
			
			//Continuous the loop when choice does not equal to 0
			while(choice != 0);	
			
		}
			
		//If can try.
		catch(Exception e)
		{
				
			//Displays error message.
			System.out.println();
			System.out.println("Invalid Input.");

				
		}

	}
	
	
	public void editDate(Event node) 
	{
		
		String newDate;
		String startTime;
		String endTime;
		
		Scanner S3 = new Scanner(System.in);
		
		
		System.out.println();
		System.out.print("Please enter new Date(dd/MM/yyyy): ");
		
		newDate = S3.nextLine();
		
		String formatedDate;	
		
	    try 
	    {
	    		
	    	String pattern = "kk:mm";
	    	
	    	SimpleDateFormat format = new SimpleDateFormat(pattern);
			
	    	startTime = format.format(node.getStartDate());
	    	endTime = format.format(node.getEndDate());
	    	
	    	System.out.println(startTime);
	    	System.out.println(endTime);
	    	
	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	
	    	formatedDate = (newDate + " " + startTime);
	    	node.setStartDate(format.parse(formatedDate));
	    	
	    	
	    	formatedDate = (newDate + " " + endTime);
	    	
	    	node.setEndDate(format.parse(formatedDate));
	    		

	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }	
	    
	    
	    System.out.println(node.getStartDate());
	    System.out.println(node.getEndDate());
	    
	}
	
	
	public void editStartTime(Event node)
	{
		
		String Date;
		String startTime;
		
		Scanner S4 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter new start time (hour:minute): ");
		
		startTime = S4.nextLine();
		
		String formatedDate;	
		
	    try 
	    {
	    		
	    	String pattern = "dd/MM/yyyy";
	    	
	    	SimpleDateFormat format = new SimpleDateFormat(pattern);
			
	    	Date = format.format(node.getStartDate());
	    	
	    	
	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	
	    	formatedDate = (Date + " " + startTime);
	    	
	    	System.out.println(formatedDate);
	    	node.setStartDate(format.parse(formatedDate));
	    	
	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }
	    
	    System.out.print(node.getStartDate());
		
	}
	
	
	public void editEndTime(Event node)
	{
		
		String Date;
		String endTime;
		
		int num1;
		int num2;
		boolean valid = false;
		
		Scanner S5 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter new hour: ");

		endTime = S5.nextLine();

		String formatedDate;	
		
	    try 
	    {
	    		
	    	String pattern = "dd/MM/yyyy";
	    	
	    	SimpleDateFormat format = new SimpleDateFormat(pattern);
			
	    	Date = format.format(node.getEndDate());
	    	
	    	
	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	
	    	formatedDate = (Date + " " + endTime);
	    	
	    	System.out.println(formatedDate);
	    	node.setStartDate(format.parse(formatedDate));
	    	
	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }
		
	    System.out.print(node.getEndDate());
	    
	}
	
	
	public void editDesc(Event node) 
	{
		
		Scanner S6 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter new description: ");
		
		String newDesc = S6.nextLine();
		
		node.setDesciption(newDesc);
		
		System.out.print(node.getDesciption());
		
	}
	
	
	public void editCap(Event node) 
	{
		
		Scanner S7 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter new capacity: ");
		
		int newCap = S7.nextInt();
		
		while(newCap < 1) 
		{
			
			System.out.println();
			System.out.print("Can't have : " + newCap);
			System.out.print("Please enter new capacity: ");
			
			newCap = S7.nextInt();
			
		}
		
		node.setCapacity(newCap);
		
		System.out.print(node.getCapacity());
		
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
		
		D1.addEvent("20/02/1992","12:12", "13:12", "SDas", 4);
		D1.editDate(D1.findEvent());
		D1.editStartTime(D1.findEvent());
		D1.editEndTime(D1.findEvent());
		D1.editCap(D1.findEvent());
		D1.editDesc(D1.findEvent());

	}
}
