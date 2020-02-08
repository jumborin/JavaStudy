package useFileTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseFile;

/**
 * UseFileクラスのテストクラス
 *
 * @author jumborin
 */
class UseFileTest {

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
     * isExistFile()メソッドのテストメソッド
     */
    @Test
    void testIsExistFile() {

	// 読み込み対象のファイル
	final String testDataFile = TestConst.INPUT_DATA_DIR + "java.properties";
	UseFile uf = new UseFile();

	// ファイルが存在することを確認
	assertEquals(true, uf.isExistFile(testDataFile));

	// ファイルが削除できないことを確認
	assertEquals(false, uf.deleteFile("NOT_EXIST.FILE"));
    }

    @Test
    void testDeleteFile() {
	UseFile uf = new UseFile();
	// ファイルが削除できないことを確認
	assertEquals(false, uf.deleteFile("NOT_EXIST.FILE"));
    }

    /**
     * getFileNameList()メソッドのテストメソッド
     */
    @Test
    void testGetFileNameList() {
	UseFile uf = new UseFile();
	List<String> list = uf.getFileNameList(TestConst.INPUT_DATA_DIR);
	assertEquals(9, list.size());
	assertEquals(false, list.contains(TestConst.INPUT_DATA_DIR + "package-info.java"));
	assertEquals(true, list.contains("package-info.java"));
    }

    /**
     * getFullFilePathList()メソッドのテストメソッド
     */
    @Test
    void testGetFullFilePathList() {
	UseFile uf = new UseFile();
	List<String> list = uf.getFullFilePathList(TestConst.INPUT_DATA_DIR);
	assertEquals(9, list.size());
	assertEquals(true, list.contains(TestConst.INPUT_DATA_DIR + "package-info.java"));
	assertEquals(false, list.contains("package-info.java"));
    }
}
