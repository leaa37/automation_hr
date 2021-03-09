package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id="onetrust-accept-btn-handler")
	public WebElement acceptCookiesBtn;

	@FindBy(xpath="//*[@class='right-side']/a[3]")
	public WebElement loginBtn;

	@FindBy(xpath="//*[@type='text']")
	public WebElement mailInput;

	@FindBy(xpath="//*[@type='password']")
	public WebElement passwordInput;

	@FindBy(xpath="//*[@data-test-id='SignIn-Submit']")
	public WebElement doLoginBtn;
}
