/**
 * 
 */
package Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Library.GreytHrExcelImporter;



/**
 * @author Mubarak
 *
 */
public class TasksListView {
	WebDriver driver;
	Actions act;
	GreytHrExcelImporter exl = new GreytHrExcelImporter();
	@FindBy(xpath = "//span[@title='Mark it as completed']/i")
	WebElement completeTaskCheckBox;
	@FindBy(className = "task-name")
	WebElement taskNameLable;
	@FindBy(xpath = "//div [@class='row gt-task-tags']/div")
	List<WebElement> tags;
	@FindBy(xpath = "//div [@class='col-md-2 col-sm-2 task-date gt-task-ellipsis']")
	WebElement dueDate;
	@FindBy(xpath = "//div [@class='col-md-1 col-sm-1 task-priority']/i")
	WebElement priority;
	@FindBy(xpath = "//i[@title='Click To Preview']")
	WebElement taskViewIcon;

	public TasksListView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCompleteTaskCheckBox(String taskName) {
		completeTaskCheckBox.findElement(By.xpath("(//span [@class='task-name'][@title="
				+ exl.getExcelData("View Task", 0, 0) + "]/../preceding-sibling::div/span/i)[1]")).click();
	}

	public List<String> getTags(String taskName) {
		List<WebElement> a = driver.findElements(By.xpath(
				"//span[@title = 'Taskkk']/../../../following-sibling::div[@class='col-md-3 col-sm-3']/div/div"));
		List<String> b = null;
		for (int i = 0; i <= a.size(); i++) {
			b.add(a.get(i).getAttribute("title"));
		}
		return b;

	}

	public void getDueDate(String taskName) {
	
	}

	public void clickOnTaskViewIcon() {

		driver.findElement(By.xpath(
				"(//span[@class='task-name']/strong[contains(text()," + exl.getExcelData("View Task", 0, 0) + ")])[1]"))
				.click();

	}

}
