package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class TeacherUI implements ActionListener{
	
	JButton btn1;
	JButton QMButt;
	JButton EPButt;
	String userName;
	
	public JFrame frame;
	private JButton EMButt;

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
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel.setBounds(135, 237, 699, 65);
		frame.getContentPane().add(lblNewLabel);
		
		String labelName = "Welcome , "+userName;
		JLabel lblNewLabel_1 = new JLabel(labelName);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(135, 170, 709, 65);
		frame.getContentPane().add(lblNewLabel_1);
		EMButt.addActionListener(this);
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
}
