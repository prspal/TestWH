package wallethub.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

	final String SELECTED_HEXCODE = "#4ae0e1";
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and ./span='Overview']")
	private WebElement lnkOverview;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and ./span='Reviews']")
	private WebElement lnkReviews;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and ./span='Q&A']")
	private WebElement lnkQnA;
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and ./span='Contact']")
	private WebElement lnkContact;
	
	@FindAll(value = @FindBy(xpath = "(//review-star[@class='rvs-svg']//*[@class='rating-box-wrapper'])[1]//*[local-name()='svg']"))
	private List<WebElement> starsShowRating;
	
	@FindAll(value = @FindBy(xpath = "//write-review//review-star[@class='rvs-svg']//*[local-name()='svg']"))
	private List<WebElement> starsWriteRating;
	
	@FindBy(xpath = "//ng-dropdown[@class='wrev-drp']/div")
	private WebElement ddnInsuranceType;

	@FindBy(xpath = "//div[@class='android']//textarea")
	private WebElement txtReviewArea;
	
	@FindBy(xpath = "//div[text()='Submit']")
	private WebElement btnReveiwSubmit;
	
	@FindAll (@FindBy(xpath = "//article[.//span[text()=' Your Review']]//*[local-name()='path' and @fill ='"+SELECTED_HEXCODE+"']"))
	private List<WebElement> txtMyReviewStars;
	
	@FindBy(xpath = "//article[.//span[text()=' Your Review']]//div[@itemprop='description']")
	private WebElement txtMyReviewText;
	
	@FindBy(xpath = "//div[@class='pr-rec-texts-container']/a")
	private WebElement lnkReviewCompanyProfile;
	
	@FindAll( @FindBy(xpath = "//div[@class='pr-rec-texts-container']//*[local-name()='path' and @fill='"+SELECTED_HEXCODE+"']"))
	private List<WebElement>  txtMyProfileReviewStars;
	
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		driver.get(BasePage.PROFILE_URL);
	}
	
	public ProfilePage(WebDriver driver, String url) {
		super(driver);
		driver.get(url);
	}

	public void SetReviewStar(int starIdx) {
		if (!isStarIdxValid(starIdx)) {
			return;
		}
		starsShowRating.get(starIdx-1).click();
	}

	public void hoverReadReviewStar(int starIdx) {
		if (!isStarIdxValid(starIdx)) {
			return;
		}
		DoHover(starsShowRating.get(starIdx -1));
	}
	
	public void hoverWriteReviewStar(int starIdx) {
		if (!isStarIdxValid(starIdx)) {
			return;
		}
		DoHover(starsWriteRating.get(starIdx -1));
	}

	private boolean isStarIdxValid(int star) {

		if(star <0 || star >5) {
			System.err.println("Only value 1-5 are expected");
			return false;
		}
		return true;
	}


	public boolean IsReadStarHighlighted(int starIdx) {
		return IsStarHighlighted(starIdx, true);
	}
	
	
	public boolean IsWriteStarHighlighted(int starIdx) {
		return IsStarHighlighted(starIdx, false);
	}
	
	
	private boolean IsStarHighlighted(int starIdx, boolean isReadStar ) {
		if (!isStarIdxValid(starIdx)) {
			return false;
		}
		try {
		WebElement parent = isReadStar ? starsShowRating.get(starIdx -1):starsWriteRating.get(starIdx -1);
		List<WebElement> stars = parent.findElements(By.xpath(".//*[local-name()='path' and @fill = '"+SELECTED_HEXCODE+"']")) ;
		return stars.size() > 0;
		}
		catch(Exception e) {
			//Return false in case element not found or other errors
			return false;
		}
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

	public void writeReview(String reviewTxt) {
		txtReviewArea.sendKeys(reviewTxt);
		btnReveiwSubmit.click();
	}
	
	public String getMyReviewText() {
		return txtMyReviewText.getText();
	}
	
	public int getMyReivewStar() {
		int count = txtMyReviewStars.size();
		
		return count;
	}
	
	public String getMyProfileReviewName() {
		return  lnkReviewCompanyProfile.getText();
	}
	
	public int getMyProfileReviewStar() {
		int count = txtMyProfileReviewStars.size();
		
		return count;
	}
}
