package use.xml.file.test;

import static org.junit.Assert.assertEquals;

import cons.TestConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import use.xml.file.UseXmlFileWithSax;

/**
 * UseXmlFileWithSaxクラスのテスト用クラス.
 *
 * @author jumborin
 */
class UseXmlFileWithSaxTest {

  /**
   * readXmlFileWithSax()のテストメソッド.
   *
   * @throws Exception Exception
   */
  @Test
  void testReadXmlFileWithSax() throws Exception {
    UseXmlFileWithSax uxfws = new UseXmlFileWithSax();
    List<String> tagNameList = new ArrayList<String>();
    tagNameList.add("author");
    tagNameList.add("title");
    tagNameList.add("text");

    List<HashMap<String, String>> resultMapList = uxfws.readXmlFileWithSax(
        TestConst.PROJECT_ROOT_DIR + "\\test\\use\\xml\\file\\test\\Book.xml", "Book", tagNameList);

    Map<String, String> map = resultMapList.get(0);
    assertEquals("清少納言", map.get("author"));
    assertEquals("枕草子", map.get("title"));

    Map<String, String> map2 = resultMapList.get(1);
    assertEquals("author", map2.get("author"));
    assertEquals("title", map2.get("title"));
  }
}
