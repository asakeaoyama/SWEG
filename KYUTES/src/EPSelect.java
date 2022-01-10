
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class EPSelect implements ActionListener{

	public JFrame frame; 
	JButton EPSMath;
	JButton EPSEnglish;
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
	public EPSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 761);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		EPSMath = new JButton("math");
		EPSMath.setBounds(72, 523, 300, 150);
		panel.add(EPSMath);
		EPSMath.addActionListener(this);
		
		EPSEnglish = new JButton("English");
		EPSEnglish.setBounds(447, 523, 300, 150);
		panel.add(EPSEnglish);
		EPSEnglish.addActionListener(this);
		
		backButt = new JButton("back");
		backButt.setBounds(804, 650, 87, 23);
		panel.add(backButt);
		
		lblNewLabel = new JLabel("Exam Paper Manage");
		lblNewLabel.setFont(new Font("�L�n������", Font.BOLD, 25));
		lblNewLabel.setBounds(72, 232, 675, 87);
		panel.add(lblNewLabel);
		backButt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==EPSMath) {
			System.out.println("in");
			frame.dispose();
			try {
				MathExamPaperEditor window = new MathExamPaperEditor();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==EPSEnglish) {
			System.out.println("in");
		}
		if(e.getSource()==backButt) {
			System.out.println("in");
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
