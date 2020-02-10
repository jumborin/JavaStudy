package daoMybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatisでH2Databaseを扱うクラス
 *
 * @author jumborin
 *
 */
public class H2DatabaseMyBatisDao {
    public void select() throws IOException {
	try (InputStream in = H2DatabaseMyBatisDao.class.getResourceAsStream("/mybatis-config.xml")) {
	    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

	    try (SqlSession session = factory.openSession()) {
		// ★SqlSession を使って SQL を実行する
		List<Map<String, Object>> result = session.selectList("test.selectTest");

		result.forEach(row -> {
		    row.forEach((columnName, value) -> {
			System.out.printf("columnName=%s, value=%s%n", columnName, value);
		    });
		});
	    }
	}
    }
}