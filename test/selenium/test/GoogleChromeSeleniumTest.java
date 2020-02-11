package selenium.test;

import org.junit.jupiter.api.Test;

import selenium.GoogleChromeSelenium;

/**
 * GoogleChromeSeleniumクラスのテストクラス.
 *
 * @author jumborin
 */
class GoogleChromeSeleniumTest {

  /**
   * openGoogle()のテストメソッド.
   */
  @Test
  final void testOpenGoogle() {
    GoogleChromeSelenium gcs = new GoogleChromeSelenium();
    gcs.openGoogle();
  }

  /**
   * openGoogleMap()のテストメソッド.
   */
  @Test
  final void testOpenGoogleMap() {
    GoogleChromeSelenium gcs = new GoogleChromeSelenium();
    gcs.openGoogleMap();
  }

}
