package scripts.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.LogHelper;
import automation.WebDriverHelper;
import pageobject.LoginPage;

public class Login {
	private final String testName = "LOGIN";

	public void run(WebDriverHelper browser, WebDriver driver) {
		// Initialize
		LogHelper logger = new LogHelper();
		LoginPage loginPage = new LoginPage();
		PageFactory.initElements(driver, loginPage);
		logger.log("Starting test: " + testName);

		// Navigation page
		browser.navigateToURL(driver, "https://www.mulesoft.com/");

		// Accept cookies
		browser.doClickOnElement(driver, loginPage.acceptCookiesBtn);

	}
}
