import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MemberInfo extends JFrame implements ActionListener
{

	private JButton searchButton, deleteButton, backButton;
	private JLabel memberIDLabel, deleteMemberLabel;
	private JTextField memberIDTextField, deleteMemberTextField;
	private JPanel panel;

	private DataAccess ds;
	static JTable table;

	private JFrame mToA, frame2;

	private String[] columnName = {"ID", "Name", "Mobile", "Email"};
	
	public MemberInfo()
	{
		super("Member Information");

		ds = new DataAccess();
		panel = new JPanel();
		panel.setLayout(null);


		memberIDLabel = new JLabel("Member ID: ");
		panel.add(memberIDLabel);
		memberIDLabel.setBounds(80,100,100,30);

		memberIDTextField = new JTextField(10);
		panel.add(memberIDTextField);
		memberIDTextField.setBounds(170,100,120,30);

		searchButton = new JButton("Search");
		panel.add(searchButton);
		searchButton.addActionListener(this);
		searchButton.setBounds(300,100,80,30);

		deleteMemberLabel = new JLabel("Delete Member: ");
		panel.add(deleteMemberLabel);
		deleteMemberLabel.setBounds(80,150,100,30);

		deleteMemberTextField = new JTextField(10);
		panel.add(deleteMemberTextField);
		deleteMemberTextField.setBounds(170,150,120,30);

		deleteButton = new JButton("Delete");
		panel.add(deleteButton);
		deleteButton.addActionListener(this);
		deleteButton.setBounds(300,150,80,30);

		backButton = new JButton("Back");
		panel.add(backButton);
		backButton.addActionListener(this);
		backButton.setBounds(170,200,80,30);

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(480,540);
		setSize(480,540);
		this.add(panel);
	}
	public void setBackToAdminFrameFromMemberInfo(JFrame m_a)
	{
		mToA = m_a;
	}

	public void showTableData()
	{
		frame2 = new JFrame("Database Search Result");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(new BorderLayout()); 
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnName);
		table = new JTable();
		table.setModel(model); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		//String textvalue = memberIDTextField.getText();

		String mid = "";
		String name = "";
		String mobile = "";
		String email = "";
		try
		{
			String sql = "select * from member where m_id='"+memberIDTextField.getText()+"'";

			//String sql = "select * from member where m_id = "+ textvalue;
			ResultSet rs  = ds.getData(sql);
			int i = 0;
			while(rs.next())
			{
				mid= rs.getString("m_id");
				name = rs.getString("name");
				mobile = rs.getString("mobile");
				email = rs.getString("email");
				model.addRow(new Object[]{mid, name, mobile, email});
				i++; 
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		frame2.add(scroll);
		frame2.setVisible(true);
		frame2.setSize(400,300);
		setLocation(480,540);	
	}
	public void deleteMember()
	{
		String sql = "DELETE FROM member WHERE m_id='"+deleteMemberTextField.getText()+"'";
		String sql1 = "DELETE FROM login WHERE id='"+deleteMemberTextField.getText()+"'";
		DataAccess da = new DataAccess();
		da.updateDB(sql);
		da.updateDB(sql1);
	}
	public void actionPerformed(ActionEvent e)
	{
		String sig=e.getActionCommand();
		if(sig.equals("Back"))
		{
			this.setVisible(false);
			mToA.setVisible(true);
		}
		else if(sig.equals("Search"))
		{
			showTableData();
		}
		else if(sig.equals("Delete"))
		{
			deleteMember();
		}
	}	
}