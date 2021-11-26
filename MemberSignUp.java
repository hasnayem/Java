import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MemberSignUp extends JFrame implements ActionListener{
	private JButton saveButton;
	private JTextField nameText, mobileText, mailText, usernameText, passText;
	private JLabel name, mobile, mail, username, pass;
	private JPanel panel;

	public CompleteSignup comSup;

	private JFrame mSUToMLI;

	public MemberSignUp(){
		super("Sign Up");
		panel = new JPanel();
		panel.setLayout(null);

		comSup = new CompleteSignup();


		name = new JLabel("Name: ");
		panel.add(name);
		name.setBounds(100,100,80,30);

		nameText = new JTextField(10);
		panel.add(nameText);
		nameText.setBounds(200,100,100,30);

		mobile = new JLabel("Mobile: ");
		panel.add(mobile);
		mobile.setBounds(100,140,80,30);

		mobileText = new JTextField(10);
		panel.add(mobileText);
		mobileText.setBounds(200,140,100,30);

		mail = new JLabel("E-Mail: ");
		panel.add(mail);
		mail.setBounds(100,180,80,30);

		mailText = new JTextField(10);
		panel.add(mailText);
		mailText.setBounds(200,180,100,30);

		username = new JLabel("User Name: ");
		panel.add(username);
		username.setBounds(100,220,80,30);


		usernameText = new JTextField(10);
		panel.add(usernameText);
		usernameText.setBounds(200,220,100,30);


		pass = new JLabel("Passward: ");
		panel.add(pass);
		pass.setBounds(100,260,80,30);


		passText = new JTextField(10);
		panel.add(passText);
		passText.setBounds(200,260,100,30);

		saveButton = new JButton("Save");
		panel.add(saveButton);
		saveButton.setBounds(260,310,70,30);
		saveButton.addActionListener(this);
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(480,640);
		setSize(480,640);
	
		this.add(panel);
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		return flag;
	}
	private boolean isValidEmail(String e){
		boolean flag=true;
		int atIdx=e.indexOf("@");
		int dotIdx=e.indexOf(".");
		if(dotIdx<atIdx)flag=false;
		return flag;
	}


	public void setMemberSignUpToMemberLogIn(JFrame msu_mli)
	{
		mSUToMLI = msu_mli;
	}

	public void signUp()
	{
		String m;
		if(nameText.getText().equals("") || mobileText.getText().equals("") || mailText.getText().equals("") || passText.getText().equals("") || usernameText.getText().equals(""))
		{
				m="All fields are mandatory";
		}
		else if(!isValidEmail(mailText.getText()))
		{
			m="Invalid Email";
		}
		else
		{
			DataAccess da = new DataAccess();
			String sql = "insert into member(m_id,name,mobile,email) values('"+usernameText.getText()+"','"
																			+nameText.getText()+"','"+mobileText.getText()+"','"+mailText.getText()+"')";

			String sql1 = "insert into login(id,password,type) values('"+usernameText.getText()+"','"+passText.getText()+"','1')";
			da.updateDB(sql);
			da.updateDB(sql1);
			m = "Sign up successfull";
			
		}
		JOptionPane.showMessageDialog(this,m);
	}
	public void actionPerformed(ActionEvent e)
	{
		String sig=e.getActionCommand();
		if(sig.equals("Save"))
		{
			signUp();
			this.setVisible(false);
			comSup.setVisible(true);
			comSup.setBackMemberLogInFromCompleteSignUp(mSUToMLI);
		}
	}


}