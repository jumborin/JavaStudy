package daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.H2DatabaseDao;

class H2DatabaseDaoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

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
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundExceptionでエラー");
		} catch (SQLException e) {
			fail("SQLExceptionでエラー");
		}
	}

}
