package useLogFileWithLog4JWithTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import useLogFileWithLog4JWith.UseLogFileWithLog4J;

/**
 * UseLogFileWithLog4jクラスのテストクラス
 *
 * @author jumborin
 */
public class UseLogFileWithLog4jTest {

    /** ログファイルパス */
    private static final String LOG_FILE_PATH = "./logs/testlog.log";

    /**
     * テストがすべて終わったときに実行するメソッド
     *
     * @throws Exception
     */
    @AfterAll
    static void tearDownAfterClass() throws Exception {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.deleteFile(LOG_FILE_PATH);
    }

    /**
     * writeTraceLog()のテストメソッド
     */
    @Test
    void testWriteTraceLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeTraceLog("トレースログのテスト");
	assertEquals(true, ulfwl.isExistFile(LOG_FILE_PATH));
    }

    /**
     * writeDebugLog()のテストメソッド
     */
    @Test
    void testWriteDebugLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeDebugLog("デバッグログのテスト");
	assertEquals(true, ulfwl.isExistFile(LOG_FILE_PATH));
    }

    /**
     * writeInfoLog()のテストメソッド
     */
    @Test
    void testWriteInfoLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeInfoLog("情報ログのテスト");
	assertEquals(true, ulfwl.isExistFile(LOG_FILE_PATH));
    }

    /**
     * writeWarnLog()のテストメソッド
     */
    @Test
    void testWriteWarnLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeWarnLog("ワーニングログのテスト");
	assertEquals(true, ulfwl.isExistFile(LOG_FILE_PATH));
    }

    /**
     * writeErrorLog()のテストメソッド
     */
    @Test
    void testWriteErrorLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeErrorLog("エラーログのテスト");
	assertEquals(true, ulfwl.isExistFile(LOG_FILE_PATH));
    }

    /**
     * writeFatalLog()のテストメソッド
     */
    @Test
    void testWriteFatalLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeFatalLog("フェイタルログのテスト");
	assertEquals(true, ulfwl.isExistFile(LOG_FILE_PATH));
    }
}