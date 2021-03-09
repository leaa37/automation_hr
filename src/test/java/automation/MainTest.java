package automation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import scripts.*;

public class MainTest {

	private WebDriver driver;
	private WebDriverHelper browser;
	private LogHelper logger;

	@Before
	public void beforeTest() {
		// Initialize
		logger = new LogHelper();
		browser = new WebDriverHelper();
		driver = browser.generateWebDriver();

		logger.log("Driver initialized successfully");
	}

	@Test
	public void login() throws Exception {
		logger.log("Starting running test: LOGIN");
		new Login(browser, driver).runTest();
	}

	@Test
	public void searchTrial() throws Exception {
		logger.log("Starting running test: SEARCH 'trial'");
		new Search(browser, driver).runTest("trial");
	}

	@Test
	public void searchApi() throws Exception {
		logger.log("Starting running test: SEARCH 'api'");
		new Search(browser, driver).runTest("api");
	}

	@Test
	public void downloadWindowsProduct() throws Exception {
		logger.log("Starting running test: DOWNLOAD WINDOWS PRODUCT");
		new Download(browser, driver).runTest("Windows");
	}

	@Test
	public void downloadMacProduct() throws Exception {
		logger.log("Starting running test: DOWNLOAD MAC PRODUCT");
		new Download(browser, driver).runTest("Mac");
	}

	@Test
	public void downloadLinuxProduct() throws Exception {
		logger.log("Starting running test: DOWNLOAD LINUX PRODUCT");
		new Download(browser, driver).runTest("Linux");
	}

	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
		logger.log("Tests execution finished");
	}
}
