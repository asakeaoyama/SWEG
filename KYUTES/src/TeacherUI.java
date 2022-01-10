
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class TeacherUI implements ActionListener{
	
	JButton btn1;
	JButton QMButt;
	JButton EPButt;
	String userName;
	JButton logOutButt;
	
	public JFrame frame;
	private JButton EMButt;
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/useraccount?serverTimezone=UTC";
			String username = "root";
			String password = "aa910828";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("connect Successfully");
			return conn;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TeacherUI window = new TeacherUI("Li-Wei,Chen");
					window.frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeacherUI(String userName) {
		this.userName=userName;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		btn1 = new JButton("Score Inquiry");
		btn1.setBounds(543, 518, 300, 150);
		frame.getContentPane().add(btn1);
		btn1.addActionListener(this);
		
		EPButt = new JButton("Exam Paper Manage");
		EPButt.setBounds(135, 518, 300, 150);
		frame.getContentPane().add(EPButt);
		EPButt.addActionListener(this);
		
		QMButt = new JButton("Quetions Manage");
		QMButt.setBounds(543, 339, 300, 150);
		frame.getContentPane().add(QMButt);
		QMButt.addActionListener(this);
		
		EMButt = new JButton("Exam Manage");
		EMButt.setBounds(135, 339, 300, 150);
		frame.getContentPane().add(EMButt);
		
		JLabel lblNewLabel = new JLabel("Exam & Quetion Manager");
		lblNewLabel.setFont(new Font("�L�n������", Font.BOLD, 25));//ioioi
		lblNewLabel.setBounds(135, 237, 699, 65);
		frame.getContentPane().add(lblNewLabel);
		
		String labelName = "Welcome , "+userName;
		JLabel lblNewLabel_1 = new JLabel(labelName);
		lblNewLabel_1.setFont(new Font("�L�n������", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(135, 170, 709, 65);
		frame.getContentPane().add(lblNewLabel_1);
		EMButt.addActionListener(this);
		
		logOutButt = new JButton("log out");
		logOutButt.setBounds(900,10,100,25);
		frame.getContentPane().add(logOutButt);
		logOutButt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			//frame.dispose();
			
			try {
				SearchScore window = new SearchScore();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==logOutButt) {
			frame.dispose();
			
			try {
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				
				LoginGUI l1= new LoginGUI();
				String sql2 = "Update useraccount SET isLogin='false'  where iduser_account ="+"'"+userName+"'";
				st.executeUpdate(sql2);
				l1.setVisible(true);
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
			
		}
		if(e.getSource()==QMButt) {
			//frame.dispose();
			try {
				QMSelect window = new QMSelect();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==EPButt) {
			//frame.dispose();
			try {
				EPSelect window = new EPSelect();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==EMButt) {
			//frame.dispose();
			try {
				EMSelect window = new EMSelect();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
	}
}
