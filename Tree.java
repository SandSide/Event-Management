import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Tree {

	private TreeNode root;
	
	public Tree() 
	{
		
		root = null;
		
	}
	
	/**
     * Get the number contained in Field: root.
     * 
     * @return Reference of the root.
     * 
     */
	public TreeNode getRoot() 
	{
		
		return root;
		
	}

	
	/**
     * Set the root reference.
     * 
     * @param refrence TreeNode reference to be set as the root.
     *                
     */
	public void setRoot(TreeNode refrence) 
	{
		
		root = refrence;
		
	}
	
	
	
	public boolean isTreeEmpty() 
	{
		
		
		boolean empty = false;
		
		if(this.getRoot() == null) 
		{
			
			empty = true;
			
		}
		else 
		{
			
			empty = false;
			
		}
		
		return empty;
		
	}
	
	
	/**
     * Search the Binary Tree to find a TreeNode containing input parameter ID.
     * 
     * @param id Number which will be searched for.
     *   
     * @return Result of the search.
     *                
     */			
	public TreeNode findTreeNode(String name) 
	{
		
		// Initialises local variables.
		TreeNode upto = root;
		boolean found = false;
		int comparison;
		String currentName;
		
		// While list is not empty and id is not found.
		while (upto != null && found == false) 
		{
			
			// Set currentID to currents TreeNode ID.
			currentName = upto.getName();
			comparison = name.compareToIgnoreCase(currentName);
			
			// If currentID = id.
			if(currentName.equals(name)) 
			{
				
				// Set found to true.
				found = true;
				
			}
			
			else
			{
			
				// If currentID is lesser than id.
				if (comparison > 0) 
				{
					
					// Set upto to its left TreeNode reference.
					upto = upto.getRight();
					
				}
				
				else 
				{
					
					// Set upto to its right TreeNode reference.
					upto = upto.getLeft();
					
				}
				
			}
			
		}
		
		// If found.
		if (found == true) 
		{
			
			// Return reference to the TreeNode containing searched id.
			return upto;
			
		}
		
		else 
		{
			// Return null.
			return null;
			
		}
		
	}
	
	
	/**
     * Add a new TreeNode to the Binary Tree.
     * 
     * @param id Number which will be searched for.
     *   
     * @return Result of the search.
     *                
     */	
	public boolean addNewTreeNode(String name) 
	{
		
		// Initialises local variables.
		TreeNode current = root;
		TreeNode previous = null;
		boolean added = false;
		String currentName;
		String previousName;
		int comparsion;
		
		// Creates a new TreeNode object using input parameters.
		TreeNode newTree = new TreeNode(name);
		
		// If list is empty.
		if(root == null) 
		{
			
			// Set newTree as root.
			this.setRoot(newTree);
			
			// Set added as true.
			added = true;
			
		}
		
		else
		{	
			
			// If ID does exist in the Binary Tree.
			if (this.findTreeNode(name) != null) 
			{
				
				// Set added as false.
				added = false;
				
				// Display message that it already exists.
				System.out.println("The ID already exists.");
				
			}
			
			else
			{
				
				// While current TreeNode is not null.
				while(current != null) 
				{
					
					// Set previous reference to currents.
					previous = current;
					
					// set as id of current TreeNode.
					currentName = current.getName();
					
					// Set currentID to currents TreeNode ID.
					comparsion = name.compareToIgnoreCase(currentName);
					
					// If id is lesser than current TreeNode id.
					if(comparsion < 0) 
					{
						
						// Set currents reference to its left TreeNode.
						current = current.getLeft();
						
					}
					else
					{
						
						// Set currents reference to its right TreeNode.
						current = current.getRight();
						
					}
					
				}
				
				// Set as previous TreeNode ID.
				previousName = previous.getName();
				
				comparsion = name.compareToIgnoreCase(previousName);
				
				// If ID is lesser than previous TreeNode ID. id < value
				if(comparsion<0) 
				{
					
					// Set reference of previous left TreeNode to newTree.
					previous.setLeft(newTree);
					added = true;
					
				}
				
				else
				{
					
					// Set reference of previous right TreeNode to newTree.
					previous.setRight(newTree);
					added = true;
					
				}
				
			}
			
		}
		
		
		// If newTree was added.
		if(added == true) 
		{
			
			// Display that it was added.
			System.out.println("The Tree was added.");
			
		}
		
		else
		{
			// Display it was noted added.
			System.out.println("The Tree could not be added.");
			
		}
		
		System.out.println();
		
		return added;
		
	}
	
	
	/**
     * Delete TreeNode in BInary Tree containing ID as the input parameter.
     * 
     * @param id Number which will be searched for.
     *               
     */	
	public void deleteTreeNode(String name) 
	{
		
		// Initialises the value of variables.

		// Sets current to root (start of the binary tree.
		TreeNode current = root;
		
		// Sets references to null.
		TreeNode previous = null;
		TreeNode nextLeft = null;
		TreeNode nextRight = null;
		TreeNode toDelete = null;
		
		// Sets as not deleted.
		boolean deleted = false;
		boolean rl = false;
		
		// Sets crrentID to ID of root.
		String currentName = root.getName();
		
		// Initialises value of position.
		String position = "";
		
		int comparison;
		
		// If the ID does not exist.
		if(this.findTreeNode(name) == null)
		{
			
			// Display message to inform the user.
			System.out.println("The Tree Node does not exist.");
			System.out.println();

		}
		
		// For everything else
		else
		{
			
			// While the currentID does not match ID your trying to find.
			while(!(currentName.equals(name))) 
			{
				
				// Set reference of previous to reference of current.
				previous = current;
				comparison = name.compareToIgnoreCase(currentName);
				
				// If currentID is greater than ID.
				if(comparison <0) 
				{
					
					// Set current to currents Left TreeNode.
					current = current.getLeft();
					
					// Sets the position from previous to Left.
					position = "Left";
					
				}
				
				else
				{
					
					// Set current to currents Right TreeNode.
					current = current.getRight();
					
					// Sets the position from previous to Right.
					position = "Right";
					
				}
				
				
				// Sets currentID to currents Tree Node ID value.
				currentName = current.getName();
				
			}	
			
			
			// Sets nextLeft to current TreeNodes (which contains same ID searched) Left.
			nextLeft = current.getLeft();
			
			// Sets nextLeft to current TreeNodes (which contains same ID searched) Left.
			nextRight = current.getRight();
			
			// Stores data of current on toDelete.
			toDelete = current;
			
		
			// If Current TreeNode is a Leaf (no further Tree Nodes).
			if(nextLeft == null && nextRight == null)
			{
			
				// If position of previous is Left.
				if(position.equals("Left")) 
				{
					
					// Set previous' Left TreeNode to null.
					previous.setLeft(null);
					
				}
				
				// If position of previous is Right.
				else if (position.equals("Right")) 
				{
					
					// Set previous' Right TreeNode to null.
					previous.setRight(null);
						
				}
					
			}
			
			
			// Sets rl to boolean result of comparison of position to "Left".
			rl = position.equals("Left");
			
			
			// If Current TreeNode has a Left Child.
			if(nextLeft != null && nextRight == null && rl == true) 
			{
				
				// Set previous' Left Node to nextLeft.
				previous.setLeft(nextLeft);
				
				// Sets deleted to true.
				deleted = true;
					
			}
			
			
			// Sets rl to boolean result of comparison of position to "Right".
			rl = position.equals("Right");
				
			
			// If Current TreeNode has a Right Child.	
			if(nextLeft == null && nextRight != null && rl == true) 
			{
				
				// Set previous' Right Node to nextRight.
				previous.setRight(nextRight);
				
				// Sets deleted to true.
				deleted = true;
					
					
			}
			
			
			// If Current TreeNode has 2 Children.	
			else if(nextLeft!= null && nextRight != null) 
			{
					
				// Sets previous to null.
				previous = null;
				
				// Set current to toDeletes Left Tree Node.
				current = toDelete.getLeft();
				
	
				// While nextRight is not null.
				while(current.getRight() != null ) 
				{
					
					// Sets previous to current.
					previous = current;
					
					// Sets current to currents Right TreeNode.
					current = current.getRight();
					
				}
				
				
				// Set current data to toDelete.
				toDelete.setName(current.getName());
				
				
				// If previous is null.
				if(previous == null) 
				{
					
					// Set toDeletes Left Tree Node to currents Left Tree Node.
					toDelete.setLeft(current.getLeft());
					
				}
				
				else 
				{
					
					// Set toDeletes Right Tree Node to currents Right Tree Node.
					previous.setRight(null);
					
				}
				
				// Sets deleted to true.
				deleted = true;
				
			}			
			
		}
		
		
		// If Tree Node was deleted.
		if(deleted == true) 
		{
			
			// Display a message stating it was deleted.
			System.out.println();
			System.out.println("The TreeNode was deleted.");
			
		}
		
		// If ID does exist in the Tree and was not deleted.
		else if(this.findTreeNode(name) != null)
		{
			
			// Display a message stating it was not deleted.
			System.out.println();
			System.out.println("The TreeNode was not deleted.");
			
		}
		
	}
	
	
	/**
     * Traverse the BinaryTree In-Order.
     * 
     * @param node TreeNode to be traversed.
     *               
     */		
	public void traverseTree(TreeNode node) 
	{
		
		// If node is not empty.
		if (node!= null)
		{
			
			// Traverse nodes left TreeNode.
			traverseTree(node.getLeft());
			
			// Print Nodes ID & Mark.
			System.out.print(node.getName() + ", ");
			
			// Traverse nodes left TreeNode.
			traverseTree(node.getRight());
			
			
		}
		
		
	}
	
	public Diary findDiary(String name) 
	{
		
		Diary searched = this.findTreeNode(name).getMyDiary();
		
		if(searched != null) 
		{
			return this.findTreeNode(name).getMyDiary();
		}
		
		return null;
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void searchGroup()
	{
		
		Scanner S8 = new Scanner(System.in);
		
		String names;
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
		
		
		String duration = "0";
		
		String choiceTime;
		String choiceTimeEnd;
			
		int currentCol;
		int num;
		
		TreeNode found;
		Date currentDate = new Date();
		Diary currentDiary;
		Date timeSearchStarted = new Date();
		
		Event copy = new Event();
		Event currentEvent = new Event();
		
		boolean valid = true;
		
		int year = currentDate.getYear();
		int day = currentDate.getDate();
		int month = currentDate.getMonth() + 1;
		
		year = year + 1900;
		date = day + "/" + month + "/" + year;
			
		System.out.println();
		System.out.println();
		System.out.print("Please enter group of people seperated by , : ");
		names = S8.next();
		
		String[] parts = names.split(",");
		
		S8 = new Scanner(System.in);		
		System.out.println();
		System.out.println("Possible times are from 8am till 5pm.");
		System.out.print("Please enter start time hour: ");
		
		startTimeHour = S8.nextLine();
		
		num = Integer.parseInt(startTimeHour);
		
		while(num <8 || num > 17) 
		{
			
			System.out.println("Invalid Input. Possible times are from 8am till 5pm.");
			System.out.print("Please enter new start time hour: ");
			
			startTimeHour = S8.nextLine();
			num = Integer.parseInt(startTimeHour);
			
			System.out.println();
			
		}
		
		S8 = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		startTimeMinute = S8.nextLine();
		
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
			
			startTimeMinute = S8.nextLine();
			num = Integer.parseInt(startTimeMinute);
			
			if(num == 0 ||num == 15 || num == 30 || num == 45 || num == 60) 
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println("Max Time.");
		System.out.println("Possible times are from 8am till 5pm.");
		System.out.print("Please enter start time hour: ");
		
		endTimeHour = S8.nextLine();
		
		num = Integer.parseInt(endTimeHour);
		
		while(num <8 || num > 17) 
		{
			
			System.out.println("Invalid Input. Possible times are from 8am till 5pm.");
			System.out.print("Please enter new start time hour: ");
			
			endTimeHour = S8.nextLine();
			num = Integer.parseInt(endTimeHour);
			
			System.out.println();
			
		}
		
		S8 = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Possible minutes are 0, 15, 30, 45 & 60 minutes.");
		System.out.print("Please enter start time minute: ");
		
		endTimeMinute = S8.nextLine();
		
		num = Integer.parseInt(endTimeMinute);
		
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
			
			endTimeMinute = S8.nextLine();
			num = Integer.parseInt(endTimeMinute);
			
			if(num == 0 ||num == 15 || num == 30 || num == 45 || num == 60) 
			{
				
				valid = true;
				
			}
			
			System.out.println();
			
		}
		
		
		
		endTime = endTimeHour + ":" + endTimeMinute;
		String startTime =startTimeHour + ":" + startTimeMinute;
		

		try 
		{   	
			 SimpleDateFormat temp = new SimpleDateFormat("kk:mm");
			 
			 Event tempp = new Event();
			 tempp.setStartDate(temp.parse(startTime));
			 startTime = temp.format(tempp.getStartDate());
			 
			 tempp.setStartDate(temp.parse(endTime));
			 endTime = temp.format(tempp.getStartDate());
			    	
		} 
		    
		catch (ParseException e) 
		{
		    	
		     e.printStackTrace();
		      
		}
		
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
		
		
		
		String[][] newArray = new String[parts.length][280];
		
		
		for(int i = 0; i < parts.length; i++) 
		{
			
			minTimeCopy = minTime;
			maxTimeCopy = maxTime;
					
			found = this.findTreeNode(parts[i]);
			
			if(found == null) 
			{
				
				valid = false;
				
			}
			
			else
			{
				
				currentCol = 0;
				
				currentDiary = found.getMyDiary();
				
				while(minTimeCopy.equals(maxTimeCopy) != true) 
				{
					
					currentEvent = currentDiary.findMeeting(date, minTimeCopy);
					
					if(currentEvent == null) 
					{
						
						newArray[i][currentCol] = minTimeCopy;
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
				
				
			}
			
			
		}
		
		
		Set<String> setA = new HashSet<String>(); 
		Set<String> setB = new HashSet<String>(); 
		
		if(valid == true) 
		{
			
			for(int k = 0; k<280; k++) 
			{
				
				if(newArray[0][k] != null) 
				{
					
					setA.add(newArray[0][k]);
					
				}
				
			}
			
			
			
			for(int i = 1; i < parts.length; i++) 
			{
				
				for(int j = 0; j <280; j++) 
				{
					
					if(newArray[i][j] != null) 
					{
						
						setB.add(newArray[i][j]);
						
					}
				}
				
				setA.retainAll(setB);
				
			}
			
			List<String> sortedList = new ArrayList(setA);
			Collections.sort(sortedList);
			
			Date time_now = new Date();
				
			System.out.println("The avaible times are: ");
			System.out.print(sortedList);
			
			System.out.println("Please enter time you want (hh:mm): ");
			choiceTime = S8.next();
			
			for(int i = 0; i < parts.length; i++) 
			{
				
				currentDiary = this.findDiary(parts[i]);
				
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
				
				currentDiary.addEvent(date, choiceTime, choiceTimeEnd, "Group Meeting", (parts.length + 1));
				
				
				if(i == (parts.length - 1)) 
				{
					long elapsed = time_now.getTime() - timeSearchStarted.getTime(); 
			        System.out.println("The search lasted for: " + elapsed + " milliseconds.");
					
				}
			}
			
		}
		else
		{
			
			System.out.println();
			System.out.println("The search could not be completed as not all entered staff exist.");
			
			
		}
	
	}
	
}
