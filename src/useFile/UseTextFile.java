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
public class UseTextFile extends UseFile {

	/**
	 * テキストファイルを読み込みリストで返却する。
	 *
	 * @param textFileName テキストファイル名
	 * @return ArrayList<String> テキストファイルの行毎のリスト
	 * @throws IOException
	 */
	public List<String> readTextFile(final String textFileName) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(textFileName)));

		String line;
		List<String> list = new ArrayList<String>();

		while ((line = bufferedReader.readLine()) != null) {
			list.add(line);
		}

		bufferedReader.close();

		return list;
	}

	/**
	 * 引数のメッセージを引数のテキストファイルに追記する。
	 *
	 * @param textFileName テキストファイル名
	 * @param writeMessage 追記するメッセージ
	 * @throws IOException
	 */
	public void writeTextFile(final String textFileName, final String writeMessage) throws IOException {

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(textFileName), true)));
		pw.println(writeMessage);
		pw.close();

	}

	/**
	 * 引数のメッセージリストを引数のテキストファイルに追記する。
	 *
	 * @param textFileName テキストファイル名
	 * @param writeMessageList 書き込むメッセージのリスト
	 * @throws IOException
	 */
	public void writeTextFileFromList(final String textFileName, final List<String> writeMessageList)
			throws IOException {

		PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(textFileName), true)));

		for (String writeMessage : writeMessageList) {
			printWriter.println(writeMessage);
		}

		printWriter.close();
	}
}
