package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * SeleniumでInternetExplorerを利用するクラス.
 *
 * @author jumborin
 */
public class InternetExplorerSelenium {

  /** InternetExplorerドライバーのクラス名. */
  private static final String IE_DRIVER_CLASS = "webdriver.ie.driver";

  /** InternetExplorerドライバーのファイルパス. */
  private static final String IE_DRIVER_PATH = "driver/IEDriverServer.exe";

  /**
   * Googleを開く.
   */
  public void openGoogle() {
    // 登録
    System.setProperty(IE_DRIVER_CLASS, IE_DRIVER_PATH);

    // インスタンス作成
    WebDriver driver = new InternetExplorerDriver();

    // グーグルに遷移
    driver.get("https://www.google.co.jp/");

    // タイトルを出力する。
    System.out.println(driver.getTitle());

    // URLを出力する
    System.out.println(driver.getCurrentUrl());

    driver.quit();
  }

  /**
   * GoogleMapを開いて検索をする.
   */
  public void openGoogleMap() {
    // 登録
    System.setProperty(IE_DRIVER_CLASS, IE_DRIVER_PATH);

    // インスタンス作成
    WebDriver driver = new InternetExplorerDriver();

    // グーグルマップに遷移する
    driver.get("https://www.google.co.jp/maps/");

    // タイトルを出力する。
    System.out.println(driver.getTitle());

    // URLを出力する
    System.out.println(driver.getCurrentUrl());

    // 検索窓に入力する
    driver.findElement(By.id("searchboxinput")).sendKeys("test");

    // 検索ボタンをクリックする。
    driver.findElement(By.id("searchbox-searchbutton")).click();

    driver.quit();
  }
}
