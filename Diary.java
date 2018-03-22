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
	
	
	public void deleteEvent(String day, String time) {
		
		{
			
		
			
			
			System.out.println();
		
			
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
	        		
	        		
	        	}

	        }
	        
	        if (found == true) 
	        {
	        	System.out.println("Found event");
	        	System.out.println("The event" + N + " has been successfully deleted");
	        	myEvents.remove(N);
	        	
	        }		
	        
	        else
	        {
	        	System.out.println("Error, could not find event");
	        	
	        	
	        }
		}
		
	}
	
	public Event searchMeeting() 
	{
		
		String date;   //Create new local string for date
		String day;    //Create new  local string for day
		String month;  //Create new local string for month
		String year;   //Create new local string for year
		
		String startTime;  //Create new local string to obtain complete start time
		String startTimeHour;  //Create local new string to obtain start time hour
		String startTimeMinute; //Create local new string for start time minute
				
		String duration;  //Local string variable for to calculate the duration of meeting
		int num;          //Local integer variable called num
		
		boolean valid = false;  //Sets boolean valid to equal false
		
		Date datte = new Date();  //Creates an instance of date
		
		Scanner S2 = new Scanner(System.in);  //Utilizing scanner to get user unput
		
		
		System.out.println();  //Prints out new Line
		System.out.print("Please enter the day of the event: "); //Outputs message prompting user to enter day of event t
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the event: ");
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println();
		System.out.print("Please enter the month of the event: ");
		
		month = S2.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the event: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println();
		System.out.print("Please enter the year of the event: ");
		
		year = S2.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date();

		    		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900;
		    
		while(num < nowYear) 
		{
		    		
		    System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("The year already passed.");
			System.out.print("Please enter the year of the event: ");
					
			year = S2.nextLine();
			num = Integer.parseInt(year);
					
		}
		    	
	
		date = day + "/" + month + "/" + year;
		
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter the Meeting Start Time Hour: " );
	
		startTimeHour = S2.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 18) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter new start time hour: ");
			
			startTimeHour = S2.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		valid = false;
		
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S2.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		if(num == 0 || num == 15 || num == 30 || num == 45 || num ==60) 
		{
			
			valid = true;
			
		}

		while(valid == false) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter start time minute: ");
			
			duration = S2.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 0 || num == 15 || num == 30 || num == 45 || num == 60) 
			{
				
				valid = true;
				
			}
			
		}
		
		startTime = startTimeHour + ":" + startTimeMinute;
		
		return (this.findEvent(date, startTime));
		
	}
	
	
	public void searchDelete() 
	{
		
		String date; //Create new local string for date
		String day;  //Create new  local string for day
		String month;  //Create new local string for month
		String year;   //Create new local string for year
		
		String startTime; //Create new local string to obtain complete start time
		String startTimeHour; //Create local new string to obtain start time hour
		String startTimeMinute; //Create local new string for start time minute
				
		String duration;  //Local string variable for to calculate the duration of meeting
		int num;   //Local integer variable called num
		
		boolean valid = false;  //Sets boolean valid to equal false
		
		
		
		Date datte = new Date();  //Creates an instance of date
		
		Scanner S2 = new Scanner(System.in); //Utilizing scanner to get user unput
		
		
		System.out.println("Search Function to Delete Meeting:"); //Outputs message telling user that this is the search function to delete
		System.out.print("Please enter the day of the event: "); //Prompts user to enter day of meeting they want to search and delete
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) //While statement to validate input is between 1 and 31 for days in month
		{
			
			System.out.println();
			System.out.println("Invalid Input.");  //Error message output
			System.out.print("Please enter the day of the event: ");  //Allows user to enter again
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day); //Setting int num to equal input for day through parsing it 
		}
			
		
		System.out.println(); 
		System.out.print("Please enter the month of the event: "); //Prompts user to enter the month of meeting
		
		month = S2.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the event: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println();
		System.out.print("Please enter the year of the event: ");
		
		year = S2.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date();

		    		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900;
		    
		while(num < nowYear) 
		{
		    		
		    System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("The year already passed.");
			System.out.print("Please enter the year of the event: ");
					
			year = S2.nextLine();
			num = Integer.parseInt(year);
					
		}
		    	
	
		date = day + "/" + month + "/" + year;
		
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter the Meeting Start Time Hour: " );
	
		startTimeHour = S2.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 18) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter new start time hour: ");
			
			startTimeHour = S2.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		valid = false;
		
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S2.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		if(num == 0 || num == 15 || num == 30 || num == 45 || num ==60) 
		{
			
			valid = true;
			
		}

		while(valid == false) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter start time minute: ");
			
			duration = S2.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 0 || num == 15 || num == 30 || num == 45 || num == 60) 
			{
				
				valid = true;
				
			}
			
		}
		
		startTime = startTimeHour + ":" + startTimeMinute;
		
		
		
		
		
		
		Event N = this.findEvent(date, startTime);
		
		
		if (N == null)
		{
			System.out.println("\nSorry, could not delete event");
		}
		else
		{
			myEvents.remove();
			System.out.println("\nEvent deleted successfully");
			System.out.println("Event deleted " + date + " at " + startTime);
		}
		
	
		
		
		
		
		
	}
	
	

	
	//Remove method
	//get day and time from user
	//Then call find function
	//IF day and time = found then return N (the reference) and delete it
	//IF day and time not found then return null and message saying not found
	
	
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
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the event: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println();
		System.out.print("Please enter the year of the event (e.g. 04): ");
		
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
		System.out.println("Please enter new end time hour: ");
		
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
		
		System.out.println("Please enter description of the event: ");
		
		desc = S2.nextLine();
		
		System.out.println("Please enter the capacity for the event: ");
		
		capacity = S2.nextInt();
		
		while(capacity < 0) 
		{
			
			System.out.println("Invalid Input.");
			System.out.println("Please enter the capacity for the event: ");
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
	 * @param E 
	* 
	* @param args N/A.
	*
	*/
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Diary D1 = new Diary();
		
		final long startTime = System.nanoTime();
		
		 
		long start = System.currentTimeMillis();
		
		                                    
		
		
		//D1.addToEvent();
		D1.addEvent("23/12/2018","12:30", "13:30", "sat", 5);
		D1.addEvent("22/12/2018","12:20", "13:30", "sat", 5);
		
		
        System.out.println("List of meetings:\n");
        
		D1.printList();
		
		
		D1.searchDelete();
		long searchTime = System.currentTimeMillis() - start;   //running time for search method
		searchTime = (searchTime)/1000;  //Divides searchTime by 1000 to get it in seconds
		System.out.println("You spent " + searchTime + " seconds using our search feature."); //Outputs the running time of the search method
		System.out.println();
		System.out.println("After deletion, the list is as follows:");
		D1.printList();
		//D1.addEvent("20/02/1992","12:12", "13:12", "SDas", 4);
		//D1.editDate(D1.findEvent(null, null));
		//D1.editStartTime(D1.findEvent(null, null));
		//D1.editEndTime(D1.findEvent(null, null));
		//D1.editCap(D1.findEvent(null, null));
		//D1.editDesc(D1.findEvent(null, null));
		
		//D1.findEvent(null, null);
		
		//D1.addEvent("05/12/2011","12:12", "23:12", "SDas", 4);
		//D1.addEvent("06/12/2011","12:12", "23:12", "SDas", 4);
		//D1.addEvent("07/12/2011","12:12", "23:12", "SDas", 4);
		
		long duration = System.nanoTime() - startTime;
		duration = (duration)/1000000000; //Dividing duration by 100000000 to get it in seconds
		System.out.print("You spent " + duration + " seconds on our Event Management program today.");
}
}