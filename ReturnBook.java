import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReturnBook extends JFrame implements ActionListener{

	private Button backButton;

	private JFrame rBToMA;

	public ReturnBook(){

		super("Return Books");
		
		backButton = new Button("Back");

		add(backButton);

		backButton.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1200,100);
		setSize(600,700);
		
		//backButton.setBounds(200,200,15,5);
	}
	public void setBackToMemberAccountFrameFromReturnBook(JFrame ma_rb){
		rBToMA = ma_rb;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Back")){
			this.setVisible(false);
			rBToMA.setVisible(true);
		}
	}
}