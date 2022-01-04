package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;

public class SearchScore implements ActionListener{

	public JFrame frame;
	
	private JPanel contentPane;
	JButton backButt;
	JComboBox<String> comboBox;
	
	JTextArea scoreArea;
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sweg";
			String username = "root";
			String password = "azukiazusa";
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
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchScore window = new SearchScore();
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
	public SearchScore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		backButt = new JButton("back");
		backButt.setBounds(10, 217, 87, 23);
		panel.add(backButt);
		backButt.addActionListener(this);
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 70, 119, 23);
		panel.add(comboBox);
		comboBox.addItem("choose examination");
		comboBox.addItem("mid exam");
		comboBox.addItem("final exam");
		comboBox.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("choose quiz");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 45, 119, 15);
		panel.add(lblNewLabel);
		
		scoreArea = new JTextArea();
		scoreArea.setBounds(139, 10, 285, 241);
		panel.add(scoreArea);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButt) {
			
			frame.dispose();
			
			
			try {
				TeacherUI window = new TeacherUI();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==comboBox) {
			String scoretxt="";
			String examSelect = (String) comboBox.getSelectedItem();
			if (examSelect.equals("mid exam")) {
				try {
					Connection conn = getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("Select * from `midExamScore`");
					while(rs.next()) {
						scoretxt += rs.getString("name")+"\t\t"+rs.getString("score")+"\n";
						
					}
					scoreArea.setText(scoretxt);
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
				
		}
		
	}
}
