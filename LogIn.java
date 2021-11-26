
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LogIn extends JFrame implements ActionListener
{

	private JButton memberLogInButton, memberSignUpButton;
	private JTextField memberIDTextField;
	private JPasswordField password;
	private Label memberIDLabel, memberPassLabel;
	private JPanel panel;
	public MemberSignUp memberSignUp;
	public Member member;
	private DataAccess ds;
	private Admin admin;

	public LogIn()
	{
		super("Log In");
		panel = new JPanel();
		panel.setLayout(null);

		ds = new DataAccess();
		admin = new Admin();
		member = new Member();
		memberSignUp = new MemberSignUp();

		memberIDLabel = new Label("ID:");
		panel.add(memberIDLabel);
		memberIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
		memberIDLabel.setBounds(120,120,100,30);

		memberIDTextField = new JTextField(10);
		panel.add(memberIDTextField);
		memberIDTextField.setBounds(230,120,100,30);

		memberPassLabel = new Label("Password:");
		panel.add(memberPassLabel);
		memberPassLabel.setFont(new Font("Arial", Font.BOLD, 15));
		memberPassLabel.setBounds(120,160,100,30);

		password = new JPasswordField(10);
		panel.add(password);
		password.setBounds(230,160,100,30);

		memberLogInButton = new JButton("LogIn");
		panel.add(memberLogInButton);
		memberLogInButton.setBounds(100,210,100,30);
		memberLogInButton.addActionListener(this);

		memberSignUpButton = new JButton("SignUp");
		panel.add(memberSignUpButton);
		memberSignUpButton.setBounds(220,210,100,30);
		memberSignUpButton.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocation(480,640);
		setSize(480,640);
		this.add(panel);
	}
	public int  checkLogIn()
	{
			//System.out.println("im in try");
		
		
    	String sql = "select * from login where id='"+ memberIDTextField.getText() +"' and password='"+ password.getText() +"'";
		try
		{			
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			while(rs.next())
			{
				//for flag = 1 it is admin
				//for flag = 2 it is member
				if(rs.getString("type").equals("0"))
				{
					return 0;
				}
				else if(rs.getString("type").equals("1"))
				{
					return 1;
				}
				
			}
		}
		
		catch(Exception ex)
		{
		    System.out.println("dfalskdjfl");

			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		return 3;
	}
	public void actionPerformed(ActionEvent e)
	{
		String sig = e.getActionCommand();
		if(sig.equals("LogIn"))
		{
			if(checkLogIn() == 0)
			{
				this.setVisible(false);
				admin.setVisible(true);
			}
			else if(checkLogIn() == 1)
			{
				this.setVisible(false);
				member.setVisible(true);
			}
			else if(checkLogIn() == 3)
			{
				JOptionPane.showMessageDialog(null, "Please SignUp first.");
			}
		}
		else if(sig.equals("SignUp"))
		{
			this.setVisible(false);
			memberSignUp.setVisible(true);
			memberSignUp.setMemberSignUpToMemberLogIn(this);
		}
	}
}