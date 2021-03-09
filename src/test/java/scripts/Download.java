package scripts;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import automation.WebDriverHelper;
import pageobject.DownloadPage;
import pageobject.MainPage;
import utils.Constants;

public class Download {
	private WebDriverHelper browser;
	private WebDriver driver;
	private MainPage mainPage;
	private DownloadPage downloadPage;

	public Download(WebDriverHelper browser, WebDriver driver) {
		this.browser = browser;
		this.driver = driver;
	}

	public void runTest(String platform) throws Exception {
		// Initialize Page Object
		mainPage = new MainPage();
		downloadPage = new DownloadPage();
		PageFactory.initElements(driver, mainPage);
		PageFactory.initElements(driver, downloadPage);

		// Check pre-conditions
		this.checkPreconditions();

		// Navigate to main page
		browser.navigateToURL(driver, Constants.mainURL);

		// Accept cookies
		this.acceptBrowserCookies();

		// Go to download page
		this.goToDownloadPage();

		// Download product
		this.downloadProduct(platform);
	}

	public void checkPreconditions() {
	}

	public void acceptBrowserCookies() throws Exception {
		browser.doClickOnElement(driver, mainPage.acceptCookiesBtn);
		Thread.sleep(1500);
	}

	public void goToDownloadPage() throws Exception {
		browser.doClickOnElement(driver, mainPage.productMenu);
		browser.doClickOnElement(driver, mainPage.downloadProductBtn);
	}

	public void downloadProduct(String platform) throws Exception {
		// Select OS
		browser.setTextOnElement(driver, downloadPage.OSSelect, platform);

		// Fill form data
		browser.setTextOnElement(driver, downloadPage.firstNameInput, "Leandro");
		browser.setTextOnElement(driver, downloadPage.lastNameInput, "Garcia");
		browser.setTextOnElement(driver, downloadPage.emailInput, "leang07@gmail.com");
		browser.setTextOnElement(driver, downloadPage.companyInput, "Salesforce");
		browser.setTextOnElement(driver, downloadPage.titleInput, "IT");
		browser.setTextOnElement(driver, downloadPage.phoneInput, "1154121251");

		// Accept EULA
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", downloadPage.EULACheck);

		// Download product
		browser.doClickOnElement(driver, downloadPage.downloadBtn);

		// Check download message
		browser.waitForElement(driver, downloadPage.productDownloadedTxt);
		Assert.assertEquals(Constants.downloadedText, downloadPage.productDownloadedTxt.getText());
	}
}
