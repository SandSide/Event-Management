import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


public class Diary {

	
	public LinkedList<Event> myEvents;
	public LinkedList<Event> myEventsCopy;
	
	
	public Diary() 
	{
		
		myEvents = new LinkedList<Event>();
		myEventsCopy = null;
		
	}
	

	
	
	public Event findEvent(String day, String time) 
	{
		
		String pattern = "dd/MM/yyyy kk:mm";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		String findDate = day + " " + time;
		String currentDate;
		boolean found = false;
		Event N = null;

		Iterator<Event> Iterator = myEvents.iterator();
		
        while (Iterator.hasNext() && found == false) 
        {
        	
        	N = Iterator.next();
        	currentDate = format.format(N.getStartDate());
        	
        	if(currentDate.equals(findDate)) 
        	{
        		
        		found = true;
        		return N;
        		
        	}

        }
        
        if (found == true) 
        {
        	
        	return N;
        	
        }		
        
        else
        {
        	
        	return null;
        	
        }
	}
	
	
	public void printList() 
	{
			
		String currentDate;
		boolean found = false;
		Event N = null;
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kk:mm");
		
		Iterator<Event> Iterator = myEvents.iterator();
		
        while (Iterator.hasNext()) 
        {
        	
        	N = Iterator.next();
        	System.out.println(format.format(N.getStartDate()));
        	System.out.println(format.format(N.getEndDate()));
        	System.out.println(N.getDesciption());
        	System.out.println(N.getCapacity());
        	System.out.println();

        }
		
	}
	
	public void addToEvent() 
	{
		
		this.setMyEventsCopy(this.getMyEvents());
		
		String date;
		String day;
		String month;
		String year;
		
		String startTime;
		String startTimeHour;
		String startTimeMinute;
		
		String endTime;
		String endTimeHour;
		String endTimeMinute;
		
		int num;
		int capacity;
		String desc;
		
		Date datte = new Date();
		
		Scanner S2 = new Scanner(System.in);
		
		
		System.out.println();
		System.out.print("Please enter the day of the event (e.g. 02): ");
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(day.length() != 2 || num<1 || num>31) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the event: ");
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println();
		System.out.print("Please enter the month of the event (e.g. 04): ");
		
		month = S2.nextLine();
		
		num = Integer.parseInt(month);
		
		while(month.length() != 2 || num<1 || num>12) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the event: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println();
		System.out.print("Please enter the year of the event (e.g. 2018): ");
		
		year = S2.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date();
		
		try 
		{
		    		
		    	int nowYear = datte.getYear();
		    	nowYear = nowYear + 1900;
		    	
		    	while(year.length() != 4 | num < nowYear) 
				{
		    		
		    		System.out.println();
					System.out.println("Invalid Input. The year already passed.");
					System.out.print("Please enter the year of the event: ");
					
					year = S2.nextLine();
					num = Integer.parseInt(year);
					
				}
		    	

		} 
		    
		catch (Exception e) 
		{
		    	
		      e.printStackTrace();
		      
		}		
		
		date = day + "/" + month + "/" + year;
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter the Event Start Time hour: " );
	
		startTimeHour = S2.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(startTimeHour.length() != 2 ||num <8 || num > 18) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter new start time hour: ");
			
			startTimeHour = S2.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		
		System.out.println();
		System.out.print("Please enter new start time minute: ");
		
		startTimeMinute = S2.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		while(startTimeMinute.length() != 2 || num <0) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter new start time minute: ");
			
			startTimeMinute = S2.nextLine();
			num = Integer.parseInt(startTimeMinute);
			
			System.out.println();
			
		}
		
		startTime = startTimeHour + ":" + startTimeMinute;
		
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter new end time hour: ");
		
		endTimeHour = S2.nextLine();
		
