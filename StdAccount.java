package KYUTES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StdAccount implements ActionListener {
	
	public JFrame frame;
	private JPanel stdAccount;
	private JButton confirm,previous;
	private JTextField newPassword,newPassword2;
	String userName;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StdAccount window = new StdAccount(userName);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public StdAccount(String userName) {
		this.userName = userName;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		BarPanel bar = new BarPanel(frame,userName);
		
		// 學生帳號管理面板
		stdAccount = new JPanel();
		stdAccount.setBounds(0, 50, 900, 550);
		stdAccount.setBackground(new Color(186, 202, 224));
		stdAccount.setLayout(null);
		frame.getContentPane().add(stdAccount);
		// 帳號名稱標籤
		JLabel userNameJL = new JLabel("user                    "+userName);
		userNameJL.setBounds(200, 100, 500, 25);
		userNameJL.setFont(new Font("", Font.BOLD, 20)); // 字型,BOLD=粗體,字體大小
		stdAccount.add(userNameJL);
		// 修改密碼
		JLabel changePW = new JLabel("輸入新密碼");
		changePW.setBounds(200, 150, 100, 25);
		changePW.setFont(new Font("", Font.BOLD, 15));
		stdAccount.add(changePW);
		newPassword = new JTextField(1);
		newPassword.setBackground(new Color(240, 240, 240));
		newPassword.setBounds(350, 150, 150, 25);
		newPassword.setFont(new Font("", Font.PLAIN, 15));
		stdAccount.add(newPassword);
		JLabel changePW2 = new JLabel("再次輸入密碼");
		changePW2.setBounds(200, 200, 100, 25);
		changePW2.setFont(new Font("", Font.BOLD, 15));
		stdAccount.add(changePW2);
		newPassword2 = new JTextField(1);
		newPassword2.setBackground(new Color(240, 240, 240));
		newPassword2.setBounds(350, 200, 150, 25);
		newPassword2.setFont(new Font("", Font.PLAIN, 15));
		stdAccount.add(newPassword2);
		confirm = new JButton("確定");
		confirm.setBounds(500, 200, 60, 25);
		stdAccount.add(confirm);
		confirm.addActionListener(this);

		previous = new JButton("上一頁");
		previous.setBounds(780, 450, 80, 25);
		previous.setFont(new Font("", Font.PLAIN, 10));
		stdAccount.add(previous);
		previous.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==previous) {
			
			frame.dispose();
		}
		if(e.getSource()==confirm) {
			String newPW=newPassword.getText();
			String newPW2=newPassword2.getText();
			/*修改密碼*/
			try {
				Connection conn = UseDatabase.getConnection();
				Statement st = conn.createStatement();
				if (newPW.equals(newPW2)) {
					String sql = "Update useraccount SET password='" + newPW + "' where iduser_account = '"+userName + "'";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(frame, "Update");
					newPassword.setText("");
					newPassword2.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong 兩次輸入不同");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
