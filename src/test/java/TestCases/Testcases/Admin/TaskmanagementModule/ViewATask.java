/**
 * 
 */
package TestCases.Testcases.Admin.TaskmanagementModule;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Library.BaseClass;
import Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu.TaskView;
import Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu.TasksListView;

/**
 * @author Mubarak
 *
 */
public class ViewATask {
	WebDriver driver;
	TasksListView taskListView;
	TaskView taskView;

	@BeforeMethod
	public void launchApplication() {
		BaseClass bc = new BaseClass();
		driver = bc.launchGreytHRApplication();
		bc.loginTOGreytHR();
	}
	/*
	 * @AfterMethod public void closeApplication() { driver.quit(); }
	 */

	@Test(priority = 0)
	public void viewTask() {
		taskListView = new TasksListView(driver);
		taskView = new TaskView(driver);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		taskListView.clickOnTaskViewIcon();
		taskView.setTaskStatus("Done");

	}

}
