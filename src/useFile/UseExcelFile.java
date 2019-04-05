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
		ExcelFileType excelFileType = ExcelFileType.getEnum(excelFileName);
		String cellValue = excelFileType.getCellValueFromExcelFile(excelFileName, excelSheetName, rowNum, columnNum);
		return cellValue;
	}

	/**
	 * エクセルファイルの拡張子毎に処理を行うためのEnum
	 *
	 * @author jumborin
	 */
	private enum ExcelFileType {
		XLSX {
			/**
			 * 指定のエクセルからセルの値を取得し返却する。
			 */
			public String getCellValueFromExcelFile(final String excelFileName, final String excelSheetName,
					final int rowNum, final int columnNum) throws IOException {
				Workbook book = new XSSFWorkbook(excelFileName);
				String cellValue = book.getSheet(excelSheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
				book.close();
				return cellValue;
			}
		},
		XLS {
			/**
			 * 指定のエクセルからセルの値を取得し返却する。
			 */
			public String getCellValueFromExcelFile(final String excelFileName, final String excelSheetName,
					final int rowNum, final int columnNum) throws IOException {
				Workbook book = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(excelFileName)));
				String cellValue = book.getSheet(excelSheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
				book.close();
				return cellValue;
			}
		};

		/**
		 * 指定のエクセルからセルの値を取得し返却する。
		 *
		 * @param excelFileName エクセルファイル名
		 * @param excelSheetName エクセルシート名
		 * @param rowNum 行No
		 * @param columnNum 列No
		 * @return セルの値
		 * @throws IOException
		 */
		public String getCellValueFromExcelFile(String excelFileName, String excelSheetName, int rowNum,
				int columnNum) throws IOException {
			return this.getCellValueFromExcelFile(excelFileName, excelSheetName, rowNum, columnNum);
		}

		/**
		 * エクセルファイル名からEnumを判断して返却する。
		 *
		 * @param excelFileName エクセルファイル名
		 * @return UseExcelEnum
		 */
		public static ExcelFileType getEnum(final String excelFileName) {
			if (excelFileName.contains(".xlsx")) {
				return ExcelFileType.XLSX;
			} else {
				return ExcelFileType.XLS;
			}
		}
	}
}
