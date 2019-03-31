package useFileTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UsePropertyFile;

/**
 * UsePropertyFileクラスのテストクラス
 *
 * @author jumborin
 *
 */
class UsePropertyFileTest {

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
	 * readPropertyFile()メソッドのテストメソッド
	 */
	@Test
	void testReadPropertyFile() {

		// 読み込み対象のファイル
		String testFile = TestConst.INPUT_DATA_DIR
				+ "D:\\workspace\\JavaStudy\\test\\inputData\\java.properties";

		// テスト対象のクラスをインスタンス化
		UsePropertyFile rpf = new UsePropertyFile();

		try {

			// テスト対象のメソッドを実行
			Map<String, String> map = rpf.readPropertyFile(testFile);

			// 実行結果が正しいかの確認
			assertEquals("test1", map.get("id"));
			assertEquals("test2", map.get("pass"));

			// プロパティファイルが存在することを確認
			assertEquals(true, rpf.isExistFile(testFile));

		} catch (IOException e) {
			fail("IOExceptionエラー");
		}
	}
}
