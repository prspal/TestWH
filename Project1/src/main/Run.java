package main;

import fb.common.Browser;
import fb.page.HomePage;
import fb.page.LoginPage;

public class Run {

	public static void main(String[] args) {

		String user = "some.user@gmail.com";
		String passwd = "password";
		String browserType = "chrome";
		String url = "https://facebook.com";
		
		
		Browser browser = Browser.init(browserType);
		browser.setUrl(url);
		LoginPage login = new LoginPage(browser.GetDriver());
		
		HomePage home = (HomePage) login.DoLogin(user, passwd);
		home.SetPost("hello world");
		
	}

}
