package useFile;

import java.io.File;

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
}
