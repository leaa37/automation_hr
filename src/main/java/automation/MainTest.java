package automation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import scripts.login.Login;

public class MainTest {

	private WebDriver driver;
	private WebDriverHelper browser;

	@Before
	public void beforeTest() {
		// Initialize
		browser = new WebDriverHelper();
		driver = browser.generateWebDriver();
	}

	@Test
	public void mainTest() {
		// Run tests

		// To Do
	}

	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}
}
