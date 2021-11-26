import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MemberAccount extends JFrame implements ActionListener
{
	private JButton returnBookButton, issueBookButton, editMyAccountButton, backButton;
	private JPanel panel;

	public IssueBook iBook;
	public ReturnBook rBook;
	public EditMyAccount editMyAccount;
	private DataAccess ds;
	
	static JTable table;
	private JFrame mAccToM, frame1;
	private String[] columnNames = {"Book ID", "Name", "Author", "Edition"};
	

	public MemberAccount()
	{
		super("Member Account");
		
		ds = new DataAccess();
		iBook = new IssueBook();
		rBook = new ReturnBook();
		editMyAccount = new EditMyAccount();
		
		
		panel = new JPanel();
		panel.setLayout(null);

		iBook = new IssueBook();
		rBook = new ReturnBook();
		editMyAccount = new EditMyAccount();
		
		returnBookButton = new JButton("Return Book");
		panel.add(returnBookButton);
		returnBookButton.setBounds(120,120,120,30);
		returnBookButton.addActionListener(this);

		issueBookButton = new JButton("Issue Book");
		panel.add(issueBookButton);
		issueBookButton.setBounds(120,160,120,30);
		issueBookButton.addActionListener(this);

		editMyAccountButton = new JButton("Edit My Account");
		panel.add(editMyAccountButton);
		editMyAccountButton.setBounds(120,200,120,30);
		editMyAccountButton.addActionListener(this);

		backButton = new JButton("Back");
		panel.add(backButton);
		backButton.setBounds(240,240,100,30);
		backButton.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400,460);
		setSize(400,460);
		this.add(panel);
	}
	public void setBackToMemberFrameFromMemberAccount(JFrame ma_m)
	{
		mAccToM = ma_m;
	}
	
	public void showTable()
	{
		frame1 = new JFrame("Database Search Result");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(new BorderLayout()); 
		//TableModel tm = new TableModel();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		//table = new JTable(model);
		table = new JTable();
		table.setModel(model); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		System.out.println("im in show table ");
		String bid = "";
		String name = "";
		String author = "";
		String edition = "";
		try
		{
			//System.out.println("im in try");
			String sql = "select * from issue_book";
			System.out.println("im in try 1.5");
			ResultSet rs  = ds.getData(sql);
			int i = 0;
			//System.out.println("im in try 2");
			while(rs.next())
			{
				System.out.println("im in try 2.5");
				bid= rs.getString("b_id");
				name = rs.getString("name");
				author = rs.getString("author");
				edition = rs.getString("edition");
				model.addRow(new Object[]{bid, name, author, edition});
				i++; 
			}
		}
		catch(Exception ex)
		{
			            System.out.println("dfalskdjfl");

			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		frame1.add(scroll);
		frame1.setVisible(true);
		frame1.setSize(400,300);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String sig=e.getActionCommand();
		if(sig.equals("Return Book")){
			this.setVisible(false);
			rBook.setVisible(true);
			rBook.setBackToMemberAccountFrameFromReturnBook(this);
		}
		else if(sig.equals("Issue Book"))
		{
			showTable();
		}
		else if(sig.equals("Edit My Account"))
		{
			this.setVisible(false);
			editMyAccount.setVisible(true);
			editMyAccount.setBackToMemberAccountFrameFromEditMyAccount(this);
		}
		else if(sig.equals("Back"))
		{
			this.setVisible(false);
			mAccToM.setVisible(true);
		}
	}
}