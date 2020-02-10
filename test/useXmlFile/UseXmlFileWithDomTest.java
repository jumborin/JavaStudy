package useXmlFile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cons.TestConst;
import useFile.UseXmlFileWithDom;

class UseXmlFileWithDomTest {
    @Test
    void testReadXmlFileWithDom() {
	UseXmlFileWithDom uxf = new UseXmlFileWithDom();
	NodeList books;
	try {
	    books = uxf.readXmlFileWithDom(TestConst.WORK_SPACE_DIR + "\\JavaStudy\\test\\useXmlFile\\Book.xml", "Book");
	    for (int i = 0; i < books.getLength(); i++) {
		Element book = (Element) books.item(i);
		String title = book.getAttribute("title");
		String author = book.getAttribute("author");
		String content = book.getTextContent();

		if (i == 0) {
		    assertEquals("清少納言", author);
		    assertEquals("枕草子", title);
		    assertEquals("春はあけぼの", content);
		}
		if (i == 1) {
		    assertEquals("author", author);
		    assertEquals("title", title);
		    assertEquals("content", content);
		}
	    }
	} catch (Exception e) {
	    fail();
	}
    }
}
