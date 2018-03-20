import java.util.Scanner;

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
	public TreeNode findTree(String name) 
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
	public boolean addNewTree(String name) 
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
			if (this.findTree(name) != null) 
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
		if(this.findTree(name) == null)
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
			System.out.println("The TreeNode was deleted.");
			
		}
		
		// If ID does exist in the Tree and was not deleted.
		else if(this.findTree(name) != null)
		{
			
			// Display a message stating it was not deleted.
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
	
	public void searchGroup()
	{
		
		Scanner S8 = new Scanner(System.in);
		String names;
		
		System.out.println("Please enter group of people seperated by , ");
		names = S8.next();
		
		String[] parts = names.split(",");
		
		for(int i = 0; i < parts.length; i++) 
		{
			
			
			
			
			
		}
		
		
		
		
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
		
		Tree T = new Tree();
		T.addNewTree("A");
		T.addNewTree("B");
		T.addNewTree("C");
		T.addNewTree("D");
		T.addNewTree("E");
		T.addNewTree("F");
		T.addNewTree("G");
		T.addNewTree("H");
		T.addNewTree("J");
		T.addNewTree("K");
		T.addNewTree("L");
		T.addNewTree("M");
		T.addNewTree("N");
		T.addNewTree("O");
		T.addNewTree("sim");
		T.addNewTree("BoB");
		T.addNewTree("sim");
		T.traverseTree(T.getRoot());
		T.deleteTreeNode("E");
		T.traverseTree(T.getRoot());

	}
}
