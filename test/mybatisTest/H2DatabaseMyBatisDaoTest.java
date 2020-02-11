package mybatisTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.dbunit.dataset.DataSetException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cons.TestConst;
import daoMybatis.H2DatabaseMyBatisDao;
import daoMybatis.TestEntity;
import dbunitUtil.DbUnitUtil;

/**
 * H2DatabaseMyBatisDaoのテストクラス
 *
 * @author jumborin
 */
class H2DatabaseMyBatisDaoTest {

    /**
     * 毎回テストメソッド実行前に実施する処理
     *
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
	DbUnitUtil.setUpNonExistSchema(TestConst.INPUT_DATA_DIR + "InitTestTable.xml");
    }

    /**
     * 毎回テストメソッド実行後に実施する処理
     *
     * @throws Exception
     */
    @AfterEach
    void tearDown() throws Exception {
	DbUnitUtil.check(TestConst.INPUT_DATA_DIR + "ExpectedTestTable.xml", "test", new String[0]);
	DbUnitUtil.tearDown();
    }

    /**
     * select()のテストメソッド
     *
     * @throws DataSetException
     * @throws ClassNotFoundException
     * @throws Exception
     */
    @Test
    void selectTest() throws DataSetException, ClassNotFoundException, Exception {
	H2DatabaseMyBatisDao dao = new H2DatabaseMyBatisDao();
	List<TestEntity> resultList = dao.select();

	// 1行目のデータ確認
	TestEntity result = resultList.get(0);
	assertEquals("1", result.getId());
	assertEquals("tarou", result.getName());

	// 2行目のデータ確認
	result = resultList.get(1);
	assertEquals("2", result.getId());
	assertEquals("jirou", result.getName());
    }
}
