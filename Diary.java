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

	
	public LinkedList<Meeting> myMeetings; // Creates a new LinkedList called myMeetings.
	private Stack<LinkedList<Meeting>> diaryStack; // Creates a private stack called diaryStack.
	
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
	/**
	 * Method which adds a new meeting to linked list.
	 */
	public void addToMeeting() 
	{
		
		String date; // Creates new local string for date.
		String day; // Creates new local string for day.
		String month; // Creates new local string for month.
		String year; // Creates new local string for year.
		
		String startTime; // Creates new local string for startTime.
		String startTimeHour; // Creates new local string for startTimeHour.
		String startTimeMinute; // Creates new local string for startTimeMinute.
		
		String endTime; // Creates new local string for date.
		String duration; // Creates new local string for date.
				
		int recurance; // Creates new local integer for recurance.
		
		int num; // Creates new local integer for num.
		int capacity; // Creates a new local integer for capacity.
		String desc; // Creates a new local string for desc.
		
		boolean valid = false; // Sets boolean valid to equal false.
		
		Date datte = new Date(); // Creates a new Date object.
		
		Scanner S10 = new Scanner(System.in);
		
		// Prompts user to enter the amount of weeks the meeting should go on for - recurring meetings.
		System.out.println();
		System.out.print("Please enter the amount of weeks the meeting should be added to: ");
		
		recurance = S10.nextInt();
		
		while(recurance<1) // While recurance entered is less than 1.
		{
			// Print invalid input message and ask user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the amount of weeks the meeting should be added to: ");
			
			recurance = S10.nextInt();
			
		}
		// Prompts user to enter the day of the meeting.
		S10 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter the day of the meeting: ");
		
		day = S10.nextLine();
		
		num = Integer.parseInt(day); // Parses input for day.
		
		while(num<1 || num>31) // While day entered is outwith range.
		{
			// Print invalid input message to display and prompts user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the meeting: ");
			
			day = S10.nextLine();
			
			num = Integer.parseInt(day); // Parses input for day.
		}
			
		// Prompts user to enter the month of the meeting.
		System.out.println();
		System.out.print("Please enter the month of the meeting: ");
		
		month = S10.nextLine();
		
		num = Integer.parseInt(month); // Parses input for month.
		
		while(num<1 || num>12)  // While statement to validate that month entered is within range.
		{
			// Output invalid message and asks user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the meeting: ");
			
			month = S10.nextLine();
			
			num = Integer.parseInt(day); // Parses input for day.
			
		}
		
		// Prompts user to enter the year of the meeting.
		System.out.println();
		System.out.print("Please enter the year of the meeting: ");
		
		year = S10.nextLine();
		
		num = Integer.parseInt(year); // Parses input for year.
		
		datte = new Date(); // Creates a new Date object.

		    		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900;
		    
		while(num < nowYear)  // While year entered is not before the current year.
		{
		    // Outputs an invalid input message and lets user enter again.
		    System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("The year already passed.");
			System.out.print("Please enter the year of the meeting: ");
					
			year = S10.nextLine();
			num = Integer.parseInt(year);
					
		}
		    	
	    // Formats the output of date using day, month and year.
		date = day + "/" + month + "/" + year;
		
		// Outputs possible times user can choose from for start time.
		System.out.println();
		System.out.println("Possible times are from 8am till 5pm.");
		System.out.print("Please enter the Meeting Start Time Hour: " );
	
		startTimeHour = S10.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 17) // While input is out-with range specified.
		{
			// Output error message to display and prompt user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter meeting start time hour: ");
			
			startTimeHour = S10.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println(); //Prints a new line.
			
		}
		
		valid = false; // Sets valid to equal false.
		
		// Outputs the possible minutes the user can choose from.
		System.out.println(); // 
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter meeting start time minute: ");
		
		startTimeMinute = S10.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		// IF statement that sets valid to equal true if any of the conditions below are met.
		if(num == 0 ||num == 15 || num == 30 || num == 45 || num == 60) 
		{
			
			valid = true;
			
		}

		while(valid == false) // While valid is equal to false.
		{
			// Print out invalid input message and asks user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter meeting start time minute: ");
			
			duration = S10.nextLine();
			num = Integer.parseInt(duration); // Parses duration input.
			
			// If any of the conditions below are met then set valid to true.
			if(num == 0 || num == 15 || num == 30 || num == 45 || num == 60) 
			{
				
				valid = true;
				
			}
			
			System.out.println(); // Prints a new line.
			
		}
		
		// Sets and formats startTime to equal to startTimeHour and startTimeMinute
		startTime = startTimeHour + ":" + startTimeMinute;
		
		// Prompts user to enter possible duration times of the meeting.
		System.out.println();
		System.out.println("Possible durations are 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter duration of the meeting: ");
		
		duration = S10.nextLine();
		
		num = Integer.parseInt(duration);
		
		if(num == 15 || num == 30 || num == 45 || num ==60) // If any of the conditions are met then set valid to true.
		{
			
			valid = true;
			
		}

		// While valid is equal to false
		while(valid == false) 
		{
			// Output invalid input message and ask user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible durations are 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter duration of the meeting: ");
			
			duration = S10.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 15 || num == 30 || num == 45 || num ==60) // If any of the conditions are met then set valid to equal to true.
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		// Adds the startTimeMinute and the duration together to get the end time of the meeting.
		num = Integer.parseInt(startTimeMinute) + Integer.parseInt(duration);
				
		endTime = startTimeHour + ":" + num;
		
		// Asks user to enter the description of the meeting.
		System.out.println();
		System.out.print("Please enter description of the event: ");
		
		desc = S10.nextLine();

		capacity = 2; // Sets capacity to equal to 2 as default
		
		if(findMeeting(date, startTime) == null) // IF statement that runs if no meeting is found.
		{
			// Adds the meeting using the information entered by user.
			this.addMeeting(date, startTime, endTime, desc, capacity);
			
		}
		else // Else error message to display as meeting already exists.
		{
			
			System.out.println();
			System.out.print("Could not add as the meeting already exits.");
			
		}
		// IF statement that runs if recurance is greater than 1 for meetings.
		if(recurance>1) 
		{
			for(int i = 1; i < recurance; i++) //Counter that adds one and adds 7 days onto the day entered by user.
			{
				
				day = String.valueOf((Integer.parseInt(day) + 7));
				date = day + "/" + month + "/" + year; // Sets date to equal to day, month & year.
				
				if(findMeeting(date, startTime) == null) // IF no meeting is found.
				{
				
					this.addMeeting(date, startTime, endTime, desc, capacity); // A meeting is added using user input.
					
				}
				else // Else error message to display as meeting already exists.
				{
					
					System.out.println();
					System.out.print("Could not add as the meeting already exits.");
					
				}
				
			}
			
		}
		
	}

	
	/**
	 * Method which adds a meeting to linked list.
	 * @param day which user will choose.
	 * @param start time which the user will chooose from select options.
	 * @param end time which user will choose from options.
	 * @param description that will outline the meeting
	 * @param cap that is the capacity of the meeting.
	 */
	public void addMeeting(String day, String start, String end, String description, int cap) 
	{
		// Creates and initalizes local variables.
		String startDate = day;
		String startTime = start;
		String endTime = end;
		String desc = description;
		int capacity = cap;
		
		String formatedDate; //Creates local String formattedDate.
		String checkTime = startTime; // Creates and initalizes local string checkTime to equal startTime.
		
		boolean valid = true; // Sets boolean valid to equal true.
		
		Meeting E = new Meeting(); // Creates an object E of meeting.
		Meeting N; // Creates an object named N of meeting.
		Meeting checkEvent; // Creates a meeting object named checkEvent.
		Meeting formatTime =  new Meeting(); // // Creates a new instance of Meeting class
		
		String pattern = "dd/MM/yyyy kk:mm"; // Sets the pattern to the correct format.
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		while(checkTime.compareTo(endTime) < 0) // While statement to validate start/end time.
		{
			
			format = new SimpleDateFormat("kk:mm");
			
			checkEvent = findMeeting(startDate, checkTime);
			
			String[] parts = checkTime.split(":"); // Creates an  array of strings called parts to equal checkTime.
			checkTime = parts[0] + ":" + Integer.toString(Integer.parseInt(parts[1]) + 15);
			
			 try 
			 {
			    formatedDate = (checkTime); //formattedDate is set equal to checkTime
			    formatTime.setStartDate(format.parse(formatedDate));
			    checkTime = format.format(formatTime.getStartDate());
			    	
			 } 
			    
			 catch (ParseException e) // Catch exception
			 {
			    	
			    e.printStackTrace();
			      
			 }
			
			if (checkEvent != null) // IF checkEvent is not equal to null
			{
				valid = false; // Set valid to equal false.
				
			}
			
		}
		
		N = findMeeting(startDate, startTime); 
		format = new SimpleDateFormat(pattern);
		
		if(N == null && valid == true) // IF meeting N is equal to null and valid is true.
		{
		
		    try 
		    {
		    	//Set formattedDate to equal startDate and startTime.
		    	formatedDate = (startDate + " " + startTime);
		    	E.setStartDate(format.parse(formatedDate));
		    	
		    	formatedDate = (startDate + " " + endTime);
		    	E.setEndDate(format.parse(formatedDate));
		    	
		    	E.setDescription(desc); // Set's the description.
		    	E.setCapacity(capacity); // Set's the capacity.
		    	
		    	Date sd = E.getStartDate();
		    	
		    } 
		    
		    catch (ParseException e) 
		    {
		    	
		      e.printStackTrace();
		      
		    }
	    
	    	myMeetings.add(E); // Adds meeting to myMeetings LinkedList.
	    	System.out.println("The Meeting was added."); // Outputs message informing user that meeting has been added.
	    	System.out.println();
	    	
		}
		
		else // Else tell's user that the meeting clashes with another meeting.
		{
			
			System.out.println();
			System.out.println("The meeting could not be added as it clashes with a different meeting.");
			System.out.println();
			
		}
		
		// Use collection class to sort the meetings in order.
		Collections.sort(myMeetings, new Comparator<Meeting>() 
		{
			
		    @Override
		    public int compare(Meeting o1, Meeting o2) 
		    {
		    	
		        return o1.getStartDate().compareTo(o2.getEndDate());
		        
		    }

		});
		
	}
	
	/**
	 * Method which prints out the LinkedList to display meetings
	 */
	public void printList() 
	{
			
		String currentDate; // Creates a local string called currentDate.
		boolean found = false; // Create and initalizes boolean found to equal false.
		Meeting N = null;
		// Formats the date to equal 'DD/MM/YY'.
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Iterator<Meeting> Iterator = myMeetings.iterator(); // Creates an iterator for linked list myMeeting.
		
        while (Iterator.hasNext())  //Iterates through the LinkedList, printing out the meetings within.
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
	
	/**
	 * Method which searches for a meeting and deletes it.
	 */
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
		
		while(recurance<1) // While recurance entered is less than 1 
		{
			// Display's an error message and prompts user to enter again.

			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the amount of weeks you want to delete the meeting from: ");
			
			recurance = S2.nextInt();
			
		}
		
		
		S2 = new Scanner(System.in);
		
		System.out.print("Please enter the day of the meeting: "); // Prompts user to enter day of meeting they want to search and delete
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) //While statement to validate input is between 1 and 31 for days in month
		{
			
			System.out.println();
			System.out.println("Invalid Input.");  // Error message output.
			System.out.print("Please enter the day of the meeting: ");  //Allows user to enter again.
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day); // Setting int num to equal input for day through parsing it. 
		}
			
		
		System.out.println(); 
		System.out.print("Please enter the month of the meeting: "); //Prompts user to enter the month of meeting
		
		month = S2.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) // While statement to validate that month entered is between 1 an 12.
		{
			// Prints an error message and prompts user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the meeting: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		// Prompts user to enter the year of event.
		System.out.println();
		System.out.print("Please enter the year of the meeting: ");
		
		year = S2.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date(); // Creates an new Date object.

		    		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900; // Sets now year to equal to the current year.
		    
		while(num < nowYear) // While num entered is less than the current year.
		{
			// Prints an error message and lets user enter again.
		    System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("The year already passed.");
			System.out.print("Please enter the year of the meeting: ");
					
			year = S2.nextLine();
			num = Integer.parseInt(year);
					
		}
		    	
		// Sets date to equal to day, month, & year.
		date = day + "/" + month + "/" + year;
		
		// Lets user enter the meeting start time hour.
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter the meeting start time hour: " );
	
		startTimeHour = S2.nextLine();
		
		num = Integer.parseInt(startTimeHour); // Parses the startTimeHour input
		
		while(num <8 || num > 18) // While the time entered is outwith range.
		{
			// Prints an error message and allows user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter meeting start time hour: ");
			
			startTimeHour = S2.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		valid = false; // Setting valid to equal false.
		
		// Prompts user to enter the start time minute.
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S2.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		if(num == 0 || num == 15 || num == 30 || num == 45 || num ==60) // IF statement that sets validates user input for minute.
		{
			
			valid = true; // Sets valid to equal true.
			
		}

		while(valid == false) // While valid is equal to false.	
		{
			// Display an error message and allow user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter start time minute: ");
			
			duration = S2.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 0 || num == 15 || num == 30 || num == 45 || num == 60) // If num entered is one of the options below then set valid to true.
			{
				
				valid = true; // Sets valid to equal true.
				
			}
			
		}
		// Sets startTime to equal to startTimeHour and startTimeMinute.
		startTime = startTimeHour + ":" + startTimeMinute;
		
		Meeting N = this.findMeeting(date, startTime); //Sets meeting N to equal to findMeeting
		
		
		if (N == null) // if N is empty the there is no meeting found.
		{
			//Displays error message.
			System.out.println();
			System.out.println("\nSorry, could not find meeting.");
			
		}
		else  //Else the meeting is removed
		{
			
			//myEvents.remove();
			myMeetings.remove(N);
			System.out.println("\nMeeting deleted successfully.");
			System.out.println("Meeting deleted: " + date + " at " + startTime);

		}
		
		if(recurance>1)  // if recurance entered is greater than 1
		{
			for(int i = 1; i < recurance; i++) 
			{
				// Adds seven days to the day entered for weekly recurring meetings.
				day = String.valueOf((Integer.parseInt(day) + 7));
				date = day + "/" + month + "/" + year;
				
				N = this.findMeeting(date, startTime);
				if(N != null)
				{
					//Remove the meeting specified in the LinkedList.
					myMeetings.remove(N);
					System.out.println("Meeting deleted: " + date + " at " + startTime);
					
				}
				
			}
			
			System.out.println();
			System.out.println("Finished Deleting: " + recurance + " weeks.");
			
		}
			
	}
	/**
	 * @param day which is used to find the date to delete.
	 * @param time which is used to find the date to delete.
	 */
	public void deleteMeeting(String day, String time)
	{

			System.out.println();
		
			String pattern = "dd/MM/yyyy kk:mm";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			// Creates and initalises local variables.
			String findDate = day + " " + time;
			String currentDate;
			boolean found = false;
			Meeting N = null;

			Iterator<Meeting> Iterator = myMeetings.iterator();
			
	        while (Iterator.hasNext() && found == false) // While it isn't empty and found is false.
	        {
	        	
	        	N = Iterator.next(); // iterate the next item.
	        	currentDate = format.format(N.getStartDate());
	        	
	        	if(currentDate.equals(findDate)) 
	        		
	        	{
	        		
	        		found = true; // Set found to equal true.
	
	        	}

	        }
	        
	        if (found == true) // If found equals true then display message.
	        {
	        	System.out.println("Found meeting");
	        	System.out.println("The meeting" + N + " has been successfully deleted.");
	        	myMeetings.remove(N);
	        	
	        }		
	        
	        else // Else meeting has not been found and displays error message.
	        {
	        	System.out.println("Error, could not find meeting.");
	        	
	        	
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
	
	/**
	 * Method which searches for a meeting specified by user.
	 * @return meeting if found
	 */
	public Meeting searchMeeting() 
	{
		// Creates and initalises local variables.
		String date;
		String day;
		String month;
		String year;
		
		String startTime;
		String startTimeHour;
		String startTimeMinute;
				
		String duration;
		int num;
		
		boolean valid = false; // Sets boolean valid to equal false.
		
		Date datte = new Date();
		
		Scanner S2 = new Scanner(System.in);
		
		
		System.out.println(); // Prompts user to enter day of the meeting they want to find.
		System.out.print("Please enter the day of the meeting you want to find: ");
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) // While statement which runs until input is within range specified.
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the meeting you want to find: ");
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println(); // Prompts user to enter the month of the meeting.
		System.out.print("Please enter the month of the meeting you want to find: ");
		
		month = S2.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12)  // While statement which runs until input is within range specified.
		{
			
			System.out.println(); // Prompts user to enter the month again.
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the meeting you want to find: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println(); // Asks user to enter the year of the meeting they want to find.
		System.out.print("Please enter the year of the meeting you want to find: ");
		
		year = S2.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date();

		    		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900;
		    
		while(num < nowYear)  // While statement which runs until input a valid year which hasn't passed.
		{
		    		
		    System.out.println(); // Invalid input message to display and prompts user to enter again.
			System.out.println("Invalid Input.");
			System.out.println("The year already passed.");
			System.out.print("Please enter the year of the meeting: ");
					
			year = S2.nextLine();
			num = Integer.parseInt(year);
					
		}
		    	
	
		date = day + "/" + month + "/" + year; // Formats the  date.
		
		// Asks user to enter start time hour.
		System.out.println();
		System.out.println("Possible times are from 8am till 6pm.");
		System.out.print("Please enter the start time hour of the meeting you want to find: " );
	
		startTimeHour = S2.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 18)  // While statement which runs until input is within range specified.
		{
			
			System.out.println(); 
			System.out.println("Invalid Input.");
			System.out.print("Please enter the start time hour: ");
			
			startTimeHour = S2.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		valid = false; // Valid is equal to false.
		
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S2.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		if(num == 0 || num == 15 || num == 30 || num == 45 || num ==60) // If statement which sets valid to true if any of the conditions are met.
		{
			
			valid = true;
			
		}

		while(valid == false)  // While valid is false.
		{
			
			System.out.println(); // Invalid input message and asks user to enter again.
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
		
		if(node != null) // If node is empty.
		{
			Scanner s1 = new Scanner(System.in);
			
			//Initialises variables
			int choice = 0;
				 
			try {
				
				//Does a do while loop.
				do{
					
					//Calls displayMenu method.
					this.displayMenu();
					
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
					System.out.println(choice);
						
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
		// Creates local variables.
		String newDate;
		String startTime;
		String endTime;
		String day;
		String month;
		String year;
		int num;
		
		boolean edited= false; // Sets boolean edited to equal false.
		
		Date datte = new Date(); // Creates a new Date object.
		
		Scanner S3 = new Scanner(System.in);
		
		System.out.println(); // Prompts user to enter the day of event.
		System.out.print("Please enter the day of the meeting: ");
		
		day = S3.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) // While num is out-with range print error message to display.
		{
			// Prompts user to enter again.
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the meeting: ");
			
			day = S3.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		// Asks user to enter the month of the event.
		System.out.println();
		System.out.print("Please enter the new month of the meeting: ");
		
		month = S3.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) // While month entered is out-with range.
		{
			// Prints error message and asks user to enter again.
			System.out.println("Invalid Input.");
			System.out.print("Please enter the new month of the meeting: ");
			
			month = S3.nextLine();
			
			num = Integer.parseInt(month);
		}
		
		// Asks user to enter the year of the event.
		System.out.println();
		System.out.print("Please enter the new year of the meeting: ");
		
		year = S3.nextLine();
		
		num = Integer.parseInt(year);
		
		datte = new Date();
		
		
		    		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900;
		    	
		while(num < nowYear) // While year entered is not before current year
		{
		    		
		    System.out.println(); //Display error message to display and allow's user to enter again.
			System.out.println("Invalid Input. The year already passed.");
			System.out.print("Please enter the year of the meeting: ");
					
			year = S3.nextLine();
			num = Integer.parseInt(year);
					
		}
		    	
		String formatedDate;	
		
	    try 
	    {
	    		
	    	String pattern = "kk:mm"; // Formats the date.
	    	
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
	    	
	    	if(formatedDate.compareTo(currentDay) >=0) // If date is valid then set the correct date and formats it.
	    	{
	    		
	    		formatedDate = (day + "/" + month + "/" + year + " " + startTime);
			    node.setStartDate(format.parse(formatedDate));
			    	
			    formatedDate = (day + "/" + month + "/" + year + " " + endTime);
			
			    node.setEndDate(format.parse(formatedDate));
			    
	    	}
	    	
	    	else
	    	{
	    		// Invalid message to display.
	    		System.out.println();
	    		System.out.println("Could not change date since is was before todays date.");
	    		
	    		
	    	}

	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }	
	    
	}
	
	/**
	 * Method which allows user to edit start time.
	 * @param node which is used to edit start time.
	 */
	public void editStartTime(Meeting node)
	{
		// Creates local variables.
		String Date;
		String startTimeHour;
		String startTimeMinute;
		
		String duration;
		String formatedDate;
		
		int num;
		
		boolean valid = false; // Sets boolean to equal false.
		
		Scanner S4 = new Scanner(System.in);
		
		System.out.println(); // Prompts user to enter start time hour.
		System.out.println("Possible times are from 8am till 5pm.");
		System.out.print("Please enter start time hour: ");
		
		startTimeHour = S4.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 17) // While startTimeHour is out-with range.
		{
			// Allow's user to enter again.
			System.out.println("Invalid Input. Possible times are from 8am till 6pm.");
			System.out.print("Please enter new start time hour: ");
			
			startTimeHour = S4.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		System.out.println(); // Informs user and lets them enter the start time minute.
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S4.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		if(num == 0 || num == 15 || num == 30 || num == 45 || num ==60) // If num entered is valid then set valid to equal true.
		{
			
			valid = true;
			
		}

		while(valid == false) //While valid is not true.
		{
			
			System.out.println(); // Output invalid input message and prompt user to enter again.
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter start time minute: ");
			
			duration = S4.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 0 ||num == 15 || num == 30 || num == 45 || num == 60) // If num entered is valid then set valid to true.
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		
		
	    try 
	    {
	    		
	    	String pattern = "dd/MM/yyyy"; // Formats the date into correct format.
	    	
	    	SimpleDateFormat format = new SimpleDateFormat(pattern);
			
	    	Date = format.format(node.getStartDate());
	    	
	    	
	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	
	    	formatedDate = (Date + " " + startTimeHour + ":" + startTimeMinute);
	    	
	    	if(formatedDate.compareTo(format.format(node.getEndDate())) >= 0) 
	    	{
	    		
	    		System.out.println(); // Error message to display
	    		System.out.println("Could not edit since the entered date is equal to or after end time.");
	    		 		
	    	}
	    	else
	    	{
	    		
	    		System.out.println(); // Else valid input and start time has been changed successfully.
		    	System.out.println("The start time was changed to: " + startTimeHour + ":" + startTimeMinute);
		    	node.setStartDate(format.parse(formatedDate));
		    	
	    	}
	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }
	    
		
	}
	
	/**
	 * Method which allows user to edit end time.
	 * @param node which is used to edit end time.
	 */
	public void editEndTime(Meeting node)
	{
		// Creates local variables.
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
		boolean valid = false; // Creates and sets boolean valid to equal false.
	
		Scanner S5 = new Scanner(System.in);	
		
		System.out.println();
		System.out.println("Possible durations are 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter duration of the meeting: ");
		
		duration = S5.nextLine();
		
		num = Integer.parseInt(duration);
		
		if(num == 15 || num == 30 || num == 45 || num ==60) // If statement to check if num entered is valid.
		{
			
			valid = true; // Sets valid to equal true.
			
		}

		while(valid == false) // While input isn't valid.
		{
			
			System.out.println(); // Output error message and allow user to enter again.
			System.out.println("Invalid Input.");
			System.out.println("Possible durations are 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter duration of the meeting: ");
			
			duration = S5.nextLine();
			num = Integer.parseInt(duration);
			
			if(num == 15 || num == 30 || num == 45 || num ==60) // If num entered is valid then set valid to true.
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
	    	// Formats the date.
	    	String pattern = "dd/MM/yyyy";
	    	
	    	format = new SimpleDateFormat(pattern);
			
	    	Date = format.format(node.getStartDate());

	    	pattern = "dd/MM/yyyy kk:mm";
	    	
	    	format = new SimpleDateFormat(pattern);
	    	
	    	formatedDate = (Date + " " + endTime);
	    	
	    	if(formatedDate.compareTo(startTime) <= 0)  // Invalid input and displays error message.
	    	{
	    		
	    		System.out.println();
	    		System.out.println("Could not edit since the entered date is equal to or before start time.");
	    		 		
	    	}
	    	
	    	else // Else valid input and ent time has been changed.
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
	
	/**
	 * Method which allows user to edit the description.
	 * @param node which is used to edit the description.
	 */
	public void editDesc(Meeting node) 
	{
		
		Scanner S6 = new Scanner(System.in);
		
		System.out.println(); // Prompting user to enter the new description.
		System.out.print("Please enter new description: ");
		
		String newDesc = S6.nextLine();
		
		node.setDescription(newDesc);
		
		System.out.println(); // Changes the description to equal new description.
		System.out.println("Changed description to: " + node.getDescription());
		
	}
	
	/**
	 * Method which allows user to edit capacity.
	 * @param node which is used to edit the capacity.
	 */
	public void editCap(Meeting node) 
	{
		// Prompts user to enter capacity of event.
		Scanner S7 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter new capacity: ");
		
		int newCap = S7.nextInt();
		
		while(newCap < 1) // While statement to validate that the capacity entered is not less than 1.
		{
			
			System.out.println(); // Error message to be displayed and prompting user to enter again.
			System.out.print("Can't have: " + newCap);
			System.out.print("Please enter new capacity: ");
			
			newCap = S7.nextInt();
			
		}
		
		node.setCapacity(newCap); // Sets the capacity to the new capacity entered by user.
		
		System.out.println();
		System.out.println("Change capacity to: " + node.getCapacity());
		
	}
	
	@SuppressWarnings("deprecation")
	public void searchEmptyTimes(Diary node) 
	{
		
		Scanner S45 = new Scanner(System.in);
		// Creates and initialises local variables.
		String date;
		String minTime;
		String maxTime;
		String minTimeCopy;
		String maxTimeCopy;
		
		String startTimeHour;
		String startTimeMinute;
		String endTime;
		
		String endTimeHour;
		String endTimeMinute;
		
		String choiceTime;
		String choiceTimeEnd;
			
		int currentCol;
		int num;

		Date currentDate = new Date(); // Creates an instance of Date.
		Diary currentDiary; // Creates an instance of Diary called currentDiary.
		Date timeSearchStarted = new Date();
		
		// Creates instance of Meeting class.
		Meeting copy = new Meeting();
		Meeting currentEvent = new Meeting();
		
		boolean valid = true; // Sets boolean valid to equal true.
		
		int Todayyear = currentDate.getYear();
		int Todayday = currentDate.getDate();
		int Todaymonth = currentDate.getMonth() + 1;
		
		String day;
		String month;
		String year;
		
		Todayyear = Todayyear + 1900; //  Setting year to equal to year + 1900.
		date = Todayday + "/" + Todaymonth + "/" + Todayyear;
			
		S45 = new Scanner(System.in);
		
		System.out.println(); // Prompts user to enter day of event.
		System.out.print("Please enter the day of the event: ");
		
		day = S45.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) // While day entered is out-with range.
		{
			// Output invalid input message and ask to enter again.
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the event: ");
			
			day = S45.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		// Prompts user to enter the month of event.
		System.out.println();
		System.out.print("Please enter the month of the event: ");
		
		month = S45.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) // While the month is out-with range.
		{
			// Asks user to enter again.
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the event: ");
			
			month = S45.nextLine();
			
			num = Integer.parseInt(month);
		}
		
		
		System.out.println(); // Prompts user to enter year of event.
		System.out.print("Please enter the year of the event: ");
		
		year = S45.nextLine();
		
		num = Integer.parseInt(year);
		
		Date datte = new Date();
		  		
		int nowYear = datte.getYear();
		nowYear = nowYear + 1900;
		    	
		while(num < nowYear) // While the year entered is before current year.
		{
		    		
		    System.out.println(); // Output error message and ask user to enter again.
			System.out.println("Invalid Input. The year already passed.");
			System.out.print("Please enter the year of the event: ");
					
			year = S45.nextLine();
			num = Integer.parseInt(year);
					
		}
		
		date = day + "/" + month + "/" + year;
		
		S45 = new Scanner(System.in);
		
		System.out.println(); // Prompts user to enter start time hour.
		System.out.println("Entering Minimum Time.");
		System.out.println("Possible times are from 8am till 5pm.");
		System.out.print("Please enter start time hour: ");
		
		startTimeHour = S45.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 17)  // While time entered is out-with range.
		{
			// Output invalid input message and ask user to enter again.
			System.out.println("Invalid Input. Possible times are from 8am till 5pm.");
			System.out.print("Please enter start time hour: ");
			
			startTimeHour = S45.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		S45 = new Scanner(System.in);
		// Prompt user to enter the start time minute.
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S45.nextLine();
		
		num = Integer.parseInt(startTimeMinute);
		
		if(num == 0 || num == 15 || num == 30 || num == 45 || num ==60) // If any of the conditions are met then set valid to equal true.
		{
			
			valid = true;
			
		}

		while(valid == false) // While valid equals false
		{
			// Print error message to display and ask user to enter again.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter start time minute: ");
			
			startTimeMinute = S45.nextLine();
			num = Integer.parseInt(startTimeMinute);
			
			if(num == 0 ||num == 15 || num == 30 || num == 45 || num == 60) // If any of the conditions are met then set valid to equal true.
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		// Prompts user to enter end time hour.
		System.out.println();
		System.out.println("Enetering Maxiumum Time.");
		System.out.println("Possible times are from 8am till 5pm.");
		System.out.print("Please enter end time hour: ");
		
		endTimeHour = S45.nextLine();
		
		num = Integer.parseInt(endTimeHour);
		
		while(num <8 || num > 17) // While statement which runs until user enter input within range.
		{
			
			System.out.println("Invalid Input. Possible times are from 8am till 5pm.");
			System.out.print("Please enter end time hour: ");
			
			endTimeHour = S45.nextLine();
			num = Integer.parseInt(endTimeHour);
			
			System.out.println();
			
		}
		
		S45 = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter end time minute: ");
		
		endTimeMinute = S45.nextLine();
		
		num = Integer.parseInt(endTimeMinute);
		
		if(num == 0 || num == 15 || num == 30 || num == 45 || num ==60) // If any of the conditions are met then set valid to equal true.
		{
			
			valid = true;
			
		}

		while(valid == false) // While statement which runs until input is valid and valid equals true.
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
			System.out.print("Please enter end time minute: ");
			
			endTimeMinute = S45.nextLine();
			num = Integer.parseInt(endTimeMinute);
			
			if(num == 0 ||num == 15 || num == 30 || num == 45 || num == 60) 
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		
		endTime = endTimeHour + ":" + endTimeMinute;
		String startTime = startTimeHour + ":" + startTimeMinute;
		

		minTime = startTime;
		maxTime = endTime;
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
		
		
		String[]newArray = new String[280]; // Creates an array of strings with a limit of 280.
		
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
				format = new SimpleDateFormat("kk:mm"); // Formats the date.
						 
				copy.setStartDate(format.parse(minTimeCopy));
				minTimeCopy = format.format(copy.getStartDate());
						 
				format = new SimpleDateFormat("dd/MM/yyyy");
						 
				copy.setStartDate(format.parse(date));
				date = format.format(copy.getStartDate());
					    	
			} 
					    
			catch (ParseException e)  // Catch exception.
			{
					    	
				 e.printStackTrace();
					      
			}
					
		}
	
		Set<String> setA = new HashSet<String>();  // Creates a new set called setA.
		
		if(valid == true) 
		{
			
			for(int k = 0; k<280; k++) 
			{
				
				if(newArray[k] != null) 
				{
					
					setA.add(newArray[k]);// Adds the array to the set.
					
				}
				
			}
					
		}
			// Sorts the List in the collection.
		List<String> sortedList = new ArrayList(setA); 
		Collections.sort(sortedList);
			
		Date time_now = new Date();
			
		System.out.println("The avaible times are: "); // Prints out the available times to display.
		System.out.print(sortedList);
		
		System.out.println(); // Prompts user to enter time.
		System.out.println("Please enter time you want (hh:mm): ");
		choiceTime = S45.next();
		
		boolean checkChoiceTime = false;
		
		for(int l = 0; l <sortedList.size(); l++) 
		{
			
			Iterator<String> Iterator = sortedList.iterator();
			
			 while (Iterator.hasNext()) 
		     {
		        	
				 if(choiceTime.equals(Iterator.next()))
				 {
					 
					 
					 checkChoiceTime = true;
						 			 
				 }
		     }	
		}
		
		while (checkChoiceTime == false) 
		{
			
			System.out.println("The entered time does not match available times.");
			System.out.println("Please enter time you want (hh:mm): ");
			choiceTime = S45.next();
			
			for(int l = 0; l <sortedList.size(); l++) 
			{
				
				Iterator<String> Iterator = sortedList.iterator();
				
				while (Iterator.hasNext()) 
			    {
			        	
					if(choiceTime.equals(Iterator.next()))
					{
						 
						 
						checkChoiceTime = true;
							 			 
					}
			    }	
			}		
		}
		
			
		currentDiary = node; // Sets currentDiary to equal node.
				
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
	
	/**
	 * Method which pushes diary to stack.
	 */
	public void pushDiaryToStack()
	{ 
		
		LinkedList<Meeting> diaryCopy = new LinkedList<Meeting>();
		diaryCopy = (LinkedList) myMeetings.clone();
	    //diaryCopy.addAll(myMeetings.clone());
		diaryStack.push(diaryCopy);
		
	}
	/**
	 * Method which lets user undo.
	 */
	public void undo()
	{
		// Pops item from stack to undo.
		System.out.println();
		System.out.println("Undoing last Action.");
	    myMeetings = diaryStack.pop();
	    
	}
	
	
}