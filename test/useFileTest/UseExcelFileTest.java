package useFileTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseExcelFile;

/**
 * UseExcelFileクラスのテストクラス
 * @author jumborin
 *
 */
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
	@DisplayName("Xlsxファイルの読み込みテスト")
	void testGetCellValueForXlsx() {

		// テスト用Excelファイル名
		final String excelFileName = TestConst.INPUT_DATA_DIR + "testExcelFile.xlsx";

		// テスト用Excelシート名
		final String excelSheetName = "XlsxTestSheet";

		// テスト対象のクラスをインスタンス化
		final UseExcelFile uef = new UseExcelFile();

		try {

			// ファイルの存在確認
			assertEquals(true, uef.isExistFile(excelFileName));

			//ファイルの中身が正しいことの確認
			assertEquals("A1CellValue", uef.getCellValue(excelFileName, excelSheetName, 0, 0));
			assertEquals("A2セルの値", uef.getCellValue(excelFileName, excelSheetName, 1, 0));
			assertEquals("B1CellValue", uef.getCellValue(excelFileName, excelSheetName, 0, 1));
			assertEquals("B2セルの値", uef.getCellValue(excelFileName, excelSheetName, 1, 1));

		} catch (FileNotFoundException e) {
			fail("FileNotFoundExceptionでエラー");
		} catch (IOException e) {
			fail("IOExceptionでエラー");
		}
	}

	/**
	 * 指定セルの読込テスト
	 */
	@Test
	@DisplayName("Xlsファイルの読み込みテスト")
	void testGetCellValueForXls() {

		// テスト用Excelファイル名
		final String excelFileName = TestConst.INPUT_DATA_DIR + "testExcelFile.xls";

		// テスト用Excelシート名
		final String excelSheetName = "XlsTestSheet";

		// テスト対象のクラスをインスタンス化
		final UseExcelFile uef = new UseExcelFile();

		try {

			// ファイルが存在すること
			assertEquals(true, uef.isExistFile(excelFileName));
			// A1セルを読み込んだ値が正しいこと
			assertEquals("A1CellValue", uef.getCellValue(excelFileName, excelSheetName, 0, 0));
			// A2セルを読み込んだ値が正しいこと
			assertEquals("A2セルの値", uef.getCellValue(excelFileName, excelSheetName, 1, 0));
			// B1セルを読み込んだ値が正しいこと
			assertEquals("B1CellValue", uef.getCellValue(excelFileName, excelSheetName, 0, 1));
			// B2セルを読み込んだ値が正しいこと
			assertEquals("B2セルの値", uef.getCellValue(excelFileName, excelSheetName, 1, 1));

		} catch (FileNotFoundException e) {
			fail("FileNotFoundExceptionでエラー");
		} catch (IOException e) {
			fail("IOExceptionでエラー");
		}
	}

	/**
	 * 指定セルの書き換えのテスト
	 * @throws InvalidFormatException
	 */
	@Test
	@DisplayName("Xlsxファイルに書き込むテスト")
	void testSetCellValueForXlsx() throws InvalidFormatException {

		// テスト用Excelファイル名
		final String excelFileName = TestConst.INPUT_DATA_DIR + "testExcelFile2.xlsx";
		// テスト用Excelシート名
		final String excelSheetName = "XlsxTestSheet";

		// テスト対象のクラスをインスタンス化
		final UseExcelFile uef = new UseExcelFile();

		try {
			// ファイルが存在することを確認
			assertEquals(true, uef.isExistFile(excelFileName));

			// A1セルの値が正しく読み込めていることを確認
			assertEquals("A1CellValue", uef.getCellValue(excelFileName, excelSheetName, 0, 0));

			uef.setCellValue(excelFileName, excelSheetName, 0, 0, "書き換え");

			// A1セルの値が書き換えた値になっていることを確認
			assertEquals("書き換え", uef.getCellValue(excelFileName, excelSheetName, 0, 0));

			uef.setCellValue(excelFileName, excelSheetName, 0, 0, "A1CellValue");

			// A1セルの値が書き換えた値になっていることを確認
			assertEquals("A1CellValue", uef.getCellValue(excelFileName, excelSheetName, 0, 0));

		} catch (FileNotFoundException e) {
			fail("FileNotFoundExceptionでエラー");
		} catch (IOException e) {
			fail("IOExceptionでエラー");
		}
	}

	/**
	 * 指定セルの書き換えのテスト
	 * @throws InvalidFormatException
	 */
	@Test
	@DisplayName("Xlsファイルに書き込むテスト")
	void testSetCellValueForXls() throws InvalidFormatException {

		// テスト用Excelファイル名
		final String excelFileName = TestConst.INPUT_DATA_DIR + "testExcelFile2.xls";
		// テスト用Excelシート名
		final String excelSheetName = "XlsTestSheet";

		// テスト対象のクラスをインスタンス化
		final UseExcelFile uef = new UseExcelFile();

		try {

			// ファイルが存在することを確認
			assertEquals(true, uef.isExistFile(excelFileName));

			// A1セルの値が正しく読み込めていることを確認
			assertEquals("A1CellValue", uef.getCellValue(excelFileName, excelSheetName, 0, 0));

			uef.setCellValue(excelFileName, excelSheetName, 0, 0, "書き換え");

			// A1セルの値が書き換えた値になっていることを確認
			assertEquals("書き換え", uef.getCellValue(excelFileName, excelSheetName, 0, 0));

			uef.setCellValue(excelFileName, excelSheetName, 0, 0, "A1CellValue");

			// A1セルの値が書き換えた値になっていることを確認
			assertEquals("A1CellValue", uef.getCellValue(excelFileName, excelSheetName, 0, 0));

		} catch (FileNotFoundException e) {
			fail("FileNotFoundExceptionでエラー");
		} catch (IOException e) {
			fail("IOExceptionでエラー");
		}
	}
}
