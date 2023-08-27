package dbs.automation.interview.steps;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dbs.automation.interview.pageObjectModel.LoginPage;
import dbs.automation.interview.pageObjectModel.SecureAreaPage;
import io.cucumber.java.en.*;

public class Login {
	WebDriver driver;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	
	@Given("I open browser and access URL {string}")
	public void i_open_browser_and_access_url(String string) {
	    this.driver = new ChromeDriver();
	    this.loginPage = new LoginPage(this.driver);
	    this.secureAreaPage = new SecureAreaPage(this.driver);
	    
	    driver.get(string);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("I see login page")
	public void i_see_login_page() {
	    String text = loginPage.getLoginText();
	    assertEquals(text,"Login Page");
	}

	@When("I input {string} as username")
	public void i_input_as_username(String string) {
	    this.loginPage.inputUsername(string);
	}

	@When("I input {string} as password")
	public void i_input_as_password(String string) {
	    this.loginPage.inputPassword(string);
	}

	@When("I click button login")
	public void i_click_button_login() {
	    this.loginPage.clickBtnLogin();
	}

	@Then("I redirected to secure area page")
	public void i_redirected_to_secure_area_page() {
	    String text = secureAreaPage.getSecureAreaText();
	    assertEquals(text,"Secure Area");
	}

	@Then("I see alert with message {string}")
	public void i_see_alert_with_message(String string) {
		if(string.contains("You logged into a secure area!")) {
			String text = secureAreaPage.getAlertMessage();
			boolean isExist = text.contains(string);
			assertTrue(isExist);
		}
		else {
			String text = loginPage.getAlertMessage();
			boolean isExist = text.contains(string);
			assertTrue(isExist);
		}
	}

	@Then("I close the alert {string}")
	public void i_close_the_alert(String string) {
		if(string.contains("You logged into a secure area!")) {
			this.secureAreaPage.closeAlert();
		}	
		else {
			this.loginPage.closeAlert();
		}
	}

	@Then("I close the browser")
	public void i_close_the_browser() {
	    this.driver.close();
	    this.driver.quit();
	}

}
