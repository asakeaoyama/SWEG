import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Home3_SystemManagerPanel extends JPanel implements ActionListener {
	JLabel ChangeLabel,TChangeLabel;
	JTextField ChangeText,TChangeText;
	JButton OkButton;
	String  UserAccounthis;
	String connectionUrl = "jdbc:mysql://localhost:3306/useraccount?serverTimezone=UTC";
	public Home3_SystemManagerPanel(String UserAccount) {
		UserAccounthis=UserAccount;
		setLayout(null);
		ChangeLabel=new JLabel("輸入新密碼");
		ChangeLabel.setBounds(300,200,200,50);
		TChangeLabel=new JLabel("二次確認");
		TChangeLabel.setBounds(300,300,200,50);
		ChangeText=new JTextField();
		ChangeText.setBounds(550,200,200,50);
		TChangeText=new JTextField();
		TChangeText.setBounds(550,300,200,50);
		OkButton= new JButton("確認");
		OkButton.setBounds(300,400,200,50);
		add(ChangeLabel);add(TChangeLabel);add(ChangeText);add(TChangeText);add(OkButton);
		OkButton.addActionListener(this);
		setBackground(Color.white);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		updateFunction(UserAccounthis);
	}
	public void updateFunction(String UserAccounthis) {
		try(Connection conn =DriverManager.getConnection(connectionUrl, "root", "aa910828")){
			JOptionPane.showMessageDialog(this, "輸入相同");
			String Change=ChangeText.getText();
			String TChange=TChangeText.getText();
			Statement stat = conn.createStatement();
			if(Change.equals(TChange)) {
				JOptionPane.showMessageDialog(this, "Update");
				String sql = "Update useraccount SET password='"+Change+"'  where iduser_account ="+"'"+UserAccounthis+"'";
				stat.executeUpdate(sql);
			}
			else {
				JOptionPane.showMessageDialog(this, "Wrong 兩次輸入不同");
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "Wrong");
			e.printStackTrace();
		}
	}
}
