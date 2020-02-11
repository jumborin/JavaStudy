package useLogFileWithLog4JWith;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import useLogFile.UseLogFileWithLog4J;

/**
 * Log4Jを使ったクラスのテスト用クラス
 *
 * @author jumborin
 *
 */
public class UseLogFileWithLog4jTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testWriteTraceLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeTraceLog("トレースログのテスト");
	assertEquals(true, ulfwl.isExistFile("./logs/testlog.log"));
    }

    @Test
    void testWriteDebugLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeDebugLog("デバッグログのテスト");
	assertEquals(true, ulfwl.isExistFile("./logs/testlog.log"));
    }

    @Test
    void testWriteInfoLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeInfoLog("情報ログのテスト");
	assertEquals(true, ulfwl.isExistFile("./logs/testlog.log"));
    }

    @Test
    void testWriteWarnLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeWarnLog("ワーニングログのテスト");
	assertEquals(true, ulfwl.isExistFile("./logs/testlog.log"));
    }

    @Test
    void testWriteErrorLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeErrorLog("エラーログのテスト");
	assertEquals(true, ulfwl.isExistFile("./logs/testlog.log"));
    }

    @Test
    void testWriteFatalLog() {
	UseLogFileWithLog4J ulfwl = new UseLogFileWithLog4J();
	ulfwl.writeFatalLog("フェイタルログのテスト");
	assertEquals(true, ulfwl.isExistFile("./logs/testlog.log"));
    }
}
