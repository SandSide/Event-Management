import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.LinkedList;

public class MyGUI{
	private JFrame window, searchWindow;
	private JPanel mainMenuPanel, mainButtonPanel, addStaffInputPanel, staffDisplayPanel, headingPanel, diaryPanel, diaryButtonPanel, backPanel, diaryDisplayPanel;
	private JPanel searchPanel, searchButtonPanel, searchInputPanel, feedbackPanel;
	private JFormattedTextField textField, searchTextField;
	private JList<String> list, diaryList;
	private DefaultListModel<String> listModel, diaryListModel;
	private JButton addStaff, save, deleteStaff, searchStaff, undo, joinMeeting, addMeeting, editDiary, deleteMeeting, searchDiary, home, back, load;
	private JButton searchIndividual, searchGroup, selectCurrentStaff;
	private JLabel inputLabel, searchInputLabel, heading, feedback;
	private JScrollPane listScroller, diaryListScroller;
	private String input = "";
	private String day;
	private TreeNode currentNode;
	private LinkedList<Meeting> currentDiary;
	
	private Tree testTree;
	
	public MyGUI() 
	{
		// create the window
	    window = new JFrame();
	    
	    init();
	    
	    // when window is closed, terminate the program as well		
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	    // set window size
	    window.setSize(600, 600);	
	    
	    // set window title
	    window.setTitle("Event Management");	

	    // make window visible
	    window.setVisible(true);
	    
	    //Centres window on screen
	    window.setLocationRelativeTo(null);
	    
	    window.add(mainMenuPanel); 
	    
	    
	}
	
	public void init()
	{
		testTree = new Tree();
		
		createHeadingPanel();
		createFeedbackPanel();
	    createstaffDisplayPanel();
	    createInputPanel();
	    createMainButtonPanel();
	    createMainMenuPanel();
	    
	    createBackButton();
	    createDiaryButtonPanel();
	    createDiaryDisplayPanel();
	    
	    createSearchInputPanel();
	    createSearchButtonPanel();
	    getUserInput();
	    
	    getSearchUserInput();
	    
	}
	
