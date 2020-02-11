package useTsvFileTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cons.TestConst;
import useTsvFile.UseTsvFile;

/**
 * UseTsvFileクラスのテストクラス
 *
 * @author jumborin
 */
class UseTsvFileTest {

    /** テスト用のTSVファイル */
    private final String TEST_DATA_TSV_FILE = TestConst.PROJECT_ROOT_DIR
	    + "\\test\\useTsvFileTest\\testWriteTsvFile.tsv";

    /**
     * writeTsvFile()メソッドのテストメソッド
     */
    @Test
    void testWriteTsvFile() {

	// テストデータ作成
	List<String> testDataList = new ArrayList<String>();
	testDataList.add("test1");
	testDataList.add("test2");
	testDataList.add("test3");
	testDataList.add("test4");

	// テスト対象のクラスをインスタンス化
	UseTsvFile utf = new UseTsvFile();

	try {
	    // テスト対象のメソッドを実行
	    utf.writeTsvFile(TEST_DATA_TSV_FILE, testDataList);
	    utf.writeTsvFile(TEST_DATA_TSV_FILE, testDataList);

	    // 作成されたテキストファイルを読み込んで書き込んだ値が正しいことを確認
	    List<String[]> list = utf.readTsvFile(TEST_DATA_TSV_FILE);
	    String[] rowData = list.get(0);
	    assertEquals("test1", rowData[0]);
	    assertEquals("test2", rowData[1]);
	    assertEquals("test3", rowData[2]);
	    assertEquals("test4", rowData[3]);
	    rowData = list.get(1);
	    assertEquals("test1", rowData[0]);
	    assertEquals("test2", rowData[1]);
	    assertEquals("test3", rowData[2]);
	    assertEquals("test4", rowData[3]);

	    // ファイルが存在することを確認
	    assertEquals(true, utf.isExistFile(TEST_DATA_TSV_FILE));

	    // ファイルが削除できることを確認
	    assertEquals(true, utf.deleteFile(TEST_DATA_TSV_FILE));

	    // ファイルが存在しないことを確認
	    assertEquals(false, utf.isExistFile(TEST_DATA_TSV_FILE));

	} catch (IOException e) {
	    fail("IOExceptionエラー");
	}
    }
}
