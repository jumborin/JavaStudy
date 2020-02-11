package dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatisでH2Databaseを扱うクラス.
 *
 * @author jumborin
 */
public class H2DatabaseMyBatisDao {

  /** MyBatisの設定ファイルのパス. */
  private static final String MYBATIS_CONFIG_FILE_PATH =
      System.getProperty("user.dir") + "\\resources\\mybatis-config.xml";

  /**
   * MyBatisを利用してselectする.
   *
   * @return TestEntityのリスト
   * @throws IOException IOException
   */
  public List<TestEntity> select() throws IOException {
    try (
        InputStream in = H2DatabaseMyBatisDao.class.getResourceAsStream(MYBATIS_CONFIG_FILE_PATH)) {
      SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
      try (SqlSession session = factory.openSession()) {
        return session.selectList("test.selectTest");
      }
    }
  }
}
