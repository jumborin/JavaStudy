package useFileTest;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseLogFile;

/**
 * UseLogFileクラスのテストクラス
 *
 * @author jumborin
 *
 */
class UseLogFileTest {

    /**
     * writeInfoLog()のテスト
     */
    @DisplayName("INFOレベルでログ出力するテスト")
    @Test
    void testWriteInfoLog() {
	UseLogFile ulf = new UseLogFile(TestConst.OUTPUT_DATA_DIR + "test.log");
	try {
	    ulf.writeInfoLog("InfoMessage");
	} catch (IOException e) {
	    fail("IOException");
	}
    }

    /**
     * writeDebugLog()のテスト
     */
    @DisplayName("DEBUGレベルでログ出力するテスト")
    @Test
    void testWriteDebugLog() {
	UseLogFile ulf = new UseLogFile(TestConst.OUTPUT_DATA_DIR + "test.log");
	try {
	    ulf.writeDebugLog("DebugMessage");
	} catch (IOException e) {
	    fail("IOException");
	}
    }

    /**
     * writeWarnLog()のテスト
     */
    @DisplayName("WARNレベルでログ出力するテスト")
    @Test
    void testWriteWarnLog() {
	UseLogFile ulf = new UseLogFile(TestConst.OUTPUT_DATA_DIR + "test.log");
	try {
	    ulf.writeWarnLog("WarnMessage");
	} catch (IOException e) {
	    fail("IOException");
	}
    }

    /**
     * writeErrorLog()のテスト
     */
    @DisplayName("ERRORレベルでログ出力するテスト")
    @Test
    void testWriteErrorLog() {
	UseLogFile ulf = new UseLogFile(TestConst.OUTPUT_DATA_DIR + "test.log");
	try {
	    ulf.writeErrorLog("ErrorMessage");
	} catch (IOException e) {
	    fail("IOException");
	}
    }

    /**
     * writeFatalLog()のテスト
     */
    @DisplayName("FATALレベルでログ出力するテスト")
    @Test
    void testWriteFatalLog() {
	UseLogFile ulf = new UseLogFile(TestConst.OUTPUT_DATA_DIR + "test.log");
	try {
	    ulf.writeFatalLog("FatalMessage");
	} catch (IOException e) {
	    fail("IOException");
	}
    }
}
