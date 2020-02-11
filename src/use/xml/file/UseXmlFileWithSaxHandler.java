package use.xml.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XMLファイルの読込を行うクラス.
 *
 * @author jumborin
 */
public class UseXmlFileWithSaxHandler extends DefaultHandler {

  /** 検索するタグ名. */
  String searchTagName;
  /** 取得するタグ名のリスト. */
  List<String> tagNameList;
  /** 取得した値のマップのリスト. */
  List<HashMap<String, String>> resultMapList;

  /**
   * デフォルトコンストラクタ.
   */
  public UseXmlFileWithSaxHandler() {}

  /**
   * 引数ありコンストラクタ.
   *
   * @param searchTagName 検索タグ名
   * @param tagNameList 値を取得するタグ名リスト
   */
  public UseXmlFileWithSaxHandler(final String searchTagName, final List<String> tagNameList) {
    this.searchTagName = searchTagName;
    this.tagNameList = tagNameList;
    this.resultMapList = new ArrayList<HashMap<String, String>>(0);
  }

  /**
   * 開始タグを検知する.
   */
  @Override
  public void startElement(String uri, String localName, String searchName, Attributes attributes)
      throws SAXException {
    if (searchTagName.equals(searchName)) {
      HashMap<String, String> map = new HashMap<String, String>();
      tagNameList.parallelStream()
          .forEach((tagName) -> map.put(tagName, attributes.getValue(tagName)));
      this.resultMapList.add(map);
    }
  }

  /**
   * 終了タグを検知する.
   */
  @Override
  public void endElement(String uri, String localName, String searchName) throws SAXException {
    if (searchTagName.equals(searchName)) {
      // 何もしない。
    }
  }
}
