import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener
{
	private JButton memberButton, bookButton, logOutButton;
	private JLabel adminInfoLabel, adminNameLabel, adminMobileLabel, adminEmailLabel, adminIDLabel;
	private JPanel panel;

	public MemberInfo mi;
	public BookInfo bi;
	
	public Admin()
	{
		super("Admin");
		
		mi = new MemberInfo();
		bi = new BookInfo();

		panel = new JPanel();
		panel.setLayout(null);

		adminInfoLabel = new JLabel("Admin Information:");
		panel.add(adminInfoLabel);
		adminInfoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		adminInfoLabel.setBounds(40,80,200,30);

		adminNameLabel = new JLabel("Admin Name: ");
		panel.add(adminNameLabel);
		adminNameLabel.setBounds(40,100,80,30);

		//nameText = new JTextField(10);
		//panel.add(nameText);
		//nameText.setBounds(200,100,100,30);

		adminMobileLabel = new JLabel("Mobile: ");
		panel.add(adminMobileLabel);
		adminMobileLabel.setBounds(40,140,80,30);

		//mobileText = new JTextField(10);
		//panel.add(mobileText);
		//mobileText.setBounds(200,140,100,30);

		adminEmailLabel = new JLabel("E-Mail: ");
		panel.add(adminEmailLabel);
		adminEmailLabel.setBounds(40,180,80,30);

		//mailText = new JTextField(10);
		//panel.add(mailText);
		//mailText.setBounds(200,180,100,30);

		adminIDLabel = new JLabel("Admin ID: ");
		panel.add(adminIDLabel);
		adminIDLabel.setBounds(40,220,80,30);


		//usernameText = new JTextField(10);
		//panel.add(usernameText);
		//usernameText.setBounds(200,220,100,30);
		
		memberButton = new JButton("Member");
		panel.add(memberButton);
		memberButton.addActionListener(this);
		memberButton.setBounds(270,100,100,30);

		bookButton = new JButton("Book");
		panel.add(bookButton);
		bookButton.addActionListener(this);
		bookButton.setBounds(270,150,100,30);

		logOutButton = new JButton("Log Out");
		panel.add(logOutButton);
		logOutButton.addActionListener(this);
		logOutButton.setBounds(300,200,80,30);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(480,540);
		setSize(480,540);
		this.add(panel);
	}
	public void actionPerformed(ActionEvent e)
	{
		String sig=e.getActionCommand();
		if(sig.equals("Member"))
		{
			this.setVisible(false);
			mi.setVisible(true);
			mi.setBackToAdminFrameFromMemberInfo(this);
		}
		else if(sig.equals("Book"))
		{
			this.setVisible(false);
			bi.setVisible(true);
			bi.setBackToAdminFrameFromBookInfo(this);
		}
		else if(sig.equals("Log Out"))
		{
			System.exit(0);
		}
	}
}