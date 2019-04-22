package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * SeleniumでGoogleChromeを利用するクラス
 *
 * @author jumborin
 *
 */
public class GoogleChromeSelenium {

	/** GoogleChromeのドライバークラス名 */
	private final static String CHROME_DRIVER_CLASS = "webdriver.chrome.driver";

	/** GoogleChromeのドライバーファイル */
	private final static String CHROME_DRIVER_PATH = "driver/chromedriver.exe";

	/**
	 * Googleを開く。
	 */
	public void openGoogle() {
		//登録
		System.setProperty(CHROME_DRIVER_CLASS, CHROME_DRIVER_PATH);

		//インスタンス作成
		WebDriver driver = new ChromeDriver();

		//グーグルに遷移
		driver.get("https://www.google.co.jp/");

		// タイトルを出力する。
		System.out.println(driver.getTitle());

		//URLを出力する
		System.out.println(driver.getCurrentUrl());

	}

	/**
	 * GoogleMapを開いて検索をする。
	 */
	public void openGoogleMap() {
		//登録
		System.setProperty(CHROME_DRIVER_CLASS, CHROME_DRIVER_PATH);

		//インスタンス作成
		WebDriver driver = new ChromeDriver();

		//グーグルマップに遷移する
		driver.get("https://www.google.co.jp/maps/");

		// タイトルを出力する。
		System.out.println(driver.getTitle());

		//URLを出力する
		System.out.println(driver.getCurrentUrl());

		//検索窓に入力する
		driver.findElement(By.id("searchboxinput")).sendKeys("test");

		//検索ボタンをクリックする。
		driver.findElement(By.id("searchbox-searchbutton")).click();
	}
}
