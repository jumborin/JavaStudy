package useFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * ファイルを扱うクラス
 *
 * @author jumborin
 */
public class UseFile {

	/**
	 * 引数で指定したファイルが存在するかを確認し、その結果を返却する。
	 *
	 * @param fileName 存在確認を行うファイル名
	 * @return boolean true：ファイルが存在する　false：ファイルが存在しない
	 */
	public boolean isExistFile(final String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	/**
	 * 引数で指定したファイルを削除する。
	 *
	 * @param fileName 削除対象のファイル名
	 */
	public boolean deleteFile(final String textFileName) {
		File file = new File(textFileName);
		if (file.exists()) {
			return file.delete();
		}
		return false;
	}

	/**
	 * 指定ディレクトリ内にあるファイル名の一覧を取得し、返却する。
	 *
	 * @param getFileListDir ファイル名を取得するディレクトリ名
	 * @return 指定ディレクトリ内にあるファイル名の一覧
	 */
	public List<String> getFileNameList(final String getFileListDir) {
		List<String> fileNameList = new ArrayList<String>();
		for (File file : (new File(getFileListDir).listFiles())) {
			fileNameList.add(file.getName());
		}
		return fileNameList;
	}

	/**
	 * 指定ディレクトリ内にあるファイルのフルパスの一覧を取得し、返却する。
	 *
	 * @param getFileListDir ファイルパスを取得するディレクトリ名
	 * @return 指定ディレクトリ内にあるファイルのフルパスの一覧
	 */
	public List<String> getFullFilePathList(final String getFileListDir) {
		List<String> fullFilePathList = new ArrayList<String>();
		for (File file : (new File(getFileListDir).listFiles())) {
			fullFilePathList.add(file.toString());
		}
		return fullFilePathList;
	}
}
