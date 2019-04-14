package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * H2Databaseを扱うクラス
 *
 * @author jumborin
 *
 */
public class H2DatabaseDao {

	/** H2DatabaseのJDBCドライバークラス */
	private static final String DRIVER_CLASS = "org.h2.Driver";

	/** H2DatabaseのDB接続URL */
	private static final String CONNECTION_URL = "jdbc:h2:~/test";

	/** H2Databaseのユーザ */
	private static final String USER_NAME = "sa";

	/** H2Databaseのパスワード */
	private static final String PASSWORD = "";

	/**
	 * H2Databaseにアクセスするためのコネクションを取得する。
	 *
	 * @return H2Database接続のためのコネクション
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		return DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
	}

	/**
	 * H2Databaseに接続して指定のSQL文を実行し、List<Map>に変換して返却する。
	 *
	 * @param selectSQL selectするSQL文
	 * @return List<Map<String, String>> テーブルの全データ
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<Map<String, String>> select(final String selectSQL) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(selectSQL);
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		ResultSetMetaData rsmd = rs.getMetaData();

		// 列名のリストを作成する。
		Set<String> columeNameSet = new HashSet<String>();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			columeNameSet.add(rsmd.getColumnName(i));
		}

		// 1件ずつデータを取得し、Mapに詰める。
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			for (String key : columeNameSet) {
				map.put(key, rs.getString(key));
			}
			resultList.add(map);
		}

		// 終了処理
		conn.close();
		st.close();
		rs.close();

		// 結果を返却
		return resultList;
	}
}
