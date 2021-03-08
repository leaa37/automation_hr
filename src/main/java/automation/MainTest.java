package automation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import scripts.login.Login;

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
	public void mainTest() {
		// Run tests
		logger.log("Starting running tests...");
		new Login().run(browser, driver);
		//new Logout().run(browser, driver);
	}

	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
		logger.log("Tests execution finished");
	}
}
