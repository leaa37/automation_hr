package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadPage {

	@FindBy(id="operatingSystem")
	public WebElement OSSelect;

	@FindBy(id="FirstName")
	public WebElement firstNameInput;

	@FindBy(id="LastName")
	public WebElement lastNameInput;

	@FindBy(id="Email")
	public WebElement emailInput;

	@FindBy(id="Company")
	public WebElement companyInput;

	@FindBy(id="Title")
	public WebElement titleInput;

	@FindBy(id="Phone")
	public WebElement phoneInput;

	@FindBy(id="Beta_License_Agreement__c")
	public WebElement EULACheck;

	@FindBy(xpath="//*[@type='submit']")
	public WebElement downloadBtn;

	@FindBy(xpath="//*[@class='cell']/h1")
	public WebElement productDownloadedTxt;

}
