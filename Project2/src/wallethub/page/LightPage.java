package wallethub.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LightPage extends BasePage {

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	private WebElement txtEmailAddress;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement txtPasswordConfirm;
	
	@FindBy(xpath = "//span[text()='Get my free credit score & report']/../input")
	private WebElement chkFreeCredit;
	
	@FindBy(xpath = "//button[.//span='Join']")
	private WebElement btnJoin;
	
	
	public LightPage(WebDriver driver) {
		super(driver);
		driver.get(BasePage.LIGHT_URL);
	}

	
}
