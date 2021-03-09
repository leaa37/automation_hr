package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

	@FindBy(id="onetrust-accept-btn-handler")
	public WebElement acceptCookiesBtn;

	@FindBy(xpath="//*[@class='right-side']/a[3]")
	public WebElement loginBtn;

	@FindBy(xpath="//*[@class='search-mag-icon']")
	public WebElement searchBtn;

	@FindBy(name="as_q")
	public WebElement searchInput;

	@FindBy(xpath="//*[@class='main-menu-product']")
	public WebElement productMenu;

	@FindBy(xpath="//*[@href='https://www.mulesoft.com/lp/dl/studio']")
	public WebElement downloadProductBtn;

}
