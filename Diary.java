import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * AC12001 Group Assignment.
 * 
 * @author Patryk Jakubek
 * Class to store meeting details.
 * Allows one to set/get the fields.
 *	   
 * @version v1.0
 */
public class Diary {

	
	public LinkedList<Meeting> myMeetings;
	private Stack<LinkedList<Meeting>> diaryStack;
	
	
	public Diary() 
	{
		
		myMeetings = new LinkedList<Meeting>();
		diaryStack = new Stack<LinkedList<Meeting>>();
		
	}
	
	public LinkedList<Meeting> getMyMeetings() 
	{
		
		return myMeetings;
		
	}




	public void setMyMeetings(LinkedList<Meeting> myMeetings) {
		this.myMeetings = myMeetings;
	}


/*
	public Stack<LinkedList<Meeting>> getMyMeetingCopy() {
		return myMeetingsCopy;
	}




	public void setMyMeetingCopy(Stack<LinkedList<Meeting>> myMeetingsCopy)
	{
		
		this.myMeetingsCopy = myMeetingsCopy;
		
	}
*/
	public void addToMeeting() 
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
				
		int recurance;
		
		int num;
		int capacity;
		String desc;
		
		boolean valid = false;
		
		Date datte = new Date();
		
		Scanner S10 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter the amount of weeks the meeting should be added to: ");
		
		recurance = S10.nextInt();
		
		while(recurance<1) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the amount of weeks the meeting should be added to: ");
			
