package useFileTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UsePropertyFile;

/**
 * UsePropertyFileクラスのテストクラス
 *
 * @author jumborin
 *
 */
class UsePropertyFileTest {

    /**
     * readPropertyFile()メソッドのテストメソッド
     */
    @Test
    void testReadPropertyFile() {

	// 読み込み対象のファイル
	String testFile = TestConst.INPUT_DATA_DIR + "java.properties";

	// テスト対象のクラスをインスタンス化
	UsePropertyFile rpf = new UsePropertyFile();

	try {

	    // テスト対象のメソッドを実行
	    Map<String, String> map = rpf.readPropertyFile(testFile);

	    // 実行結果が正しいかの確認
	    assertEquals("test1", map.get("id"));
	    assertEquals("test2", map.get("pass"));

	    // プロパティファイルが存在することを確認
	    assertEquals(true, rpf.isExistFile(testFile));

	} catch (IOException e) {
	    fail("IOExceptionエラー");
	}
    }

    /**
     * getProperty()メソッドのテストメソッド
     */
    @Test
    void testGetProperty() {

	// 読み込み対象のファイル
	String testFile = TestConst.INPUT_DATA_DIR + "java.properties";

	// テスト対象のクラスをインスタンス化
	UsePropertyFile rpf = new UsePropertyFile();

	try {
	    // 実行結果が正しいかの確認
	    assertEquals("test1", rpf.getProperty(testFile, "id"));
	    assertEquals("test2", rpf.getProperty(testFile, "pass"));
	} catch (FileNotFoundException e) {
	    fail("FileNotFoundExceptionでエラー");
	} catch (IOException e) {
	    fail("IOExceptionでエラー");
	}
    }
}