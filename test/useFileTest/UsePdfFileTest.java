package useFileTest;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UsePdfFile;

class UsePdfFileTest {

    /**
     * createPdfFileOnlyText()メソッドのテストメソッド
     */
    @Test
    void testCreatePdfFileOnlyText() {

	// テスト出力するPDFファイル名
	String testPdfFile = TestConst.OUTPUT_DATA_DIR + "test.pdf";

	// テスト対象のクラスをインスタンス化
	UsePdfFile upf = new UsePdfFile();

	try {
	    // テスト対象のメソッドを実行
	    upf.createPdfFileOnlyText(testPdfFile, "test message");

	    // PDFファイルが存在することを確認
	    assertEquals(true, upf.isExistFile(testPdfFile));

	    // PDFファイルを削除できたことを確認
	    assertEquals(true, upf.deleteFile(testPdfFile));

	    // PDFファイルが存在しないことを確認
	    assertEquals(false, upf.isExistFile(testPdfFile));

	} catch (IOException e) {
	    fail("IOExceptionでエラー");
	}
    }

    @Test
    void testGetImageFromPdfFile() {
	// テスト対象のクラスをインスタンス化
	UsePdfFile upf = new UsePdfFile();
	try {
	    upf.getImageFromPdfFile(TestConst.INPUT_DATA_DIR + "test.pdf", TestConst.OUTPUT_DATA_DIR);
	} catch (IOException e) {
	    fail("IOExceptionのエラー");
	}
    }
}
