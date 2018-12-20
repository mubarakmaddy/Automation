package Pages.Admin.TaskmanagementModule.Tasks.TaskNavigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksMenuNavigation {
	WebDriver driver;
	@FindBy(xpath = "//span[@class='primary-menu'][contains(text(),'TASKS')]")
	WebElement tasksMenu;
	@FindBy(xpath = "//span[contains(@class,'secondary-menu')][contains(text(),'My Task Board')]")
	WebElement myTaskBoardMenu;
	@FindBy(xpath = "//span[@class='primary-menu'][text()='Tasks ']/../..")
	WebElement tasksMenuIsEnabled;
	@FindBy(xpath = "//span[contains(@class,'secondary-menu')][contains(text(),'All Tasks')]")
	WebElement allTasksMenu;
	@FindBy(xpath = "//span[contains(@class,'secondary-menu')][contains(text(),'Delegated')]")
	WebElement delegatedMenu;
	@FindBy(xpath = "//span[contains(@class,'secondary-menu')][contains(text(),'Following')]")
	WebElement followingMenu;
	@FindBy(xpath = "//span[contains(@class,'secondary-menu')][contains(text(),'Unassigned')]")
	WebElement unassignedMenu;
	@FindBy(xpath = "//span[contains(@class,'secondary-menu')][contains(text(),'Private')]")
	WebElement privateMenu;

	public TasksMenuNavigation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyMenuIsEnabled(WebElement a) {
		return a.isDisplayed();
	}

	public WebElement myTaskBoardMenu() {
		return myTaskBoardMenu;

	}

	public void clickOnTasksMenu() {
		tasksMenu.click();
	}

	public void clickOnMyTaskBoardMenu() {
		myTaskBoardMenu.click();
	}

	public String verifyTasksMenuIsEnable() {
		return tasksMenuIsEnabled.getAttribute("aria-multiselectable");
	}

	public void AllTasksMenu() {
		allTasksMenu.click();
	}

	public void Delegated() {
		delegatedMenu.click();
	}

	public void FollowingMenu() {
		followingMenu.click();
	}

	public void UnassignedMenu() {
		unassignedMenu.click();
	}

	public void PrivateMenu() {
		privateMenu.click();
	}

}
