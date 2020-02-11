package daoJdbcTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import cons.TestConst;
import daoJdbc.H2DatabaseDao;
import dbunitUtil.DbUnitUtil;

/**
 * H2DatabaseDaoのテストクラス
 *
 * @author jumborin
 */
class H2DatabaseDaoTest {

    /**
     * select()のテストメソッド
     */
    @Test
    void testSelect() {
	try {
	    List<Map<String, String>> list = H2DatabaseDao.select("select * from test;");
	    Map<String, String> map = list.get(0);
	    assertEquals("1", map.get("ID"));
	    assertEquals("tarou", map.get("NAME"));
	    map = list.get(1);
	    assertEquals("2", map.get("ID"));
	    assertEquals("jirou", map.get("NAME"));
	} catch (Exception e) {
	    fail("Exceptionでエラー");
	}
    }

    /**
     * selectDbUnit()のテストメソッド
     */
    @Test
    void testSelectDbUnit() {
	try {
	    DbUnitUtil.setUpNonExistSchema(TestConst.INPUT_DATA_DIR + "InitTestTable.xml");
	    List<Map<String, String>> list = H2DatabaseDao.select("select * from test;");
	    Map<String, String> map = list.get(0);
	    assertEquals("1", map.get("ID"));
	    assertEquals("tarou", map.get("NAME"));
	    map = list.get(1);
	    assertEquals("2", map.get("ID"));
	    assertEquals("jirou", map.get("NAME"));
	    DbUnitUtil.check(TestConst.INPUT_DATA_DIR + "ExpectedTestTable.xml", "test", new String[0]);
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
