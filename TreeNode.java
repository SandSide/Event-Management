import java.util.LinkedList;
import java.util.Scanner;

/**
 * AC12001 Group Assignment.
 * 
 * @author Patryk Jakubek
 * Class to store meeting details.
 * Allows one to set/get the fields.
 *	   
 * @version v1.0
 */
public class TreeNode {
	
	// Fields to store Staff Information.
	public String name;
	public Diary myDiary;
	public TreeNode left;
	public TreeNode right;

	
	/**
     * Initial constructor for TreeNode.
     * 
     */
	public TreeNode(String staff) 
	{
		
		name = staff;
		myDiary = new Diary();
		left = null;
		right = null;
		
	}
	
	
	/**
     * Getter method for nane.
     *
     * @return Name of the staff.
     * 
     */
	public String getName()
	{
		
		return name;
		
	}
	
	
	/**
     * Setter method for name.
     *
     * @param name The new name for the staff.
     * 
     */
	public void setName(String name) 
	{
		
		this.name = name;
		
	}
	
	
	/**
     * Getter method for myDiary.
     *
     * @return Diary of the staff.
     * 
     */
	public Diary getMyDiary() 
	{
		
		return myDiary;
		
	}
	
	
	/**
     * Setter method for myDiary.
     *
     * @param myDiary The new diary for the staff.
     * 
     */
	public void setMyDiary(Diary myDiary) 
	{
		
		this.myDiary = myDiary;
		
	}
	
	
	/**
     * Getter method for left.
     *
     * @return TreeNode to the left of Staff.
     * 
     */
	public TreeNode getLeft() 
	{
		
		return left;
		
	}
	
	
	/**
     * Setter method for StartDate.
     *
     * @param left The new TreeNode to the left of Staff.
     * 
     */
	public void setLeft(TreeNode left)
	{
		
		this.left = left;
		
	}
	
	
	/**
     * Getter method for right.
     *
     * @return TreeNode to the right of Staff.
     * 
     */
	public TreeNode getRight()
	{
		
		return right;
		
	}
	
	
	/**
     * Setter method for right.
     *
     * @param right The new TreeNode to the right of Staff.
     * 
     */
	public void setRight(TreeNode right)
	{
		
		this.right = right;
		
	}
	
	
	/**
     * Getter method for myMeetings.
     *
     * @return LinkedList of meetings.
     * 
     */
	public LinkedList<Meeting> getMyMeetings()
	{
		
		return myDiary.getMyMeetings(); 
		
	}
	
	
	/**
     * Displays a line break.
     * 
     */
	public void lineBreak() {
		
		// Displays "---------------------------------------------------------------".
		System.out.print("---------------------------------------------------------------");
	}
	
	
	/**
	* displayMenu
	* Displays available choices.
	*
	*/
	public void displayDiaryMenu()
	{
		
		// Displays Choice Options.
		System.out.println("Please select one of the Diary options below.");
		System.out.println();
		System.out.println("1: Add Meeting.");
		System.out.println("2: Display Diary.");
		System.out.println("3: Delete Event.");
		System.out.println("4: Search Diary.");
		System.out.println("5: Search Empty Meeting.");
		System.out.println("6: Edit Meeting.");
		System.out.println("7: Undo.");
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
		
		// Initialises variables
		String choice = "0";
		 
		try {
			
			// Does a do while loop.
			do
			{
			
				// Calls displayDiaryMenu() method.
				this.displayDiaryMenu();
			
				// Creates an instance of a scanner, which records next int value entered.
				Scanner S19 = new Scanner(System.in);
			
				choice = S19.nextLine();
			
				// Checks the value of choice and does something based on that value.
				switch (choice)
				{
					
					// If choice = 1 then it calls method myDiary.addToMeeting().
					// Calls lineBreak method.
					case "1":
						myDiary.addToMeeting();
						this.myDiary.pushDiaryToStack();
						lineBreak();
						break;
						
					// If choice = 2 then it calls myDiary.printList().
					// Calls lineBreak method.					
					case "2":
						myDiary.printList();
						lineBreak();
						break;
					
					// If choice = 3 then it calls method myDiary.searchDelete().
					// Calls lineBreak method.						
					case "3":
						myDiary.searchDelete();
						this.myDiary.pushDiaryToStack();
						lineBreak();
						break;
						
					// If choice = 4 then it calls method myDiary.searchMeeting().
					// Calls lineBreak method.					
					case "4":
						myDiary.searchMeeting();
						lineBreak();
						break;
						
					// If choice = 5 then it calls method myDiary.searchEmptyTimes(myDiary).
					// Calls lineBreak method.				
					case "5":
						myDiary.searchEmptyTimes(myDiary);
						this.myDiary.pushDiaryToStack();
						lineBreak();
						break;	
						
					// If choice = 6 then it calls method myDiary.editMeeting(myDiary.searchMeeting()).
					// Calls lineBreak method.				
					case "6":
						myDiary.editMeeting(myDiary.searchMeeting());
						lineBreak();
						break;
						
					// If choice = 7 then it calls method myDiary.undo().
					// Calls lineBreak method.				
					case "7":
						myDiary.undo();
						lineBreak();
						break;			
						
					//If choice = 0 then displays exit message.
					//Calls lineBreak method.
					case "0":
						System.out.println("Exiting Diary.");
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
