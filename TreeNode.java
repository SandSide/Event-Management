import java.util.LinkedList;

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

	
}
