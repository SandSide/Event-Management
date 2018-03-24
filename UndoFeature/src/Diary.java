import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


public class Diary {

	
	private LinkedList<Meeting> myMeetings;
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
	
	
	public Meeting findMeeting() 
	{
		
		return myMeetings.getFirst();
		
	}
	
	public void addToMeeting() 
	{
		
		String date;
		String startTime;
		String endTime;
		String formatedDate;
		int capacity;
		String desc;
		
		Scanner S2 = new Scanner(System.in);
		
		System.out.print("Please enter the Meeting Date (dd/mm/yyyy): " );
		
		date = S2.nextLine();
		
		System.out.print("Please enter the Meeting Start Time (Hour:Minute): " );
		
		startTime = S2.nextLine();
		
		
		System.out.print("Please enter the Meeting End Time (Hour:Minute): " );
		
		endTime = S2.nextLine();
		
		
		System.out.println("Please enter description of the Meeting: ");
		
		desc = S2.nextLine();
		
		System.out.println("Please enter the capacity for the Meeting: ");
		
		capacity = S2.nextInt();
		
		this.addMeeting(date, startTime, endTime, desc, capacity);
		
	}
	
	
	public void addMeeting(String day, String start, String end, String description, int cap) 
	{
		
		String startDate = day;
		String startTime = start;
		String endTime = end;;
		String formatedDate;
		String desc = description;
		int capacity = cap;
		
		Meeting E = new Meeting();
		
		Date date = null;
		
		String pattern = "dd/MM/yyyy kk:mm";
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
	    try 
	    {
	    	
	    	formatedDate = (startDate + " " + startTime);
	    	E.setStartDate(format.parse(formatedDate));
	    	
	    	formatedDate = (startDate + " " + endTime);
	    	E.setEndDate(format.parse(formatedDate));
	    	
	    	E.setDescription(desc);
	    	E.setCapacity(capacity);
	    	
	    	Date sd = E.getStartDate();
	    	
	    	System.out.println(format.format(sd));
	    	

	    } 
	    
	    catch (ParseException e) 
	    {
	    	
	      e.printStackTrace();
	      
	    }

	    myMeetings.add(E);
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
		System.out.println("4: Description.");
		System.out.println("5: Capacity.");
		System.out.println("0: Exit.");
		System.out.println("");
		System.out.print("Enter: ");
	
	}
	
	
	public void editMeeting() 
	{
		pushDiaryToStack();
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
	
	
	public void editDate(Meeting node) 
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
	
	
	public void editStartTime(Meeting node)
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
	
	
	public void editEndTime(Meeting node)
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
	
	
	public void editDesc(Meeting node) 
	{
		
		Scanner S6 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter new description: ");
		
		String newDesc = S6.nextLine();
		
		node.setDescription(newDesc);
		
		System.out.print(node.getDescription());
		
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
			System.out.print("Can't have : " + newCap);
			System.out.print("Please enter new capacity: ");
			
			newCap = S7.nextInt();
			
		}
		
		node.setCapacity(newCap);
		
		System.out.print(node.getCapacity());
		
	}

public void deleteMeeting(String day, String time) {
		
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
	        	System.out.println("Found meeting");
	        	System.out.println("The meeting" + N + " has been successfully deleted");
	        	myMeetings.remove(N);
	        	
	        }		
	        
	        else
	        {
	        	System.out.println("Error, could not find meeting");
	        	
	        	
	        }
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
		System.out.print("Please enter the day of the meeting: ");
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the meeting: ");
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println();
		System.out.print("Please enter the month of the meeting: ");
		
		month = S2.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the meeting: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println();
		System.out.print("Please enter the year of the meeting: ");
		
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
		
		return (this.findMeeting(date, startTime));
		
	}
	
	
	public void searchDelete() 
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
		
		
		System.out.println("Search Function:");
		System.out.print("Please enter the day of the meeting: ");
		
		day = S2.nextLine();
		
		num = Integer.parseInt(day);
		
		while(num<1 || num>31) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the day of the meeting: ");
			
			day = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
			
		
		System.out.println();
		System.out.print("Please enter the month of the meeting: ");
		
		month = S2.nextLine();
		
		num = Integer.parseInt(month);
		
		while(num<1 || num>12) 
		{
			
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.print("Please enter the month of the meeting: ");
			
			month = S2.nextLine();
			
			num = Integer.parseInt(day);
		}
		
		
		System.out.println();
		System.out.print("Please enter the year of the meeting: ");
		
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
			System.out.println("\nSorry, could not delete meeting");
		}
		else
		{
			myMeetings.remove();
			System.out.println("\nMeeting deleted successfully");
			System.out.println("Meeting deleted " + date + " at " + startTime);
		}
		
	
		
		
		
		
		
	}
	public void pushDiaryToStack()
	{ 
		LinkedList<Meeting>diaryCopy = new LinkedList<Meeting>();
	    diaryCopy.addAll(myMeetings);
		diaryStack.push(diaryCopy);
	}
	
	public void undo()
	{
	    myMeetings = diaryStack.pop();
	}
	

}
