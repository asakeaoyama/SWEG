package KYUTES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;

public class BarPanel {
	
	public JFrame frame;
	private JPanel barPanel;
	private JButton logOut;
	private String userName;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarPanel window = new BarPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public BarPanel(JFrame frame, String userName) {
		this.frame = frame;
		this.userName = userName;
		initialize();
	}
	
	private void initialize() {
		barPanel = new JPanel();
		barPanel.setBounds(0, 0, 900, 50);
		barPanel.setBackground(new Color(212,222,236));
		barPanel.setLayout(null);
		frame.getContentPane().add(barPanel);
		
		JLabel kyutes = new JLabel("KYUTES");
		kyutes.setBounds(5, 5, 140, 40);
		kyutes.setFont(new Font("", Font.BOLD, 30)); // 字型,BOLD=粗體,字體大小
		barPanel.add(kyutes);
		
		JLabel welcome = new JLabel("Welcome, "+userName,SwingConstants.RIGHT);
		welcome.setBounds(650, 15, 230, 25);
		welcome.setFont(new Font("", Font.BOLD, 13)); // 字型,BOLD=粗體,字體大小
		barPanel.add(welcome);
		
		logOut = new JButton("log out");
		logOut.setBounds(150, 15, 80, 25);
		logOut.setFont(new Font("", Font.PLAIN, 13));
		barPanel.add(logOut);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = UseDatabase.getConnection();
					Statement st = conn.createStatement();
					//LoginGUI l1 = new LoginGUI();
					String sql2 = "Update useraccount SET isLogin='false'  where iduser_account =" + "'"+ userName + "'";
					st.executeUpdate(sql2);
					//l1.setVisible(true);
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}