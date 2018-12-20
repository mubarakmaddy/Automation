package Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TaskmanagementBaseClass {
	public WebDriver driver;

	@BeforeClass
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://testtask.lk.greytip2.in/v3/login");

	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
	}

}
