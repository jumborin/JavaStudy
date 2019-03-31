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

	@Test
	void testGetCellValueFromExcelFile() {
		String xlsxFileName = TestConst.INPUT_DATA_DIR + "testExcelFile.xlsx";
		String xlsxSheetName = "XlsxTestSheet";
		String xlsFileName = TestConst.INPUT_DATA_DIR + "testExcelFile.xls";
		String xlsSheetName = "XlsTestSheet";

		// テスト対象のクラスをインスタンス化
		UseExcelFile uef = new UseExcelFile();

		try {

			// xlsファイルを確認
			assertEquals(true,uef.isExistFile(xlsFileName));
			assertEquals("A1CellValue", uef.getCellValueFromExcelFile(xlsFileName, xlsSheetName, 0, 0));
			assertEquals("A2セルの値", uef.getCellValueFromExcelFile(xlsFileName, xlsSheetName, 1, 0));
			assertEquals("B1CellValue", uef.getCellValueFromExcelFile(xlsFileName, xlsSheetName, 0, 1));
			assertEquals("B2セルの値", uef.getCellValueFromExcelFile(xlsFileName, xlsSheetName, 1, 1));

			// xlsxファイルを確認
			assertEquals(true,uef.isExistFile(xlsxFileName));
			assertEquals("A1CellValue", uef.getCellValueFromExcelFile(xlsxFileName, xlsxSheetName, 0, 0));
			assertEquals("A2セルの値", uef.getCellValueFromExcelFile(xlsxFileName, xlsxSheetName, 1, 0));
			assertEquals("B1CellValue", uef.getCellValueFromExcelFile(xlsxFileName, xlsxSheetName, 0, 1));
			assertEquals("B2セルの値", uef.getCellValueFromExcelFile(xlsxFileName, xlsxSheetName, 1, 1));

		} catch (FileNotFoundException e) {
			fail("FileNotFoundExceptionでエラー");
		} catch (IOException e) {
			fail("IOExceptionでエラー");
		}
	}

}
