
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MathExamEditor implements ActionListener{

	public JFrame frame;
	private final JPanel panel = new JPanel();
	
	JButton backButt;
	JTextArea EArea;
	JButton addButt;
	JEditorPane editorPane;
	private JButton delButt;
	JButton reButt;
	
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
	public MathExamEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		panel.setBounds(0, 0, 984, 761);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		 
		editorPane = new JEditorPane();
		editorPane.setBounds(31, 672, 581, 21);
		panel.add(editorPane);
		
		EArea = new JTextArea();
		EArea.setBounds(31, 10, 920, 627);
		panel.add(EArea);
		EArea.setEditable(false);
		String Etxt="";
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from `exams`");
			while(rs.next()) {
				Etxt += rs.getString("name")+"\t"+rs.getString("time")+"\t"+rs.getString("level")+"\n";
				
			}
			EArea.setText(Etxt);
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		backButt = new JButton("back");
		backButt.setBounds(864, 713, 87, 23);
		panel.add(backButt);
		backButt.addActionListener(this);
		
		addButt = new JButton("add");
		addButt.setBounds(622, 670, 87, 23);
		panel.add(addButt);
		addButt.addActionListener(this);
		
		delButt = new JButton("del");
		delButt.setBounds(719, 670, 87, 23);
		panel.add(delButt);
		delButt.addActionListener(this);
		
		reButt = new JButton("refresh");
		reButt.setBounds(864, 672, 87, 23);
		panel.add(reButt);
		reButt.addActionListener(this);
		
		JLabel label = new JLabel("name/time/level");
		label.setBounds(31, 672, 581, 21);
		panel.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reButt) {
			String Etxt="";
			try {
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("Select * from `exams`");
				while(rs.next()) {
					Etxt += rs.getString("name")+"\t"+rs.getString("time")+"\t"+rs.getString("level")+"\n";
					
				}
				EArea.setText(Etxt);
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		if(e.getSource()==addButt) {
			String ELine = editorPane.getText();
			String[] EA = ELine.split("/"); 
			try {
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				String ins = "insert into `exams` values('"+EA[0]+"',"+EA[1]+","+EA[2]+");";
				st.executeUpdate(ins);
				String insCreateExamPaper = "create table `"+EA[0]+"paper` (`question_num` int AUTO_INCREMENT primary key,`quetion` varchar(100), `ans` varchar(100));";
				st.executeUpdate(insCreateExamPaper);
				ResultSet rs = st.executeQuery("SELECT * FROM `exams` where `name`=\""+EA[0]+"\"");
				rs.next();
				if(rs.getInt("level") == 1) {
					QuestionSelect qs = new QuestionSelect(EA[0]+"paper",3,2,0);
				}else if(rs.getInt("level") == 2) {
					QuestionSelect qs = new QuestionSelect(EA[0]+"paper",1,3,1);
				}else if(rs.getInt("level") == 3) {
					QuestionSelect qs = new QuestionSelect(EA[0]+"paper",1,1,3);
				}
				
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		if(e.getSource()==delButt) {
			String ELine = editorPane.getText();
			String[] EA = ELine.split("/"); 
			try {
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				String ins = "delete from `exams` where `name`='"+EA[0]+"';";
				st.executeUpdate(ins);
				String insDelExamPaper = "drop table `"+EA[0]+"paper` ;";
				st.executeUpdate(insDelExamPaper);
				
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		if(e.getSource()==backButt) {
			frame.dispose();
			try {
				EMSelect window = new EMSelect();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
