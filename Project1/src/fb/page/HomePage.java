package fb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(tagName = "textarea")
    private WebElement txtStatusBox;
	
	@FindBy(xpath = "//div[@role='textbox']")
	private WebElement txtBoxStatus;
	
	@FindBy(xpath = "//button[.='Post']")
	private WebElement btnPost;
 
    public void SetPost(String text) {
    	txtStatusBox.click();
    	txtBoxStatus.sendKeys(text);
    	btnPost.click();
    }
    
    
}
