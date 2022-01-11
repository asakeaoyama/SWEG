package KYUTES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StdExercises implements ActionListener {
	
	public JFrame frame;
	private JPanel stdExercises;
	private JComboBox<String> subjectCB;
	private JButton start,confirmAns,previous;
	private JLabel timeJL,timer;
	private JTextArea question;
	private JTextField answer;
	CountDown cd;
	private int testTime,score;
	private String userName,test,ans;
	ArrayList<Integer> select;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StdExercises window = new StdExercises(userName);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public StdExercises(String userName) {
		this.userName = userName;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Online Test");
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		BarPanel bar = new BarPanel(frame,userName);

		stdExercises = new JPanel();
		stdExercises.setBounds(0, 50, 900, 550);
		stdExercises.setBackground(new Color(186, 202, 224));
		stdExercises.setLayout(null);
		frame.getContentPane().add(stdExercises);
		
		//選擇考試
		subjectCB = new JComboBox<String>();
		subjectCB.setBounds(200, 50, 150, 23);
		subjectCB.setFont(new Font("", Font.PLAIN, 13));
		stdExercises.add(subjectCB);
		subjectCB.addItem("請選擇科目");
		try {
			Connection conn = UseDatabase.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM user_"+userName);
			while(rs.next()){
				subjectCB.addItem(rs.getString("subject"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		subjectCB.addActionListener(this);
		//作答時間
		testTime = 3;
		timeJL = new JLabel("作答時間: 3分鐘");
		timeJL.setBounds(200, 100, 150, 20);
		timeJL.setFont(new Font("", Font.BOLD, 15));
		stdExercises.add(timeJL);
		//開始考試按鈕
		start = new JButton("開始考試");
		start.setBounds(350, 100, 90, 23);
		start.setFont(new Font("", Font.BOLD, 13));
		stdExercises.add(start);
		start.setEnabled(false);
		start.addActionListener(this);
		//倒數計時
		timer = new JLabel();
		timer.setBounds(480, 100, 150, 20);
		timer.setFont(new Font("", Font.BOLD, 15));
		stdExercises.add(timer);
		//題目&作答區
		question = new JTextArea();
		question.setBackground(new Color(240, 240, 240));
		question.setBounds(200, 150, 500, 250);
		question.setEditable(false);
		question.setFont(new Font("", Font.BOLD, 20));
		stdExercises.add(question);
		JLabel answerJL = new JLabel("答案:");
		answerJL.setBounds(200, 410, 40, 20);
		answerJL.setFont(new Font("", Font.BOLD, 15));
		stdExercises.add(answerJL);
		answer = new JTextField(1);
		answer.setBackground(new Color(240, 240, 240));
		answer.setBounds(240, 410, 200, 25);
		answer.setFont(new Font("", Font.PLAIN, 20));
		stdExercises.add(answer);
		answer.setEditable(false);
		confirmAns = new JButton("確定答案");
		confirmAns.setBounds(450, 410, 90, 23);
		confirmAns.setFont(new Font("", Font.BOLD, 13));
		stdExercises.add(confirmAns);
		confirmAns.setEnabled(false);
		confirmAns.addActionListener(this);
		
		previous = new JButton("上一頁");
		previous.setBounds(780, 450, 80, 25);
		previous.setFont(new Font("", Font.PLAIN, 10));
		stdExercises.add(previous);
		previous.addActionListener(this);
	}
	
	void randomTest() {
		if(select.size()==5) {
			cd.stop(); //停止倒數
			answer.setEditable(false); //不能再撰寫答案
			confirmAns.setEnabled(false); //不能送出答案、進入下一題
			question.setText("Finish!\r\nScore = "+score+" / 50");
		}else {
			try {
				Connection conn = UseDatabase.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select count(`question_num`) from `mathQ`");
				rs.next();
				int n = rs.getInt(1);
				int randomNum=0;
				while(true) {
					randomNum = (int)(Math.random()*n)+1;
					if(!select.contains(randomNum)) {
						break;
					}
				}
				select.add(randomNum);
				rs = st.executeQuery("select * from `mathQ` where `question_num` = "+randomNum);
				rs.next();
				//MySQL table裡的question打錯
				question.setText(rs.getString("quetion"));
				ans = rs.getString("ans");
			} catch (Exception e) {
				e.printStackTrace();
			}
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
				ResultSet rs = st.executeQuery("SELECT * FROM `user_"+userName+"` where `subject`=\""+subjectCB.getSelectedItem()+"\"");
				rs.next();
				test = subjectCB.getSelectedItem()+"Paper";
				start.setEnabled(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==start) {
			cd = new CountDown(timer,testTime);
			answer.setEditable(true); //開始之後才可以輸入
			confirmAns.setEnabled(true);
			score=0;
			select = new ArrayList<Integer>();
			this.randomTest();
			cd.start();
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
				this.randomTest();
			}
		}
	}
}