package use.log.file;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import use.text.file.UseTextFile;

/**
 * ログファイルを出力するクラス.
 *
 * @author jumborin
 */
public class UseLogFile extends UseTextFile {

  /** ログファイル名. */
  private static String LOG_FILE_NAME;

  /**
   * コンストラクタ.
   *
   * @param logFileName 出力するログファイル名
   */
  public UseLogFile(final String logFileName) {
    LOG_FILE_NAME = logFileName;
  }

  /**
   * ログレベルをINFOとしてログを出力する.
   *
   * @param message ログメッセージ
   * @throws IOException IOException
   */
  public void writeInfoLog(final String message) throws IOException {
    this.outputLog("INFO ", message);
  }

  /**
   * ログレベルをDEBUGとしてログを出力する.
   *
   * @param message ログメッセージ
   * @throws IOException IOException
   */
  public void writeDebugLog(final String message) throws IOException {
    this.outputLog("DEBUG", message);
  }

  /**
   * ログレベルをWARNとしてログを出力する.
   *
   * @param message ログメッセージ
   * @throws IOException IOException
   */
  public void writeWarnLog(final String message) throws IOException {
    this.outputLog("WARN ", message);
  }

  /**
   * ログレベルをERRORとしてログを出力する.
   *
   * @param message ログメッセージ
   * @throws IOException IOException
   */
  public void writeErrorLog(final String message) throws IOException {
    this.outputLog("ERROR", message);
  }

  /**
   * ログレベルをFATALとしてログを出力する.
   *
   * @param message ログメッセージ
   * @throws IOException IOException
   */
  public void writeFatalLog(final String message) throws IOException {
    this.outputLog("FATAL", message);
  }

  /**
   * ログを出力する共通メソッド.
   *
   * @param logLevel ログレベル
   * @param logMessage ログメッセージ
   * @throws IOException IOException
   */
  private void outputLog(final String logLevel, final String logMessage) throws IOException {
    DateFormat dateSdf = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat timeSdf = new SimpleDateFormat("HH:mm:ss");
    super.writeTextFile(LOG_FILE_NAME, dateSdf.format(new Date()) + "," + timeSdf.format(new Date())
        + "," + logLevel + "," + logMessage);
  }
}
