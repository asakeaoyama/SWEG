package KYUTES;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class SearchQuizScore extends JFrame implements ActionListener {
	private JPanel contentPane;
	JButton backButton;
	JComboBox comboBox;
	String scoretxt;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SearchQuizScore frame = new
	 * SearchQuizScore(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public SearchQuizScore() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton backButton = new JButton("back");
		backButton.setBounds(10, 216, 87, 23);
		panel.add(backButton);
		backButton.addActionListener(this);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 54, 87, 23);
		panel.add(comboBox);
		comboBox.addItem("choose examination");
		comboBox.addItem("mid exam");
		comboBox.addItem("final exam");
		comboBox.addActionListener(this);

		JTextArea textArea = new JTextArea();
		textArea.setText(scoretxt);
		textArea.setBounds(109, 23, 315, 217);
		panel.add(textArea);

		JLabel lblNewLabel = new JLabel("choose quiz");
		lblNewLabel.setBounds(21, 29, 81, 15);
		panel.add(lblNewLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {

		}
		if (e.getSource() == comboBox) {
			String examSelect = (String) comboBox.getSelectedItem();
			if (examSelect.equals("mid exam")) {
				try {
					Connection conn = UseDatabase.getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("Select * from `midExamScore`");
					while (rs.next()) {
						scoretxt += rs.getString("`name`") + "\t" + rs.getString("`score`") + "\n";
					}

				} catch (Exception e1) {
					System.out.println(e1);
				}
			}

		}

	}
}
