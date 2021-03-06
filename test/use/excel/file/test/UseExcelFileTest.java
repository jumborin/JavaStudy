package use.excel.file.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cons.TestConst;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import use.excel.file.UseExcelFile;

/**
 * UseExcelFileクラスのテストクラス.
 *
 * @author jumborin
 */
class UseExcelFileTest {

  private static final String THIS_DIR =
      TestConst.PROJECT_ROOT_DIR + "\\test\\use\\excel\\file\\test\\";

  /**
   * getCellValueForXlsx()のテストメソッド.
   */
  @Test
  @DisplayName("Xlsxファイルの読み込みテスト")
  void testGetCellValueForXlsx() {

    // テスト用Excelファイル名
    final String excelFileName = THIS_DIR + "testExcelFile.xlsx";

    // テスト用Excelシート名
    final String excelSheetName = "XlsxTestSheet";

    // テスト対象のクラスをインスタンス化
    final UseExcelFile uef = new UseExcelFile();

    try {

      // ファイルの存在確認
      assertEquals(true, uef.isExistFile(excelFileName));

      // ファイルの中身が正しいことの確認
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
   * getCellValueForXls()のテストメソッド.
   */
  @Test
  @DisplayName("Xlsファイルの読み込みテスト")
  void testGetCellValueForXls() {

    // テスト用Excelファイル名
    final String excelFileName = THIS_DIR + "testExcelFile.xls";

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
   * setCellValueForXlsx()のテストメソッド.
   *
   * @throws InvalidFormatException InvalidFormatException
   */
  @Test
  @DisplayName("Xlsxファイルに書き込むテスト")
  void testSetCellValueForXlsx() throws InvalidFormatException {

    // テスト用Excelファイル名
    final String excelFileName = THIS_DIR + "testExcelFileUpdate.xlsx";
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
   * setCellValueForXls()のテストメソッド.
   *
   * @throws InvalidFormatException InvalidFormatException
   */
  @Test
  @DisplayName("Xlsファイルに書き込むテスト")
  void testSetCellValueForXls() throws InvalidFormatException {

    // テスト用Excelファイル名
    final String excelFileName = THIS_DIR + "testExcelFileUpdate.xls";
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
