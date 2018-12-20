package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Abc {
	static String expectedMonth = "Jan";
	static String actuslMonth;
	static String expectedYear = "2025";
	static String actualYear;

	public static void main(String[] args) {

		String a = "Confirm Checklist";

		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("http://testtask.greytip2.in/login.do");
		/*
		 * driver.findElement(By.id("j_username")).sendKeys("admin");
		 * driver.findElement(By.id("j_password")).sendKeys("saaa");
		 * driver.findElement(By.id("login-button")).click();
		 * driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		 * System.out.println(driver.findElement(By.id("login_error_message")).isEnabled
		 * ()); //System.out.println(driver.getTitle());
		 */
		driver.get("http://testtask.lk.greytip2.in/v3/login");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("sa");
		driver.findElement(By.name("submit")).click();
		driver.navigate().to("http://testtask.lk.greytip2.in/v3/portal");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//span[@class='primary-menu'][text()='Tasks
		// ']/../..")).click();
		// System.out.println(driver.findElement(By.xpath("//span[@class='secondary-menu'][text()='All
		// Tasks']")).isDisplayed());
		/*
		 * driver.navigate().to("http://testtask.lk.greytip2.in/v3/portal");
		 * driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		 * //driver.findElement(By.xpath("(//div[@class='panel-title card-title'])[3]"))
		 * .click(); //driver.findElement(By.className("fa fa-chevron-right")).click();
		 * driver.findElement(By.
		 * xpath("//div[@class='accordion-toggle']/a/span[@class='primary-menu'][contains(text(), 'Checklists')]"
		 * )).click(); driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		 * //driver.findElement(By.xpath(
		 * "//span[@class='secondary-menu'][contains(text(),'"+a+"')]")).click();
		 * TaskmanagementNavigation tnv = new TaskmanagementNavigation(driver);
		 * tnv.selectChecklist("Confirm Checklist");
		 * 
		 * String checklistXpath = "//span[@class='secondary-menu'][contains(text(),'";
		 * checklistXpath = a + "')]" ;
		 * driver.findElement(By.xpath(checklistXpath)).click();
		 */
		/*
		 * driver.findElement(By.
		 * xpath("//button [@class='btn btn-primary btn-md create-btn']")).click();
		 * //driver.findElement(By.name("taskName")).sendKeys("Task 1"); CreateTaskForm
		 * ct = new CreateTaskForm(driver); ct.enterTaskname("Taskkk");
		 * ct.enterDescription("uyggh  fddsaf"); ct.setPriorityMedium();
		 * ct.setTaskStatus("Ongoing"); //ct.mapTaskToChecklist(); ct.mapTaskToNone();
		 * //ct.enterChecklists(Arrays.asList("automation","before1"));
		 * ct.enterDueDate(20,"Dec",2017); ct.enterAssignee("5018"); //List<String>
		 * tagName = Arrays.asList("agh","hyt");
		 * //ct.enterTags(Arrays.asList("agh","hyt","ads","hyt"));
		 * //ct.enterComment("jksdksjkfsdksjdfk"); ct.addFollower("5018");
		 * //ct.clickOnSaveButton();
		 */
		Actions act;

		act = new Actions(driver);
		WebElement abc = driver
				.findElement(By.xpath("(//strong[contains(text()," + "'same Day-Named User-Task'" + ")])[1]"));
		act.moveToElement(abc.findElement(By.xpath("//i[@title='Click To Preview']"))).click().perform();

		// driver.findElement(By.xpath("//input [@id='task']")).click();
		// driver.findElement(By.xpath("//span [@class='gtdpicon
		// icon-gtdpcalendar']")).click();

		// System.out.println(driver.findElement(By.xpath("//button
		// [@class='headerlabelbtn yearlabel']")).getText());

		// System.out.println(diff);

		/*
		 * do{ actuslMonth =
		 * driver.findElement(By.xpath("//button [@class='headerlabelbtn monthlabel']"))
		 * .getText(); if (!actuslMonth.equalsIgnoreCase(expectedMonth)){
		 * driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click(); }
		 * }while(!actuslMonth.equalsIgnoreCase(expectedMonth));
		 * 
		 * actualYear =
		 * driver.findElement(By.xpath("//button [@class='headerlabelbtn yearlabel']")).
		 * getText(); int ay = Integer.parseInt(actualYear); int ey =
		 * Integer.parseInt(expectedYear);
		 * 
		 * int diff = ay-ey;
		 * 
		 * if(diff>0){ for(int i=0; i<diff;i++){
		 * driver.findElement(By.xpath("//button[@aria-label='Previous Year']")).click()
		 * ; System.out.println(i+"jh"+diff); } driver.findElement(By.
		 * xpath("//td/div [@class='currmonth' or @class='currmonth sunday']")).
		 * findElement(By.xpath("//span[text() = '13']")).click(); } else if(diff<0){
		 * for(int i=0; i>diff;i--){
		 * driver.findElement(By.xpath("//button[@aria-label='Next Year']")).click();
		 * System.out.println(i+"hj"+diff); } driver.findElement(By.
		 * xpath("//td/div [@class='currmonth' or @class='currmonth sunday']")).
		 * findElement(By.xpath("//span[text() = '13']")).click(); }
		 */

		// System.out.println(diff);

	}

}
