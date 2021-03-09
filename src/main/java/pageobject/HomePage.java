package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="//*[@data-test-id='navbar-profile-dropdown']")
	public WebElement profileLogoTxt;

	@FindBy(xpath="//*[@data-test-id='navbar-profile']/section/div[1]")
	public WebElement profileFullNameTxt;

	@FindBy(xpath="//*[@data-test-id='navbar-profile']/section/div[2]")
	public WebElement profileUserNameTxt;

}
