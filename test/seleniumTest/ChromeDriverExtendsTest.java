/**
 *
 */
package seleniumTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import selenium.ChromeDriverExtends;

/**
 * @author jumborin
 *
 */
class ChromeDriverExtendsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//登録
		System.setProperty(CHROME_DRIVER_CLASS, CHROME_DRIVER_PATH);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/** GoogleChromeのドライバークラス名 */
	private final static String CHROME_DRIVER_CLASS = "webdriver.chrome.driver";

	/** GoogleChromeのドライバーファイル */
	private final static String CHROME_DRIVER_PATH = "driver/chromedriver.exe";

	/**
	 * {@link selenium.InternetExplorerDriverExtends#maxWindowSize()} のためのテスト・メソッド。
	 */
	@Test
	final void test() {

		//インスタンス作成
		ChromeDriverExtends driver = new ChromeDriverExtends();

		//グーグルマップに遷移する
		driver.get("https://www.google.co.jp/maps/");

		// タイトルを出力する。
		System.out.println(driver.getTitle());

		//URLを出力する
		System.out.println(driver.getCurrentUrl());

		//検索窓に入力する
		driver.input("searchboxinput", "test");

		//検索ボタンをクリックする。
		driver.click("searchbox-searchbutton");
	}
}