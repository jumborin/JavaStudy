package use.log.file.test;

import static org.junit.Assert.fail;

import cons.TestConst;
import java.io.IOException;
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
   * writeInfoLog()のテストメソッド.
   */
  @DisplayName("INFOレベルでログ出力するテスト")
  @Test
  void testWriteInfoLog() {
    UseLogFile ulf = new UseLogFile(THIS_DIR + "testOutput.log");
    try {
      ulf.writeInfoLog("InfoMessage");
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
    } catch (IOException e) {
      fail("IOException");
    }
  }
}
