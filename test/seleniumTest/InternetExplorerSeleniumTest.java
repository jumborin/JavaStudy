package seleniumTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import selenium.InternetExplorerSelenium;

class InternetExplorerSeleniumTest {

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
