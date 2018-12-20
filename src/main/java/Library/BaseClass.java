/**
 * 
 */
package Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import Pages.Admin.Login.GreytHRLoginPage;



/**
 * @author Mubarak
 *
 */
public class BaseClass {
	public WebDriver driver;
	public String chromeDriverPath = "D:\\D\\Automation\\Drivers\\chromedriver.exe";
	public String mozillaDriverPath = "D:\\D\\Automation\\Drivers\\geckodriver.exe";
	
	public WebDriver launchGreytHRApplication() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("disable-infobars");
		opt.addArguments("--start-maximized");
		opt.addArguments("--disable-extensions");
		driver = new ChromeDriver(opt);
		driver.get("http://project.gtin.gr8hr.biz");
		
		return driver;
		
	}

	public void loginTOGreytHR() {
		GreytHRLoginPage ghrlogin = new GreytHRLoginPage(driver);
		ghrlogin.loginToGreytHRApplication("Admin", "sa");
	}

	public void closeApplication() {
		driver.quit();
	}
	
}
