package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(28, 228, 89, 23);
		panel.add(comboBox);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(140, 230, 258, 21);
		panel.add(editorPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 35, 369, 183);
		panel.add(textArea);
		
		backButt = new JButton("back");
		backButt.setBounds(28, 2, 87, 23);
		panel.add(backButt);
		backButt.addActionListener(this);
		
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
		
	}
}
