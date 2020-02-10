package seleniumTest;

import org.junit.jupiter.api.Test;

import selenium.GoogleChromeSelenium;

class GoogleChromeSeleniumTest {

    @Test
    final void testOpenGoogle() {
	GoogleChromeSelenium gcs = new GoogleChromeSelenium();
	gcs.openGoogle();
    }

    /**
     * GoogleMapを開く。
     */
    @Test
    final void testOpenGoogleMap() {
	GoogleChromeSelenium gcs = new GoogleChromeSelenium();
	gcs.openGoogleMap();
    }

}
