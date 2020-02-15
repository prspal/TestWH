package wallethub.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected WebDriver driver;
	
		public BasePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		 
		public boolean IsElementPresent(WebElement element) {
			try {
				return element.isDisplayed();
			}
			catch(Exception e){
				return false;
			}
		}
		
		public boolean IsElementEnabled(WebElement element) {
			try {
				return element.isEnabled();
			}
			catch(Exception e){
				return false;
			}
		}
}
