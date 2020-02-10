package useFileTest;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UsePdfFile;

/**
 * RDFBoxを使ってPDFの操作を行うクラス
 *
 * @author jumborin
 */
class UsePdfFileTest {

    /** テスト出力するPDFファイル名 */
    private final String TEST_OUTPUT_PDF_FILE = TestConst.OUTPUT_DATA_DIR + "test.pdf";
    private final String TEST_INPUT_PDF_FILE = TestConst.INPUT_DATA_DIR + "test.pdf";

    /**
     * createPdfFileOnlyText()メソッドのテストメソッド
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

    @Test
    void testGetImageFromPdfFile() {
	// テスト対象のクラスをインスタンス化
	UsePdfFile upf = new UsePdfFile();
	try {
	    upf.getImageFromPdfFile(TEST_INPUT_PDF_FILE, TestConst.OUTPUT_DATA_DIR);
	} catch (IOException e) {
	    fail("IOExceptionのエラー");
	}
    }
}
