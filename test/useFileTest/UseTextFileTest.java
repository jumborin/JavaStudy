package useFileTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseTextFile;

/**
 * UseTextFileクラスのテストクラス
 *
 * @author jumborin
 *
 */
class UseTextFileTest {

    /**
     * readTextFile()メソッドのテストメソッド
     */
    @Test
    public void testReadTextFile() {

	// テスト時に読み込むファイル
	String testTextFile = TestConst.INPUT_DATA_DIR + "java.properties";

	// テスト対象のクラスをインスタンス化
	UseTextFile utf = new UseTextFile();
	try {
	    List<String> list = utf.readTextFile(testTextFile);
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

	// テスト時に書き込むファイル
	String testDataTextFile = TestConst.OUTPUT_DATA_DIR + "testWriteTextFile.txt";
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

	    // ファイルが存在しないことを確認
	    assertEquals(false, utf.isExistFile(testDataTextFile));

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

	// テスト時に書き込むファイル
	String testDataTextFile = TestConst.OUTPUT_DATA_DIR + "testWriteTextFileFromList.txt";

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

	    // ファイルが存在しないことを確認
	    assertEquals(false, utf.isExistFile(testDataTextFile));

	} catch (IOException e) {
	    fail("IOExceptionエラー");
	}
    }
}
