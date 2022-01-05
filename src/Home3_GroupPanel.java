import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
public class Home3_GroupPanel extends JPanel implements ActionListener {
	String connectionUrl = "jdbc:mysql://localhost:3306/useraccount?serverTimezone=UTC";
	JPanel TablePanel,FunctionPanel;
	DefaultTableModel model;
	JTextField NewNameText,NewSubjectText,NewNumberText,NewDateText,NewTimeText;
	JTable UserTable ;
	JTextField EditAccountText,EditWhatText,DeleteText;
	JComboBox<String> EditChooseBox, TypeChooseBox;
	public Home3_GroupPanel() {
		setLayout(null);
		//瀏覽
		JLabel ViewUserLabel= new JLabel("瀏覽群組");
		JButton ShowUserTable = new JButton("Show Table");
		ShowUserTable.addActionListener(this);
		JLabel Seperate= new JLabel("*******************");
		ViewUserLabel.setBounds(10,20,100,25);
		Seperate.setBounds(10,45,100,10);
		FunctionPanel=new JPanel();
		TablePanel= new JPanel();
		model = new DefaultTableModel();
		UserTable = new JTable(model);
		model.addColumn("群組名稱");
		model.addColumn("科目");
		model.addColumn("人數");
		model.addColumn("日期");
		model.addColumn("時間");
		JScrollPane UserTableScroll = new JScrollPane(UserTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		UserTableScroll.setBackground(Color.WHITE);
		UserTableScroll.setBounds(10,55,300,100);
		ShowUserTable.setBounds(10,165,100,25);
		//新增使用者
		JLabel NewUserLabel= new JLabel("新增群組");
		JLabel Seperate1= new JLabel("*******************");
		NewUserLabel.setBounds(10,210,100,25);
		Seperate1.setBounds(10,235,100,10);
		//新增內容
		JLabel NewWhatLabel= new JLabel("新增內容");
		NewWhatLabel.setBounds(10,255,50,25);
		NewNameText= new JTextField("輸入群組名稱");
		NewNameText.setBounds(70,255,100,25);
		NewSubjectText= new JTextField("輸入科目");
		NewSubjectText.setBounds(180,255,100,25);
		NewNumberText= new JTextField("輸入人數");
		NewNumberText.setBounds(290,255,100,25);
		NewDateText= new JTextField("輸入日期");
		NewDateText.setBounds(400,255,100,25);
		NewTimeText= new JTextField("輸入時間");
		NewTimeText.setBounds(510,255,100,25);
		JButton OkNewUserButton = new JButton("儲存新增");
		OkNewUserButton.addActionListener(this);
		OkNewUserButton.setBounds(10,290,100,25);
		//編輯群組
		JLabel EditUserLabel= new JLabel("編輯使用者");
		EditUserLabel.setBounds(10,345,100,25);
		JLabel Seperate2= new JLabel("*******************");
		Seperate2.setBounds(10,370,100,10);
		//編輯群組
		JLabel EditWhatLabel= new JLabel("編輯群組");
		EditWhatLabel.setBounds(10,390,50,25);
		EditAccountText= new JTextField("輸入編輯名稱");
		EditAccountText.setBounds(70,390,100,25);
		String[] ChooseStrings = { "測驗名稱", "科目", "人數", "日期", "時間"};
		EditChooseBox = new JComboBox<String>(ChooseStrings);
		EditChooseBox.setBounds(175,390,150,25);
		EditWhatText= new JTextField("輸入編輯內容");
		EditWhatText.setBounds(330,390,150,25);
		JButton OkEditUserButton = new JButton("儲存編輯");
		OkEditUserButton.addActionListener(this);
		OkEditUserButton.setBounds(10,425,100,25);
		//刪除群組
		JLabel DeleteUserLabel= new JLabel("刪除群組");
		DeleteUserLabel.setBounds(10,480,100,25);	
		JLabel Seperate3= new JLabel("*******************");
		Seperate3.setBounds(10,505,100,10); 
		JLabel DeleteWhatLabel= new JLabel("刪除群組");
		DeleteWhatLabel.setBounds(10,515,100,25);
		DeleteText= new JTextField("輸入刪除群組");
		DeleteText.setBounds(120,515,200,25);
		JButton OkDeleteUserButton = new JButton("儲存刪除");
		OkDeleteUserButton.addActionListener(this);
		OkDeleteUserButton.setBounds(10,550,100,25); 
		
		//Panel
		add(ViewUserLabel);add(ShowUserTable);add(Seperate);add(UserTableScroll);
		add(NewUserLabel);add(Seperate1);  add(NewWhatLabel); add(NewNameText);add(NewSubjectText);add(NewNumberText);
		add(NewTimeText); add(NewDateText);add(OkNewUserButton);
		add(EditUserLabel);add(EditWhatText); add(Seperate2);add(EditWhatLabel); add(EditAccountText);add(EditChooseBox);add(OkEditUserButton);
		add(DeleteUserLabel);add(Seperate3); add(DeleteWhatLabel);add(DeleteText); add(OkDeleteUserButton);
		setBackground(Color.orange);
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
				addFunction(NewNameText.getText(),NewSubjectText.getText(),NewNumberText.getText(),NewDateText.getText(),NewTimeText.getText());
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
			System.out.println(EditChoose);
			String sql="";
			String UserEditWhat=EditWhatText.getText();
			if(EditChoose.equals("測驗名稱")) {
				sql = "Update testgroup SET idtestgroup="+"'"+UserEditWhat+"'"+" idtestgroup ="+"'"+UserID+"'";
			}
			else if(EditChoose.equals("科目")) {
				sql = "Update testgroup SET subject="+"'"+UserEditWhat+"'"+" where idtestgroup ="+"'"+UserID+"'";
			}
			else if(EditChoose.equals("人數")){
				sql = "Update testgroup SET peoplenumber="+"'"+UserEditWhat+"'"+" where idtestgroup ="+"'"+UserID+"'";
			}
			else if(EditChoose.equals("日期")){
				sql = "Update testgroup SET date="+"'"+UserEditWhat+"'"+" where idtestgroup ="+"'"+UserID+"'";
			}
			else if(EditChoose.equals("時間")){
				sql = "Update testgroup SET time="+"'"+UserEditWhat+"'"+" where idtestgroup ="+"'"+UserID+"'";
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
		    PreparedStatement pstm = conn.prepareStatement("SELECT * FROM testgroup");
		    ResultSet Rs = pstm.executeQuery();
		    while(Rs.next()){
		         model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)});
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
	public void addFunction(String Name,String Subject,String Number,String Date,String Time) {
		try(Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")){
			String sql="INSERT INTO `useraccount`.`testgroup` (`idtestgroup`, `subject`, `peoplenumber`, `date`, `time`) VALUES ('"+Name+"', '"+Subject+"', '"+Number+"', '"+Date+"', '"+Time+"');";
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
			String sql = "DELETE from testgroup where idtestgroup ="+"'"+Delete+"'";
			stat.execute(sql);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "Wrong deleteFunction");
			e.printStackTrace();
		}
	}
}
