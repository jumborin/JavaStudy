/**
 *
 */
package useFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * ファイルを読むクラス
 *
 * @author jumborin
 *
 */
public class ReadFile {

	/* プロパティクラス */
	private static Properties properties;

	/**
	 * プロパティファイルを読み込み、Mapに詰めて返却する。
	 *
	 * @param propertyFileName
	 * @return Map<String, String> プロパティファイルの中身のマップ
	 * @throws IOException
	 */
	public Map<String, String> readPropertyFile(final String propertyFileName) throws IOException {

		properties = new Properties();

		Map<String, String> map = null;

		//プロパティファイルを読み込む
		InputStream istream = new FileInputStream(propertyFileName);
		properties.load(istream);

		//マップに詰める
		map = new HashMap<String, String>();
		List<String> list = this.readTextFile(propertyFileName);
		for (String line : list) {
			if (line.contains("=")) {
				String[] val = line.split("=");
				map.put(val[0], properties.getProperty(val[0]));
			}
		}
		return map;
	}

	/**
	 * テキストファイルを読み込みリストで返却する。
	 *
	 * @param fileName ファイル名
	 * @return ArrayList<String> テキストファイルの行毎のリスト
	 * @throws IOException
	 */
	public List<String> readTextFile(final String fileName) throws IOException {

		FileReader fileReader = new FileReader(new File(fileName));
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line;
		List<String> list = new ArrayList<String>();

		while ((line = bufferedReader.readLine()) != null) {
			list.add(line);
		}

		fileReader.close();
		bufferedReader.close();

		return list;
	}
}
