package KYUTES;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StdScore implements ActionListener {
	
	public JFrame frame;
	private JPanel stdScore;
	private JButton previous;
	private static String userName;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StdScore window = new StdScore(userName);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public StdScore(String userName) {
		this.userName = userName;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		BarPanel bar = new BarPanel(frame,userName);

		stdScore = new JPanel();
		stdScore.setBounds(0, 50, 900, 550);
		stdScore.setBackground(new Color(186, 202, 224));
		stdScore.setLayout(null);
		frame.getContentPane().add(stdScore);
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		table.setBackground(new Color(240, 240, 240));
		table.setEnabled(false);
		model.addColumn("科目");
		model.addColumn("成績");
		try {
			Connection conn = UseDatabase.getConnection();
			PreparedStatement prest = conn.prepareStatement("SELECT * FROM user_"+userName);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1), rs.getInt(2) });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane jscrollPane = new JScrollPane(table);
		jscrollPane.setBounds(50, 50, 400, 100);
		stdScore.add(jscrollPane);
		
		previous = new JButton("上一頁");
		previous.setBounds(780, 450, 80, 25);
		previous.setFont(new Font("", Font.PLAIN, 10));
		stdScore.add(previous);
		previous.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==previous) {
			
			frame.dispose();
		}
	}
}