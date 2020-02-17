package test.Profile;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import wallethub.page.LightPage;
import wallethub.page.ProfilePage;
import wallethub.page.BasePage.InsuranceType;
import wallethub.util.Browser;

public class TestReviewStar {

	ProfilePage profile;
	static Browser browser = Browser.init("chrome");

	@Before
	public void setUp() {
		LightPage login = new LightPage(browser.GetDriver());

		//This can be optimized
		String user= "prspal@outlook.com";
		String passwd = "A!s2d3f4";
		login.doLogin(user, passwd);
		login.waitLoginFinish();
		profile = new ProfilePage(browser.GetDriver());
	}

	@AfterClass
	public static void tearDown()  {
		browser.Quit();
	}

	@Test
	public void testSetWriteReviewStar() {
		int starIdx = 4;
		profile.SetReviewStar(starIdx);
		Assert.assertTrue(profile.IsReadStarHighlighted(starIdx));
	}
	
	@Test
	public void testHoverStar() {
		int starIdx = 3;
		profile.hoverReadReviewStar(starIdx);
		Assert.assertTrue(profile.IsReadStarHighlighted(starIdx));
		System.out.print("");

	}

	@Test
	public void testReviewSubmit() {
		int starIdx = 4;
		InsuranceType insurance = InsuranceType.HEALTH;
		String submittedReviewText = "Quick brown fox jumped over the lazy dog";
		submittedReviewText = submittedReviewText+submittedReviewText+submittedReviewText+submittedReviewText;

		profile.SetReviewStar(starIdx); profile.SetReviewInsuranceType(insurance);
		profile.writeReview(submittedReviewText);
		
		String myReviewText = profile.getMyReviewText();
		int myReviewStarCnt = profile.getMyReivewStar();

		Assert.assertEquals(submittedReviewText, myReviewText);
		Assert.assertEquals(starIdx, myReviewStarCnt);
		
	}
}
