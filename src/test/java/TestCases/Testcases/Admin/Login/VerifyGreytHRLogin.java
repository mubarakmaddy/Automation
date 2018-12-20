package TestCases.Testcases.Admin.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.BaseClass;
import Library.GreytHrExcelImporter;
import Pages.Admin.Login.GreytHRLoginPage;





/**
 * @author Mubarak
 *
 */

public class VerifyGreytHRLogin {
	WebDriver driver;
	GreytHRLoginPage greytHRLogin;
	GreytHrExcelImporter excelImport = new GreytHrExcelImporter();

	@BeforeMethod
	public void launchApplication() {
		BaseClass bc = new BaseClass();
		driver = bc.launchGreytHRApplication();
		greytHRLogin = new GreytHRLoginPage(driver);
		
	}

	@AfterMethod
	public void closeApplication() {
		driver.quit();
	}

	@Test(priority = 0)
	public void loginValidUsernameValidPassword() {
		// login to application
		greytHRLogin.loginToGreytHRApplication(excelImport.getExcelData("Login", 0, 0),
				excelImport.getExcelData("Login", 0, 1));

		Assert.assertEquals("Feeds", driver.findElement(By.className("home-page")).getText());
	}

	@Test(priority = 1)
	public void loginInvalidUsernameValidPassword() {
		greytHRLogin.loginToGreytHRApplication(excelImport.getExcelData("Login", 1, 0),
				excelImport.getExcelData("Login", 1, 1));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void loginValidUsernameInvalidPassword() {
		greytHRLogin.loginToGreytHRApplication(excelImport.getExcelData("Login", 2, 0),
				excelImport.getExcelData("Login", 2, 1));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@Test(priority = 3)
	public void loginInvalidUsernameInvalidPassword() {
		greytHRLogin.loginToGreytHRApplication(excelImport.getExcelData("Login", 3, 0),
				excelImport.getExcelData("Login", 3, 1));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}