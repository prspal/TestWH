package fb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "email")
	private WebElement txtUserName;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(id = "loginbutton")
	private WebElement btnLogin;

	@FindBy(id = "username")
	private WebElement lnkForgotPasswd;

	public BasePage DoLogin(String user, String passwd) {
		txtUserName.sendKeys(user);
		txtPassword.sendKeys(passwd);
		btnLogin.click();

		if (IsElementPresent(btnLogin)) {
			// Login failed, if button present
			// return same page
			return this;
		} else {
			//Login succeeded, return HomePage
			return new HomePage(driver);
		}
	}

}
