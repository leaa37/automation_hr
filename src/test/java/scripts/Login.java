package scripts;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import automation.WebDriverHelper;
import pageobject.HomePage;
import pageobject.LoginPage;
import utils.Constants;

public class Login {
	private WebDriverHelper browser;
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;

	public Login(WebDriverHelper browser, WebDriver driver) {
		this.browser = browser;
		this.driver = driver;
	}

	public void runTest() throws Exception {
		// Initialize Page Object
		loginPage = new LoginPage();
		homePage = new HomePage();
		PageFactory.initElements(driver, loginPage);
		PageFactory.initElements(driver, homePage);

		// Check pre-conditions
		this.checkPreconditions();

		// Navigate to main page
		browser.navigateToURL(driver, Constants.mainURL);

		// Accept cookies
		this.acceptBrowserCookies();

		// Do login
		this.doLogin();
		
		// Validate Home Page
		this.validateHomePage();
	}

	public void checkPreconditions() {
	}

	public void acceptBrowserCookies() throws Exception {
		browser.doClickOnElement(driver, loginPage.acceptCookiesBtn);
		Thread.sleep(1500);
	}

	public void doLogin() throws Exception {
		browser.doClickOnElement(driver, loginPage.loginBtn);
		browser.setTextOnElement(driver, loginPage.mailInput, Constants.loginUserName);
		browser.setTextOnElement(driver, loginPage.passwordInput, Constants.loginPassword);
		browser.doClickOnElement(driver, loginPage.doLoginBtn);
	}

	public void validateHomePage() throws Exception {
		// Check Logo
		browser.waitForElement(driver, homePage.profileLogoTxt);
		Assert.assertEquals(Constants.profileTextLogo, homePage.profileLogoTxt.getText());
		
		// Check user data
		browser.doClickOnElement(driver, homePage.profileLogoTxt);
		browser.waitForElement(driver, homePage.profileFullNameTxt);
		browser.waitForElement(driver, homePage.profileUserNameTxt);
		Assert.assertEquals(Constants.profileFullName, homePage.profileFullNameTxt.getText());
		Assert.assertEquals(Constants.loginUserName, homePage.profileUserNameTxt.getText());
	}
}