	public void createMainMenuPanel()
	{
		mainMenuPanel = new JPanel();
		
		heading.setText("Staff Menu");
		
		mainMenuPanel.add(headingPanel);
		mainMenuPanel.add(staffDisplayPanel);
		mainMenuPanel.add(feedbackPanel);
		mainMenuPanel.add(addStaffInputPanel);
		mainMenuPanel.add(mainButtonPanel);
		
		mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));
	}
	
	public void createHeadingPanel()
	{
		headingPanel = new JPanel();
		heading = new JLabel();
		headingPanel.add(heading);
		
		
		heading.setFont(new Font("Arial",1,26));
		
		heading.setHorizontalAlignment(SwingConstants.CENTER);

		headingPanel.setVisible(true);
	}
	
	public void createFeedbackPanel()
	{
		feedbackPanel = new JPanel();
		feedback = new JLabel();
		feedbackPanel.add(feedback);
		
		
		feedback.setHorizontalAlignment(SwingConstants.CENTER);
		feedback.setVisible(true);

		feedbackPanel.setVisible(false);
	}
	
	public void createMainButtonPanel()
	{
		 mainButtonPanel = new JPanel();
		 GridLayout buttonLayout = new GridLayout(0,2,50,30);
		 mainButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		 mainButtonPanel.setLayout(buttonLayout);
		 mainButtonPanel.add(selectCurrentStaff = new JButton("Select this Employee"));
		 mainButtonPanel.add(addStaff = new JButton("Add Staff"));
	     mainButtonPanel.add(deleteStaff = new JButton("Delete Staff"));
	     mainButtonPanel.add(searchStaff = new JButton("Search Staff"));
	     mainButtonPanel.add(save = new JButton("Save Program"));
	     mainButtonPanel.add(load = new JButton("Load Saved Program"));
	    
	     
	     selectCurrentStaff.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  if(list.getSelectedValue() != null)
	    		  {
	    		   String staff = list.getSelectedValue();
		    	   switchToDiaryPanel();
		    	   currentNode = testTree.findTree(staff);
		    	   currentDiary = (testTree.findTree(staff)).getMyMeetings();
		    	   updateDiaryDisplayPanel();
	    		  }
		    	  
		    	  }
	     });
	     
	     addStaff.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
		    	    inputLabel.setText("Enter Name of Employee to Add: ");
		    	    inputLabel.setVisible(true);
		    	    textField.setVisible(true);
		    	    addStaffInputPanel.add(textField);
		    	    addStaffInputPanel.setVisible(true);
		    	  }
	     });
	     
	     
	     
	     deleteStaff.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		    inputLabel.setText("Enter Name of Employee to Delete: ");
		    	    inputLabel.setVisible(true);
		    	    textField.setVisible(true);
		    	  }
	     });
	     
	     searchStaff.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		    
	    		    createSearchWindow();
	    		    searchPanel.add(searchButtonPanel);
	    		    searchPanel.add(searchInputPanel);
	    		    searchInputPanel.setVisible(false);
	    		    
		    	  }
	     });
	     
	     save.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
		    	    
		    	    feedbackPanel.setVisible(true);
		    	    feedback.setText("Program Saved");
		    	    testTree.writeTree();
	    	  }
	     });
	     
	     load.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  feedbackPanel.setVisible(true);
		    	  feedback.setText("Program Loaded");
	    		  testTree.readTree();
	    		  updateStaffDisplayPanel();
		    	  }
	     });
	     	     
	}
	
	public void 
	
	public void createInputPanel()
	{
		addStaffInputPanel = new JPanel();
		inputLabel= new JLabel("Input:");
		
	    textField = new JFormattedTextField(new String(""));
	    textField.setColumns(20);
	    textField.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		        input = textField.getText();
                textField.setValue("");
              

		    });
	   
	    addStaffInputPanel.add(inputLabel);
	    addStaffInputPanel.add(textField);
		
	    addStaffInputPanel.setMaximumSize(new Dimension(500, 100));
		addStaffInputPanel.setBackground(Color.lightGray);
	    textField.setVisible(false);
	    inputLabel.setVisible(false);
	}
	
	public void updateStaffDisplayPanel()
	{
		String[] names = testTree.createArrayOfNames();
		
		listModel.removeAllElements();
		for (int i = 0; i < names.length; i++)
	    {
			if(!(names[i].equals("")))
			{
				listModel.addElement(names[i]);
			}
		    
		}
		
	}
	
	public void createstaffDisplayPanel()
	{
		
		staffDisplayPanel = new JPanel();
		
		listModel = new DefaultListModel<String>();
		
		list = new JList<String>(listModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setSelectedIndex(0);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		
		updateStaffDisplayPanel();
	
		listScroller = new JScrollPane(list);
		
		listScroller.setPreferredSize(new Dimension(500, 400));
		
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		staffDisplayPanel.add(listScroller, BorderLayout.CENTER);
		list.setVisible(true);
		listScroller.setVisible(true);
	}
	
	public void createDiaryButtonPanel()
	{
		 diaryButtonPanel = new JPanel();
		 GridLayout buttonLayout = new GridLayout(0,2,50,30);
		 diaryButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		 diaryButtonPanel.setLayout(buttonLayout);
		 
	     diaryButtonPanel.add(addMeeting = new JButton("Add Meeting"));
	     diaryButtonPanel.add(editDiary = new JButton("Edit Meeting"));
	     diaryButtonPanel.add(deleteMeeting = new JButton("Delete Meeting"));
	     diaryButtonPanel.add(searchDiary = new JButton("Search Diary"));
	     diaryButtonPanel.add(undo = new JButton("Undo Last Change"));
	     
	     updateDiaryDisplayPanel();
	     
	     addMeeting.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
		    	  inputLabel.setText("Enter meeting start: ");
		    	  inputLabel.setVisible(true);
		    	  addStaffInputPanel.setVisible(true);
	    	  }
	     });
	     
	     editDiary.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  
		    	  }
	     });
	     
	     deleteMeeting.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  inputLabel.setText("Enter the day of the meeting to delete: ");
    			  inputLabel.setVisible(true);
    			  addStaffInputPanel.setVisible(true);
    			  textField.setVisible(true);
    		
	    		  
		    	  }
	     });
	     
	     searchDiary.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
		    	   
		    	  }
	     });
	     
	     undo.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		 
		    	  }
	     });
	     	     
	}
	
	public void updateDiaryDisplayPanel()
	{
		int a = 0;
		
		if (currentDiary != null)
		{
			Meeting[] meeting = currentDiary.toArray(new Meeting[currentDiary.size()]);
			diaryListModel.removeAllElements();
			for(int i = 0; i < meeting.length; i++)
			{
				diaryListModel.addElement((meeting[i]).getStartDate() + " " + (meeting[i]).getEndDate() + " " + (meeting[i]).getDescription() + " " + (meeting[i]).getCapacity());
			}
		}
		
	}
	
	public void createDiaryDisplayPanel()
	{
		diaryDisplayPanel = new JPanel();
		
		
		diaryListModel = new DefaultListModel<String>();
		
	
		diaryList = new JList<String>(diaryListModel);

		diaryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		diaryList.setSelectedIndex(0);
		diaryList.setLayoutOrientation(JList.VERTICAL);
		diaryList.setVisibleRowCount(-1);
		
	
		diaryListScroller = new JScrollPane(diaryList);
		
		diaryListScroller.setPreferredSize(new Dimension(500, 400));
		
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) diaryList.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		diaryDisplayPanel.add(diaryListScroller, BorderLayout.CENTER);
		diaryListScroller.setVisible(true);
	}
	
	
	public void createBackButton()
	{
		backPanel = new JPanel();
		
	    backPanel.add(back = new JButton("Back"));
	    
	    back.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		    createMainMenuPanel();
	    		    window.add(mainMenuPanel);
		    	    diaryPanel.setVisible(false);
		    	    mainMenuPanel.setVisible(true);
		    	    backPanel.setVisible(false);
		    	  }
	     });
	    
	}
	
	public void switchToDiaryPanel()
	{
		createDiaryPanel();
	    heading.setText("Diary");
		window.add(diaryPanel);
		diaryPanel.add(addStaffInputPanel);
		diaryPanel.setVisible(true);
		mainMenuPanel.setVisible(false);
		backPanel.setVisible(true);
		addStaffInputPanel.setVisible(false);
		inputLabel.setVisible(false);
		updateDiaryDisplayPanel();
	}
	
	public void createDiaryPanel()
	{
		diaryPanel = new JPanel();
		
		diaryPanel.add(headingPanel);
		diaryPanel.add(diaryDisplayPanel);
		diaryPanel.add(addStaffInputPanel);
		diaryPanel.add(diaryButtonPanel);
		diaryPanel.add(backPanel);
		
		diaryPanel.setLayout(new BoxLayout(diaryPanel, BoxLayout.Y_AXIS));
		
		diaryPanel.setVisible(false);
	}
	
	public void createSearchButtonPanel()
	{
		
		 searchButtonPanel = new JPanel();
		 Box box = Box.createVerticalBox();    // vertical box
		   
	     searchIndividual = new JButton("Search for an Individual Staff Member");
	     searchGroup = new JButton("Search For Mutiple Staff to Compare Potential Meeting Times");
	     
	     box.add(searchIndividual);
	     box.add(Box.createVerticalStrut(25));
		 box.add(searchGroup);
	  
	     searchButtonPanel.add(box);
	     searchIndividual.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
		    	  searchInputLabel.setText("Enter Employee Name: ");
		    	  searchInputLabel.setVisible(true);
		    	  searchInputPanel.setVisible(true);
	    	  }
	     });
	     
	     searchGroup.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  searchInputLabel.setText("Enter Employee Names separated by a comma");
	    		  searchInputLabel.setVisible(true);
	    		  searchInputPanel.setVisible(true);
		    	  }
	    	  
	     });
	     
	}
	
	public void createSearchWindow()
	{
		searchWindow = new JFrame();
		searchPanel = new JPanel();
		
		searchPanel.add(searchButtonPanel);
		searchPanel.add(searchInputPanel);
		
		searchWindow.add(searchPanel);

	    // set window size
	    searchWindow.setSize(550, 300);	
	    
	    // set window title
	    searchWindow.setTitle("Event Management");	

	    // make window visible
	    searchWindow.setVisible(true);
	    
	    //Centres window on screen
	    searchWindow.setLocationRelativeTo(null);
	}
	
	public void createSearchInputPanel()
	{
		searchInputPanel = new JPanel();
		searchInputLabel= new JLabel("Input:");
		
	    searchTextField = new JFormattedTextField(new String(""));
	    searchTextField.setColumns(20);
	    
	   
	    searchInputPanel.add(searchInputLabel);
	    searchInputPanel.add(searchTextField);
		
	    searchInputPanel.setMaximumSize(new Dimension(400, 100));
		searchInputPanel.setBackground(Color.lightGray);
	    searchTextField.setVisible(true);
	    searchInputLabel.setVisible(true);
	}
	
	public void getSearchUserInput()
	{
	    searchTextField.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        input = searchTextField.getText();
                searchTextField.setValue("");
		      }
		    });
	}

	
	public static void main(String [] args)
	  {
		 javax.swing.SwingUtilities.invokeLater(new Runnable()
		  {
		      public void run()
		      {
		          runprogram();
		      }
		  });
	  }
	      
	  public static void runprogram()
	  {
		  new MyGUI();
	  }
	  
	  
}

