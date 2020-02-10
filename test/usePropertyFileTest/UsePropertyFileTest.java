package usePropertyFileTest;

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

    /** 読み込み対象のファイル */
    private static final String TEST_FILE = TestConst.PROJECT_ROOT_DIR + "\\test\\usePropertyFileTest\\java.properties";

    /**
     * readPropertyFile()メソッドのテストメソッド
     */
    @Test
    void testReadPropertyFile() {

	// テスト対象のクラスをインスタンス化
	UsePropertyFile rpf = new UsePropertyFile();

	try {

	    // プロパティファイルが存在することを確認
	    assertEquals(true, rpf.isExistFile(TEST_FILE));

	    // テスト対象のメソッドを実行
	    Map<String, String> map = rpf.readPropertyFile(TEST_FILE);

	    // 実行結果が正しいかの確認
	    assertEquals("test1", map.get("id"));
	    assertEquals("test2", map.get("pass"));

	} catch (IOException e) {
	    fail("IOExceptionエラー");
	}
    }

    /**
     * getProperty()メソッドのテストメソッド
     */
    @Test
    void testGetProperty() {

	// テスト対象のクラスをインスタンス化
	UsePropertyFile rpf = new UsePropertyFile();

	try {
	    // 実行結果が正しいかの確認
	    assertEquals("test1", rpf.getProperty(TEST_FILE, "id"));
	    assertEquals("test2", rpf.getProperty(TEST_FILE, "pass"));
	} catch (FileNotFoundException e) {
	    fail("FileNotFoundExceptionでエラー");
	} catch (IOException e) {
	    fail("IOExceptionでエラー");
	}
    }
}