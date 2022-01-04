import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
public class LoginGUI extends JFrame implements ActionListener {
	JPanel Panel;
	JLabel AccountLabel;JTextField AccountField;
	JLabel PwLabel;JPasswordField PwField;JCheckBox ShowPw;
	JButton EnterButton;
	LoginGUI(){
		//Set Account
		AccountLabel = new JLabel("User");
		AccountLabel.setBounds(10,20,80,25);
		AccountField= new JTextField(20);
		AccountField.setBounds(100,20,165,25);
		//Set Password
		PwLabel = new JLabel("Password");
		PwLabel .setBounds(10,60,80,25);
		PwField= new JPasswordField(8);
		PwField.setBounds(100,60,165,25);
		ShowPw=new JCheckBox("Show PW");
		ShowPw.setBounds(10,100,200,40);
		//Enter Button
		EnterButton = new JButton("Enter");
		EnterButton.setBounds(10,140,100,25);
		//Panel
		Panel= new JPanel();
		Panel.setLayout(null);
		Panel.add(AccountLabel);
		Panel.add(AccountField);
		Panel.add(PwLabel);
		Panel.add(PwField);
		Panel.add(ShowPw);
		Panel.add(EnterButton);
		//adding listeners
		EnterButton.addActionListener(this);
		//Frame
		setTitle("User Login");
		add(Panel,BorderLayout.CENTER);
		setBounds(20,50,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args)  {
		new LoginGUI();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
		String FileStr;
		String isLogin="false";
		String FileArray[];
		String UserAccount = AccountField.getText();
		String UserPassword= new String (PwField.getPassword());
		BufferedReader buf= new BufferedReader(new FileReader("UserAccount.txt"));
		while(((FileStr=buf.readLine())!=null)) {
			FileArray= FileStr.split(" ");
			String Account = FileArray[0];
			String Pw= FileArray[1];
			String type = FileArray[2];
			isLogin  = FileArray[3];
			if(isLogin.equals("true")) {
				JOptionPane.showMessageDialog(this,"Dont enter twice");
			}
			else if((UserAccount.equals(Account))&&(UserPassword.equals(Pw))) {
				JOptionPane.showMessageDialog(this,"Welcome");
				if(type.equals("Stu")) {
					JOptionPane.showMessageDialog(this,"Welcome Stu");
					Home1 h1= new Home1();
					h1.StudentAccount=Account;
					h1.StudentPassword=Pw;
					//isLogin
					isLogin="true";
					h1.setVisible(true);
				}
				else if(type.equals("Tea")) {
					JOptionPane.showMessageDialog(this,"Welcome Tea");
					Home2 h2= new Home2();
					h2.TeacherAccount=Account;
					h2.TeacherPassword=Pw;
					//isLogin
					isLogin="true";
					h2.setVisible(true);
				}
				else if(type.equals("Sys")) {
					JOptionPane.showMessageDialog(this,"Welcome Sys");
					Home3 h3= new Home3();
					h3.SystemAccount=Account;
					h3.SystemPassword=Pw;
					deleteStrToFile(Account+" "+Pw+" "+"Sys false\r\n");
					appendStrToFile(Account+" "+Pw+" "+"Sys true\r\n");
					isLogin="true";
					h3.setVisible(true);
				}
				this.dispose();
				break;
			}
		}
		if(isLogin.equals("false")) JOptionPane.showMessageDialog(this, "Wrong Account or Password");
		buf.close();
		}catch(IOException e10) {
			JOptionPane.showMessageDialog(this, "Wrong");
			e10.printStackTrace();
		}
	}
	
	//change txt function
		public void appendStrToFile(String str) {
			try {
				BufferedWriter buf= new BufferedWriter(new FileWriter("UserAccount.txt",true));
				buf.write(str);
				buf.close();
			}catch(IOException e10){
				JOptionPane.showMessageDialog(this, "Wrong");
				e10.printStackTrace();
			}
		}
		public void deleteStrToFile(String str) {
			try {

				File inputFile = new File("UserAccount.txt"); 
				File tempFile = new File("tempFile.txt"); 
				BufferedReader reader = new BufferedReader(new FileReader(inputFile)); 
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile)); 
				String lineToRemove = str; 
				String currentLine; 
				 
				while((currentLine = reader.readLine()) != null) { 
				    String trimmedLine = currentLine.trim();
				    if(trimmedLine.equals(lineToRemove)) continue;
				    writer.write(currentLine + System.getProperty("line.separator")); 
				} 
				writer.close();  
				reader.close();  
				boolean successful= tempFile.renameTo(inputFile); 
			}catch(IOException e10) {
				JOptionPane.showMessageDialog(this, "Wrong");
				e10.printStackTrace();
			}		
		}
}

