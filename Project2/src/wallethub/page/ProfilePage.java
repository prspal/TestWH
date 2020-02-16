package wallethub.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

	@FindBy(xpath = "//a[contains(@class,'nav-link') and ./span='Overview']")
	private WebElement lnkOverview;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and ./span='Reviews']")
	private WebElement lnkReviews;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and ./span='Q&A']")
	private WebElement lnkQnA;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and ./span='Contact']")
	private WebElement lnkContact;
	
	@FindAll(value = @FindBy(xpath = "//review-star[@class='rvs-svg']//*[local-name()='svg']"))
	private List<WebElement> svgStars;
	
	@FindBy(tagName = "ng-dropdown")
	private WebElement ddnInsuranceType;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		driver.get(BasePage.PROFILE_URL);
	}

	public void SetReviewStar(int star) {
		if(star <0 || star >5) {
			System.err.println("Only value 1-5 are expected");
		}
		DoHover(svgStars.get(star));
		svgStars.get(star).click();
	}

	public void SetReviewInsuranceType(InsuranceType type) {
		String selectText = "";
		switch(type) {
		case ANNUITIES:
			selectText = "Annuities";
			break;
		case HEALTH:
			selectText = "Health Insurance";
			break;
		case LIFE:
			selectText = "Life Insurance";
			break;
		}
		SetDropdown(ddnInsuranceType, selectText);
	}
}
