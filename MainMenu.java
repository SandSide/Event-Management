import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

/**
 * AC12001 Group Assignment.
 * 
 * @author Patryk Jakubek
 * Class To 
 *	   
 * @version v1.0
 */
public class MainMenu {

	// Tree Type Field.
	private Tree myTree;
	
	
	/**
     * Initial constructor for MainMenu.
     * 
     */
	public MainMenu()
	{
		
		// Sets myTree as an instance of Tree.
		myTree = new Tree();
		
	}
	
	/**
	* Displays a a dotted line.
	*
	*/
	
	public void lineBreak() 
	{
		
		// Displays "---------------------------------------------------------------".
		System.out.print("---------------------------------------------------------------");
		
	}
	
	
	/**
	* displayMenu
	* Displays available choices.
	*
	*/
	public void displayMenu()
	{
		
		// Displays Choice Options.
		System.out.println("Please select one of the options below.");
		System.out.println();
		System.out.println("1: Populate Tree.");
		System.out.println("2: Add Staff.");
		System.out.println("3: Display Staff.");
		System.out.println("4: Delete Staff.");
		System.out.println("5: Search Staff.");
		System.out.println("6: Save Staff.");
		System.out.println("7: Load Staff.");
		System.out.println("0: Exit.");
		System.out.println("");
		System.out.print("Enter: ");
	
	}
	

