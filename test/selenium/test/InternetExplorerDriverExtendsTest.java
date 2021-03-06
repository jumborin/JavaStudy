package selenium.test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import selenium.InternetExplorerDriverExtends;

/**
 * InternetExplorerDriverExtendsクラスのテストクラス.
 *
 * @author jumborin
 */
class InternetExplorerDriverExtendsTest {

  /**
   * 毎回テストメソッド実行前に実施する処理.
   *
   * @throws Exception Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    // 登録
    System.setProperty(IE_DRIVER_CLASS, IE_DRIVER_PATH);
  }

  /** InternetExplorerドライバーのクラス名. */
  private static final String IE_DRIVER_CLASS = "webdriver.ie.driver";

  /** InternetExplorerドライバーのファイルパス. */
  private static final String IE_DRIVER_PATH = "driver/IEDriverServer.exe";

  /**
   * テストメソッド.
   */
  @Test
  final void test() {
    // 登録
    System.setProperty(IE_DRIVER_CLASS, IE_DRIVER_PATH);

    // インスタンス作成
    InternetExplorerDriverExtends driver = new InternetExplorerDriverExtends();

    // グーグルマップに遷移する
    driver.get("https://www.google.co.jp/maps/");

    // 10秒待機する
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // タイトルを出力する。
    System.out.println(driver.getTitle());

    // URLを出力する
    System.out.println(driver.getCurrentUrl());

    // 10秒待機する
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // 検索窓に入力する
    driver.input("searchboxinput", "test");

    // 検索ボタンをクリックする。
    driver.click("searchbox-searchbutton");
  }
}
