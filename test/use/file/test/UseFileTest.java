package use.file.test;

import static org.junit.Assert.assertEquals;

import cons.TestConst;
import java.util.List;
import org.junit.jupiter.api.Test;
import use.file.UseFile;

/**
 * UseFileクラスのテストクラス.
 *
 * @author jumborin
 */
class UseFileTest {

  /** このフォルダのパス. */
  private static final String THIS_DIR = TestConst.PROJECT_ROOT_DIR + "\\test\\use\\file\\test\\";

  /**
   * isExistFile()のテストメソッド.
   */
  @Test
  void testIsExistFile() {

    // 読み込み対象のファイル
    final String testDataFile = THIS_DIR + "package-info.java";
    UseFile uf = new UseFile();

    // ファイルが存在することを確認
    assertEquals(true, uf.isExistFile(testDataFile));

    // ファイルが削除できないことを確認
    assertEquals(false, uf.deleteFile("NOT_EXIST.FILE"));
  }

  /**
   * deleteFile()のテストメソッド.
   */
  @Test
  void testDeleteFile() {
    UseFile uf = new UseFile();
    // ファイルが削除できないことを確認
    assertEquals(false, uf.deleteFile("NOT_EXIST.FILE"));
  }

  /**
   * getFileNameList()のテストメソッド.
   */
  @Test
  void testGetFileNameList() {
    UseFile uf = new UseFile();
    List<String> list = uf.getFileNameList(THIS_DIR);
    assertEquals(2, list.size());
    assertEquals(false, list.contains(THIS_DIR + "package-info.java"));
    assertEquals(true, list.contains("package-info.java"));
  }

  /**
   * getFullFilePathList()のテストメソッド.
   */
  @Test
  void testGetFullFilePathList() {
    UseFile uf = new UseFile();
    List<String> list = uf.getFullFilePathList(THIS_DIR);
    assertEquals(2, list.size());
    assertEquals(true, list.contains(THIS_DIR + "package-info.java"));
    assertEquals(false, list.contains("package-info.java"));
  }
}
