package seleniumTest;

import org.junit.jupiter.api.Test;

import selenium.InternetExplorerSelenium;

/**
 * IE11のSeleniumのテスト
 */
class InternetExplorerSeleniumTest {

    @Test
    final void testOpenGoogle() {
	InternetExplorerSelenium ies = new InternetExplorerSelenium();
	ies.openGoogle();
    }

    /**
     * GoogleMapを開く。
     */
    @Test
    final void testOpenGoogleMap() {
	InternetExplorerSelenium ies = new InternetExplorerSelenium();
	ies.openGoogleMap();
    }
}
