@Regression @LoginFeature
Feature: The Heroku App Login Feature

	Background: 
	Given I open browser and access URL "http://the-internet.herokuapp.com/login"
	And I see login page
	
	@Positive
	Scenario: Login using valid credentials
	When I input "tomsmith" as username
	And I input "SuperSecretPassword!" as password
	And I click button login
	Then I redirected to secure area page
	And I see alert with message "You logged into a secure area!"
	And I close the alert "You logged into a secure area!"
	And I close the browser
	
	@Negative
	Scenario: Login using valid credentials
	When I input "admin" as username
	And I input "SuperSecretPassword!" as password
	And I click button login
	Then I see alert with message "Your username is invalid!"
	And I close the alert "Your username is invalid!"
	When I input "tomsmith" as username
	And I input "admin" as password
	And I click button login
	Then I see alert with message "Your password is invalid!"
	And I close the alert "Your password is invalid!"
	And I close the browser
	
	