package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * SeleniumをInternetExplorerで使用する際の拡張クラス.
 *
 * @author jumborin
 */
public class InternetExplorerDriverExtends extends InternetExplorerDriver {

  /**
   * Windowサイズを最大化する.
   */
  public void maxWindowSize() {
    this.manage().window().maximize();
  }

  /**
   * 指定URLに遷移する.
   *
   * @param url 遷移するURL
   */
  public void moveToUrl(final String url) {
    this.navigate().to(url);
  }

  /**
   * 前画面に戻る.
   */
  public void back() {
    this.navigate().back();
  }

  /**
   * 次画面へ遷移する.
   */
  public void forward() {
    this.navigate().forward();
  }

  /**
   * 指定IDの要素をクリックする.
   *
   * @param id ID
   */
  public void click(final String id) {
    this.findElement(By.id(id)).click();
  }

  /**
   * 指定インプット領域に指定のテキストを入力する.
   *
   * @param inputBoxId 指定インプット領域
   * @param inputText 入力するテキスト
   */
  public void input(final String inputBoxId, final String inputText) {
    this.findElement(By.id(inputBoxId)).sendKeys(inputText);
  }

  /**
   * 指定IDのテキストを取得する.
   *
   * @param id ID
   * @return 指定IDに入力されているテキストを取得する。
   */
  public String getText(final String id) {
    return this.findElement(By.id(id)).getText();
  }

  /**
   * 指定IDが表示されているかを返却する.
   *
   * @param id ID
   * @return 表示有無(True:表示、False:非表示)
   */
  public boolean isDisplayed(final String id) {
    return this.findElement(By.id(id)).isDisplayed();
  }

  /**
   * 指定IDが有効かを返却する.
   *
   * @param id ID
   * @return 有効であるかどうか(True:有効、False:無効)
   */
  public boolean isEnabled(final String id) {
    return this.findElement(By.id(id)).isEnabled();
  }

  /**
   * 指定IDが選択されているかを返却する.
   *
   * @param id ID
   * @return 選択されているかどうか(True:選択状態、False:非選択状態)
   */
  public boolean isSelected(final String id) {
    return this.findElement(By.id(id)).isSelected();
  }
}
