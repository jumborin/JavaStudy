package useFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * プロパティファイルを扱うクラス
 *
 * @author jumborin
 *
 */
public class UsePropertyFile extends UseFile {

	/**
	 * プロパティファイルを読み込み、Mapに詰めて返却する。
	 *
	 * @param propertyFileName プロパティファイル名
	 * @return Map<String, String> プロパティファイルの中身のマップ
	 * @throws IOException
	 */
	public Map<String, String> readPropertyFile(final String propertyFileName) throws IOException {

		Map<String, String> resultMap = new HashMap<String, String>();

		UseTextFile utf = new UseTextFile();
		for (String line : utf.readTextFile(propertyFileName)) {
			if (line.contains("=")) {
				String[] val = line.split("=");
				resultMap.put(val[0], val[1]);
			}
		}
		return resultMap;
	}

	/**
	 * プロパティファイルから引数で指定したキーの該当するプロパティを取得し返却する。
	 *
	 * @param propertyFileName プロパティファイル名
	 * @param key 取得したいプロパティのキー文字列
	 * @return 引数で指定したキーに該当するプロパティ
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getProperty(final String propertyFileName, final String key)
			throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(propertyFileName));
		return properties.getProperty(key);
	}
}
