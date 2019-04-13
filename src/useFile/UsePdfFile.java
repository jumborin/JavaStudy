package useFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * PDFファイルを扱うクラス。
 * 利用条件：PDFBoxが必要。
 *
 * @author jumborin
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

	/**
	 * PDFファイル内の画像イメージを取得する。
	 *
	 * @param readFileName 読み込むPDFファイル名
	 * @param outputDir 画像ファイルを出力するフォルダ
	 * @throws IOException
	 */
	public void getImageFromPdfFile(
			final String readFileName,
			final String outputDir)
			throws IOException {
		PDDocument document = PDDocument.load(new File(readFileName));
		PDPageTree pageTree = document.getDocumentCatalog().getPages();
		COSName name = null;
		PDXObject xobject = null;
		PDImageXObject image = null;
		PDPage page = pageTree.get(0);
		PDResources resources = page.getResources();
		Iterator<COSName> ite = resources.getXObjectNames().iterator();
		while (ite.hasNext()) {
			name = ite.next();
			xobject = resources.getXObject(name);
			if (xobject instanceof PDImageXObject) {
				image = (PDImageXObject) resources.getXObject(name);
				ImageIO.write(image.getImage(), "jpg",
						new FileOutputStream(outputDir + this.getNowForString() + ".jpg"));
			}
		}
	}

	private String getNowForString() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(new Date());
	}
}
