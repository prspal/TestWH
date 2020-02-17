package wallethub.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath = "//button[.//span='Login']")
	private WebElement btnLogin;
	
	
	public LightPage(WebDriver driver) {
		super(driver);
		driver.get(BasePage.LOGIN_URL);
	}

	public void doLogin(String user, String passwd) {
		txtEmailAddress.sendKeys(user);
		txtPassword.sendKeys(passwd);
		btnLogin.click();
		
	}

	public void waitLoginFinish() {
		//Wait for login to finish
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(((WrapsElement)txtPassword).getWrappedElement()));
	}
}
