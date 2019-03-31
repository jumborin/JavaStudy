package useFileTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseFile;

/**
 * UseFileクラスのテストクラス
 *
 * @author jumborin
 */
class UseFileTest {

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

	/**
	 * isExistFile()メソッドのテストメソッド
	 */
	@Test
	void testIsExistFile() {

		// 読み込み対象のファイル
		String testDataFile = TestConst.INPUT_DATA_DIR + "java.properties";
		UseFile uf = new UseFile();

		// ファイルが存在することを確認
		assertEquals(true, uf.isExistFile(testDataFile));

		// ファイルが削除できることを確認
		assertEquals(false, uf.deleteFile("NOT_EXIST.FILE"));
	}
}
