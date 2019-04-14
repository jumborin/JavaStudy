package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H2DatabaseDao {

	/** H2DatabaseのJDBCドライバー */
	private static final String JDBC_DRIVER = "org.h2.Driver";

	/** H2DatabaseのDB接続 */
	private static final String DB_CONNECT = "jdbc:h2:~/test";

	/** H2Databaseのユーザ */
	private static final String USER = "sa";

	/** H2Databaseのパスワード */
	private static final String PASSWORD = "";

	/**
	 * H2Databaseに接続して指定のSQL文を実行し、List<Map>に変換して返却する。
	 *
	 * @param selectSQL selectするSQL文
	 * @return List<Map<String, String>> テーブルの全データ
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<Map<String, String>> select(final String selectSQL) throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(DB_CONNECT, USER, PASSWORD);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(selectSQL);
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", rs.getString("id"));
			map.put("name", rs.getString("name"));
			resultList.add(map);
		}
		conn.close();
		return resultList;
	}
}
