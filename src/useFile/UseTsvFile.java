package useFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TSVファイルを扱うクラス
 *
 * @author jumborin
 *
 */
public class UseTsvFile extends UseTextFile {

	/**
	 * TSVファイルを読み込みリストで返却する。
	 *
	 * @param tsvFileName TSVファイル名
	 * @return ArrayList<String[]> TSVファイルの行毎のリスト
	 * @throws IOException
	 */
	public List<String[]> readTsvFile(final String tsvFileName) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(tsvFileName)));

		String line;
		List<String[]> list = new ArrayList<String[]>();

		while (Objects.nonNull(line = bufferedReader.readLine())) {
			list.add(line.split("\t"));
		}

		bufferedReader.close();

		return list;
	}

	/**
	 * 引数のメッセージを引数のTSVファイルにタブ区切りで追記する。
	 *
	 * @param tsvFileName TSVファイル名
	 * @param writeMessageList 書き込むメッセージ(1行分)
	 * @throws IOException
	 */
	public void writeTsvFile(final String tsvFileName, final List<String> writeMessageList) throws IOException {

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(tsvFileName), true)));
		String writeData = "";

		for (String columnData : writeMessageList) {
			if (writeData != "") {
				writeData += "\t" + columnData;
			} else {
				writeData = columnData;
			}
		}

		pw.println(writeData);

		pw.close();
	}
}
