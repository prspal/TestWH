package wallethub.page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	public enum InsuranceType {ANNUITIES, HEALTH, LIFE}
	
	public static final String LIGHT_URL = "https://wallethub.com/join/light";
	public static final String LOGIN_URL = "https://wallethub.com/join/login";

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
			Dimension offSet = elem.getSize();
			int randX = new Random().nextInt(offSet.getWidth())/2;
			int randY = new Random().nextInt(offSet.getHeight())/2;

			Actions axn = new Actions(driver);
			axn.moveToElement(elem).build().perform();
			axn.moveToElement(elem,randX,randY).build().perform();
		}
		
		protected void SetDropdown(WebElement dropdownElement, String text) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
			dropdownElement.click();
			String childXPath = ".//li[normalize-space(text())='"+text+"']";
			 
			WebElement selection = dropdownElement.findElement(By.xpath(childXPath));
			selection.click();
		}
}
