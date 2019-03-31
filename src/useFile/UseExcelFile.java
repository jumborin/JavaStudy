/**
 *
 */
package useFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excelファイルを扱うクラス
 * 利用条件：Apache POIが必要。
 *
 * @author jumborin
 */
public class UseExcelFile extends UseFile {
	/**
	 * 指定のExcelファイル、シート、セルから値を取得する。
	 * 利用条件：Apache POIが必要。
	 *
	 * @param excelFileName Excelファイル名
	 * @param excelSheetName Excelシート名
	 * @param rowNum 行番号
	 * @param columnNum 列番号
	 * @return セルの値
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getCellValueFromExcelFile(final String excelFileName, final String excelSheetName,
			final int rowNum, final int columnNum)
			throws FileNotFoundException, IOException {
		String cellValue = "";
		if (excelFileName.contains(".xlsx")) {
			Workbook book = new XSSFWorkbook(excelFileName);
			cellValue = book.getSheet(excelSheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
			book.close();
		} else {
			Workbook book = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(excelFileName)));
			cellValue = book.getSheet(excelSheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
			book.close();
		}
		return cellValue;
	}
}
