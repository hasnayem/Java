import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BookInfo extends JFrame implements ActionListener
{

	private JButton addButton, deleteButton, searchButton, backButton, clearButton;
	private JLabel bookIDLabel, bookNameLabel, authorNameLabel, editionLabel, numberOfBooksLabel, availableBookLabel, deleteBookLabel, bookIDLabelSearch ;
	private JLabel bookNameLabel1, authorNameLabel1, editionLabel1, numberOfBooksLabel1;
	private JLabel bookNameLabel2, authorNameLabel2, editionLabel2, numberOfBooksLabel2;
	private JTextField bookIDTextField, bookNameTextField, authorNameTextField, editionTextField, numberofBooksTextField, availableBookTextField, deleteBookTextField, bookIDTextFieldSearch;
	private JPanel panel;

	private JFrame bToA;
	
	public BookInfo()
	{
		super("Book Information");
		panel = new JPanel();
		panel.setLayout(null);

		bookIDLabel = new JLabel("Book ID:");
		panel.add(bookIDLabel);
		bookIDLabel.setBounds(100,80,100,30);

		bookIDTextField = new JTextField(10);
		panel.add(bookIDTextField);
		bookIDTextField.setBounds(210,80,100,30);

		

		bookNameLabel = new JLabel("Book Name:");
		panel.add(bookNameLabel);
		bookNameLabel.setBounds(100,120,100,30);

		bookNameTextField = new JTextField(10);
		panel.add(bookNameTextField);
		bookNameTextField.setBounds(210,120,100,30);

		authorNameLabel = new JLabel("Author Name:");
		panel.add(authorNameLabel);
		authorNameLabel.setBounds(100,160,100,30);

		authorNameTextField = new JTextField(10);
		panel.add(authorNameTextField);
		authorNameTextField.setBounds(210,160,100,30);

		editionLabel= new JLabel("Edition:");
		panel.add(editionLabel);
		editionLabel.setBounds(100,200,100,30);

		editionTextField = new JTextField(10);
		panel.add(editionTextField);
		editionTextField.setBounds(210,200,100,30);

		numberOfBooksLabel= new JLabel("Book Number:");
		panel.add(numberOfBooksLabel);
		numberOfBooksLabel.setBounds(100,240,100,30);

		numberofBooksTextField = new JTextField(10);
		panel.add(numberofBooksTextField);
		numberofBooksTextField.setBounds(210,240,100,30);

		addButton = new JButton("ADD");
		panel.add(addButton);
		addButton.addActionListener(this);
		addButton.setBounds(300,280,60,30);

		clearButton = new JButton("Clear");
		panel.add(clearButton);
		clearButton.addActionListener(this);
		clearButton.setBounds(200,280,80,30);
		clearButton.setVisible(false);

		availableBookLabel= new JLabel("Avilable Books:");
		panel.add(availableBookLabel);
		availableBookLabel.setBounds(100,340,100,30);

		availableBookTextField = new JTextField(10);
		panel.add(availableBookTextField);
		availableBookTextField.setBounds(210,340,100,30);

		deleteBookLabel= new JLabel("Delete Book:");
		panel.add(deleteBookLabel);
		deleteBookLabel.setBounds(100,380,100,30);

		deleteBookTextField = new JTextField(10);
		panel.add(deleteBookTextField);
		deleteBookTextField.setBounds(210,380,100,30);

		deleteButton = new JButton("Delete");
		panel.add(deleteButton);
		deleteButton.addActionListener(this);
		deleteButton.setBounds(300,420,80,30);

		backButton = new JButton("Back");
		panel.add(backButton);
		backButton.addActionListener(this);
		backButton.setBounds(420,460,80,30);

		bookIDLabelSearch = new JLabel("Book ID:");
		panel.add(bookIDLabelSearch);
		bookIDLabelSearch.setBounds(420,60,100,30);

		bookIDTextFieldSearch = new JTextField(10);
		panel.add(bookIDTextFieldSearch);
		bookIDTextFieldSearch.setBounds(530,60,100,30);

		searchButton = new JButton("Search");
		panel.add(searchButton);
		searchButton.addActionListener(this);
		searchButton.setBounds(640,60,80,30);




		bookNameLabel1 = new JLabel("Book Name:");
		panel.add(bookNameLabel1);
		bookNameLabel1.setBounds(440,120,100,30);

		authorNameLabel1 = new JLabel("Author Name:");
		panel.add(authorNameLabel1);
		authorNameLabel1.setBounds(440,160,100,30);

		editionLabel1 = new JLabel("Edition:");
		panel.add(editionLabel1);
		editionLabel1.setBounds(440,200,100,30);

		numberOfBooksLabel1 = new JLabel("Book Number:");
		panel.add(numberOfBooksLabel1);
		numberOfBooksLabel1.setBounds(440,240,100,30);

		bookNameLabel2 = new JLabel("----");
		panel.add(bookNameLabel2);
		bookNameLabel2.setBounds(550,120,100,30);

		authorNameLabel2 = new JLabel("----");
		panel.add(authorNameLabel2);
		authorNameLabel2.setBounds(550,160,100,30);

		editionLabel2 = new JLabel("-----");
		panel.add(editionLabel2);
		editionLabel2.setBounds(550,200,100,30);

		numberOfBooksLabel2 = new JLabel("----");
		panel.add(numberOfBooksLabel2);
		numberOfBooksLabel2.setBounds(550,240,100,30);



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800,600);
		setSize(800,600);
		this.add(panel);
	}

	public void setBackToAdminFrameFromBookInfo(JFrame b_a)
	{
		bToA = b_a;
	}

	public void searchBook()
	{
		String sql = "select * from book_info where b_id='"+bookIDTextFieldSearch.getText()+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getData(sql);
		//System.out.println("ho bhai jinish chole");
		//String bookte;
		/*while(rs.next())
		{
		bookNameLabel2.setText(rs.getString("b_id"));
			//bookNameTextLable2.setText(rs.getString("name").toString());
		}
		bookNameLabel2.setText(rs.getString("b_id"));
		*/	
		
		

	}

	public void actionPerformed(ActionEvent e)
	{
		String sig=e.getActionCommand();
		if(sig.equals("Back"))
		{
			this.setVisible(false);
			bToA.setVisible(true);
		}

		else if(sig.equals("Search"))
		{
			searchBook();
		}
	}		
}