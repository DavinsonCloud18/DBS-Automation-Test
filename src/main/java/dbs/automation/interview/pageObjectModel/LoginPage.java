package dbs.automation.interview.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver newDriver) {
		this.driver = newDriver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement usernameFields;
	
	@FindBy(id = "password")
	private WebElement passwordFields;
	
	@FindBy(id = "flash")
	private WebElement flashAlert;
	
	@FindBy(xpath = "//a[@class='close']")
	private WebElement closeFlashAlert;
	
	@FindBy(xpath = "//i[normalize-space() = 'Login']/parent::button")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//h2[normalize-space()='Login Page']")
	private WebElement loginText;;
	
	public void inputUsername(String username) {
		this.usernameFields.sendKeys(username);
	}
	
	public void inputPassword(String password) {
		this.passwordFields.sendKeys(password);
	}
	
	public void clickBtnLogin() {
		this.btnLogin.click();
	}
	
	public void closeAlert() {
		this.closeFlashAlert.click();
	}
	
	public String getAlertMessage() {
		return this.flashAlert.getText();
	}
	
	public String getLoginText() {
		return this.loginText.getText();
	}
	
}
