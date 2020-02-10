package mybatisTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import daoMybatis.H2DatabaseMyBatisDao;

class H2DatabaseMyBatisDaoTest {

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
    void selectTest() throws IOException {
	List<Map<String, Object>> resultMapList = null;
	H2DatabaseMyBatisDao dao = new H2DatabaseMyBatisDao();
	dao.select();

    }

}
