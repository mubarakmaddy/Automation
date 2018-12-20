/**
 * 
 */
package Pages.Admin.TaskmanagementModule.Tasks.MyTaskBoardSubMenu;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Mubarak
 *
 */
public class CreateTaskForm {
	WebDriver driver;
	int day;
	Select selectObj;

	@FindBy(className = "cancel-task")
	WebElement cancelTaskButton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveTaskButton;
	@FindBy(name = "taskName")
	WebElement taskNameTextBox;
	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement descriptionTextArea;
	@FindBy(xpath = "//div[@class='col-md-3 col-sm-3']/div[contains(text(),'Low')]/preceding-sibling::i")
	WebElement priorityLowCheckBox;
	@FindBy(xpath = "//div[@class='col-md-3 col-sm-3']/div[contains(text(),'Medium')]/preceding-sibling::i")
	WebElement priorityMediumCheckBox;
	@FindBy(xpath = "//div[@class='col-md-3 col-sm-3']/div[contains(text(),'High')]/preceding-sibling::i")
	WebElement priorityHighCheckBox;
	@FindBy(name = "taskStatus")
	WebElement taskStatus;
	@FindBy(xpath = "//input[@id='checklist']")
	WebElement checklistRadioButton;
	@FindBy(xpath = "//input [@id='task']")
	WebElement taskRadioButton;
	@FindBy(xpath = "//span [@class='gtdpicon icon-gtdpcalendar']")
	WebElement dueDateInputField;
	@FindBy(xpath = "//button [@class='headerlabelbtn monthlabel']")
	WebElement monthLable;
	@FindBy(xpath = "//button[@class='headertodaybtn headertodaybtnenabled']")
	WebElement todayLable;
	@FindBy(xpath = "//button [@class='headerlabelbtn yearlabel']")
	WebElement yearLable;
	@FindBy(xpath = "//td/div [@class='currmonth' or @class='currmonth sunday']")
	WebElement dateLable;
	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement nextMonthButton;
	@FindBy(xpath = "//button[@aria-label='Previous Month']")
	WebElement previousMonthButton;
	@FindBy(xpath = "//button[@aria-label='Next Year']")
	WebElement nextYearButton;
	@FindBy(xpath = "//button[@aria-label='Previous Year']")
	WebElement previousYearButton;
	@FindBy(xpath = "(//input [@class='owner-name ng-untouched ng-pristine ng-valid'])[1]")
	WebElement assigneeSearchField;
	@FindBy(xpath = "//div [@class='drop']")
	WebElement assigneeDropdown;
	@FindBy(xpath = "//input[@placeholder='Add Tags']")
	WebElement addtagsSearchField;
	@FindBy(xpath = "//input[@placeholder='Add More Tags']")
	WebElement addMoreTagsSearchField;
	@FindBy(xpath = "")
	WebElement tagsDropdown;
	@FindBy(xpath = "//textarea [@placeholder='Write a comment.....']")
	WebElement commentTextarea;
	@FindBy(xpath = "//span [@class='circle icon']")
	WebElement followersIcon;
	@FindBy(xpath = "(//input[@placeholder='Search for employee'])[2]")
	WebElement followersSearchField;
	@FindBy(xpath = "//div[@class='drop']")
	WebElement followersDropdown;
	@FindBy(xpath = "//input[@placeholder='Search a Checklist']")
	WebElement checklistinputField;

	public CreateTaskForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCancelButton() {
		cancelTaskButton.click();
	}

	public void clickOnSaveButton() {
		saveTaskButton.click();
	}

	public void enterTaskname(String taskName) {
		taskNameTextBox.sendKeys(taskName);
	}

	public void enterDescription(String description) {
		descriptionTextArea.click();
		descriptionTextArea.sendKeys(description);
	}

	public void setPriority(String a) {
		switch (a.toLowerCase()) {
		case "low":
			priorityLowCheckBox.click();
		case "medium":
			priorityMediumCheckBox.click();
		case "high":
			priorityHighCheckBox.click();

		}
	}

	public void setTaskStatus(String status) {
		selectObj = new Select(taskStatus);
		selectObj.selectByVisibleText(status);
	}

	public void mapTo(String a) {
		if (a.equalsIgnoreCase("Checklist")) {
			checklistRadioButton.click();
		} else if (a.equalsIgnoreCase("Task")) {
			taskRadioButton.click();
		}

	}

	public void enterDueDate(String date, String month, String year) {
		int rdate = Integer.parseInt(date);
		int ryear = Integer.parseInt(year);
		String actuslMonth;
		String actualYear;
		dueDateInputField.click();
		do {
			actuslMonth = monthLable.getText();
			driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
			/*if (!actuslMonth.equalsIgnoreCase(month)) {
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
			}*/
		} while (!actuslMonth.equalsIgnoreCase(month));

		actualYear = yearLable.getText();

		int diff = Integer.parseInt(actualYear) - ryear;

		if (diff > 0) {
			for (int i = 0; i < diff; i++) {
				previousYearButton.click();
			}
			dateLable.findElement(By.xpath("//span[text() =" + rdate + "]")).click();
		} else if (diff <= 0) {
			for (int i = 0; i > diff; i--) {
				nextYearButton.click();
			}
			dateLable.findElement(By.xpath("//span[text() =" + rdate + "]")).click();
		}

	}

	public void enterAssignee(String employeeNo) {
		Actions actions = new Actions(driver);
		assigneeSearchField.sendKeys(employeeNo);
		// assigneeDropdown.findElement(By.xpath("//ul/li/a[contains(text(),"+employeeNo+")]")).click();
		actions.moveToElement(assigneeDropdown.findElement(By.xpath("//ul/li/a[contains(text()," + employeeNo + ")]")))
				.click().perform();

	}

	public void enterTags(List<String> tagName) {
		addtagsSearchField.sendKeys(tagName.get(0), Keys.ENTER);
		for (int i = 1; i < tagName.size(); i++) {
			addMoreTagsSearchField.sendKeys(tagName.get(i), Keys.ENTER);
		}
	}

	public void enterComment(String comment) {
		commentTextarea.click();
		commentTextarea.sendKeys(comment);

	}

	/*
	 * public void addFollower(List<String> employeeNo){ for (int i = 0; i <
	 * employeeNo.size(); i++) { System.out.println(i); followersIcon.click();
	 * followersSearchField.sendKeys(employeeNo.get(i));
	 * followersDropdown.findElement(By.xpath("//ul/li/a[contains(text(),"+
	 * employeeNo.get(i)+")]")).click(); } }
	 */
	public void addFollower(String follower) {
		followersIcon.click();
		followersSearchField.sendKeys(follower);
		Actions actions = new Actions(driver);
		// assigneeDropdown.findElement(By.xpath("//ul/li/a[contains(text(),"+follower+")]")).click();
		actions.moveToElement(assigneeDropdown.findElement(By.xpath("//ul/li/a[contains(text()," + follower + ")]")))
				.click().perform();

		// followersDropdown.findElement(By.xpath("//ul/li/a[contains(text(),"+follower+")]")).click();
	}

	public void enterChecklists(List<String> checklistName) {
		for (int i = 0; i < checklistName.size(); i++) {
			checklistinputField.sendKeys(checklistName.get(i));
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			List<WebElement> a = driver
					.findElements(By.xpath("//span/b[contains(text()," + checklistName.get(i) + ")]"));
			for (WebElement webElement : a) {
				if (webElement.getText().equalsIgnoreCase(checklistName.get(i)))
					webElement.click();
			}
		}
	}

}
