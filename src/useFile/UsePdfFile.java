/**
 *
 */
package useFile;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * PDFファイルを扱うクラス。
 * 利用条件：PDFBoxが必要。
 * @author jumborin
 *
 */
public class UsePdfFile extends UseFile {

	/**
	 * テキストファイルのみのPDFファイルを作成する。
	 * 利用条件：PDFBoxが必要。
	 *
	 * @param pdfFileName PDFファイル名
	 * @param outputText 出力するテキスト
	 * @throws IOException
	 */
	public void createPdfFileOnlyText(final String pdfFileName, final String outputText) throws IOException {
		// ドキュメントオブジェクトの作成
		PDDocument document = new PDDocument();

		// ページオブジェクトの作成
		PDPage page = new PDPage();
		document.addPage(page);

		//文字出力処理
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.beginText();

		//フォント指定
		PDFont font = PDType1Font.TIMES_ITALIC;
		contentStream.setFont(font, 12);

		//出力位置指定
		contentStream.newLineAtOffset(0f, 0f);

		//出力文字列
		contentStream.showText(outputText);
		contentStream.endText();
		contentStream.close();

		// ドキュメントを保存します
		document.save(pdfFileName);
		document.close();
	}
}
