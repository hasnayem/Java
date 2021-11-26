import java.awt.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Member extends JFrame implements ActionListener
{
	private JButton myAccountButton, searchButton, logOutButton;
	private JLabel bookNameLabel;
	private JTextField bookNameTextField; 
	private JPanel panel;
	private JFrame mToA, frame2;
	public MemberAccount memberAcc;
	private DataAccess ds;
	static JTable table;
	private String[] columnNames = {"Book ID", "Name", "Author", "Edition","Number oF Books"};
	

	public Member()
	{
		super("Member");
		panel = new JPanel();
		panel.setLayout(null);

		memberAcc = new MemberAccount();
		DataAccess 	ds = new DataAccess();

		bookNameLabel = new JLabel("Book ID:");
		panel.add(bookNameLabel);
		bookNameLabel.setBounds(70,100,80,30);

		bookNameTextField = new JTextField(10);
		panel.add(bookNameTextField);
		bookNameTextField.setBounds(150,100,100,30);

		searchButton = new JButton("Search");
		panel.add(searchButton);
		searchButton.setBounds(260,100,80,30);
		searchButton.addActionListener(this);

		myAccountButton = new JButton("My Account");
		panel.add(myAccountButton);
		myAccountButton.setBounds(70,150,100,30);
		myAccountButton.addActionListener(this);

		logOutButton = new JButton("Log Out");
		panel.add(logOutButton);
		logOutButton.setBounds(190,150,80,30);
		logOutButton.setBackground(Color.RED);
		logOutButton.addActionListener(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400,460);
		setSize(400,460);
		this.add(panel);
	}

	public void showSearchedBook()
	{
		frame2 = new JFrame("Database Search Result");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(new BorderLayout()); 
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
		//System.out.println("im in show table ");
		String bid = "";
		String name = "";
		String author = "";
		String edition = "";
		String number = "";
		try
		{
			//System.out.println("im in try");
			String sql = "select * from book_info where b_id='"+bookNameTextField.getText()+"'";
			//ystem.out.println("im in try 1.5");
			ResultSet rs  = ds.getData(sql);
			int i = 0;
			//System.out.println("im in try 2");
			while(rs.next())
			{
				//System.out.println("im in try 2.5");
				bid= rs.getString("b_id");
				name = rs.getString("name");
				author = rs.getString("author");
				edition = rs.getString("edition");
				number = rs.getString("book_number");

				model.addRow(new Object[]{bid, name, author, edition,number});
				i++; 
			}
		}
		catch(Exception ex)
		{
			// System.out.println("dfalskdjfl");

			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		frame2.add(scroll);
		frame2.setVisible(true);
		frame2.setSize(400,300);
				setLocation(480,540);

	}
	public void actionPerformed(ActionEvent e)
	{
		String sig=e.getActionCommand();
		if(sig.equals("My Account"))
		{
			this.setVisible(false);
			memberAcc.setVisible(true);
			memberAcc.setBackToMemberFrameFromMemberAccount(this);
		}
		else if(sig.equals("Log Out"))
		{
			System.exit(0);
		}
		else if(sig.equals("Search"))
		{
			showSearchedBook();
		}
	}
}