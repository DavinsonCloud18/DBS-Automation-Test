package dbs.automation.interview.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage {
	WebDriver driver;
	
	public SecureAreaPage(WebDriver newDriver) {
		this.driver = newDriver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Secure Area']")
	private WebElement textSecureArea;
	
	@FindBy(id = "flash")
	private WebElement flashAlert;
	
	@FindBy(xpath = "//a[@class='close']")
	private WebElement closeFlashAlert;
	
	public String getSecureAreaText() {
		return this.textSecureArea.getText();
	}
	
	public String getAlertMessage() {
		return this.flashAlert.getText();
	}
	
	public void closeAlert() {
		this.closeFlashAlert.click();
	}
}
