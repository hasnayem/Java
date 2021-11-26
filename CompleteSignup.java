import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CompleteSignup extends JFrame implements ActionListener
{
	private JButton loginButton;
	private JLabel welcomeLabel;
	private JPanel panel;

	public JFrame cSUToMLI;

	public CompleteSignup()
	{
		super("Sign Up Complete");
		panel = new JPanel();
		panel.setLayout(null);

		welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(welcomeLabel);
		welcomeLabel.setBounds(45,80,160,50);

		loginButton = new JButton("Log In");	
		panel.add(loginButton);
		loginButton.addActionListener(this);
		loginButton.setBounds(80,150,70,30);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(250,300);
		setSize(250,300);
		
		this.add(panel);
		
	}
	public void setBackMemberLogInFromCompleteSignUp(JFrame csu_mli)
	{
		cSUToMLI = csu_mli;
	}
	public void actionPerformed(ActionEvent e)
	{
		String sig=e.getActionCommand();
		if(sig.equals("Log In"))
		{
			cSUToMLI.setVisible(true);
			this.setVisible(false);
		}
	}
}