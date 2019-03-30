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

import useFile.UseTextFile;

/**
 * UseTextFileクラスのテストクラス
 *
 * @author jumborin
 *
 */
class UseTextFileTest {

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
	 * readTextFile()メソッドのテストメソッド
	 */
	@Test
	public void testReadTextFile() {
		UseTextFile utf = new UseTextFile();
		try {
			List<String> list = utf.readTextFile("D:\\workspace\\JavaStudy\\resource\\java.properties");
			assertEquals("# プロパティファイル", list.get(0));
			assertEquals("id=test1", list.get(1));
			assertEquals("pass=test2", list.get(2));
		} catch (IOException e) {
			fail("IOExceptionエラー");
		}
	}

	/**
	 * writeTextFile()メソッドのテストメソッド
	 */
	@Test
	void testWriteTextFile() {

		// テストデータ作成
		String testData = "test";

		// 読み込み対象のファイル
		String testDataTextFile = "testWriteTextFile.txt";
		UseTextFile utf = new UseTextFile();

		try {

			// テスト対象のメソッドを実行
			utf.writeTextFile(testDataTextFile, testData);

			// 作成されたテキストファイルを読み込んで書き込んだ値が正しいことを確認
			List<String> list = utf.readTextFile(testDataTextFile);
			assertEquals(testData, list.get(0));

			// ファイルが存在することを確認
			assertEquals(true, utf.isExistFile(testDataTextFile));

			// ファイルが削除できることを確認
			assertEquals(true, utf.deleteFile(testDataTextFile));

		} catch (IOException e) {
			fail("IOExceptionエラー");
		}
	}

	/**
	 * writeTextFileFromList()メソッドのテストメソッド
	 */
	@Test
	void testWriteTextFileFromList() {

		// テストデータ作成
		List<String> testDataList = new ArrayList<String>();
		testDataList.add("test1");
		testDataList.add("test2");

		// 読み込み対象のファイル
		String testDataTextFile = "testWriteTextFileFromList.txt";

		// テスト対象のクラスをインスタンス化
		UseTextFile utf = new UseTextFile();

		try {

			// テスト対象のメソッドを実行
			utf.writeTextFileFromList(testDataTextFile, testDataList);

			// 作成されたテキストファイルを読み込んで書き込んだ値が正しいことを確認
			List<String> list = utf.readTextFile(testDataTextFile);
			assertEquals("test1", list.get(0));
			assertEquals("test2", list.get(1));

			// ファイルが存在することを確認
			assertEquals(true, utf.isExistFile(testDataTextFile));

			// ファイルが削除できることを確認
			assertEquals(true, utf.deleteFile(testDataTextFile));

		} catch (IOException e) {
			fail("IOExceptionエラー");
		}
	}
}
