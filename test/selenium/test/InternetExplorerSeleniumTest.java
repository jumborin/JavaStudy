package selenium.test;

import org.junit.jupiter.api.Test;

import selenium.InternetExplorerSelenium;

/**
 * InternetExplorerSeleniumのテストクラス.
 */
class InternetExplorerSeleniumTest {

  /**
   * openGoogle()のテストメソッド.
   */
  @Test
  final void testOpenGoogle() {
    InternetExplorerSelenium ies = new InternetExplorerSelenium();
    ies.openGoogle();
  }

  /**
   * openGoogleMap()のテストメソッド.
   */
  @Test
  final void testOpenGoogleMap() {
    InternetExplorerSelenium ies = new InternetExplorerSelenium();
    ies.openGoogleMap();
  }
}
