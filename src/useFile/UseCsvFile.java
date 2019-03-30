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

/**
 * テキストファイルを扱うクラス
 *
 * @author jumborin
 *
 */
public class UseCsvFile extends UseTextFile {

	/**
	 * CSVファイルを読み込みリストで返却する。
	 *
	 * @param csvFileName CSVファイル名
	 * @return ArrayList<String[]> CSVファイルの行毎のリスト
	 * @throws IOException
	 */
	public List<String[]> readCsvFile(final String csvFileName) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(csvFileName)));

		String line;
		List<String[]> list = new ArrayList<String[]>();

		while ((line = bufferedReader.readLine()) != null) {
			list.add(line.split(","));
		}

		bufferedReader.close();

		return list;
	}

	/**
	 * 引数のメッセージを引数のCSVファイルに追記する。
	 *
	 * @param textCsvName CSVファイル名
	 * @param writeMessageList 書き込むメッセージ(1行分)
	 * @throws IOException
	 */
	public void writeCsvFile(final String textCsvName, final List<String> writeMessageList) throws IOException {

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(textCsvName), true)));
		String writeData = "";
		for (String columnData : writeMessageList) {
			writeData = writeData + columnData;
		}
		pw.println(writeData);

		pw.close();
	}
}
