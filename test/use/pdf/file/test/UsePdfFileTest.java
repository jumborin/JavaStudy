package use.pdf.file.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cons.TestConst;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import use.log.file.with.log4j.with.UseLogFileWithLog4J;
import use.pdf.file.UsePdfFile;

/**
 * UsePdfFileクラスのテストクラス.
 *
 * @author jumborin
 */
class UsePdfFileTest {

  /** このフォルダのパス. */
  private static final String THIS_DIR =
      TestConst.PROJECT_ROOT_DIR + "\\test\\use\\pdf\\file\\test\\";

  /** テスト出力するPDFファイル名. */
  private static final String TEST_OUTPUT_PDF_FILE = THIS_DIR + "UsePdfFileOutputFile.pdf";

  /** テスト入力するPDFファイル名. */
  private static final String TEST_INPUT_PDF_FILE = THIS_DIR + "UsePdfFileInputFile.pdf";

  /**
   * テストがすべて終わったときに実行するメソッド.
   *
   * @throws Exception Exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {
    UsePdfFile upf = new UsePdfFile();
    // 作成した画像ファイルを削除する。
    upf.deleteFiles(THIS_DIR, ".jpg");
  }

  /**
   * createPdfFileOnlyText()メソッドのテストメソッド.
   */
  @Test
  void testCreatePdfFileOnlyText() {

    // テスト対象のクラスをインスタンス化
    UsePdfFile upf = new UsePdfFile();

    try {
      // テスト対象のメソッドを実行
      upf.createPdfFileOnlyText(TEST_OUTPUT_PDF_FILE, "test message");

      // PDFファイルが存在することを確認
      assertEquals(true, upf.isExistFile(TEST_OUTPUT_PDF_FILE));

      // PDFファイルを削除できたことを確認
      assertEquals(true, upf.deleteFile(TEST_OUTPUT_PDF_FILE));

      // PDFファイルが存在しないことを確認
      assertEquals(false, upf.isExistFile(TEST_OUTPUT_PDF_FILE));

    } catch (IOException e) {
      fail("IOExceptionでエラー");
    }
  }

  /**
   * getImageFromPdfFile()のテストメソッド.
   */
  @Test
  void testGetImageFromPdfFile() {
    // テスト対象のクラスをインスタンス化
    UsePdfFile upf = new UsePdfFile();
    try {
      upf.getImageFromPdfFile(TEST_INPUT_PDF_FILE, THIS_DIR);

      // 作成した画像ファイルを削除する。
      upf.deleteFiles(THIS_DIR, ".jpg");

    } catch (IOException e) {
      fail("IOExceptionのエラー");
    }
  }
}
