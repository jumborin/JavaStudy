package useFileTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import useFile.ReadFile;

class ReadFileTest {

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
	void testReadProperties() {
		ReadFile rpf = new ReadFile();
		try {
			Map<String, String> map = rpf.readPropertyFile("D:\\workspace\\JavaStudy\\resource\\java.properties");
			assertEquals("test1", map.get("id"));
			assertEquals("test2", map.get("pass"));
		} catch (IOException e) {
			fail("IOExceptionエラー");
		}
	}

	@Test
	public void testReadTextFile() {
		ReadFile rpf = new ReadFile();
		try {
			List<String> list = rpf.readTextFile("D:\\workspace\\JavaStudy\\resource\\java.properties");
			assertEquals("# プロパティファイル", list.get(0));
			assertEquals("id=test1", list.get(1));
			assertEquals("pass=test2", list.get(2));
		} catch (IOException e) {
			fail("IOExceptionエラー");
		}
	}

}
