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
import Pages.Admin.Login.GreytHRLoginPage;
import Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu.CreateTaskForm;
import Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu.MytaskboardPage;
import Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu.TaskView;
import Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu.TasksListView;
import Pages.Admin.TaskmanagementModule.Tasks.TaskNavigation.TasksMenuNavigation;



/**
 * @author Mubarak
 *
 */
public class TaskManagement {

	WebDriver driver;
	BaseClass bc;

	int row = 2;
	public MytaskboardPage myTaskboardPage;
	public CreateTaskForm createTaskForm;
	public TasksMenuNavigation taskNavigation;
	public GreytHRNavigation greytHRNavigation;
	public GreytHRLoginPage greytHRLogin;
	public TasksListView taskListView;
	public TaskView taskView;
	public GreytHrExcelImporter excelImporter;

	@BeforeMethod
	public void launchApplication() {
		bc = new BaseClass();
		driver = bc.launchGreytHRApplication();
		bc.loginTOGreytHR();
		
		myTaskboardPage = new MytaskboardPage(driver);
		createTaskForm = new CreateTaskForm(driver);
		taskNavigation = new TasksMenuNavigation(driver);
		greytHRNavigation = new GreytHRNavigation(driver);
		taskListView = new TasksListView(driver);
		taskView = new TaskView(driver);
		excelImporter = new GreytHrExcelImporter();

	}

	@AfterMethod
	public void closeApplication() {
		driver.quit();
	}

	/*@Test(priority = 0)
	public void CreateTaskAndMapToStandlone() {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		greytHRNavigation.navigateToTaskMenu();
		myTaskboardPage.clickOnAddNewButton();
		createTaskForm.enterTaskname(excelImporter.getExcelData("Create Task", row, 0));
		createTaskForm.enterDescription(excelImporter.getExcelData("Create Task", row, 1));
		createTaskForm.setPriority(excelImporter.getExcelData("Create Task", row, 2));
		createTaskForm.setTaskStatus(excelImporter.getExcelData("Create Task", row, 3));
		createTaskForm.mapTo(excelImporter.getExcelData("Create Task", row, 4));
		createTaskForm.enterDueDate(excelImporter.getExcelData("Create Task", row, 5),
				excelImporter.getExcelData("Create Task", row, 6), excelImporter.getExcelData("Create Task", row, 7));
		// createTaskForm.enterAssignee(excl.getExcelData("Create Task", row,
		// 8));
		createTaskForm.clickOnSaveButton();
	}

	@Test(priority = 1)
	public void viewTask() {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		greytHRNavigation.navigateToTaskMenu();
		taskNavigation.AllTasksMenu();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		taskListView.clickOnTaskViewIcon();
	}*/
	@Test(priority = 2)
	public void completeATask(){
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		greytHRNavigation.navigateToTaskMenu();
		taskNavigation.AllTasksMenu();
		taskListView.clickOnCompleteTaskCheckBox("Demo Auto 1");
		
	}

}
