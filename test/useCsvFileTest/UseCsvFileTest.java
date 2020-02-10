package useCsvFileTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseCsvFile;

/**
 * UseCsvFileクラスのテストクラス
 *
 * @author jumborin
 *
 */
class UseCsvFileTest {

    /** テスト用のCSVファイル */
    private final String TEST_DATA_CSV_FILE = TestConst.PROJECT_ROOT_DIR + "\\test\\useCsvFileTest\\testWriteCsvFile.csv";

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
	UseCsvFile ucf = new UseCsvFile();

	try {

	    // テスト対象のメソッドを実行
	    ucf.writeCsvFile(TEST_DATA_CSV_FILE, testDataList);
	    ucf.writeCsvFile(TEST_DATA_CSV_FILE, testDataList);

	    // 作成されたテキストファイルを読み込んで書き込んだ値が正しいことを確認
	    List<String[]> list = ucf.readCsvFile(TEST_DATA_CSV_FILE);
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
	    assertEquals(true, ucf.isExistFile(TEST_DATA_CSV_FILE));

	    // ファイルが削除できることを確認
	    assertEquals(true, ucf.deleteFile(TEST_DATA_CSV_FILE));

	    // ファイルが存在しないことを確認
	    assertEquals(false, ucf.isExistFile(TEST_DATA_CSV_FILE));

	} catch (IOException e) {
	    fail("IOExceptionエラー");
	}
    }
}
