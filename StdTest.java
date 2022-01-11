package KYUTES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StdTest implements ActionListener {
	
	public JFrame frame;
	private JPanel stdTest;
	private JComboBox<String> subjectCB;
	private JButton start,confirmAns,previous;
	private JLabel timeJL,timer;
	private JTextArea question;
	private JTextField answer;
	CountDown cd;
	private int testTime,n,score;
	private String userName,test,ans;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StdTest window = new StdTest(userName);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public StdTest(String userName) {
		this.userName = userName;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Online Test");
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		BarPanel bar = new BarPanel(frame,userName);

		stdTest = new JPanel();
		stdTest.setBounds(0, 50, 900, 550);
		stdTest.setBackground(new Color(186, 202, 224));
		stdTest.setLayout(null);
		frame.getContentPane().add(stdTest);
		
		//選擇考試
		subjectCB = new JComboBox<String>();
		subjectCB.setBounds(200, 50, 150, 23);
		subjectCB.setFont(new Font("", Font.PLAIN, 13));
		stdTest.add(subjectCB);
		try {
			Connection conn = UseDatabase.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `exams`");
			subjectCB.addItem("請選擇");
			while(rs.next()){
				subjectCB.addItem(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		subjectCB.addActionListener(this);
		//作答時間
		timeJL = new JLabel("作答時間: "+testTime+"分鐘");
		timeJL.setBounds(200, 100, 150, 20);
		timeJL.setFont(new Font("", Font.BOLD, 15));
		stdTest.add(timeJL);
		//開始考試按鈕
		start = new JButton("開始考試");
		start.setBounds(350, 100, 90, 23);
		start.setFont(new Font("", Font.BOLD, 13));
		stdTest.add(start);
		start.setEnabled(false);
		start.addActionListener(this);
		//倒數計時
		timer = new JLabel();
		timer.setBounds(480, 100, 150, 20);
		timer.setFont(new Font("", Font.BOLD, 15));
		stdTest.add(timer);
		//題目&作答區
		question = new JTextArea();
		question.setBackground(new Color(240, 240, 240));
		question.setBounds(200, 150, 500, 250);
		question.setEditable(false);
		question.setFont(new Font("", Font.BOLD, 20));
		stdTest.add(question);
		JLabel answerJL = new JLabel("答案:");
		answerJL.setBounds(200, 410, 40, 20);
		answerJL.setFont(new Font("", Font.BOLD, 15));
		stdTest.add(answerJL);
		answer = new JTextField(1);
		answer.setBackground(new Color(240, 240, 240));
		answer.setBounds(240, 410, 200, 25);
		answer.setFont(new Font("", Font.PLAIN, 20));
		stdTest.add(answer);
		answer.setEditable(false);
		confirmAns = new JButton("確定答案");
		confirmAns.setBounds(450, 410, 90, 23);
		confirmAns.setFont(new Font("", Font.BOLD, 13));
		stdTest.add(confirmAns);
		confirmAns.setEnabled(false);
		confirmAns.addActionListener(this);
		
		previous = new JButton("上一頁");
		previous.setBounds(780, 450, 80, 25);
		previous.setFont(new Font("", Font.PLAIN, 10));
		stdTest.add(previous);
		previous.addActionListener(this);
	}
	
	void showQuestion() {
		try {
			Connection conn = UseDatabase.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM "+test+"paper where `question_num` = "+n);
			if(rs.next()) { //未完成全部題目
				question.setText(rs.getString("quetion"));
				ans=rs.getString("ans");
			}else {
				cd.stop(); //停止倒數
				answer.setEditable(false); //不能再撰寫答案
				confirmAns.setEnabled(false); //不能送出答案、進入下一題
				question.setText("Finish!\r\nScore = "+score+" / 50");
				st.executeUpdate("Update user_" + userName + " SET `score` = "+score+" where `subject` = '" + test + "'");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==previous) {
			
			frame.dispose();
		}
		if(e.getSource()==subjectCB) {
			try {
				Connection conn = UseDatabase.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM `exams` where `name`='"+subjectCB.getSelectedItem()+"'");
				rs.next();
				test = (String) subjectCB.getSelectedItem();
				
				testTime = rs.getInt("time");
				timeJL.setText("作答時間: "+testTime+"分鐘");
				start.setEnabled(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==start) {
			try {
				Connection conn = UseDatabase.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM user_" + userName + " where `subject` = '" + test + "'");
				rs.next();
				if(rs.getInt("score") != 0 ) { //還沒有測驗過
					cd = new CountDown(timer,testTime);
					answer.setEditable(true); //開始之後才可以輸入
					confirmAns.setEnabled(true);
					n=1;
					showQuestion();
					start.setEnabled(false); //設定按鈕不可點選
					cd.start();
				} else {
					JOptionPane.showMessageDialog(frame, "已進行過測驗");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==confirmAns) {
			if(timer.getText().equals("Time's Over!")) {
				question.setText("Time's Over!\r\nScore = "+score+" / 50");
				confirmAns.setEnabled(false);
			}else {
				if(answer.getText().equals(ans)) { //答對
					score+=10; //一題10分
				}
				answer.setText(null);
				n++; //題號++
				showQuestion();
			}
		}
	}
}