	/**
	* processUserChoices 
	* Gets user input and proceeds to do a choice based on input.
	*
	*/
	public void processUserChoices()
	{
		
		// Initialises variables
		String choice = "0";
		 
		try {
			
			// Does a do while loop.
			do
			{
			
				// Calls displayMenu method.
				this.displayMenu();
			
				// Creates an instance of a scanner, which records next int value entered.
				Scanner S14 = new Scanner(System.in);
			
				choice = S14.nextLine();
			
				// Checks the value of choice and does something based on that value.
				switch (choice)
				{
					
					// If choice = 1 then it calls method automatedRun().
					// Calls lineBreak method.
					case "1":
						automatedRun();
						lineBreak();
						break;
						
					// If choice = 2 then it calls method addStaff().
					// Calls lineBreak method.				
					case "2":
						this.addStaff();
						lineBreak();
						break;
						
					// If choice = 3 then it calls method displayStaff().
					// Calls lineBreak method.								
					case "3":
						this.displayStaff();
						lineBreak();
						break;
						
					// If choice = 4 then it calls method deleteStaff().
					// Calls lineBreak method.								
					case "4":
						this.deleteStaff();
						lineBreak();
						break;
						
					// If choice = 5 then it calls method searchStaff().
					// Calls lineBreak method.								
					case "5":
						this.searchStaff();
						lineBreak();
						break;
						
					// If choice = 6 then it calls method myTree.writeTree().
					// Calls lineBreak method.								
					case "6":
					this.myTree.writeTree();
						lineBreak();
						break;
						
					// If choice = 7 then it calls method myTree.readTree().
					// Calls lineBreak method.								
					case "7":
						this.myTree.readTree();
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
	
	
	/**
     * Populates the Program with data.
     *
     * 
     */
	public void automatedRun() 
	{
		
		// Creats Staff and adds Meetings to Staff.
		myTree.addNewTreeNode("SAD");
		myTree.findTreeNode("SAD").myDiary.addMeeting("20/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("SAD").myDiary.addMeeting("22/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("SAD").myDiary.addMeeting("23/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("SAD").myDiary.addMeeting("24/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("SAD").myDiary.addMeeting("24/02/2018", "13:00", "14:00", "Meeting", 2);
		
		myTree.addNewTreeNode("BOB");
		myTree.findTreeNode("BOB").myDiary.addMeeting("25/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("BOB").myDiary.addMeeting("20/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("BOB").myDiary.addMeeting("21/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("BOB").myDiary.addMeeting("20/02/2018", "12:00", "13:00", "Meeting", 2);
		
	}
	
	
	/**
     * Adds a new staff to Binary Tree.
     * 
     */
	public void addStaff() 
	{
		
		// Creates a new scanner.
		Scanner S17 = new Scanner(System.in);
		
		// Asks for user input.
		System.out.println();
		System.out.print("Please enter new staff name: ");
		String name = S17.nextLine();
		
		// Searches the Binary Tree for Staff with inputed name.
		TreeNode  find = myTree.findTreeNode(name);
		
		// If staff does not exist.
		if(find ==  null) 
		{
			
			// Add name as new Staff.
			myTree.addNewTreeNode(name);
			
		}

		else
		{
			
			// Display that the Staff already exists.
			System.out.println("The Staff already Exists.");
			
		}
		
		
	}
	
	
	/**
     * Displays all staff in Binary Tree.
     * 
     */
	public void displayStaff() 
	{
		
		// If Binary Tree is not empty.
		if(myTree.getRoot() != null) 
		{
			// Traverse Tree in In-Order and dispaly Staff Name.
			System.out.println();
			System.out.println("Displaying Staff:");
			myTree.traverseTree(myTree.getRoot());
			System.out.println();
		}
		
		else
		{
			
			// Display Tree Empty.
			System.out.println();
			System.out.println("Tree empty. Can not display Tree.");
			
		}
		
	}
	
	
	/**
     * Delete Inputed Staff from Binary Tree.
     *
     * 
     */
	public void deleteStaff() 
	{
		
		// Creates a new Scanner.
		Scanner S15 = new Scanner(System.in);
		
		// If Binary Tree is not empty.
		if(myTree.getRoot() != null) 
		{
			
			// Ask for user input.
			System.out.println();
			System.out.print("Please enter name of the staff you want to delete: ");
			String name = S15.nextLine();
			
			// Search Binary Tree for Staff with enter name.
			TreeNode find = myTree.findTreeNode(name);
			
			// IF staff exists.
			if(find !=  null) 
			{
				
				// Delete Staff from Tree.
				System.out.println();
				myTree.deleteTreeNode(name);
				
			}

			else
			{
				// Display invalid move message.
				System.out.println("The Staff does not Exist.");
				
			}
			
		}	
		else
		{
			// Display invalid move message.
			System.out.println();
			System.out.println("Tree empty. Can not Delete.");
			
		}
		
	}
	
	
	/**
     * Gives Options to:
     * Search for Inputed Staff.
     * Search for Possible Free Times for a Group of Staff.
     * 
     */
	public void searchStaff() 
	{
		
		// Creates a new Scanner.
		Scanner S18 = new Scanner(System.in);
		
		// If Tree not empty.
		if(myTree.getRoot() != null) 
		{
			
			// Display Options.
			System.out.println();
			System.out.println("Please enter one of the following searches.");
			System.out.println("1: Search Staff.");
			System.out.println("2: Search Group.");
			System.out.println("0: Exit.");
			System.out.println("");
			System.out.print("Enter: ");
			
			// Get user input.
			int choice = S18.nextInt();
			
			S18 = new Scanner(System.in);
			
			// If picked Search Staff.
			if (choice == 1) 
			{
				
				// Ask for Staff name.
				System.out.println();
				System.out.print("Please enter name of the staff you want to find: ");
				
				// Get user input.
				String name = S18.nextLine();
				
				// Searches the Staff.
				TreeNode find = myTree.findTreeNode(name);
				
				// If staff exists.
				if(find !=  null) 
				{
					
					// Display DiaryMenu
					find.displayDiaryMenu();
					find.processUserDiaryChoices();
					
				}

				else
				{
					
					// Display Invalid Move Message.
					System.out.println("");
					System.out.println("The Staff does not Exist.");
					
				}
				
				
			}
			
			// If picked Group Search.
			else if (choice == 2) 
			{
				
				// Calls searchGroup() method.
				myTree.searchGroup();
				
			}
			
			// If picked exit.
			else if (choice == 0) 
			{
				
				// Diplays current action.
				System.out.println("Exiting.");
				
			}
			
			// If did not enter valid option.
			else
			{
				
				// Display invalid Search.
				System.out.println("Invalid Search.");
				
			}
			
		}
		
		// If tree empty.
		else
		{
			// Display invalid Search.
			System.out.println();
			System.out.println("Tree empty. Can not search Tree.");
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
		MainMenu M = new MainMenu();
		M.processUserChoices();

	}

}
