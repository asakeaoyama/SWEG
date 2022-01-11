package KYUTES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StdHome extends JFrame implements ActionListener{

	public JFrame frame;
	private JPanel stdHome;
	private JButton account,score,exercises,test;
	String userName,userPassword;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StdHome window = new StdHome("???","123");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void setVisible(boolean t) {
		frame.setVisible(t);
	}
	
	public StdHome(String userName,String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
		initialize();
	}

	/*
	 * 學生功能選單(登入主頁)
	 */
	private void initialize() {
		frame = new JFrame("學生功能選單");
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		BarPanel bar = new BarPanel(frame,userName);

		// 學生主頁面板
		stdHome = new JPanel();
		stdHome.setBounds(0, 50, 900, 550);
		stdHome.setBackground(new Color(186, 202, 224)); // RGB
		stdHome.setLayout(null);
		frame.getContentPane().add(stdHome);
		// 個人帳號管理按鈕
		account = new JButton("個人帳號管理");
		account.setBounds(200, 100, 200, 100);
		stdHome.add(account);
		account.addActionListener(this);
		// 成績查詢按鈕
		score = new JButton("成績查詢");
		score.setBounds(500, 100, 200, 100);
		stdHome.add(score);
		score.addActionListener(this);
		// 練習按鈕
		exercises = new JButton("練習");
		exercises.setBounds(200, 300, 200, 100);
		stdHome.add(exercises);
		exercises.addActionListener(this);
		// 測驗按鈕
		test = new JButton("測驗");
		test.setBounds(500, 300, 200, 100);
		stdHome.add(test);
		test.addActionListener(this);

		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==account) {
			
			try {
				StdAccount window = new StdAccount(userName);
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==score) {
			
			try {
				StdScore window = new StdScore(userName);
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==exercises) {
			
			try {
				StdExercises window = new StdExercises(userName);
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==test) {
			
			try {
				StdTest window = new StdTest(userName);
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
