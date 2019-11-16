package useFileTest;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
