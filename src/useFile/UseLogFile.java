package useFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ログファイルを出力するクラス
 *
 * @author jumborin
 *
 */
public class UseLogFile extends UseTextFile {

	/** ログファイル名 */
	private String LOG_FILE_NAME;

	/**
	 * コンストラクタ
	 * @param logFileName 出力するログファイル名
	 */
	public UseLogFile(final String logFileName) {
		LOG_FILE_NAME = logFileName;
	}

	/**
	 * ログレベルをINFOとしてログを出力する。
	 * @param message ログメッセージ
	 * @throws IOException
	 */
	public void writeInfoLog(final String message) throws IOException {
		this.outputLog("INFO ", message);
	}

	/**
	 * ログレベルをDEBUGとしてログを出力する。
	 * @param message ログメッセージ
	 * @throws IOException
	 */
	public void writeDebugLog(final String message) throws IOException {
		this.outputLog("DEBUG", message);
	}

	/**
	 * ログレベルをWARNとしてログを出力する。
	 * @param message ログメッセージ
	 * @throws IOException
	 */
	public void writeWarnLog(final String message) throws IOException {
		this.outputLog("WARN ", message);
	}

	/**
	 * ログレベルをERRORとしてログを出力する。
	 * @param message ログメッセージ
	 * @throws IOException
	 */
	public void writeErrorLog(final String message) throws IOException {
		this.outputLog("ERROR", message);
	}

	/**
	 * ログレベルをFATALとしてログを出力する。
	 * @param message ログメッセージ
	 * @throws IOException
	 */
	public void writeFatalLog(final String message) throws IOException {
		this.outputLog("FATAL", message);
	}

	/**
	 * ログを出力する共通メソッド
	 *
	 * @param LogLevel ログレベル
	 * @param logMessage ログメッセージ
	 * @throws IOException
	 */
	private void outputLog(final String LogLevel, final String logMessage) throws IOException {
		DateFormat dateSdf = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat timeSdf = new SimpleDateFormat("HH:mm:ss");
		super.writeTextFile(LOG_FILE_NAME,
				dateSdf.format(new Date()) + "," + timeSdf.format(new Date()) + "," + LogLevel + "," + logMessage);
	}
}
