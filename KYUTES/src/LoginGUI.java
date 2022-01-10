import javax.swing.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.*;
public class LoginGUI extends JFrame implements ActionListener {
	JPanel Panel;
	JLabel AccountLabel;JTextField AccountField;
	JLabel PwLabel;JPasswordField PwField;JCheckBox ShowPw;
	JButton EnterButton;
	String connectionUrl = "jdbc:mysql://localhost:3306/useraccount?serverTimezone=UTC";
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
		PwField.setEchoChar('*');
		ShowPw.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					PwField.setEchoChar((char)0);
				}
				else {
					PwField.setEchoChar('*');
				}
			}
		});
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
		setLocationRelativeTo(null);
	}
	public static void main(String[] args)  {
		new LoginGUI();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		try(Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")) {
		Statement stat = conn.createStatement();
		String UserAccount = AccountField.getText();
		String UserPassword= new String (PwField.getPassword());
		String sql1 = "select * from useraccount where iduser_account ="+"'"+UserAccount+"'"+"and password="+"'"+UserPassword+"'";
		String sql2 = "Update useraccount SET isLogin='true'  where iduser_account ="+"'"+UserAccount+"'"+"and password="+"'"+UserPassword+"'";
		ResultSet rsResultSet = stat.executeQuery(sql1);
		if(rsResultSet.next()) {
			String isLogin= rsResultSet.getString("isLogin");
			if(isLogin.equals("true")) {
				JOptionPane.showMessageDialog(this,"Dont enter twice");
			}
			else  {
				String type= rsResultSet.getString("type");
				JOptionPane.showMessageDialog(this,"Welcome");
				if(type.equals("Stu")) {
					JOptionPane.showMessageDialog(this,"Welcome Stu");
					Home1 h1= new Home1(UserAccount,UserPassword);
					h1.setVisible(true);
					stat.executeUpdate(sql2);
				}
				else if(type.equals("Tea")) {
					JOptionPane.showMessageDialog(this,"Welcome Tea");
					TeacherUI h2= new TeacherUI(UserAccount);
					h2.setVisible(true);
					stat.executeUpdate(sql2);
				}
				else if(type.equals("Sys")) {
					JOptionPane.showMessageDialog(this,"Welcome Sys");
					SystemManagerGUI h3= new SystemManagerGUI(UserAccount,UserPassword);
					h3.setVisible(true);
					stat.executeUpdate(sql2);
				}
				this.dispose();
			}
		}
		else JOptionPane.showMessageDialog(this, "Wrong Account or Password");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "Wrong");
			e.printStackTrace();
		}
	}
}

