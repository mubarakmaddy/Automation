package Pages.Admin.GHRNavigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GreytHRNavigation {
	WebDriver driver;
	@FindBy(xpath = "(//span/i[@class='icon-tasks'])[1]")
	private WebElement taskMenu;
	@FindBy(xpath = "(//span/i[@class='icon-tasks'])[2]")
	private WebElement expandedTaskMenu;
	

	public GreytHRNavigation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToTaskMenu() {
		taskMenu.click();
		expandedTaskMenu.click();
	}
	

}
