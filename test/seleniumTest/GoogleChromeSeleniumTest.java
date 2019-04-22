package seleniumTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import selenium.GoogleChromeSelenium;

class GoogleChromeSeleniumTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

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
