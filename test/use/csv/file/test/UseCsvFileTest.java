package use.csv.file.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cons.TestConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import use.csv.file.UseCsvFile;

/**
 * UseCsvFileクラスのテストクラス.
 *
 * @author jumborin
 */
class UseCsvFileTest {

  /** テスト用のCSVファイル. */
  private static final String TEST_DATA_CSV_FILE =
      TestConst.PROJECT_ROOT_DIR + "\\test\\use\\csv\\file\\test\\testWriteCsvFile.csv";

  /**
   * writeCsvFile()のテストメソッド.
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
      List<List<String>> list = ucf.readCsvFile(TEST_DATA_CSV_FILE);
      List<String> rowData = list.get(0);
      assertEquals("test1", rowData.get(0));
      assertEquals("test2", rowData.get(1));
      assertEquals("test3", rowData.get(2));
      assertEquals("test4", rowData.get(3));

      rowData = list.get(1);
      assertEquals("test1", rowData.get(0));
      assertEquals("test2", rowData.get(1));
      assertEquals("test3", rowData.get(2));
      assertEquals("test4", rowData.get(3));

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
