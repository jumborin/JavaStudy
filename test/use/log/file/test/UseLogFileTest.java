package use.log.file.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cons.TestConst;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import use.log.file.UseLogFile;

/**
 * UseLogFileクラスのテストクラス.
 *
 * @author jumborin
 */
class UseLogFileTest {

  /** このフォルダのパス. */
  private static final String THIS_DIR =
      TestConst.PROJECT_ROOT_DIR + "\\test\\use\\log\\file\\test\\";


  /**
   * 毎回テストメソッド実行後に実施する処理.
   *
   * @throws Exception Exception
   */
  @AfterEach
  void tearDown() throws Exception {
    UseLogFile ulf = new UseLogFile(THIS_DIR + "testOutput.log");
    ulf.deleteFile(THIS_DIR + "testOutput.log");
  }

  /**
   * writeInfoLog()のテストメソッド.
   */
  @DisplayName("INFOレベルでログ出力するテスト")
  @Test
  void testWriteInfoLog() {
    UseLogFile ulf = new UseLogFile(THIS_DIR + "testOutput.log");
    try {
      ulf.writeInfoLog("InfoMessage");

      // ログファイルが存在すること
      assertEquals(true, ulf.isExistFile(THIS_DIR + "testOutput.log"));

      List<String> readLogLineList = ulf.readTextFile(THIS_DIR + "testOutput.log");

      // 1行だけ出力されていること
      assertEquals(1, readLogLineList.size());

      // INFOが含まれていること
      assertEquals(true, readLogLineList.get(0).contains("INFO"));

    } catch (IOException e) {
      fail("IOException");
    }
  }

  /**
   * writeDebugLog()のテスト.
   */
  @DisplayName("DEBUGレベルでログ出力するテスト")
  @Test
  void testWriteDebugLog() {
    UseLogFile ulf = new UseLogFile(THIS_DIR + "testOutput.log");
    try {
      ulf.writeDebugLog("DebugMessage");

      // ログファイルが存在すること
      assertEquals(true, ulf.isExistFile(THIS_DIR + "testOutput.log"));


      List<String> readLogLineList = ulf.readTextFile(THIS_DIR + "testOutput.log");

      // 1行だけ出力されていること
      assertEquals(1, readLogLineList.size());

      // DEBUGが含まれていること
      assertEquals(true, readLogLineList.get(0).contains("DEBUG"));

    } catch (IOException e) {
      fail("IOException");
    }
  }

  /**
   * writeWarnLog()のテスト.
   */
  @DisplayName("WARNレベルでログ出力するテスト")
  @Test
  void testWriteWarnLog() {
    UseLogFile ulf = new UseLogFile(THIS_DIR + "testOutput.log");
    try {
      ulf.writeWarnLog("WarnMessage");

      // ログファイルが存在すること
      assertEquals(true, ulf.isExistFile(THIS_DIR + "testOutput.log"));

      List<String> readLogLineList = ulf.readTextFile(THIS_DIR + "testOutput.log");

      // 1行だけ出力されていること
      assertEquals(1, readLogLineList.size());

      // WARNが含まれていること
      assertEquals(true, readLogLineList.get(0).contains("WARN"));

    } catch (IOException e) {
      fail("IOException");
    }
  }

  /**
   * writeErrorLog()のテスト.
   */
  @DisplayName("ERRORレベルでログ出力するテスト")
  @Test
  void testWriteErrorLog() {
    UseLogFile ulf = new UseLogFile(THIS_DIR + "testOutput.log");
    try {
      ulf.writeErrorLog("ErrorMessage");

      // ログファイルが存在すること
      assertEquals(true, ulf.isExistFile(THIS_DIR + "testOutput.log"));

      List<String> readLogLineList = ulf.readTextFile(THIS_DIR + "testOutput.log");

      // 1行だけ出力されていること
      assertEquals(1, readLogLineList.size());

      // ERRORが含まれていること
      assertEquals(true, readLogLineList.get(0).contains("ERROR"));
    } catch (IOException e) {
      fail("IOException");
    }
  }

  /**
   * writeFatalLog()のテスト.
   */
  @DisplayName("FATALレベルでログ出力するテスト")
  @Test
  void testWriteFatalLog() {
    UseLogFile ulf = new UseLogFile(THIS_DIR + "testOutput.log");
    try {
      ulf.writeFatalLog("FatalMessage");

      // ログファイルが存在すること
      assertEquals(true, ulf.isExistFile(THIS_DIR + "testOutput.log"));

      List<String> readLogLineList = ulf.readTextFile(THIS_DIR + "testOutput.log");

      // 1行だけ出力されていること
      assertEquals(1, readLogLineList.size());

      // FATALが含まれていること
      assertEquals(true, readLogLineList.get(0).contains("FATAL"));
    } catch (IOException e) {
      fail("IOException");
    }
  }
}
