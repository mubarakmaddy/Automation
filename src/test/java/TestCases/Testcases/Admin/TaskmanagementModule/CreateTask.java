/**
 * 
 */
package TestCases.Testcases.Admin.TaskmanagementModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.BaseClass;
import Library.GreytHrExcelImporter;
import Pages.Admin.GHRNavigation.GreytHRNavigation;
import Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu.CreateTaskForm;
import Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu.MytaskboardPage;





/**
 * @author Mubarak
 *
 */
public class CreateTask {
	WebDriver driver;
	MytaskboardPage myTaskboardPage;
	CreateTaskForm createTaskForm;
	GreytHrExcelImporter excl;
	int row = 2;
	GreytHRNavigation greytHRNavigation;

	@BeforeMethod
	public void launchApplication() {
		BaseClass bc = new BaseClass();
		driver = bc.launchGreytHRApplication();
		bc.loginTOGreytHR();
	}

	@AfterMethod
	public void closeApplication() {
		//driver.quit();
	}

	@Test(priority = 0)
	public void CreateTaskAndMapToStandlone() {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		greytHRNavigation = new GreytHRNavigation(driver);
		greytHRNavigation.navigateToTaskMenu();
		myTaskboardPage = new MytaskboardPage(driver);
		myTaskboardPage.clickOnAddNewButton();
		createTaskForm = new CreateTaskForm(driver);
		excl = new GreytHrExcelImporter();
		createTaskForm.enterTaskname(excl.getExcelData("Create Task", row, 0));
		createTaskForm.enterDescription(excl.getExcelData("Create Task", row, 1));
		createTaskForm.setPriority(excl.getExcelData("Create Task", row, 2));
		createTaskForm.setTaskStatus(excl.getExcelData("Create Task", row, 3));
		createTaskForm.mapTo(excl.getExcelData("Create Task", row, 4));
		createTaskForm.enterDueDate(excl.getExcelData("Create Task", row, 5), excl.getExcelData("Create Task", row, 6),excl.getExcelData("Create Task", row, 7));
		//createTaskForm.enterAssignee(excl.getExcelData("Create Task", row, 8));
		createTaskForm.clickOnSaveButton();

	}

}
