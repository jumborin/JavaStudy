package useLogFile;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import useFile.UseFile;

/**
 * Log4Jを使ってログファイルを扱うクラス
 *
 * @author jumborin
 */
public class UseLogFileWithLog4J extends UseFile {

    /** ロガー */
    private Logger logger = Logger.getLogger(UseLogFileWithLog4J.class);

    /**
     * 設定ファイルを読み込む
     */
    private void readConfig() {
	DOMConfigurator.configure(LogConst.LOG4J_CONFIG_FILE);
    }

    public static void main(String[] args) {
	DOMConfigurator.configure(LogConst.LOG4J_CONFIG_FILE);
	Logger logger = Logger.getLogger(UseLogFileWithLog4J.class);
	logger.error("test99");
    }

    /**
     * Traceログを出力する(yyyy/mm/dd HH:MM:ss:sss [メソッド名] TRACE クラス名 message )
     *
     * @param message
     */
    public void writeTraceLog(final String message) {
	this.readConfig();
	logger.trace(message);
    }

    /**
     * Debugログを出力する(yyyy/mm/dd HH:MM:ss:sss [メソッド名] DEBUG クラス名 message )
     *
     * @param message
     */
    public void writeDebugLog(final String message) {
	this.readConfig();
	logger.debug(message);
    }

    /**
     * Infoログを出力する(yyyy/mm/dd HH:MM:ss:sss [メソッド名] INFO クラス名 message )
     *
     * @param message
     */
    public void writeInfoLog(final String message) {
	this.readConfig();
	logger.info(message);
    }

    /**
     * Warnログを出力する(yyyy/mm/dd HH:MM:ss:sss [メソッド名] WARN クラス名 message )
     *
     * @param message
     */
    public void writeWarnLog(final String message) {
	this.readConfig();
	logger.warn(message);
    }

    /**
     * Errorログを出力する(yyyy/mm/dd HH:MM:ss:sss [メソッド名] ERROR クラス名 message )
     *
     * @param message
     */
    public void writeErrorLog(final String message) {
	this.readConfig();
	logger.error(message);
    }

    /**
     * Fatalログを出力する(yyyy/mm/dd HH:MM:ss:sss [メソッド名] FATAL クラス名 message)
     *
     * @param message
     */
    public void writeFatalLog(final String message) {
	this.readConfig();
	logger.fatal(message);
    }
}