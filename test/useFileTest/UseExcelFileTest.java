package useFileTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseExcelFile;

class UseExcelFileTest {

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
	 * 指定セルの読込テスト
	 */
	@Test
	void testGetCellValue() {
		final String xlsxFileName = TestConst.INPUT_DATA_DIR + "testExcelFile.xlsx";
		final String xlsxSheetName = "XlsxTestSheet";
		final String xlsFileName = TestConst.INPUT_DATA_DIR + "testExcelFile.xls";
		final String xlsSheetName = "XlsTestSheet";

		// テスト対象のクラスをインスタンス化
		UseExcelFile uef = new UseExcelFile();

		try {

			// xlsファイルを確認
			assertEquals(true, uef.isExistFile(xlsFileName));
			assertEquals("A1CellValue", uef.getCellValue(xlsFileName, xlsSheetName, 0, 0));
			assertEquals("A2セルの値", uef.getCellValue(xlsFileName, xlsSheetName, 1, 0));
			assertEquals("B1CellValue", uef.getCellValue(xlsFileName, xlsSheetName, 0, 1));
			assertEquals("B2セルの値", uef.getCellValue(xlsFileName, xlsSheetName, 1, 1));

			// xlsxファイルを確認
			assertEquals(true, uef.isExistFile(xlsxFileName));
			assertEquals("A1CellValue", uef.getCellValue(xlsxFileName, xlsxSheetName, 0, 0));
			assertEquals("A2セルの値", uef.getCellValue(xlsxFileName, xlsxSheetName, 1, 0));
			assertEquals("B1CellValue", uef.getCellValue(xlsxFileName, xlsxSheetName, 0, 1));
			assertEquals("B2セルの値", uef.getCellValue(xlsxFileName, xlsxSheetName, 1, 1));

		} catch (FileNotFoundException e) {
			fail("FileNotFoundExceptionでエラー");
		} catch (IOException e) {
			fail("IOExceptionでエラー");
		}
	}

	/**
	 * 指定セルの書き換えのテスト
	 */
	@Test
	void testSetCellValue() {
		final String xlsxFileName = TestConst.INPUT_DATA_DIR + "testExcelFile.xlsx";
		final String xlsxSheetName = "XlsxTestSheet";
		final String xlsFileName = TestConst.INPUT_DATA_DIR + "testExcelFile.xls";
		final String xlsSheetName = "XlsTestSheet";

		// テスト対象のクラスをインスタンス化
		UseExcelFile uef = new UseExcelFile();

		try {

			// xlsファイルを確認
			assertEquals(true, uef.isExistFile(xlsFileName));
			assertEquals("A1CellValue", uef.getCellValue(xlsFileName, xlsSheetName, 0, 0));
			uef.setCellValue(xlsFileName, xlsSheetName, 0, 0, "書き換え");
			assertEquals("書き換え", uef.getCellValue(xlsFileName, xlsSheetName, 0, 0));
			uef.setCellValue(xlsFileName, xlsSheetName, 0, 0, xlsSheetName);
			assertEquals("A1CellValue", uef.getCellValue(xlsFileName, xlsSheetName, 0, 0));

			// xlsxファイルを確認
			assertEquals(true, uef.isExistFile(xlsxFileName));
			assertEquals("A1CellValue", uef.getCellValue(xlsxFileName, xlsxSheetName, 0, 0));
			uef.setCellValue(xlsFileName, xlsSheetName, 0, 0, "書き換え");
			assertEquals("書き換え", uef.getCellValue(xlsFileName, xlsSheetName, 0, 0));
			uef.setCellValue(xlsFileName, xlsSheetName, 0, 0, xlsSheetName);
			assertEquals("A1CellValue", uef.getCellValue(xlsFileName, xlsSheetName, 0, 0));

		} catch (FileNotFoundException e) {
			fail("FileNotFoundExceptionでエラー");
		} catch (IOException e) {
			fail("IOExceptionでエラー");
		}
	}
}
