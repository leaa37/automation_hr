package automation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import scripts.Login;

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

	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
		logger.log("Tests execution finished");
	}
}
