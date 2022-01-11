package KYUTES;

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

public class MathExamPaperEditor implements ActionListener {

	public JFrame frame;
	private final JPanel panel = new JPanel();
	JButton backButt;
	JComboBox<String> comboBox;
	JTextArea EArea;
	JButton addButt;
	JEditorPane editorPane;
	private JButton delButt;
	JButton reButt;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MathExamEditor window = new
	 * MathExamEditor(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 * 
	 * /** Create the application.
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
		frame.setLocationRelativeTo(null);
		panel.setBounds(0, 0, 984, 761);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(31, 672, 168, 23);
		panel.add(comboBox);
		comboBox.addItem("choose paper");
		try {
			Connection conn = UseDatabase.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from `exams`");
			while (rs.next()) {
				comboBox.addItem(rs.getString("name"));

			}

		} catch (Exception e1) {
			System.out.println(e1);
		}
		comboBox.addActionListener(this);

		editorPane = new JEditorPane();
		editorPane.setBounds(209, 672, 533, 21);
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

		reButt = new JButton("refresh");
		reButt.setBounds(875, 705, 87, 23);
		panel.add(reButt);
		reButt.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == backButt) {
			frame.dispose();
			frame.dispose();
			try {
				EPSelect window = new EPSelect();
				window.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == comboBox) {
			String Etxt = "";
			String ExamSelect = (String) comboBox.getSelectedItem();
			String[] examArr = new String[100];

			try {
				Connection conn = UseDatabase.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("Select * from `exams`");
				int counter = 0;
				while (rs.next()) {
					examArr[counter] = rs.getString("name");
					counter++;
				}

			} catch (Exception e1) {
				System.out.println(e1);
			}

			for (int i = 0; i < examArr.length; i++) {
				if (ExamSelect.equals(examArr[i])) {
					try {
						Connection conn = UseDatabase.getConnection();
						Statement st = conn.createStatement();
						String ins = "Select * from `" + examArr[i] + "paper`";
						ResultSet rs = st.executeQuery(ins);
						while (rs.next()) {
							Etxt += rs.getString("quetion") + "\t" + rs.getString("ans") + "\t\n";

						}
						EArea.setText(Etxt);

					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
			}
		}
		if (e.getSource() == addButt) {
			String QLine = editorPane.getText();
			String[] QA = QLine.split("/");
			String ExamSelect = (String) comboBox.getSelectedItem();

			try {
				Connection conn = UseDatabase.getConnection();
				Statement st = conn.createStatement();
				String ins = "insert into `" + ExamSelect + "paper` values('" + QA[0] + "','" + QA[1] + "');";
				st.executeUpdate(ins);

			} catch (Exception e1) {
				System.out.println(e1);
			}

		}
		if (e.getSource() == reButt) {
			String Etxt = "";
			String ExamSelect = (String) comboBox.getSelectedItem();
			try {
				Connection conn = UseDatabase.getConnection();
				Statement st = conn.createStatement();
				String ins = "Select * from `" + ExamSelect + "paper`";
				ResultSet rs = st.executeQuery(ins);
				while (rs.next()) {
					Etxt += rs.getString("quetion") + "\t" + rs.getString("ans") + "\t\n";

				}
				EArea.setText(Etxt);

			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}
}
