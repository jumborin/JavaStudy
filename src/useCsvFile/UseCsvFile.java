package useCsvFile;

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

import useFile.UseTextFile;

/**
 * CSVファイルを扱うクラス
 *
 * @author jumborin
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

	while (Objects.nonNull(line = bufferedReader.readLine())) {
	    list.add(line.split(","));
	}
	bufferedReader.close();
	return list;
    }

    /**
     * 引数のメッセージを引数のCSVファイルにカンマ区切りで追記する。
     *
     * @param csvFileName      CSVファイル名
     * @param writeMessageList 書き込むメッセージ(1行分)
     * @throws IOException
     */
    public void writeCsvFile(final String csvFileName, final List<String> writeMessageList) throws IOException {

	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(csvFileName), true)));
	String writeData = "";

	for (String columnData : writeMessageList) {
	    if (writeData != "") {
		writeData += "," + columnData;
	    } else {
		writeData = columnData;
	    }
	}
	pw.println(writeData);
	pw.close();
    }
}
