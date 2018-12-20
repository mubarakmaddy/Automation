package TestCases.Testcases.Admin.TaskmanagementModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.BaseClass;
import Pages.Admin.TaskmanagementModule.Tasks.TaskNavigation.TasksMenuNavigation;


public class NavigateToMytaskBoard {
	WebDriver driver;
	TasksMenuNavigation tmNavigate;

	@BeforeMethod
	public void launchApplication() {
		BaseClass bc = new BaseClass();
		driver = bc.launchGreytHRApplication();
	}

	@AfterMethod
	public void closeApplication() {
		driver.quit();
	}

	@Test(priority = 0)
	public void navigateToMytaskBoard() {
		tmNavigate = new TasksMenuNavigation(driver);
		if (tmNavigate.myTaskBoardMenu().isDisplayed()) {
			tmNavigate.clickOnMyTaskBoardMenu();
		} else {
			tmNavigate.clickOnTasksMenu();
			tmNavigate.clickOnMyTaskBoardMenu();
		}

	}

	@Test(priority = 1)
	public void navigateToAllTasks() {
		tmNavigate.AllTasksMenu();
	}

}
