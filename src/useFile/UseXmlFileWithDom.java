package useFile;

import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * XMLファイルを扱うクラス
 *
 * @author jumborin
 */
public class UseXmlFileWithDom {
    /**
     * XMLファイルのパスとタグ名を引数に、要素の一覧を取得する。
     *
     * @param xmlFilePath
     * @param xmlTagName
     * @return XMLファイルの要素の一覧
     * @throws Exception
     */
    public NodeList readXmlFileWithDom(final String xmlFilePath, final String xmlTagName) throws Exception {
	DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	Element bookList = builder.parse(Paths.get(xmlFilePath).toFile()).getDocumentElement();
	NodeList nodeList = bookList.getElementsByTagName(xmlTagName);
	return nodeList;
    }
}
