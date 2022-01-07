import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class Home3_RegisterUserPanel extends JPanel implements ActionListener {
	String connectionUrl = "jdbc:mysql://localhost:3306/useraccount?serverTimezone=UTC";
	JPanel TablePanel,FunctionPanel;
	DefaultTableModel model;
	JTextArea  NewUserTextArea;
	JTable UserTable ;
	JTextField EditAccountText,EditWhatText,DeleteAccountText;
	JComboBox<String> EditChooseBox, TypeChooseBox;
	public Home3_RegisterUserPanel() {
		setLayout(null);
		//瀏覽
		JLabel ViewUserLabel= new JLabel("瀏覽使用者");
		JButton ShowUserTable = new JButton("Show Table");
		ShowUserTable.addActionListener(this);
		JLabel Seperate= new JLabel("*******************");
		ViewUserLabel.setBounds(10,20,100,25);
		Seperate.setBounds(10,45,100,10);
		FunctionPanel=new JPanel();
		TablePanel= new JPanel();
		model = new DefaultTableModel();
		UserTable = new JTable(model);
		model.addColumn("帳號");
		model.addColumn("密碼");
		model.addColumn("身分");
		model.addColumn("登入狀態");	
		JScrollPane UserTableScroll = new JScrollPane(UserTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		UserTableScroll.setBackground(Color.WHITE);
		UserTableScroll.setBounds(10,55,300,100);
		ShowUserTable.setBounds(10,165,100,25);
		//新增使用者
		JLabel NewUserLabel= new JLabel("新增使用者");
		JLabel Seperate1= new JLabel("*******************");
		NewUserLabel.setBounds(10,210,100,25);
		Seperate1.setBounds(10,235,100,10);
		//***創建身分類型
		JLabel TypeChooseLabel= new JLabel("選擇身分");
		TypeChooseLabel.setBounds(10,245,50,25);
		String[] TypeStrings = { "Student", "Teacher", "System Manager","Mix"};
		TypeChooseBox = new JComboBox<String>(TypeStrings);
		TypeChooseBox.setBounds(65,245,150,25);
		//***輸入大量新增使用者區域
		NewUserTextArea = new JTextArea("創建身分固定:帳號 密碼\r\nMix:帳號 密碼 身分\r\n請務必按照此格式,否則將出現錯誤\r\n",10,20);
		NewUserTextArea.setLineWrap(true);
		JScrollPane jScrollPane = new JScrollPane(NewUserTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setBackground(getForeground());
		jScrollPane.setBounds(10,285,300,100);
		JButton OkNewUserButton = new JButton("儲存新增");
		OkNewUserButton.addActionListener(this);
		OkNewUserButton.setBounds(10,395,100,25);
		//編輯使用者
		JLabel EditUserLabel= new JLabel("編輯使用者");
		EditUserLabel.setBounds(10,450,100,25);
		JLabel Seperate2= new JLabel("*******************");
		Seperate2.setBounds(10,475,100,10);
		//編輯內容
		JLabel EditWhatLabel= new JLabel("編輯內容");
		EditWhatLabel.setBounds(10,495,50,25);
		EditAccountText= new JTextField("輸入編輯帳號");
		EditAccountText.setBounds(70,495,100,25);
		String[] ChooseStrings = { "帳號", "密碼", "身分"};
		EditChooseBox = new JComboBox<String>(ChooseStrings);
		EditChooseBox.setBounds(175,495,150,25);
		EditWhatText= new JTextField("輸入編輯內容");
		EditWhatText.setBounds(330,495,150,25);
		JButton OkEditUserButton = new JButton("儲存編輯");
		OkEditUserButton.addActionListener(this);
		OkEditUserButton.setBounds(10,530,100,25);
		//刪除使用者
		JLabel DeleteUserLabel= new JLabel("刪除使用者");
		DeleteUserLabel.setBounds(10,585,100,25);
		JLabel Seperate3= new JLabel("*******************");
		Seperate3.setBounds(10,620,100,10);
		JLabel DeleteWhatLabel= new JLabel("刪除使用者");
		DeleteWhatLabel.setBounds(10,630,100,25);
		DeleteAccountText= new JTextField("輸入刪除帳號");
		DeleteAccountText.setBounds(120,630,200,25);
		JButton OkDeleteUserButton = new JButton("儲存刪除");
		OkDeleteUserButton.addActionListener(this);
		OkDeleteUserButton.setBounds(10,665,100,25);
		
		//Panel
		add(ViewUserLabel);add(ShowUserTable);add(Seperate);add(UserTableScroll);
		add(NewUserLabel);add(Seperate1); add(jScrollPane);add(TypeChooseLabel);add(TypeChooseBox);add(EditWhatText); add(OkNewUserButton);
		add(EditUserLabel); add(Seperate2);add(EditWhatLabel); add(EditAccountText);add(EditChooseBox);add(OkEditUserButton);
		add(DeleteUserLabel);add(Seperate3); add(DeleteWhatLabel);add(DeleteAccountText); add(OkDeleteUserButton);
		setBackground(Color.yellow);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String buttonName= e.getActionCommand();
			
			if(buttonName.equals("儲存編輯")) {
				JOptionPane.showMessageDialog(this,"編輯");
				editFunction();
			}
			else if (buttonName.equals("Show Table")) {
				showFunction();
			}
			else if(buttonName.equals("儲存新增")) {
				try {
				JOptionPane.showMessageDialog(this,"新增");
				//int NewUserNumber=NewUserTextArea.getColumns();
				Scanner sc= new Scanner(NewUserTextArea.getText());
				String TypeChoose=(String)TypeChooseBox.getSelectedItem();
				if(TypeChoose.equals("Student")) {
					for(String  lines :NewUserTextArea.getText().split("\\n")) {
						String user[]=lines.split(" ");
						addFunction(user[0],user[1],"Stu");
					}
				}
				else if(TypeChoose.equals("Teacher")) {
					for(String  lines :NewUserTextArea.getText().split("\\n")) {
						String user[]=lines.split(" ");
						addFunction(user[0],user[1],"Tea");
					}
				}
				else if (TypeChoose.equals("System Maneger")) {
					for(String  lines :NewUserTextArea.getText().split("\\n")) {
						String user[]=lines.split(" ");
						addFunction(user[0],user[1],"Sys");
					}
				}
				else {
					for(String  lines :NewUserTextArea.getText().split("\\n")) {
						String user[]=lines.split(" ");
						addFunction(user[0],user[1],user[2]);
					}
				}
				}catch(Exception e10) {
					JOptionPane.showMessageDialog(this, "輸入錯誤");
					e10.printStackTrace();
				}
			}
			else if(buttonName.equals("儲存刪除")) {
				JOptionPane.showMessageDialog(this,"刪除");
				deleteFunction();
			}
		}catch(Exception e10) {
			e10.printStackTrace();
		}
	}
	public void editFunction() {
		try(Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")){
			Statement stat = conn.createStatement();
			String UserAccount=EditAccountText.getText();
			System.out.println(UserAccount);
			String EditChoose=(String)EditChooseBox.getSelectedItem();
			System.out.println(EditChoose);
			String sql="";
			String UserEditWhat=EditWhatText.getText();
			if(EditChoose.equals("帳號")) {
				sql = "Update useraccount SET iduser_account="+"'"+UserEditWhat+"'"+" where iduser_account ="+"'"+UserAccount+"'";
			}
			else if(EditChoose.equals("密碼")) {
				sql = "Update useraccount SET password="+"'"+UserEditWhat+"'"+" where iduser_account ="+"'"+UserAccount+"'";
			}
			else if(EditChoose.equals("身分")){
				sql = "Update useraccount SET type="+"'"+UserEditWhat+"'"+" where iduser_account ="+"'"+UserAccount+"'";
			}
			stat.executeUpdate(sql);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "Wrong editFunction");
			e.printStackTrace();
		}
	}
	public void showFunction() {
		cleanTableFunction() ;
		try (Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")){
		    PreparedStatement pstm = conn.prepareStatement("SELECT * FROM useraccount");
		    ResultSet Rs = pstm.executeQuery();
		    while(Rs.next()){
		         model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4)});
		    }
		} catch (Exception e) {
		     System.out.println(e.getMessage());
		}	
	}
	public void cleanTableFunction() {
		try {
			for (int i = model.getRowCount()-1; i >=0; i--) {
			   model.removeRow(i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addFunction(String UserAccount,String UserPassword,String Type) {
		try(Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")){
			String sql="INSERT INTO `useraccount`.`useraccount` (`iduser_account`, `password`, `type`, `isLogin`) VALUES ('"+UserAccount+"', '"+UserPassword+"', '"+Type+"', 'false');";
			Statement stat = conn.createStatement();
			stat.execute(sql);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "Wrong addFunction");
			e.printStackTrace();
		}
	}
	public void deleteFunction() {
		try(Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")){
			Statement stat = conn.createStatement();
			String UserAccount=DeleteAccountText.getText();
			String sql = "DELETE from useraccount where iduser_account ="+"'"+UserAccount+"'";
			stat.execute(sql);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "Wrong deleteFunction");
			e.printStackTrace();
		}
	}
}
