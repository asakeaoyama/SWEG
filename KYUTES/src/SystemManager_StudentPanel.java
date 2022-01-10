import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
public class SystemManager_StudentPanel extends JPanel implements ActionListener {
	String connectionUrl = "jdbc:mysql://localhost:3306/useraccount?serverTimezone=UTC";
	JPanel TablePanel,FunctionPanel;
	DefaultTableModel model;
	JTextField NewNameText,NewAccountText,NewMajorText,NewGradeText;
	JTable UserTable ;
	JTextField EditAccountText,EditWhatText,DeleteText;
	JComboBox<String> EditChooseBox, TypeChooseBox;
	public  SystemManager_StudentPanel() {
		setLayout(null);
		//瀏覽
		JLabel ViewUserLabel= new JLabel("瀏覽學生");
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
		model.addColumn("姓名");
		model.addColumn("主修");
		model.addColumn("年級");
		JScrollPane UserTableScroll = new JScrollPane(UserTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		UserTableScroll.setBackground(Color.WHITE);
		UserTableScroll.setBounds(10,55,300,100);
		ShowUserTable.setBounds(10,165,100,25);
		//新增使用者
		JLabel NewUserLabel= new JLabel("新增學生");
		JLabel Seperate1= new JLabel("*******************");
		NewUserLabel.setBounds(10,210,100,25);
		Seperate1.setBounds(10,235,100,10);
		//新增內容
		JLabel NewWhatLabel= new JLabel("新增學生");
		NewWhatLabel.setBounds(10,255,50,25);
		NewAccountText= new JTextField("輸入帳號");
		NewAccountText.setBounds(70,255,100,25);
		NewNameText= new JTextField("輸入姓名");
		NewNameText.setBounds(180,255,100,25);
		NewMajorText= new JTextField("輸入主修");
		NewMajorText.setBounds(290,255,100,25);
		NewGradeText= new JTextField("輸入年級");
		NewGradeText.setBounds(400,255,100,25);
		JButton OkNewUserButton = new JButton("儲存新增");
		OkNewUserButton.addActionListener(this);
		OkNewUserButton.setBounds(10,290,100,25);
		//編輯群組
		JLabel EditUserLabel= new JLabel("編輯學生");
		EditUserLabel.setBounds(10,345,100,25);
		JLabel Seperate2= new JLabel("*******************");
		Seperate2.setBounds(10,370,100,10);
		//編輯群組
		JLabel EditWhatLabel= new JLabel("編輯學生");
		EditWhatLabel.setBounds(10,390,50,25);
		EditAccountText= new JTextField("輸入學生帳號");
		EditAccountText.setBounds(70,390,100,25);
		String[] ChooseStrings = { "帳號", "姓名", "主修", "年級"};
		EditChooseBox = new JComboBox<String>(ChooseStrings);
		EditChooseBox.setBounds(175,390,150,25);
		EditWhatText= new JTextField("輸入編輯內容");
		EditWhatText.setBounds(330,390,150,25);
		JButton OkEditUserButton = new JButton("儲存編輯");
		OkEditUserButton.addActionListener(this);
		OkEditUserButton.setBounds(10,425,100,25);
		//刪除群組
		JLabel DeleteUserLabel= new JLabel("刪除學生");
		DeleteUserLabel.setBounds(10,480,100,25);	
		JLabel Seperate3= new JLabel("*******************");
		Seperate3.setBounds(10,505,100,10); 
		JLabel DeleteWhatLabel= new JLabel("刪除學生");
		DeleteWhatLabel.setBounds(10,515,100,25);
		DeleteText= new JTextField("輸入刪除學生帳號");
		DeleteText.setBounds(120,515,200,25);
		JButton OkDeleteUserButton = new JButton("儲存刪除");
		OkDeleteUserButton.addActionListener(this);
		OkDeleteUserButton.setBounds(10,550,100,25); 
		
		//Panel
		add(ViewUserLabel);add(ShowUserTable);add(Seperate);add(UserTableScroll);
		add(NewUserLabel);add(Seperate1);  add(NewWhatLabel); add(NewNameText);add(NewAccountText);add(NewMajorText);
		add(NewGradeText); add(OkNewUserButton);add(EditWhatText);
		add(EditUserLabel); add(Seperate2);add(EditWhatLabel); add(EditAccountText);add(EditChooseBox);add(OkEditUserButton);
		add(DeleteUserLabel);add(Seperate3); add(DeleteWhatLabel);add(DeleteText); add(OkDeleteUserButton);
		setBackground(Color.red);
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
				JOptionPane.showMessageDialog(this,"新增");
				addFunction(NewAccountText.getText(),NewNameText.getText(),NewMajorText.getText(),NewGradeText.getText());
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
			String UserID=EditAccountText.getText();
			String EditChoose=(String)EditChooseBox.getSelectedItem();
			String sql="";
			String UserEditWhat=EditWhatText.getText();
			if(EditChoose.equals("帳號")) {
				sql = "Update student SET account="+"'"+UserEditWhat+"'"+"where account ="+"'"+UserID+"'";
			}
			else if(EditChoose.equals("名稱")) {
				sql = "Update  student SET name="+"'"+UserEditWhat+"'"+" where account ="+"'"+UserID+"'";
			}
			else if(EditChoose.equals("主修")){
				sql = "Update  student SET major="+"'"+UserEditWhat+"'"+" where account ="+"'"+UserID+"'";
			}
			else if(EditChoose.equals("年級")){
				sql = "Update  student SET grade="+"'"+UserEditWhat+"'"+" where account ="+"'"+UserID+"'";
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
		    PreparedStatement pstm = conn.prepareStatement("SELECT * FROM student");
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
	public void addFunction(String Account,String Name,String Major,String Grade) {
		try(Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")){
			String sql="INSERT INTO `useraccount`.`student` (`account`, `name`, `major`, `grade`) VALUES ('"+Account+"', '"+Name+"', '"+Major+"', '"+Grade+"');";
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
			String Delete=DeleteText.getText();
			String sql = "DELETE from student where account ="+"'"+Delete+"'";
			stat.execute(sql);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "Wrong deleteFunction");
			e.printStackTrace();
		}
	}
}
