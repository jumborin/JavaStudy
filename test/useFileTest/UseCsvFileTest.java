package useFileTest;

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
	String testDataCsvFile = TestConst.INPUT_DATA_DIR + "testWriteCsvFile.csv";
	UseCsvFile ucf = new UseCsvFile();

	try {

	    // テスト対象のメソッドを実行
	    ucf.writeCsvFile(testDataCsvFile, testDataList);

	    // 作成されたテキストファイルを読み込んで書き込んだ値が正しいことを確認
	    List<String[]> list = ucf.readCsvFile(testDataCsvFile);
	    String[] rowData = list.get(0);
	    assertEquals("test1", rowData[0]);
	    assertEquals("test2", rowData[1]);
	    assertEquals("test3", rowData[2]);
	    assertEquals("test4", rowData[3]);

	    // ファイルが存在することを確認
	    assertEquals(true, ucf.isExistFile(testDataCsvFile));

	    // ファイルが削除できることを確認
	    assertEquals(true, ucf.deleteFile(testDataCsvFile));

	    // ファイルが存在しないことを確認
	    assertEquals(false, ucf.isExistFile(testDataCsvFile));

	} catch (IOException e) {
	    fail("IOExceptionエラー");
	}
    }
}
