package daoMybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatisでH2Databaseを扱うクラス
 *
 * @author jumborin
 */
public class H2DatabaseMyBatisDao {

    /**
     * MyBatisを利用してselectする
     *
     * @return TestEntityのリスト
     * @throws IOException
     */
    public List<TestEntity> select() throws IOException {
	try (InputStream in = H2DatabaseMyBatisDao.class.getResourceAsStream("/mybatis-config.xml")) {
	    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
	    try (SqlSession session = factory.openSession()) {
		return session.selectList("test.selectTest");
	    }
	}
    }
}