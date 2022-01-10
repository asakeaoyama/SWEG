
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MathExamPaperEditor implements ActionListener{

	public JFrame frame;
	private final JPanel panel = new JPanel();
	
	JButton backButt;
	JComboBox<String> comboBox;
	JTextArea EArea;
	JButton addButt;
	JEditorPane editorPane;
	private JButton delButt;

	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
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
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MathExamEditor window = new MathExamEditor();
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
	public MathExamPaperEditor() {
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
		panel.setBounds(0, 0, 984, 761);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(31, 672, 89, 23);
		panel.add(comboBox);
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from `exams`");
			while(rs.next()) {
				comboBox.addItem(rs.getString("name"));
				
			}
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		comboBox.addActionListener(this);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(161, 672, 581, 21);
		panel.add(editorPane);
		
		EArea = new JTextArea();
		EArea.setBounds(31, 10, 920, 627);
		panel.add(EArea);
		EArea.setEditable(false);
		
		backButt = new JButton("back");
		backButt.setBounds(875, 672, 87, 23);
		panel.add(backButt);
		backButt.addActionListener(this);
		
		addButt = new JButton("add");
		addButt.setBounds(768, 672, 87, 23);
		panel.add(addButt);
		addButt.addActionListener(this);
		
		delButt = new JButton("del");
		delButt.setBounds(768, 705, 87, 23);
		panel.add(delButt);
		delButt.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButt) {
			frame.dispose();
			frame.dispose();
			try {
				EPSelect window = new EPSelect();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==comboBox) {
			String Etxt="";
			String ExamSelect = (String) comboBox.getSelectedItem();
			String[] examArr = new String[100];
			
			try {
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("exams`");
				int counter = 0;
				while(rs.next()) {
					examArr[counter] = rs.getString("quetion");
					counter ++;
				}
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
			for(int i=0;i<examArr.length;i++) {
				if (ExamSelect.equals(examArr[i])) {
					try {
						Connection conn = getConnection();
						Statement st = conn.createStatement();
						String ins = "Select * from `"+examArr+"Paper`";
						ResultSet rs = st.executeQuery(ins);
						while(rs.next()) {
							Etxt += rs.getString("quetion")+"\t"+rs.getString("ans")+"\t\n";
							
						}
						EArea.setText(Etxt);
						
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
			}
		}
		if(e.getSource()==addButt) {
			String QLine = editorPane.getText();
			String[] QA = QLine.split("/"); 
			String ExamSelect = (String) comboBox.getSelectedItem();
			if (ExamSelect.equals("mid exam")) {
				try {
					Connection conn = getConnection();
					Statement st = conn.createStatement();
					String ins = "insert into `midExamPaper` values('"+QA[0]+"','"+QA[1]+"');";
					st.executeUpdate(ins);
					
					
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
			if (ExamSelect.equals("final exam")) {
				try {
					Connection conn = getConnection();
					Statement st = conn.createStatement();
					String ins = "insert into `finalExamPaper` values('"+QA[0]+"','"+QA[1]+"');";
					st.executeUpdate(ins);
					
					
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		}
	}

}
