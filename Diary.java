import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	

	public Event searchMeeting() 
	{
		
		String date;
		String day;
		String month;
		String year;
		
		String startTime;
		String startTimeHour;
		String startTimeMinute;
				
		String duration;
		int num;
		
		boolean valid = false;
		
		Date datte = new Date();
		
		Scanner S2 = new Scanner(System.in);
		
		
		System.out.println();
		System.out.print("Please enter the day of the meeting you want to find: ");
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the meeting you want to find: ");
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println();
		System.out.print("Please enter the month of the meeting you want to find: ");
		
		month = S2.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the meeting you want to find: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println();
		System.out.print("Please enter the year of the meeting you want to find: ");
		
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
			System.out.print("Please enter the year of the meeting: ");
					
			year = S2.nextLine();
			num = Integer.parseInt(year);
					
		}
		    	
	
		date = day + "/" + month + "/" + year;
		
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter the start time hour of the meeting you want to find: " );
	
		startTimeHour = S2.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 18) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the start time hour: ");
			
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
		
		return (this.findMeeting(date, startTime));
		
	}
	
	
	public Event findMeeting(String day, String time) 
	{
		
		String pattern = "dd/MM/yyyy kk:mm";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		String findDate = day + " " + time;
		String currentDate;
		boolean found = false;
		Event N = null;

		Event E = new Event();
		
		try 
	    {
			
	    	E.setStartDate(format.parse(findDate));
	    	format = new SimpleDateFormat("kk:mm");
	    	findDate = format.format(E.getStartDate());

	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }
		
		pattern = "dd/MM/yyyy kk:mm";
		format = new SimpleDateFormat(pattern);
		
		findDate = day + " " + time;
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
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Iterator<Event> Iterator = myEvents.iterator();
		
        while (Iterator.hasNext()) 
        {
        	
        	N = Iterator.next();
        	format = new SimpleDateFormat("dd/MM/yyyy");
        	System.out.println("Date: " + "\t" + "\t" +  format.format(N.getStartDate()));
        	
        	format = new SimpleDateFormat("kk:mm");
        	System.out.println("Start Time: " + "\t" + format.format(N.getStartDate()));
        	System.out.println("End Time: " + "\t" +format.format(N.getEndDate()));
        	System.out.println("Description: " + "\t" + N.getDesciption());
        	System.out.println("Capacity: " + "\t" + N.getCapacity());
        	System.out.println();

        }
		    
	}
	
	
	
	public void addToEvent() 
	{
		
		String date;
		String day;
		String month;
		String year;
		
		String startTime;
		String startTimeHour;
		String startTimeMinute;
		
		String endTime;
		String duration;
				
		int num;
		int capacity;
		String desc;
		
		boolean valid = false;
		
		Date datte = new Date();
		
		Scanner S10 = new Scanner(System.in);
		
		
		System.out.println();
		System.out.print("Please enter the day of the meeting: ");
		
		day = S10.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the meeting: ");
			
			day = S10.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println();
		System.out.print("Please enter the month of the meeting: ");
		
		month = S10.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the meeting: ");
			
			month = S10.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println();
		System.out.print("Please enter the year of the meeting: ");
		
		year = S10.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date();

		    		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900;
		    
		while(num < nowYear) 
		{
		    		
		    System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("The year already passed.");
			System.out.print("Please enter the year of the meeting: ");
					
			year = S10.nextLine();
			num = Integer.parseInt(year);
					
		}
		    	
	
		date = day + "/" + month + "/" + year;
		
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter the Meeting Start Time Hour: " );
	
		startTimeHour = S10.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 18) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter meeting start time hour: ");
			
			startTimeHour = S10.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		valid = false;
		
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter meeting start time minute: ");
		
		startTimeMinute = S10.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		if(num == 0 ||num == 15 || num == 30 || num == 45 || num == 60) 
		{
			
			valid = true;
			
		}

		while(valid == false) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter meeting start time minute: ");
			
			duration = S10.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 0 || num == 15 || num == 30 || num == 45 || num == 60) 
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		
		
		startTime = startTimeHour + ":" + startTimeMinute;
		
		System.out.println();
		System.out.println("Possible durations are 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter duration of the meeting: ");
		
		duration = S10.nextLine();
		
		num = Integer.parseInt(duration);
		
		if(num == 15 || num == 30 || num == 45 || num ==60) 
		{
			
			valid = true;
			
		}

		
		while(valid == false) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible durations are 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter duration of the meeting: ");
			
			duration = S10.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 15 || num == 30 || num == 45 || num ==60) 
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		
		num = Integer.parseInt(startTimeMinute) + Integer.parseInt(duration);
				
		endTime = startTimeHour + ":" + num;
		
		
		System.out.println();
		System.out.print("Please enter description of the event: ");
		
		desc = S10.nextLine();
		
		System.out.println();
		System.out.print("Please enter the capacity for the event: ");
		
		capacity = S10.nextInt();
		
		while(capacity < 0) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the capacity for the event: ");
			capacity = S10.nextInt();
			
		}
		
		if(findMeeting(date, startTime) != null)
		{
		
			this.addEvent(date, startTime, endTime, desc, capacity);
			
		}
		else
		{
			
		}
		
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
			
		String startDate = day;
		String startTime = start;
		String endTime = end;
		String desc = description;
		int capacity = cap;
		
		String formatedDate;
		String checkTime = startTime;
		
		int num1;
		int num2;
		int num3;
		int num4;
		int num5;
		int num6 = 0;
		
		boolean valid = false;
		
		Event E = new Event();
		Event N;
		Date date = null;
		
		String pattern = "dd/MM/yyyy kk:mm";
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		
		String[] parts = startTime.split(":");
		num1 = Integer.parseInt(parts[1]);
		
		parts = endTime.split(":");
		num2 = Integer.parseInt(parts[1]);
		
		num3 = num2 - num1;
		num4 = 0;
		
		switch (num3) 
		{
		
			case -45:
				num4 = 1;
				break;
			
			case -30:
				num4 = 2;
				break;
				
			case -15:
				num4 = 3;
				break;
				
			case 0:
				num4 = 4;
				break;
				
			case 15:
				num4 = 1;
				break;
				
			case 30:
				num4 = 2;
				break;
				
			case 45:
				num4 = 3;
				break;
						
		}
		
		
		String [] partss = checkTime.split(":");
		num5 = Integer.parseInt(partss[1]);
		
		for(int i = 1; i<= num4; i++) 
		{
			
			num5 = 15 + num5;
			checkTime = partss[0] + ":" + String.valueOf(num5);
	
			N = this.findMeeting(day, checkTime);
			
			if(N == null) 
			{
				
				num6++;
					
			}

		}
		
		
		N = findMeeting(startDate, startTime);
		
		if(N == null && num6 == num4)
		{
		
		    try 
		    {
		    	
		    	formatedDate = (startDate + " " + startTime);
		    	E.setStartDate(format.parse(formatedDate));
		    	
		    	formatedDate = (startDate + " " + endTime);
		    	E.setEndDate(format.parse(formatedDate));
		    	
		    	E.setDesciption(desc);
		    	E.setCapacity(capacity);
		    	
		    	Date sd = E.getStartDate();
		    	
		    } 
		    
		    catch (ParseException e) 
		    {
		    	
		      e.printStackTrace();
		      
		    }
	    
	    	myEvents.add(E);
	    	System.out.println("The Event was added.");
	    	System.out.println();
	    	
		}
		
		else
		{
			
			System.out.println("The meeting could not be added as it clashes with a different meeting.");
			System.out.println();
			
		}
		
		
		Collections.sort(myEvents, new Comparator<Event>() 
		{
			
		    @Override
		    public int compare(Event o1, Event o2) 
		    {
		    	
		        return o1.getStartDate().compareTo(o2.getEndDate());
		        
		    }

		});
		
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
				Scanner S11 = new Scanner(System.in);
				
				choice = S11.nextInt();
			
				//Checks the value of choice and does something based on that value.
				switch (choice)
				{
						
					//If choice = 1 then it calls method testAutomated().
					//Calls lineBreak method.
					case 1:
						this.editDate(this.searchMeeting());
						lineBreak();
						break;
						
					//If choice = 2 then it calls method singlePlayer().
					//Calls lineBreak method.
					case 2:
						this.editStartTime(this.searchMeeting());
						lineBreak();
						break;
		
					//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 3:
						this.editEndTime(this.searchMeeting());
						lineBreak();
						break;
						
					//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 4:
						this.editDesc(this.searchMeeting());
						lineBreak();
						break;
						
					//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 5:
						this.editCap(this.searchMeeting());;
						lineBreak();
						break;
					
						//If choice = 3 then it calls method multiplayer()
					//Calls lineBreak method.
					case 6:
						this.editEndTime(this.searchMeeting());
						lineBreak();
						break;
						
					//If choice = 0 then displays exit message.
					//Calls lineBreak method.
					case 0:
						System.out.println("Exiting.");
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
		
		System.out.println();
		System.out.print("Please enter the day of the event: ");
		
		day = S3.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the event: ");
			
			day = S3.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println();
		System.out.print("Please enter the new month of the event: ");
		
		month = S3.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) 
		{
			
			System.out.println("Invalid Input.");
			System.out.print("Please enter the new month of the event: ");
			
			month = S3.nextLine();
			
			num = Integer.parseInt(month);
		}
		
		
		System.out.println();
		System.out.print("Please enter the new year of the event: ");
		
		year = S3.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date();
		
		
		    		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900;
		    	
		while(num < nowYear) 
		{
		    		
		    System.out.println();
			System.out.println("Invalid Input. The year already passed.");
			System.out.print("Please enter the year of the event: ");
					
			year = S3.nextLine();
			num = Integer.parseInt(year);
					
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
		
		String duration;
		String formatedDate;
		
		int num;
		
		boolean valid = false;
		
		Scanner S4 = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter start time hour: ");
		
		startTimeHour = S4.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 18) 
		{
			
			System.out.println("Invalid Input. Possible times are from 8am till 6pm.");
			System.out.print("Please enter new start time hour: ");
			
			startTimeHour = S4.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println("Possible minutes are 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S4.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		if(num == 15 || num == 30 || num == 45 || num ==60) 
		{
			
			valid = true;
			
		}

		while(valid == false) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter start time minute: ");
			
			duration = S4.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 15 || num == 30 || num == 45 || num == 60) 
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		
		
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
		String endTime;
		
		String startTimeHour;
		String startTimeMinute;
		
		String formatedDate;
		
		String duration;
		
		int num;
		int num1;
		int num2;
		boolean valid = false;
	
		Scanner S5 = new Scanner(System.in);	
		
		System.out.println();
		System.out.println("Possible durations are 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter duration of the meeting: ");
		
		duration = S5.nextLine();
		
		num = Integer.parseInt(duration);
		
		if(num == 15 || num == 30 || num == 45 || num ==60) 
		{
			
			valid = true;
			
		}

		
		while(valid == false) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible durations are 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter duration of the meeting: ");
			
			duration = S5.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 15 || num == 30 || num == 45 || num ==60) 
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		
		SimpleDateFormat format = new SimpleDateFormat("mm");
		
		startTimeMinute = format.format(node.getStartDate());
		
		num = Integer.parseInt(startTimeMinute) + Integer.parseInt(duration);
		
		format = new SimpleDateFormat("kk");
		
		startTimeHour = format.format(node.getStartDate());
				
		endTime = startTimeHour + ":" + num;	
		
	    try 
	    {
	    		
	    	String pattern = "dd/MM/yyyy";
	    	
	    	format = new SimpleDateFormat(pattern);
			
	    	Date = format.format(node.getStartDate());
	    	
	    	
	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	
	    	formatedDate = (Date + " " + endTime);
	    	
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
		
		D1.addEvent("20/02/2018","12:00", "13:00", "SDas", 4);
		D1.addEvent("20/02/2018","12:00", "13:00", "SDas", 4);
		D1.addEvent("20/02/1992","13:00", "13:30", "SDas", 4);
		D1.addEvent("20/02/1992","11:00", "12:00", "SDas", 4);
		D1.addEvent("20/02/1992","11:30", "12:30", "SDas", 4);
		
		D1.editEvent();
	}
}
