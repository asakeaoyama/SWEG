package KYUTES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionSelect {
	private int[] lv;
	private String test;

	/*
	 * public static void main(String[] args) { new QuestionSelect("midExamPaper",
	 * 3,1,1); }
	 */

	QuestionSelect(String test, int lv1, int lv2, int lv3) {
		this.test = test;
		lv = new int[3];
		lv[0] = lv1;
		lv[1] = lv2;
		lv[2] = lv3;
		randomTest();
	}

	void randomTest() {
		try {
			Connection conn = UseDatabase.getConnection();
			Statement st = conn.createStatement();

			for (int i = 0; i < 3; i++) {
				ArrayList<Integer> select = new ArrayList<Integer>();
				ResultSet rs = st.executeQuery("select `question_num` from `mathQ` where `lv` = " + (i + 1));
				while (rs.next()) {
					select.add(rs.getInt("question_num"));
				}

				for (int j = 0; j < lv[i]; j++) {
					int randomNum = 0;
					randomNum = (int) (Math.random() * (select.size() - 1));
					rs = st.executeQuery("select * from `mathQ` where `question_num` = " + select.get(randomNum));
					rs.next();
					// MySQL table裡的question打錯
					String sql = "INSERT INTO " + test + "(`quetion`,`ans`) VALUES(\"" + rs.getString("quetion")
							+ "\",\"" + rs.getString("ans") + "\")";
					st.execute(sql);
					select.remove(randomNum);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
