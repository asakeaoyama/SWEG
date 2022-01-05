package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class EMSelect implements ActionListener{


	public JFrame frame;
	JButton EMSMath;
	JButton EMSEnglish;
	JButton backButt ;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EMSelect window = new EMSelect();
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
	public EMSelect() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 761);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		EMSMath = new JButton("math");
		EMSMath.setBounds(99, 468, 300, 150);
		panel.add(EMSMath);
		EMSMath.addActionListener(this);
		
		EMSEnglish = new JButton("English");
		EMSEnglish.setBounds(432, 468, 300, 150);
		panel.add(EMSEnglish);
		EMSEnglish.addActionListener(this);
		
		backButt = new JButton("back");
		backButt.setBounds(846, 595, 87, 23);
		panel.add(backButt);
		
		lblNewLabel = new JLabel("Exam Manage");
		lblNewLabel.setFont(new Font("·L³n¥¿¶ÂÅé", Font.BOLD, 25));
		lblNewLabel.setBounds(99, 151, 268, 83);
		panel.add(lblNewLabel);
		backButt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==EMSMath) {
			frame.dispose();
			try {
				MathExamEditor window = new MathExamEditor();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==EMSEnglish) {
			
		}
		
		if(e.getSource()==backButt) {
			frame.dispose();
			/*
			try {
				TeacherUI window = new TeacherUI();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			*/
		}
	}

}
