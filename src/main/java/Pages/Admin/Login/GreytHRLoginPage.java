package Pages.Admin.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GreytHRLoginPage {
	WebDriver driver;
	@FindBy(id = "j_username")
	private WebElement usernameTextbox;
	@FindBy(id = "j_password")
	private WebElement passwordTextbox;
	@FindBy(id = "login-button")
	private WebElement loginButton;
	@FindBy(linkText = "#reset-panel")
	private WebElement forgotPasswordLink;
	@FindBy(linkText = "mailto:?subject=Trouble logging into greytHR.")
	private WebElement contactUsLink;
	@FindBy(linkText = "/home.do")
	private WebElement titleText;
	@FindBy(className = "login-powered-by-logo")
	private WebElement loginFailtitleText;
	@FindBy(id = "login_error_message")
	private WebElement invalidLoginMessage;

	public GreytHRLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) {

		usernameTextbox.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		passwordTextbox.sendKeys(strPassword);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public void clickOnForgotPasswordLink() {
		forgotPasswordLink.click();
	}

	public void clickOnContactUsLink() {
		contactUsLink.click();
	}

	public String getLoginTitle() {
		return titleText.getText();
	}

	public String getloginFailtitleText() {
		return loginFailtitleText.getText();
	}

	public boolean invalidLoginMessage() {
		return invalidLoginMessage.isEnabled();
	}

	public void loginToGreytHRApplication(String strUserName, String strPassword) {
		setUserName(strUserName);
		setPassword(strPassword);
		clickOnLoginButton();
	}

	public boolean verifyLoginSuccess() {
		if (invalidLoginMessage.isDisplayed()) {
			return false;
		} else
			return true;

	}

}