			recurance = S10.nextInt();
			
		}
		
		S10 = new Scanner(System.in);
		
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
		System.out.println("Possible times are from 8am till 5pm.");
		System.out.print("Please enter the Meeting Start Time Hour: " );
	
		startTimeHour = S10.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 17) 
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

		capacity = 2;
		
		if(findMeeting(date, startTime) == null)
		{
		
			this.addMeeting(date, startTime, endTime, desc, capacity);
			
		}
		else
		{
			
			System.out.println();
			System.out.print("Could not add as the meeting already exits.");
			
		}
		
		if(recurance>1) 
		{
			for(int i = 1; i < recurance; i++) 
			{
				
				day = String.valueOf((Integer.parseInt(day) + 7));
				date = day + "/" + month + "/" + year;
				
				if(findMeeting(date, startTime) == null)
				{
				
					this.addMeeting(date, startTime, endTime, desc, capacity);
					
				}
				else
				{
					
					System.out.println();
					System.out.print("Could not add as the meeting already exits.");
					
				}
				
			}
			
		}
		
	}

	
	
	public void addMeeting(String day, String start, String end, String description, int cap) 
	{
			
		String startDate = day;
		String startTime = start;
		String endTime = end;
		String desc = description;
		int capacity = cap;
		
		String formatedDate;
		String checkTime = startTime;
		
		boolean valid = true;
		
		Meeting E = new Meeting();
		Meeting N;
		Meeting checkEvent;
		Meeting formatTime =  new Meeting();
		
		String pattern = "dd/MM/yyyy kk:mm";
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		while(checkTime.compareTo(endTime) < 0) 
		{
			
			format = new SimpleDateFormat("kk:mm");
			
			checkEvent = findMeeting(startDate, checkTime);
			
			String[] parts = checkTime.split(":");
			checkTime = parts[0] + ":" + Integer.toString(Integer.parseInt(parts[1]) + 15);
			
			 try 
			 {
			    formatedDate = (checkTime);
			    formatTime.setStartDate(format.parse(formatedDate));
			    checkTime = format.format(formatTime.getStartDate());
			    	
			 } 
			    
			 catch (ParseException e) 
			 {
			    	
			    e.printStackTrace();
			      
			 }
			
			if (checkEvent != null) 
			{
				valid = false;
				
			}
			
		}
		
		N = findMeeting(startDate, startTime);
		format = new SimpleDateFormat(pattern);
		
		if(N == null && valid == true)
		{
		
		    try 
		    {
		    	
		    	formatedDate = (startDate + " " + startTime);
		    	E.setStartDate(format.parse(formatedDate));
		    	
		    	formatedDate = (startDate + " " + endTime);
		    	E.setEndDate(format.parse(formatedDate));
		    	
		    	E.setDescription(desc);
		    	E.setCapacity(capacity);
		    	
		    	Date sd = E.getStartDate();
		    	
		    } 
		    
		    catch (ParseException e) 
		    {
		    	
		      e.printStackTrace();
		      
		    }
	    
	    	myMeetings.add(E);
	    	System.out.println("The Event was added.");
	    	System.out.println();
	    	
		}
		
		else
		{
			
			System.out.println();
			System.out.println("The meeting could not be added as it clashes with a different meeting.");
			System.out.println();
			
		}
		
		
		Collections.sort(myMeetings, new Comparator<Meeting>() 
		{
			
		    @Override
		    public int compare(Meeting o1, Meeting o2) 
		    {
		    	
		        return o1.getStartDate().compareTo(o2.getEndDate());
		        
		    }

		});
		
	}
	
	
	public void printList() 
	{
			
		String currentDate;
		boolean found = false;
		Meeting N = null;
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Iterator<Meeting> Iterator = myMeetings.iterator();
		
        while (Iterator.hasNext()) 
        {
        	
        	N = Iterator.next();
        	format = new SimpleDateFormat("dd/MM/yyyy");
        	System.out.println("Date: " + "\t" + "\t" +  format.format(N.getStartDate()));
        	
        	format = new SimpleDateFormat("kk:mm");
        	System.out.println("Start Time: " + "\t" + format.format(N.getStartDate()));
        	System.out.println("End Time: " + "\t" +format.format(N.getEndDate()));
        	System.out.println("Description: " + "\t" + N.getDescription());
        	System.out.println("Capacity: " + "\t" + N.getCapacity());
        	System.out.println();

        }
		    
	}
	
	
	public void searchDelete() 
	{
		
		String date; // Create new local string for date.
		String day;  // Create new  local string for day.
		String month;  // Create new local string for month.
		String year;   // Create new local string for year.
		
		String startTime; // Create new local string to obtain complete start time.
		String startTimeHour; // Create local new string to obtain start time hour.
		String startTimeMinute; // Create local new string for start time minute.
				
		String duration;  // Local string variable for to calculate the duration of meeting.
		int num;   // Local integer variable called num.
		
		boolean valid = false;  // Sets boolean valid to equal false.
		
		
		Date datte = new Date();  //Creates an instance of date.
		
		Scanner S2 = new Scanner(System.in); // Utilising scanner to get user input.
		
		System.out.println("Selected Delete."); // Outputs message telling user that this is the search function to delete.
		
		System.out.println();
		System.out.print("Please enter the amount of weeks you want to delete the meeting from: ");
		
		int recurance = S2.nextInt();
		
		while(recurance<1) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the amount of weeks you want to delete the meeting from: ");
			
			recurance = S2.nextInt();
			
		}
		
		
		S2 = new Scanner(System.in);
		
		System.out.print("Please enter the day of the event: "); // Prompts user to enter day of meeting they want to search and delete
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) //While statement to validate input is between 1 and 31 for days in month
		{
			
			System.out.println();
			System.out.println("Invalid Input.");  // Error message output.
			System.out.print("Please enter the day of the event: ");  //Allows user to enter again.
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day); // Setting int num to equal input for day through parsing it. 
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
		
		Meeting N = this.findMeeting(date, startTime);
		
		
		if (N == null)
		{
			System.out.println();
			System.out.println("\nSorry, could not find meeting.");
			
		}
		else
		{
			
			//myEvents.remove();
			myMeetings.remove(N);
			System.out.println("\nEvent deleted successfully.");
			System.out.println("Event deleted: " + date + " at " + startTime);

		}
		
		if(recurance>1) 
		{
			for(int i = 1; i < recurance; i++) 
			{
				
				day = String.valueOf((Integer.parseInt(day) + 7));
				date = day + "/" + month + "/" + year;
				
				N = this.findMeeting(date, startTime);
				if(N != null)
				{
				
					myMeetings.remove(N);
					System.out.println("Event deleted: " + date + " at " + startTime);
					
				}
				
			}
			
			System.out.println();
			System.out.println("Finished Deleting: " + recurance + " weeks.");
			
		}
			
	}
	
	public void deleteMeeting(String day, String time)
	{

			System.out.println();
		
			String pattern = "dd/MM/yyyy kk:mm";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			String findDate = day + " " + time;
			String currentDate;
			boolean found = false;
			Meeting N = null;

			Iterator<Meeting> Iterator = myMeetings.iterator();
			
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
	        	myMeetings.remove(N);
	        	
	        }		
	        
	        else
	        {
	        	System.out.println("Error, could not find event");
	        	
	        	
	        }
		
		
	}

	public Meeting findMeeting(String day, String time) 
	{
		
		String pattern = "dd/MM/yyyy kk:mm";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		String findDate = day + " " + time;
		String currentDate;
		boolean found = false;
		Meeting N = null;

		Meeting E = new Meeting();
		
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
		Iterator<Meeting> Iterator = myMeetings.iterator();
		
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
        	
        	System.out.print(found);
        	return N;
        	
        }		
        
        else
        {
        	
        	return null;
        	
        }
        
        
	}
	
	
	public Meeting searchMeeting() 
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
		
		if((this.findMeeting(date, startTime)) == null) 
		{
			System.out.println();
			System.out.println("Could not find meeting.");
			
		}
		else
		{
			System.out.println();
			System.out.println("Editing: " + date + " " + startTime);
			
		}
		
		return (this.findMeeting(date, startTime));
		
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
	
	public void editMeeting(Meeting node) 
	{
		
		if(node != null) 
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
							this.editDate(node);
							lineBreak();
							break;
							
						//If choice = 2 then it calls method singlePlayer().
						//Calls lineBreak method.
						case 2:
							this.editStartTime(node);
							lineBreak();
							break;
			
						//If choice = 3 then it calls method multiplayer()
						//Calls lineBreak method.
						case 3:
							this.editEndTime(node);
							lineBreak();
							break;
							
						//If choice = 3 then it calls method multiplayer()
						//Calls lineBreak method.
						case 4:
							this.editDesc(node);
							lineBreak();
							break;
							
						//If choice = 3 then it calls method multiplayer()
						//Calls lineBreak method.
						case 5:
							this.editCap(node);;
							lineBreak();
							break;
						
							//If choice = 3 then it calls method multiplayer()
						//Calls lineBreak method.
						case 6:
							this.editEndTime(node);
							lineBreak();
							break;
						
						//If choice = 0 then displays exit message.
						//Calls lineBreak method.
						case 0:
							System.out.println("Stopping Edit.");
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
					this.pushDiaryToStack();
						
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
		else
		{
			
			//System.out.println("Could not find Meeting to edit.");
			
		}
	}

	@SuppressWarnings("deprecation")
	public void editDate(Meeting node) 
	{
		
		String newDate;
		String startTime;
		String endTime;
		String day;
		String month;
		String year;
		int num;
		
		boolean edited= false;
		
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
	    	
	    	Date currentDate = new Date();
	    	
	    	String currentDay = currentDate.getDate() + "/" + (currentDate.getMonth() + 1) + "/" + (currentDate.getYear() +1900);
	    	
	    	if(formatedDate.compareTo(currentDay) >=0) 
	    	{
	    		
	    		formatedDate = (day + "/" + month + "/" + year + " " + startTime);
			    node.setStartDate(format.parse(formatedDate));
			    	
			    formatedDate = (day + "/" + month + "/" + year + " " + endTime);
			
			    node.setEndDate(format.parse(formatedDate));
			    
	    	}
	    	
	    	else
	    	{
	    		
	    		System.out.println();
	    		System.out.println("Could not change date since is was before todays date.");
	    		
	    		
	    	}

	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }	
	    
	}
	
	
	public void editStartTime(Meeting node)
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
		System.out.println("Possible times are from 8am till 5pm.");
		System.out.print("Please enter start time hour: ");
		
		startTimeHour = S4.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 17) 
		{
			
			System.out.println("Invalid Input. Possible times are from 8am till 6pm.");
			System.out.print("Please enter new start time hour: ");
			
			startTimeHour = S4.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S4.nextLine();
		
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
			
			duration = S4.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 0 ||num == 15 || num == 30 || num == 45 || num == 60) 
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
	    	
	    	if(formatedDate.compareTo(format.format(node.getEndDate())) >= 0) 
	    	{
	    		
	    		System.out.println();
	    		System.out.println("Could not edit since the entered date is equal to or after end time.");
	    		 		
	    	}
	    	else
	    	{
	    		
	    		System.out.println();
		    	System.out.println("The start time was changed to: " + startTimeHour + ":" + startTimeMinute);
		    	node.setStartDate(format.parse(formatedDate));
		    	
	    	}
	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }
	    
		
	}
	
	
	public void editEndTime(Meeting node)
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
		
		String startTime = startTimeHour + ":" + startTimeMinute;
		
	    try 
	    {
	    		
	    	String pattern = "dd/MM/yyyy";
	    	
	    	format = new SimpleDateFormat(pattern);
			
	    	Date = format.format(node.getStartDate());

	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	formatedDate = (Date + " " + endTime);
	    	
	    	if(formatedDate.compareTo(startTime) <= 0) 
	    	{
	    		
	    		System.out.println();
	    		System.out.println("Could not edit since the entered date is equal to or before start time.");
	    		 		
	    	}
	    	
	    	else
	    	{

	    		System.out.println();
	    		System.out.println("End Time was changed to: " + endTime);
	    		node.setEndDate(format.parse(formatedDate));
	    		
	    	}
	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }
		
	    
	}
	
	
	public void editDesc(Meeting node) 
	{
		
		Scanner S6 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter new description: ");
		
		String newDesc = S6.nextLine();
		
		node.setDescription(newDesc);
		
		System.out.println();
		System.out.println("Change descipriton to: " + node.getDescription());
		
	}
	
	
	public void editCap(Meeting node) 
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
		
		System.out.println();
		System.out.println("Change capacity to: " + node.getCapacity());
		
	}
	
	@SuppressWarnings("deprecation")
	public void searchEmptyTimes(Diary node) 
	{
		
		Scanner S45 = new Scanner(System.in);
		
		String date;
		String minTime;
		String maxTime;
		String minTimeCopy;
		String maxTimeCopy;
		
		String choiceTime;
		String choiceTimeEnd;
			
		int currentCol;
		int num;

		Date currentDate = new Date();
		Diary currentDiary;
		Date timeSearchStarted = new Date();
		
		Meeting copy = new Meeting();
		Meeting currentEvent = new Meeting();
		
		boolean valid = true;
		
		int year = currentDate.getYear();
		int day = currentDate.getDate();
		int month = currentDate.getMonth() + 1;
		
		year = year + 1900;
		date = day + "/" + month + "/" + year;
			
		System.out.println("Please enter minimum time (hh:mm): ");
		minTime = S45.next();
		
		System.out.println("Please enter maximum time (hh:mm): ");
		maxTime = S45.next();
		
		minTimeCopy = minTime;
		maxTimeCopy = maxTime;
		
	
		String pattern = "kk:mm";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
	
		try 
		{   	
			 format = new SimpleDateFormat("dd/MM/yyyy");
			 
			 copy.setStartDate(format.parse(date));
			 date = format.format(copy.getStartDate());
			 
		    	
		} 
		    
		catch (ParseException e) 
		{
		    	
		     e.printStackTrace();
		      
		}
		
		
		String[]newArray = new String[280];
		
		minTimeCopy = minTime;
		maxTimeCopy = maxTime;
	
		currentCol = 0;
				
		currentDiary = node;
				
		while(minTimeCopy.equals(maxTimeCopy) != true) 
		{
					
			currentEvent = currentDiary.findMeeting(date, minTimeCopy);
					
			if(currentEvent == null) 
			{
						
				newArray[currentCol] = minTimeCopy;
				currentCol++;
						
			}
				
					
			String[] startparts = minTimeCopy.split(":");
					
			num = (Integer.parseInt(startparts[1])) + 15;
					
			minTimeCopy = startparts[0] + ":" + num;
							
			try 
			{   	
				format = new SimpleDateFormat("kk:mm");
						 
				copy.setStartDate(format.parse(minTimeCopy));
				minTimeCopy = format.format(copy.getStartDate());
						 
				format = new SimpleDateFormat("dd/MM/yyyy");
						 
				copy.setStartDate(format.parse(date));
				date = format.format(copy.getStartDate());
					    	
			} 
					    
			catch (ParseException e) 
			{
					    	
				 e.printStackTrace();
					      
			}
					
		}
	
		Set<String> setA = new HashSet<String>(); 
		
		if(valid == true) 
		{
			
			for(int k = 0; k<280; k++) 
			{
				
				if(newArray[k] != null) 
				{
					
					setA.add(newArray[k]);
					
				}
				
			}
					
		}
			
		List<String> sortedList = new ArrayList(setA);
		Collections.sort(sortedList);
			
		Date time_now = new Date();
			
		System.out.println("The avaible times are: ");
		System.out.print(sortedList);
			
		System.out.println("Please enter time you want (hh:mm): ");
		choiceTime = S45.next();
			
		currentDiary = node;
				
		String[] startparts = choiceTime.split(":");
				
		num = (Integer.parseInt(startparts[1])) + 15;
				
		choiceTimeEnd = startparts[0] + ":" + num;
				
		try 
		{   	
			format = new SimpleDateFormat("kk:mm");
					 
			copy.setStartDate(format.parse(choiceTimeEnd));
			choiceTimeEnd = format.format(copy.getStartDate());
				    	
		} 
				    
		catch (ParseException e) 
		{
				    	
			e.printStackTrace();
				      
		}
				
		currentDiary.addMeeting(date, choiceTime, choiceTimeEnd, "Group Meeting", 2);
				
		long elapsed = time_now.getTime() - timeSearchStarted.getTime(); 
		System.out.println("The search lasted for: " + elapsed + " milliseconds.");

	}	
	
	
	public void pushDiaryToStack()
	{ 
		
		LinkedList<Meeting> diaryCopy = new LinkedList<Meeting>();
		diaryCopy = (LinkedList) myMeetings.clone();
	    //diaryCopy.addAll(myMeetings.clone());
		diaryStack.push(diaryCopy);
		
	}
	
	public void undo()
	{
		
		System.out.println();
		System.out.println("Undoing last Action.");
	    myMeetings = diaryStack.pop();
	    
	}
	
	
}
