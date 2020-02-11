package useExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import useFile.UseFile;

/**
 * Excelファイルを扱うクラス 利用条件：Apache POIが必要。
 *
 * @author jumborin
 */
public class UseExcelFile extends UseFile {

    /**
     * 指定のExcelファイル、シート、セルから値を取得する。 利用条件：Apache POIが必要。
     *
     * @param excelFileName  Excelファイル名
     * @param excelSheetName Excelシート名
     * @param rowNum         行番号
     * @param columnNum      列番号
     * @return セルの値
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String getCellValue(final String excelFileName, final String excelSheetName, final int rowNum,
	    final int columnNum) throws FileNotFoundException, IOException {
	ExcelFileType excelFileType = ExcelFileType.getEnum(excelFileName);
	String cellValue = excelFileType.getCellValue(excelFileName, excelSheetName, rowNum, columnNum);
	return cellValue;
    }

    /**
     * 引数の値を指定のセルに設定する。 利用条件：Apache POIが必要。
     *
     * @param excelFileName  Excelファイル名
     * @param excelSheetName Excelシート名
     * @param rowNum         行番号
     * @param columnNum      列番号
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidFormatException
     */
    public void setCellValue(final String excelFileName, final String excelSheetName, final int rowNum,
	    final int columnNum, final String value) throws FileNotFoundException, IOException, InvalidFormatException {
	ExcelFileType excelFileType = ExcelFileType.getEnum(excelFileName);
	excelFileType.setCellValue(excelFileName, excelSheetName, rowNum, columnNum, value);
    }

    /**
     * エクセルファイルの拡張子毎に処理を行うためのEnum
     *
     * @author jumborin
     */
    public enum ExcelFileType {
	XLSX {
	    /**
	     * 指定のエクセルからセルの値を取得し返却する。
	     */
	    public String getCellValue(final String excelFileName, final String excelSheetName, final int rowNum,
		    final int columnNum) throws IOException {
		Workbook book = new XSSFWorkbook(new FileInputStream(excelFileName));
		String cellValue = book.getSheet(excelSheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
		book.close();
		return cellValue;
	    }

	    /**
	     * 引数の値を指定のエクセルのセルの値に設定する。
	     *
	     * @throws InvalidFormatException
	     */
	    public void setCellValue(final String excelFileName, final String excelSheetName, final int rowNum,
		    final int columnNum, final String value)
		    throws IOException, InvalidFormatException, FileNotFoundException {
		Workbook book = new XSSFWorkbook(new FileInputStream(excelFileName));
		book.getSheet(excelSheetName).getRow(rowNum).getCell(columnNum).setCellValue(value);
		book.write(new FileOutputStream(excelFileName));
		book.close();
	    }
	},
	XLS {
	    /**
	     * 指定のエクセルからセルの値を取得し返却する。
	     */
	    public String getCellValue(final String excelFileName, final String excelSheetName, final int rowNum,
		    final int columnNum) throws IOException {
		Workbook book = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(excelFileName)));
		String cellValue = book.getSheet(excelSheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
		book.close();
		return cellValue;
	    }

	    /**
	     * 引数の値を指定のエクセルのセルの値に設定する。
	     */
	    public void setCellValue(final String excelFileName, final String excelSheetName, final int rowNum,
		    final int columnNum, final String value) throws IOException {
		Workbook book = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(excelFileName)));
		book.getSheet(excelSheetName).getRow(rowNum).getCell(columnNum).setCellValue(value);
		FileOutputStream out = new FileOutputStream(excelFileName);
		book.write(out);
		out.close();
		book.close();
	    }
	};

	/**
	 * 指定のエクセルからセルの値を取得し返却する。
	 *
	 * @param excelFileName  エクセルファイル名
	 * @param excelSheetName エクセルシート名
	 * @param rowNum         行No
	 * @param columnNum      列No
	 * @return セルの値
	 * @throws IOException
	 */
	public String getCellValue(final String excelFileName, final String excelSheetName, final int rowNum,
		final int columnNum) throws IOException {
	    return this.getCellValue(excelFileName, excelSheetName, rowNum, columnNum);
	}

	/**
	 *
	 * 引数の値を指定のエクセルのセルの値に設定する。
	 *
	 * @param excelFileName  エクセルファイル名
	 * @param excelSheetName エクセルシート名
	 * @param rowNum         行No
	 * @param columnNum      列No
	 * @param value          セルに設定する値
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public void setCellValue(final String excelFileName, final String excelSheetName, final int rowNum,
		final int columnNum, final String value) throws IOException, InvalidFormatException {
	    this.setCellValue(excelFileName, excelSheetName, rowNum, columnNum, value);
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
