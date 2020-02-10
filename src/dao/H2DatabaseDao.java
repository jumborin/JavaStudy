package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * H2Databaseを扱うクラス
 *
 * @author jumborin
 *
 */
public class H2DatabaseDao {

    /** H2DatabaseのJDBCドライバークラスキー */
    private static final String DRIVER_CLASS = "DRIVER_CLASS";

    /** H2DatabaseのDB接続URLキー */
    private static final String CONNECTION_URL = "CONNECTION_URL";

    /** H2Databaseのユーザキー */
    private static final String USER_NAME = "USER_NAME";

    /** H2Databaseのパスワードキー */
    private static final String PASSWORD = "PASSWORD";

    /** プロパティファイル名 */
    private static final String PROPERTY_FILE_NAME = System.getProperty("user.dir")
	    + "\\src\\dao\\H2DBConfig.properties";

    /**
     * H2Databaseにアクセスするためのコネクションを取得する。
     *
     * @return H2Database接続のためのコネクション
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
	Properties properties = new Properties();
	try {
	    properties.load(new FileInputStream(PROPERTY_FILE_NAME));
	    Class.forName(properties.getProperty(DRIVER_CLASS));
	    return DriverManager.getConnection(properties.getProperty(CONNECTION_URL),
		    properties.getProperty(USER_NAME), properties.getProperty(PASSWORD));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    /**
     * H2Databaseに接続して指定のSQL文を実行し、List<Map>に変換して返却する。
     *
     * @param selectSQL selectするSQL文
     * @return List<Map<String, String>> テーブルの全データ
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static List<Map<String, String>> select(final String selectSQL) {
	ResultSet rs;
	ResultSetMetaData rsmd;
	// 列名のリストを作成する。
	Set<String> columeNameSet = new HashSet<String>();
	// 結果のリストを作成する。
	List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
	try {
	    rs = getConnection().createStatement().executeQuery(selectSQL);
	    rsmd = rs.getMetaData();
	    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
		columeNameSet.add(rsmd.getColumnName(i));
	    }
	    // 1件ずつデータを取得し、Mapに詰める。
	    while (rs.next()) {
		Map<String, String> map = new HashMap<String, String>();
		columeNameSet.parallelStream().forEach((key) -> {
		    try {
			map.put(key, rs.getString(key));
		    } catch (SQLException e) {
			e.printStackTrace();
		    }
		});
		resultList.add(map);
	    }
	    // 終了処理
	    rs.close();
	} catch (ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
	}
	// 結果を返却
	return resultList;
    }
}
