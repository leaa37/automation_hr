package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id="onetrust-accept-btn-handler")
	public WebElement acceptCookiesBtn;

	@FindBy(xpath="//*[@text='Login']")
	public WebElement loginBtn;

}
