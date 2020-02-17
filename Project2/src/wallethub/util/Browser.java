package wallethub.util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	private static Browser browser = null;
	private WebDriver driver;
	
	private Browser(String browser) {
		WebDriver driver = null;
		if (browser.startsWith("chrome")){
			//Disable notifications on Chrome
			Map<String,Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}
		else if (browser.startsWith("firefox")){
			//Disable notifications on Firefox
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", "false");
			driver = new FirefoxDriver(options);
		}
		else if (browser.startsWith("edge")){
			driver = new EdgeDriver();
		}
		else{
			driver = new InternetExplorerDriver();
		}
		
		this.driver = driver;
	}
	
	public static Browser init (String browserType) {
		return null != browser ? browser :  new Browser(browserType);
	}
	
	public WebDriver GetDriver() {
		return driver;
	}

	public void setUrl(String url) {
		driver.get(url);
	}

	public void getUrl() {
		driver.getCurrentUrl();
	}

	public void Quit() {
		driver.quit();
	}
	
}
