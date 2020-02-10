package useXmlFile;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import cons.TestConst;
import useFile.UseXmlFileWithSax;

class UseXmlFileWithSaxTest {

    @Test
    void testStartElementStringStringStringAttributes() {
	fail("まだ実装されていません");
    }

    @Test
    void testEndElementStringStringString() {
	fail("まだ実装されていません");
    }

    @Test
    void testReadXmlFileWithSax() throws Exception {
	UseXmlFileWithSax uxfws = new UseXmlFileWithSax();
	List<String> tagNameList = new ArrayList<String>();
	tagNameList.add("author");
	tagNameList.add("title");
	tagNameList.add("text");

	List<HashMap<String, String>> resultMapList = uxfws.readXmlFileWithSax(
		TestConst.WORK_SPACE_DIR + "\\JavaStudy\\test\\useXmlFile\\Book.xml", "Book", tagNameList);

	Map<String, String> map = resultMapList.get(0);
	assertEquals("清少納言", map.get("author"));
	assertEquals("枕草子", map.get("title"));

	Map<String, String> map2 = resultMapList.get(1);
	assertEquals("author", map2.get("author"));
	assertEquals("title", map2.get("title"));
    }
}
