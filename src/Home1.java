import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class Home1 extends JFrame implements ActionListener{
	String UserAccountthis;
	String UserPasswordthis;
	static String UserAccount,UserPassword;
	Home1(String UserAccount,String UserPassword){
		UserAccountthis=UserAccount;
		UserPasswordthis=UserPassword;
		//Button
		JButton Leave = new JButton("Leave");
		Leave.setBounds(10,20,80,25);
		JButton Edit = new JButton("Edit");
		Edit.setBounds(10,20,80,25);
		//監聽
		Leave.addActionListener(this);
		Edit.addActionListener(this);
		//Panel
		JPanel Panel = new JPanel();
		
		Panel.add(Leave);
		Panel.add(Edit);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
		add(Panel);
		setTitle("Welcome H1");  
	    setSize(400, 200);  
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String buttonName= e.getActionCommand();
			if(buttonName.equals("Leave")) {
				JOptionPane.showMessageDialog(this, "Leaving");
			}
			else  {
				JOptionPane.showMessageDialog(this, "Edit");
			}
		}catch(Exception e10) {
			e10.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Home1(UserAccount,UserPassword);	
	}
}
