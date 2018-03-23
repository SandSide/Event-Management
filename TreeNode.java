import java.util.LinkedList;
import java.util.Scanner;

public class TreeNode {
	
	public String name;
	public Diary myDiary;
	public TreeNode left;
	public TreeNode right;

	
	public TreeNode(String staff) 
	{
		
		name = staff;
		myDiary = new Diary();
		left = null;
		right = null;
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Diary getMyDiary() {
		return myDiary;
	}

	public void setMyDiary(Diary myDiary) {
		this.myDiary = myDiary;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	
	public void lineBreak() {
		
		//Displays "---------------------------------------------------------------".
		System.out.print("---------------------------------------------------------------");
	}
	
	
	/**
	* displayMenu
	* Displays available choices.
	*
	*/
	public void displayDiaryMenu()
	{
		
		//Displays Choice Options.
		System.out.println("Please select one of the tests below.");
		System.out.println();
		System.out.println("1: Add Meeting.");
		System.out.println("2: Display Diary.");
		System.out.println("3: Delete Event.");
		System.out.println("4: Search Diary.");
		System.out.println("5: Edit Meeting.");
		System.out.println("0: Exit.");
		System.out.println("");
		System.out.print("Enter: ");
	
	}
	

	/**
	* processUserChoices 
	* Gets user input and proceeds to do a choice based on input.
	*
	* 
	*/
	public void processUserDiaryChoices()
	{
		
		//Initialises variables
		String choice = "0";
		 
		try {
			
			//Does a do while loop.
			do
			{
			
				//Calls displayMenu method.
				this.displayDiaryMenu();
			
				//Creates an instance of a scanner, which records next int value entered.
				Scanner S19 = new Scanner(System.in);
			
				choice = S19.nextLine();
			
				//Checks the value of choice and does something based on that value.
				switch (choice)
				{
					
					//If choice = 1 then it calls method testAutomated().
					//Calls lineBreak method.
					case "1":
						myDiary.addToEvent();
						lineBreak();
						break;
					
					case "2":
						myDiary.printList();
						lineBreak();
						break;
						
					case "3":
						myDiary.searchDelete();
						lineBreak();
						break;
						
					case "4":
						myDiary.searchMeeting();
						lineBreak();
						break;
						
					case "5":
						myDiary.editEvent(myDiary.searchMeeting());
						lineBreak();
						break;
							
					//If choice = 0 then displays exit message.
					//Calls lineBreak method.
					case "0":
						System.out.println("Stopping Program.");
						System.exit(0);
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
			while(choice != "0");	
		
		}
		
		//If can try.
		catch(Exception e)
		{
			
			//Displays error message.
			System.out.println();
			System.out.println("Invalid Input.");
			System.out.println("Stopping Program.");
			
		}
	}
	
	
}
