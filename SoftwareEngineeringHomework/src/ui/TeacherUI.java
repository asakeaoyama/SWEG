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
	JButton EMButt;
	
	
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TeacherUI window = new TeacherUI();
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
	public TeacherUI() {
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
		
		btn1 = new JButton("Score Inquiry");
		btn1.setBounds(283, 189, 141, 23);
		frame.getContentPane().add(btn1);
		btn1.addActionListener(this);
		
		QMButt = new JButton("Quetions Manage");
		QMButt.setBounds(10, 189, 113, 23);
		frame.getContentPane().add(QMButt);
		QMButt.addActionListener(this);
		
		EMButt = new JButton("Exam Manage");
		EMButt.setBounds(146, 189, 113, 23);
		frame.getContentPane().add(EMButt);
		EMButt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			frame.dispose();
			
			try {
				SearchScore window = new SearchScore();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==QMButt) {
			frame.dispose();
			try {
				QMSelect window = new QMSelect();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==EMButt) {
			frame.dispose();
			
			
		}
	}
}
