import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.sql.*;
public class Home3 extends JFrame implements ActionListener{
	String connectionUrl = "jdbc:mysql://localhost:3306/useraccount?serverTimezone=UTC";
	static String SystemAccount,SystemPassword;
	CardLayout Cards=new CardLayout();
	JPanel MenuPanel,FunctionPanel,LeavePanel;
	Home3_GroupPanel GroupPanel;
	Home3_StudentPanel InformationPanel;
	Home3_SubjectPanel SubjectPanel;
	Home3_SystemManagerPanel EditPanel;
	Home3_RegisterUserPanel RegisterPanel;
	String SystemAccountthis, SystemPasswordthis;
	Home3(String SystemAccount,String SystemPassword){
		SystemAccountthis= SystemAccount;SystemPasswordthis=SystemPassword;
		MenuPanel = new JPanel();
		FunctionPanel=new JPanel();
		EditPanel=new Home3_SystemManagerPanel(SystemAccount);
		RegisterPanel = new Home3_RegisterUserPanel();
		GroupPanel=new Home3_GroupPanel();
		EditPanel=new Home3_SystemManagerPanel(SystemAccount);
		InformationPanel=new Home3_StudentPanel();
		SubjectPanel= new Home3_SubjectPanel();
		LeavePanel= new JPanel();
		//Welcome
		JLabel Welcome = new JLabel("Welcome "+SystemAccount+"!"+"                ");
		//Menu Button
		JButton Leave = new JButton("離開");
		Leave.setSize(80,25);
		JButton Edit = new JButton("管理個人帳號");
		Edit.setSize(80,25);
		JButton Register= new JButton("管理使用者帳號");
		Register.setSize(80,25);
		JButton Information =new JButton("管理學生資訊");
		Information.setSize(80,25);
		JButton Group= new JButton("管理測驗群組");
		Group.setSize(80,25);
		JButton Subject = new JButton("管理科目");
		Subject.setSize(80,25);
		//監聽
		Leave.addActionListener(this);
		Edit.addActionListener(this);
		Register.addActionListener(this);
		Information.addActionListener(this);
		Group.addActionListener(this);
		Subject.addActionListener(this);
		//LeavePanel
		LeavePanel.setBackground(Color.green);
		//RegisterPanel
		//FuntionPanel
		FunctionPanel.setBackground(Color.pink);
		FunctionPanel.setLayout(Cards);
		FunctionPanel.add("LeaveCardPanel",LeavePanel);
		FunctionPanel.add("EditCardPanel",EditPanel);
		FunctionPanel.add("RegisterCardPanel",RegisterPanel);
		FunctionPanel.add("InformationCardPanel",InformationPanel);
		FunctionPanel.add("GroupCardPanel",GroupPanel);
		FunctionPanel.add("SubjectCardPanel",SubjectPanel);
		//MenuPanel
		MenuPanel.add(Welcome);
		MenuPanel.add(Leave);
		MenuPanel.add(Edit);
		MenuPanel.add(Register);
		MenuPanel.add(Information);
		MenuPanel.add(Group);
		MenuPanel.add(Subject);
		//container
		Container Con=getContentPane();
		Con.add(MenuPanel,BorderLayout.NORTH);
		Con.add(FunctionPanel,BorderLayout.SOUTH);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
		add(FunctionPanel);
		setTitle("Welcome H3");  
	    setSize(1000, 800);  
	    setVisible(true);
	}
	public static void main(String[] args) {
		new Home3(SystemAccount,SystemPassword);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String buttonName= e.getActionCommand();
			
			if(buttonName.equals("離開")) {
				Cards.show(FunctionPanel,"LeaveCardPanel");
				int Confirm =JOptionPane.showConfirmDialog(this, "Continue Leaving?","Continue?",JOptionPane.YES_NO_OPTION);
				if(Confirm==JOptionPane.YES_OPTION) {
					leaveMethod();
				}
			}
			else if(buttonName.equals("管理使用者帳號")) {
				Cards.show(FunctionPanel,"RegisterCardPanel");
			}
			else if(buttonName.equals("管理學生資訊")) {
				Cards.show(FunctionPanel,"InformationCardPanel");
			}
			else if(buttonName.equals("管理個人帳號")) {
				Cards.show(FunctionPanel,"EditCardPanel");
			}
			else if(buttonName.equals("管理測驗群組")) {
				Cards.show(FunctionPanel,"GroupCardPanel");
			}
			else if(buttonName.equals("管理科目")) {
				Cards.show(FunctionPanel,"SubjectCardPanel");
			}
		}catch(Exception e10) {
			e10.printStackTrace();
		}
	}
	public void leaveMethod()throws IOException {
	try(Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")){
		Statement stat = conn.createStatement();
		LoginGUI l1= new LoginGUI();
		String sql2 = "Update useraccount SET isLogin='false'  where iduser_account ="+"'"+SystemAccountthis+"'";
		stat.executeUpdate(sql2);
		l1.setVisible(true);
		dispose();
		}catch(SQLException e) {
		JOptionPane.showMessageDialog(this, "Wrong");
		e.printStackTrace();
		}
	}
}
