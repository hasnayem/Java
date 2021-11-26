import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IssueBook extends JFrame implements ActionListener{
	private Button backButton;
	
	private JFrame iBToMA;
	
	public IssueBook(){
		super("Issue Book");
		
		backButton = new Button("Back");
		add(backButton);
		backButton.addActionListener(this);
		//backButton.setBounds();
		
		setLayout(new FlowLayout());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1200,100);
		setSize(600,700);
	}
	public void setBackToMemberAccountFrameFromIssueBook(JFrame ma_ib){
		iBToMA = ma_ib;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Back")){
			this.setVisible(false);
			iBToMA.setVisible(true);
		}
	}
}