		num = Integer.parseInt(endTimeHour);
		
		
		while(endTimeHour.length() != 2 ||num <8 || num > 16) 
		{
			
			System.out.println("Invalid Input. Possible times are from 8am till 6pm: ");
			System.out.print("Please enter new end time hour: ");
			
			endTimeHour = S2.nextLine();
			num = Integer.parseInt(endTimeHour);
			
			System.out.println();
			
		}
		
		
		System.out.println();
		System.out.print("Please enter new end time minute: ");
		
		endTimeMinute = S2.nextLine();
		
		num = Integer.parseInt(endTimeMinute);
		
		while(endTimeMinute.length() != 2 || num <0) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter new end time minute: ");
			
			endTimeMinute = S2.nextLine();
			num = Integer.parseInt(endTimeMinute);
			
			System.out.println();
			
		}
		
		
		endTime = endTimeHour + ":" + endTimeMinute;
		
		System.out.println();
		System.out.print("Please enter description of the event: ");
		
		desc = S2.nextLine();
		
		System.out.println();
		System.out.print("Please enter the capacity for the event: ");
		
		capacity = S2.nextInt();
		
		while(capacity < 0) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter the capacity for the event: ");
			capacity = S2.nextInt();
			
		}
		
		this.addEvent(date, startTime, endTime, desc, capacity);
		
	}
	
	
	public LinkedList<Event> getMyEvents() 
	{
		
		return myEvents;
		
	}




	public void setMyEvents(LinkedList<Event> myEvents) {
		this.myEvents = myEvents;
	}




	public LinkedList<Event> getMyEventsCopy() {
		return myEventsCopy;
	}




	public void setMyEventsCopy(LinkedList<Event> myEventsCopy) {
		this.myEventsCopy = myEventsCopy;
	}




	public void addEvent(String day, String start, String end, String description, int cap) 
	{
		
		this.myEventsCopy = this.getMyEvents();
		
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
	    	System.out.println();
	    	

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
						this.editDate(this.findEvent());
						lineBreak();
						break;
						
					//If choice = 2 then it calls method singlePlayer().
					//Calls lineBreak method.
					case 2:
						this.editStartTime(this.findEvent());
						lineBreak();
						break;
		
					//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 3:
						this.editEndTime(this.findEvent());
						lineBreak();
						break;
						
					//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 4:
						this.editDesc(this.findEvent());
						lineBreak();
						break;
						
					//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 5:
						this.editCap(this.findEvent());;
						lineBreak();
						break;
					
						//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 6:
						this.editEndTime(this.findEvent());
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
	
	
	@SuppressWarnings("deprecation")
	public void editDate(Event node) 
	{
		
		String newDate;
		
		String startTime;
		String endTime;
		String day;
		String month;
		String year;
		int num;
		
		
		Date datte = new Date();
		
		Scanner S3 = new Scanner(System.in);
		
		//System.out.println();
		//System.out.print("Please enter new Date(dd/MM/yyyy): ");
		//newDate = S3.nextLine();
		
		System.out.println();
		System.out.print("Please enter the new day of the event (e.g. 02): ");
		
		day = S3.nextLine();
		
		num = Integer.parseInt(day);
		
		while(day.length() != 2 || num<1 || num>31) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter the new day of the event: ");
			
			day = S3.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println();
		System.out.print("Please enter the new month of the event (e.g. 04): ");
		
		month = S3.nextLine();
		
		num = Integer.parseInt(month);
		
		while(month.length() != 2 || num<1 || num>12) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter the new month of the event: ");
			
			month = S3.nextLine();
			
			num = Integer.parseInt(month);
		}
		
		
		System.out.println();
		System.out.print("Please enter the new year of the event (e.g. 04): ");
		
		year = S3.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date();
		
		 try 
		 {
		    		
		    	int nowYear = datte.getYear();
		    	nowYear = nowYear + 1900;
		    	
		    	while(year.length() != 4 | num < nowYear) 
				{
		    		
		    		System.out.println();
					System.out.println("Invalid Input. The year already passed.");
					System.out.print("Please enter the year of the event: ");
					
					year = S3.nextLine();
					num = Integer.parseInt(year);
					
				}
		    	

		    } 
		    
		catch (Exception e) 
		{
		    	
		      e.printStackTrace();
		      
		}		
		
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
	    	
	    	
	    	formatedDate = (day + "/" + month + "/" + year + " " + startTime);
	    	node.setStartDate(format.parse(formatedDate));
	    	
	    	formatedDate = (day + "/" + month + "/" + year + " " + endTime);
	
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
		String startTimeHour;
		String startTimeMinute;
		int num;
		
		Scanner S4 = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter new start time hour: ");
		
		startTimeHour = S4.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(startTimeHour.length() != 2 ||num <8 || num > 18) 
		{
			
			System.out.println("Invalid Input. Possible times are from 8am till 6pm.");
			System.out.print("Please enter new start time hour: ");
			
			startTimeHour = S4.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		
		System.out.println();
		System.out.print("Please enter new start time minute: ");
		
		startTimeMinute = S4.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(startTimeMinute.length() != 2 || num <0) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter new start time minute: ");
			
			startTimeMinute = S4.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		String formatedDate;	
		
	    try 
	    {
	    		
	    	String pattern = "dd/MM/yyyy";
	    	
	    	SimpleDateFormat format = new SimpleDateFormat(pattern);
			
	    	Date = format.format(node.getStartDate());
	    	
	    	
	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	
	    	formatedDate = (Date + " " + startTimeHour + ":" + startTimeMinute);
	    	
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
		String endTimeHour;
		String endTimeMinute;
		int num;
		
		int num1;
		int num2;
		boolean valid = false;
	
		Scanner S5 = new Scanner(System.in);	
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.println("Please enter new end time hour: ");
		
		endTimeHour = S5.nextLine();
		
		num = Integer.parseInt(endTimeHour);
		
		while(endTimeHour.length() != 2 ||num <8 || num > 18) 
		{
			
			System.out.println("Invalid Input. Possible times are from 8am till 6pm.");
			System.out.print("Please enter new end time hour: ");
			
			endTimeHour = S5.nextLine();
			num = Integer.parseInt(endTimeHour);
			
			System.out.println();
			
		}
		
		
		System.out.println();
		System.out.print("Please enter new end time minute: ");
		
		endTimeMinute = S5.nextLine();
		
		num = Integer.parseInt(endTimeHour);
		
		while(endTimeMinute.length() != 2 || num <0) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter new start time minute: ");
			
			endTimeMinute = S5.nextLine();
			num = Integer.parseInt(endTimeMinute);
			
			System.out.println();
			
		}
		
		String formatedDate;	
		
	    try 
	    {
	    		
	    	String pattern = "dd/MM/yyyy";
	    	
	    	SimpleDateFormat format = new SimpleDateFormat(pattern);
			
	    	Date = format.format(node.getStartDate());
	    	
	    	
	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	
	    	formatedDate = (Date + " " + endTimeHour + ":" + endTimeMinute);
	    	
	    	node.setEndDate(format.parse(formatedDate));
	    	
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
			System.out.print("Can't have: " + newCap);
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
		
		//D1.addToEvent();
		D1.addEvent("20/02/1992","12:12", "13:12", "SDas", 4);
		//D1.editDate(D1.findEvent());
		//D1.editStartTime(D1.findEvent());
		//D1.editEndTime(D1.findEvent());
		//D1.editCap(D1.findEvent());
		//D1.editDesc(D1.findEvent());
		//D1.addToEvent();
		D1.addEvent("05/12/2011","12:12", "23:12", "SDas", 4);
		D1.addEvent("06/12/2011","12:12", "23:12", "SDas", 4);
		D1.addEvent("07/12/2011","12:12", "23:12", "SDas", 4);
		D1.printList();
		D1.addToEvent();
	}
}
