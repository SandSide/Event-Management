import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class MainMenu {

	private Tree myTree;
	
	public MainMenu()
	{
		
		myTree = new Tree();
		
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
		System.out.println("Please select one of the options below.");
		System.out.println();
		System.out.println("1: Populate Tree.");
		System.out.println("2: Add Staff.");
		System.out.println("3: Display Staff.");
		System.out.println("4: Delete Staff.");
		System.out.println("5: Search Staff.");
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
	public void processUserChoices()
	{
		
		//Initialises variables
		String choice = "0";
		 
		try {
			
			//Does a do while loop.
			do
			{
			
				//Calls displayMenu method.
				this.displayMenu();
			
				//Creates an instance of a scanner, which records next int value entered.
				Scanner S14 = new Scanner(System.in);
			
				choice = S14.nextLine();
			
				//Checks the value of choice and does something based on that value.
				switch (choice)
				{
					
					//If choice = 1 then it calls method testAutomated().
					//Calls lineBreak method.
					case "1":
						automatedRun();
						lineBreak();
						break;
					
					case "2":
						this.addStaff();
						lineBreak();
						break;
						
					case "3":
						this.displayStaff();
						lineBreak();
						break;
						
					case "4":
						this.deleteStaff();
						lineBreak();
						break;
						
					case "5":
						this.searchStaff();
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
	
	
	public void automatedRun() 
	{
		
		myTree.addNewTreeNode("SAD");
		myTree.findTreeNode("SAD").myDiary.addEvent("20/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("SAD").myDiary.addEvent("22/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("SAD").myDiary.addEvent("23/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("SAD").myDiary.addEvent("24/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("SAD").myDiary.addEvent("24/02/2018", "13:00", "14:00", "Meeting", 2);
		
		myTree.addNewTreeNode("BOB");
		myTree.findTreeNode("BOB").myDiary.addEvent("25/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("BOB").myDiary.addEvent("20/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("BOB").myDiary.addEvent("21/02/2018", "12:00", "13:00", "Meeting", 2);
		myTree.findTreeNode("BOB").myDiary.addEvent("20/02/2018", "12:00", "13:00", "Meeting", 2);
		
	}
	
	public void addStaff() 
	{
		
		Scanner S17 = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Please enter new staff name: ");
		String name = S17.nextLine();
		
		TreeNode  find = myTree.findTreeNode(name);
		
		if(find ==  null) 
		{
			
			myTree.addNewTreeNode(name);
			
		}

		else
		{
			
			System.out.println("The Staff already Exists.");
			
		}
		
		
	}
	
	public void displayStaff() 
	{
		
		if(myTree.getRoot() != null) 
		{
			System.out.println();
			System.out.println("Displaying Staff:");
			myTree.traverseTree(myTree.getRoot());
			System.out.println();
		}
		
		else
		{
			
			System.out.println();
			System.out.println("Tree empty. Can not display Tree.");
			
		}
		
	}
	
	public void deleteStaff() 
	{
		
		Scanner S15 = new Scanner(System.in);
		
		if(myTree.getRoot() != null) 
		{
			
			System.out.println();
			System.out.print("Please enter name of the staff you want to delete: ");
			String name = S15.nextLine();
			TreeNode find = myTree.findTreeNode(name);
			
			if(find !=  null) 
			{
				
				System.out.println();
				myTree.deleteTreeNode(name);
				
			}

			else
			{
				
				System.out.println("The Staff does not Exist.");
				
			}
			
		}	
		else
		{
			
			System.out.println();
			System.out.println("Tree empty. Can not Delete.");
			
		}
		
		

		
	}
	
	public void searchStaff() 
	{
		
		Scanner S18 = new Scanner(System.in);
		
		if(myTree.getRoot() != null) 
		{
			
			System.out.println();
			System.out.println("Please enter one of the following searches.");
			System.out.println("1: Search Staff.");
			System.out.println("2: Search Group.");
			System.out.println("0: Exit.");
			System.out.println("");
			System.out.print("Enter: ");
			
			int choice = S18.nextInt();
			
			S18 = new Scanner(System.in);
			
			if (choice == 1) 
			{
				
				System.out.println();
				System.out.print("Please enter name of the staff you want to find: ");
				
				String name = S18.nextLine();
				
				TreeNode find = myTree.findTreeNode(name);
				
				if(find !=  null) 
				{
					
					find.displayDiaryMenu();
					find.processUserDiaryChoices();
					
				}

				else
				{
					
					System.out.println("");
					System.out.println("The Staff does not Exist.");
					
				}
				
				
			}
			
			else if (choice == 2) 
			{
				
				myTree.searchGroup();
				
			}
			else if (choice == 0) 
			{
				
				System.out.println("Exiting.");
				
			}
			
			else
			{
				
				System.out.println("Invalid Search.");
				
			}
			
		}
		
		else
		{
			
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
