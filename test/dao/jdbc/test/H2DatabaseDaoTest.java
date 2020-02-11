package dao.jdbc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cons.TestConst;
import dao.jdbc.H2DatabaseDao;
import dbunit.util.DbUnitUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * H2DatabaseDaoのテストクラス.
 *
 * @author jumborin
 */
class H2DatabaseDaoTest {

  private static final String THIS_DIR = TestConst.PROJECT_ROOT_DIR + "\\test\\dao\\jdbc\\test\\";

  /**
   * select()のテストメソッド.
   */
  @Test
  void testSelect() {
    List<Map<String, String>> list = H2DatabaseDao.select("select * from test;");
    Map<String, String> map = list.get(0);
    assertEquals("1", map.get("ID"));
    assertEquals("tarou", map.get("NAME"));
    map = list.get(1);
    assertEquals("2", map.get("ID"));
    assertEquals("jirou", map.get("NAME"));
  }

  /**
   * selectDbUnit()のテストメソッド.
   */
  @Test
  void testSelectDbUnit() {
    try {
      DbUnitUtil.setUpNonExistSchema(THIS_DIR + "InitTestTable.xml");
      List<Map<String, String>> list = H2DatabaseDao.select("select * from test;");
      Map<String, String> map = list.get(0);
      assertEquals("1", map.get("ID"));
      assertEquals("tarou", map.get("NAME"));
      map = list.get(1);
      assertEquals("2", map.get("ID"));
      assertEquals("jirou", map.get("NAME"));
      DbUnitUtil.check(THIS_DIR + "ExpectedTestTable.xml", "test", new String[0]);
      DbUnitUtil.tearDown();
    } catch (ClassNotFoundException e) {
      fail("ClassNotFoundExceptionでエラー");
    } catch (SQLException e) {
      fail("SQLExceptionでエラー");
    } catch (Exception e) {
      fail("Exceptionでエラー");
    }
  }
}
