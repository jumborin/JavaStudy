package useFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XMLファイルの読込を行うクラス
 *
 * @author jumborin
 */
public class UseXmlFileWithSaxHandler extends DefaultHandler {

    /** 検索するタグ名 */
    String searchTagName;
    /** 取得するタグ名のリスト */
    List<String> tagNameList;
    /** 取得した値のマップのリスト */
    List<HashMap<String, String>> resultMapList;

    /**
     * デフォルトコンストラクタ
     */
    public UseXmlFileWithSaxHandler() {
    }

    /**
     * 引数ありコンストラクタ
     */
    public UseXmlFileWithSaxHandler(final String searchTagName, final List<String> tagNameList) {
	this.searchTagName = searchTagName;
	this.tagNameList = tagNameList;
	this.resultMapList = new ArrayList<HashMap<String, String>>(0);
    }

    /**
     * 開始タグを検知する
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	if (searchTagName.equals(qName)) {
	    HashMap<String, String> map = new HashMap<String, String>();
	    for (String tagName : tagNameList) {
		map.put(tagName, attributes.getValue(tagName));
	    }
	    this.resultMapList.add(map);
	}
    }

    /**
     * 終了タグを検知する
     */
    public void endElement(String uri, String localName, String qName) throws SAXException {
	if (searchTagName.equals(qName)) {
	    // 何もしない。
	}
    }
}
