package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

	@FindBy(xpath="//*[@class='search-term']")
	public WebElement searchedTxt;

	@FindBy(id="search-results")
	public WebElement searchResults;

}
