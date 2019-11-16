package useFileTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseTsvFile;

/**
 * UseTsvFileクラスのテストクラス
 *
 * @author jumborin
 *
 */
class UseTsvFileTest {

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
	void testWriteTsvFile() {

		// テストデータ作成
		List<String> testDataList = new ArrayList<String>();
		testDataList.add("test1");
		testDataList.add("test2");
		testDataList.add("test3");
		testDataList.add("test4");

		// テスト時に書き込むファイル
		String testDataCsvFile = TestConst.INPUT_DATA_DIR + "testWriteCsvFile.csv";

		//テスト対象のクラスをインスタンス化
		UseTsvFile utf = new UseTsvFile();

		try {

			// テスト対象のメソッドを実行
			utf.writeTsvFile(testDataCsvFile, testDataList);

			// 作成されたテキストファイルを読み込んで書き込んだ値が正しいことを確認
			List<String[]> list = utf.readTsvFile(testDataCsvFile);
			String[] rowData = list.get(0);
			assertEquals("test1", rowData[0]);
			assertEquals("test2", rowData[1]);
			assertEquals("test3", rowData[2]);
			assertEquals("test4", rowData[3]);

			// ファイルが存在することを確認
			assertEquals(true, utf.isExistFile(testDataCsvFile));

			// ファイルが削除できることを確認
			assertEquals(true, utf.deleteFile(testDataCsvFile));

			// ファイルが存在しないことを確認
			assertEquals(false, utf.isExistFile(testDataCsvFile));

		} catch (IOException e) {
			fail("IOExceptionエラー");
		}
	}
}
