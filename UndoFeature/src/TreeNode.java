import java.util.LinkedList;

public class TreeNode {
	
	public String name;
	public TreeNode left;
	public TreeNode right;
	private Diary myDiary;

	
	public TreeNode(String staff) 
	{
		name = staff;
		myDiary = new Diary();
		left = null;
		right = null;
	}
	
	
	public LinkedList<Meeting> getMyMeetings()
	{
		return myDiary.getMyMeetings(); 
		
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