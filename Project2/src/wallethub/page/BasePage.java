package wallethub.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	enum InsuranceType {ANNUITIES, HEALTH, LIFE}
	
	public static final String LIGHT_URL = "https://wallethub.com/join/light";

	public static final String PROFILE_URL = "http://wallethub.com/profile/test_insurance_company/";

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
		
		public void SetText(WebElement elem, String text) {
			elem.sendKeys(text);
		}
		
		public String GetText(WebElement elem) {
			return elem.getText();
		}
		
		public void DoHover(WebElement elem) {
			Actions axn = new Actions(driver);
			axn.moveToElement(elem).build().perform();
			axn.moveToElement(elem,50,0).build().perform();
		}
		
		protected void SetDropdown(WebElement dropdownElement, String text) {
			dropdownElement.click();
			String childXPath = ".//li[normalize-space(text())='"+text+"']";
			 
			WebElement selection = dropdownElement.findElement(By.xpath(childXPath));
			selection.click();
		}
}
