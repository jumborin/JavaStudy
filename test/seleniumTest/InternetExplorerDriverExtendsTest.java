/**
 *
 */
package seleniumTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import selenium.InternetExplorerDriverExtends;

/**
 * @author jumborin
 *
 */
class InternetExplorerDriverExtendsTest {

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
		System.setProperty(IE_DRIVER_CLASS, IE_DRIVER_PATH);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/** InternetExplorerドライバーのクラス名 */
	private final String IE_DRIVER_CLASS = "webdriver.ie.driver";

	/** InternetExplorerドライバーのファイルパス */
	private final String IE_DRIVER_PATH = "driver/IEDriverServer.exe";


	/**
	 * {@link selenium.InternetExplorerDriverExtends#maxWindowSize()} のためのテスト・メソッド。
	 */
	@Test
	final void test() {
		//登録
		System.setProperty(IE_DRIVER_CLASS, IE_DRIVER_PATH);

		//インスタンス作成
		InternetExplorerDriverExtends driver = new InternetExplorerDriverExtends();

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
