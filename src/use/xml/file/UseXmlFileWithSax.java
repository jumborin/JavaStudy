package use.xml.file;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XMLファイルの読込を行うクラス.
 *
 * @author jumborin
 */
public class UseXmlFileWithSax extends DefaultHandler {

  /**
   * XMLファイルの特定タグ内のものを読込、リスト化して返却する.
   *
   * @param xmlFileName XMLファイル名
   * @param tagNameList タグ名のリスト
   * @return XMLのマップリスト
   * @throws SAXException SAXException
   * @throws ParserConfigurationException ParserConfigurationException
   * @throws IOException IOException
   * @throws Exception Exception
   */
  public List<HashMap<String, String>> readXmlFileWithSax(final String xmlFileName,
      final String searchTagName, final List<String> tagNameList)
      throws ParserConfigurationException, SAXException, IOException {
    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
    UseXmlFileWithSaxHandler uxfwsh = new UseXmlFileWithSaxHandler(searchTagName, tagNameList);
    parser.parse(Paths.get(xmlFileName).toFile(), uxfwsh);
    return uxfwsh.resultMapList;
  }
}
