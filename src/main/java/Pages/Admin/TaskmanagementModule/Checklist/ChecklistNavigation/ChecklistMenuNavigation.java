package Pages.Admin.TaskmanagementModule.Checklist.ChecklistNavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChecklistMenuNavigation {
	WebDriver driver;
	//String checklistName;
	
	@FindBy(xpath="//span[@class='primary-menu'][text()='Checklists']")
	WebElement checklistsMainMenu;
	@FindBy(linkText="/v3/portal/checklists")
	WebElement checklistGalleryLink;
	@FindBy(linkText="/v3/portal/checklists/archived")
	WebElement archivedChecklistlink;
	
	
	public ChecklistMenuNavigation(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		public void clickOnChecklistsMainMenu(){
		checklistsMainMenu.click();
	}
	
	public void clickOnChecklistGalleryLink(){
		checklistGalleryLink.click();
	}
	
	public void clickOnarChivedChecklistlink(){
		archivedChecklistlink.click();
	}
	public void selectChecklist(String checklistName){
		driver.findElement(By.xpath("//span[@class='secondary-menu'][contains(text(),'"+checklistName+"')]")).click();
	}
	
}
