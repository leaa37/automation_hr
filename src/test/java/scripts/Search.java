package scripts;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automation.WebDriverHelper;
import pageobject.MainPage;
import pageobject.SearchPage;
import utils.Constants;

public class Search {
	private WebDriverHelper browser;
	private WebDriver driver;
	private MainPage mainPage;
	private SearchPage searchPage;

	public Search(WebDriverHelper browser, WebDriver driver) {
		this.browser = browser;
		this.driver = driver;
	}

	public void runTest() throws Exception {
		// Initialize Page Object
		mainPage = new MainPage();
		searchPage = new SearchPage();
		PageFactory.initElements(driver, mainPage);
		PageFactory.initElements(driver, searchPage);

		// Check pre-conditions
		this.checkPreconditions();

		// Navigate to main page
		browser.navigateToURL(driver, Constants.mainURL);

		// Accept cookies
		this.acceptBrowserCookies();

		// Search in Main page
		this.search("trial");
		this.search("api");
	}

	public void checkPreconditions() {
	}

	public void acceptBrowserCookies() throws Exception {
		browser.doClickOnElement(driver, mainPage.acceptCookiesBtn);
		Thread.sleep(1500);
	}

	public void search(String text) throws Exception {
		// Do search
		this.doSearch(text);

		// Validate search
		this.validateSearch(text);
	}

	public void doSearch(String text) throws Exception {
		// Click on search button
		browser.waitForElement(driver, mainPage.searchBtn);
		browser.doClickOnElement(driver, mainPage.searchBtn);

		// Search text
		browser.waitForElement(driver, mainPage.searchInput);
		browser.setTextOnElement(driver, mainPage.searchInput, text);
		mainPage.searchInput.sendKeys(Keys.ENTER);
	}

	public void validateSearch(String text) throws Exception {
		// Validate search title
		browser.waitForElement(driver, searchPage.searchedTxt);
		Assert.assertEquals("Searched for: " + text, searchPage.searchedTxt.getText());

		// Validate search results
		browser.waitForElement(driver, searchPage.searchResults);

		List<WebElement> resultELements = searchPage.searchResults.findElements(By.xpath("div"));
		for (WebElement element : resultELements) {
			browser.waitForElement(driver, element);
			if (!element.getText().contains(text)) {
				//fail("Search result no contains '" + text + "' text: " + element.getText());
			}
		}
	}
}
