package KYUTES;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class QMSelect implements ActionListener {

	public JFrame frame;

	JButton QMSMath;
	JButton QMSEnglish;
	private JButton backButt;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QMSelect window = new QMSelect();
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
	public QMSelect() {
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
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 761);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		QMSMath = new JButton("math");
		QMSMath.setBounds(88, 546, 300, 150);
		panel.add(QMSMath);
		QMSMath.addActionListener(this);

		QMSEnglish = new JButton("English");
		QMSEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		QMSEnglish.setBounds(432, 546, 300, 150);
		panel.add(QMSEnglish);

		backButt = new JButton("back");
		backButt.setBounds(832, 673, 87, 23);
		panel.add(backButt);

		JLabel lblNewLabel = new JLabel("Question Pool Manage");
		lblNewLabel.setFont(new Font("�L�n������", Font.BOLD, 25));// ioioi
		lblNewLabel.setBounds(88, 220, 644, 65);
		panel.add(lblNewLabel);
		backButt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButt) {
			frame.dispose();
			/*
			 * try { TeacherUI window = new TeacherUI(); window.frame.setVisible(true); }
			 * catch (Exception e1) { e1.printStackTrace(); }
			 */
		}
		if (e.getSource() == QMSMath) {
			frame.dispose();
			try {
				MathQueEditor window = new MathQueEditor();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}
}
