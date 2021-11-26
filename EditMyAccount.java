import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditMyAccount extends JFrame implements ActionListener{
	private Button saveButton;
	private TextField currentNameText, currentMobileText, currentMailText;
	private TextField newNameText, newMobileText, newMailText;
	private Label nameLabel, mobileLabel, mailLabel;

	private JFrame eMAToMA;

	public EditMyAccount(){
		super("Edit My Account");
	
		nameLabel = new Label("Name: ");
		currentNameText = new TextField(10);
		newNameText = new TextField(10);
		mobileLabel = new Label("Mobile: ");
		currentMobileText = new TextField(10);
		newMobileText = new TextField(10);
		mailLabel = new Label("Mail: ");
		currentMailText = new TextField(10);
		newMailText = new TextField(10);
		saveButton = new Button("Save");
		
		add(nameLabel);
		add(currentNameText);
		add(newNameText);
		add(mailLabel);
		add(currentMobileText);
		add(newMobileText);
		add(mailLabel);
		add(currentMailText);
		add(newMailText);
		add(saveButton);
		
		saveButton.addActionListener(this);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1200,100);
		setSize(600,700);
		
	}
	public void setBackToMemberAccountFrameFromEditMyAccount(JFrame ema_ma){
		eMAToMA = ema_ma;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Save")){
			this.setVisible(false);
			eMAToMA.setVisible(true);
		}
	}
}