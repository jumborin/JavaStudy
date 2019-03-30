package useFileTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import useFile.UseCsvFile;

/**
 * UseCsvFileクラスのテストクラス
 *
 * @author jumborin
 *
 */
class UseCsvFileTest {

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
	 * writeCsvFile()メソッドのテストメソッド
	 */
	@Test
	void testWriteCsvFile() {

		// テストデータ作成
		List<String> testDataList = new ArrayList<String>();
		testDataList.add("test1");
		testDataList.add("test2");
		testDataList.add("test3");
		testDataList.add("test4");

		// 読み込み対象のファイル
		String testDataCsvFile = "testWriteCsvFile.csv";
		UseCsvFile ucf = new UseCsvFile();

		try {

			// テスト対象のメソッドを実行
			ucf.writeCsvFile(testDataCsvFile, testDataList);

			// 作成されたテキストファイルを読み込んで書き込んだ値が正しいことを確認
			List<String[]> list = ucf.readCsvFile(testDataCsvFile);
			assertEquals("test1",list.get(0)[0]);
			assertEquals("test2", list.get(0)[1]);
			assertEquals("test3", list.get(0)[2]);
			assertEquals("test4", list.get(0)[3]);

			// ファイルが存在することを確認
			assertEquals(true, ucf.isExistFile(testDataCsvFile));

			// ファイルが削除できることを確認
			assertEquals(true, ucf.deleteFile(testDataCsvFile));

		} catch (IOException e) {
			fail("IOExceptionエラー");
		}
	}
}
