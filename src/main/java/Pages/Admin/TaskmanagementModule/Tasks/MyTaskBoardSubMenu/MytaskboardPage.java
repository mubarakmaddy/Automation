/**
 * 
 */
package Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Mubarak
 *
 */
public class MytaskboardPage {
	WebDriver driver;
	@FindBy(className = "fa fa-power-off fa-2x")
	WebElement logoutButton;
	@FindBy(xpath = "//button[@title='Create a Task']")
	WebElement addNewButton;
	@FindBy(xpath = "(//div[@class='panel-title card-title'])[3]")
	WebElement overdueTasksAccordian;
	@FindBy(xpath = "(//div[@class='panel-title card-title'])[4]")
	WebElement upcommingTasksAccordian;
	@FindBy(xpath = "(//div[@class='panel-title card-title'])[5]")
	WebElement completedTasksAccordian;
	@FindBy(className = "btn create-task")
	WebElement createNewTaskBannerButton;

	public MytaskboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLogoutButton() {
		logoutButton.click();
	}

	public void clickOnAddNewButton() {
		addNewButton.click();
	}

	public void clickOnOverdueTasksAccordian() {
		overdueTasksAccordian.click();
	}

	public void clickOnUpcommingTasksAccordian() {
		upcommingTasksAccordian.click();
	}

	public void clickOnCompletedTasksAccordian() {
		completedTasksAccordian.click();
	}

	public void clickOnCreateNewTaskBannerButton() {
		createNewTaskBannerButton.click();
	}

}
