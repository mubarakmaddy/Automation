/**
 * 
 */
package Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Mubarak
 *
 */
public class TaskView {
	WebDriver driver;
	Select selectObj;

	@FindBy(className = "cancel-task")
	WebElement cancelTaskButton;
	@FindBy(xpath = "//i[@title='More Options']")
	WebElement taskOptionsIcon;
	@FindBy(xpath = "//div [@class='popover-content']/div/div/div[contains(text(),'Duplicate')]")
	WebElement taskDuplicateOption;
	@FindBy(xpath = "//div [@class='popover-content']/div/div[contains(text(),'Activity Log')]")
	WebElement taskActivityLogOption;
	@FindBy(xpath = "//div [@class='popover-content']/div/div[contains(text(),'Delete')]")
	WebElement taskDeleteOption;
	@FindBy(xpath = "//button[@title='Click To Edit']")
	WebElement taskEditButton;
	@FindBy(name = "taskStatus")
	WebElement taskStatus;
	@FindBy(xpath = "//textarea [@placeholder='Write a comment.....']")
	WebElement commentTextarea;
	@FindBy(xpath = "//span[contains(text(),'Comment')]")
	WebElement commentButton;
	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[1]")
	WebElement commentCancelButton;
	@FindBy(xpath = "//span[contains(text(),'Update')]")
	WebElement commentUpdateButton;

	public TaskView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCancelTaskLink() {
		cancelTaskButton.click();
	}

	public void clickOnOptionsOfTask() {
		taskOptionsIcon.click();
	}

	public void deleteTask() {
		taskDeleteOption.click();
	}

	public void duplicateTask() {
		taskDuplicateOption.click();
	}

	public void ViewTaskActivityLog() {
		taskActivityLogOption.click();
	}

	public void editATask() {
		taskEditButton.click();
	}

	public void setTaskStatus(String status) {
		selectObj = new Select(taskStatus);
		selectObj.selectByVisibleText(status);
	}

	public void clickOnCommentTextArea() {
		commentTextarea.click();
	}

	public void commentOnATask(String enterComment) {
		commentTextarea.sendKeys(enterComment);
		commentButton.click();
	}

	public void clickCancelButtonOfComment() {
		commentCancelButton.click();
	}

	public void updateAComment(String commentToUpdated, String data) {
		driver.findElement(By.xpath("//div [@class='gt-ellipsis']/p[contains(text()," + commentToUpdated + ")]"));

		commentTextarea.clear();
		commentTextarea.sendKeys(data);
		commentUpdateButton.click();
	}
}
