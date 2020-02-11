package dao.mybatis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cons.TestConst;
import dao.mybatis.H2DatabaseMyBatisDao;
import dao.mybatis.TestEntity;
import dbunit.util.DbUnitUtil;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * H2DatabaseMyBatisDaoのテストクラス.
 *
 * @author jumborin
 */
class H2DatabaseMyBatisDaoTest {

  /** このフォルダのパス. */
  private static final String THIS_DIR =
      TestConst.PROJECT_ROOT_DIR + "\\test\\dao\\mybatis\\test\\";

  /**
   * 毎回テストメソッド実行前に実施する処理.
   *
   * @throws Exception Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    DbUnitUtil.setUpNonExistSchema(THIS_DIR + "InitTestTable.xml");
  }

  /**
   * 毎回テストメソッド実行後に実施する処理.
   *
   * @throws Exception Exception
   */
  @AfterEach
  void tearDown() throws Exception {
    DbUnitUtil.check(THIS_DIR + "ExpectedTestTable.xml", "test", new String[0]);
    DbUnitUtil.tearDown();
  }

  /**
   * select()のテストメソッド.
   *
   * @throws DataSetException DataSetException
   * @throws ClassNotFoundException ClassNotFoundException
   * @throws Exception Exception
   */
  @Test
  void selectTest() {
    H2DatabaseMyBatisDao dao = new H2DatabaseMyBatisDao();
    try {
      List<TestEntity> resultList = dao.select();

      // 1行目のデータ確認
      TestEntity result = resultList.get(0);
      assertEquals("1", result.getId());
      assertEquals("tarou", result.getName());

      // 2行目のデータ確認
      result = resultList.get(1);
      assertEquals("2", result.getId());
      assertEquals("jirou", result.getName());

    } catch (IOException e) {
      e.printStackTrace();
      fail("IOException");
    }
  }
}
