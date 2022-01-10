
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MathQueEditor implements ActionListener{

	public JFrame frame;
	private final JPanel panel = new JPanel();
	
	JButton backButt;
	JComboBox comboBox;
	JTextArea QArea;
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
					QueEditor window = new QueEditor();
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
	public MathQueEditor() {
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
		frame.setLocationRelativeTo(null);
		panel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(31, 672, 89, 23);
		panel.add(comboBox);
		comboBox.addItem("choose level");
		comboBox.addItem("Lv1");
		comboBox.addItem("Lv2");
		comboBox.addItem("Lv3");
		comboBox.addActionListener(this);
		 
		editorPane = new JEditorPane();
		editorPane.setBounds(161, 672, 581, 21);
		panel.add(editorPane);
		
		QArea = new JTextArea();
		QArea.setBounds(31, 10, 920, 627);
		panel.add(QArea);
		QArea.setEditable(false);
		
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
				QMSelect window = new QMSelect();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==comboBox) {
			String Qtxt="";
			String lvSelect = (String) comboBox.getSelectedItem();
			if (lvSelect.equals("Lv1")) {
				try {
					Connection conn = getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("Select * from `mathQ` where `lv`=1");
					while(rs.next()) {
						Qtxt += rs.getString("quetion")+"\t"+rs.getString("ans")+"\t"+rs.getString("lv")+"\n";
						
					}
					QArea.setText(Qtxt);
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
			else if (lvSelect.equals("Lv2")) {
				try {
					Connection conn = getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("Select * from `mathQ` where `lv`=2");
					while(rs.next()) {
						Qtxt += rs.getString("quetion")+"\t"+rs.getString("ans")+"\t"+rs.getString("lv")+"\n";
						
					}
					QArea.setText(Qtxt);
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
			else if (lvSelect.equals("Lv3")) {
				try {
					Connection conn = getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("Select * from `mathQ` where `lv`=3");
					while(rs.next()) {
						Qtxt += rs.getString("quetion")+"\t"+rs.getString("ans")+"\t"+rs.getString("lv")+"\n";
						
					}
					QArea.setText(Qtxt);
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
				
		}
		if(e.getSource()==addButt) {
			String QLine = editorPane.getText();
			String[] QA = QLine.split("/"); 
			try {
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				String ins = "insert into `mathQ` values('"+QA[0]+"','"+QA[1]+"',"+QA[2]+");";
				st.executeUpdate(ins);
				
				
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		if(e.getSource()==delButt) {
			String QLine = editorPane.getText();
			String[] QA = QLine.split("/"); 
			try {
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				String ins = "delete from `mathQ` where `quetion`='"+QA[0]+"';";
				st.executeUpdate(ins);
				
				
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}
}
