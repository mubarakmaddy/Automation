/**
 * 
 */
package Pages.Admin.TaskmanagementModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Mubarak
 *
 */
public class TaskmanagementLoginPage {
	WebDriver driver;
	@FindBy(name = "username")
	WebElement tmUserNameTextBox;
	@FindBy(name = "password")
	WebElement tmPasswordTextBox;
	@FindBy(name = "submit")
	WebElement tmLoginButton;

	public TaskmanagementLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getTmUserName(String userName) {
		tmUserNameTextBox.sendKeys(userName);
	}

	public void getTmPassword(String password) {
		tmPasswordTextBox.sendKeys(password);
	}

	public void clickOnTmLoginButton() {
		tmLoginButton.click();
	}

	public void taskmanagementLogin(String UserName, String password) {
		getTmUserName(UserName);
		getTmPassword(password);
		clickOnTmLoginButton();
	}
}
