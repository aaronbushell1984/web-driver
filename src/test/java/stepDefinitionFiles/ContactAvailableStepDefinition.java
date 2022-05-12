package stepDefinitionFiles;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import driverUtilities.DriverUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ContactPage;
import pageObjects.NavBar;
import testData.ContactPageTestData;
import testData.HomePageTestData;

public class ContactAvailableStepDefinition {
	
	WebDriver driver;
	
	public ContactAvailableStepDefinition(BaseStepDefinition baseStepDefinition) {
		this.driver = baseStepDefinition.driver;
	}
	
	@Given("User attempts to contact FDM")
	public void user_attempts_to_contact_fdm() {
		// Opens the browser
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver();	
		// Maximize browser
		driver.manage().window().maximize();		
	}
	@When("Online at anytime")
	public void online_at_anytime() {
		// Load the website Home page
		driver.get(HomePageTestData.pageUrl);
		// Step 1 Click the CONTACT link
		NavBar.contactLink(driver).click();
		// Check Url
	}
	@Then("Contact is avaialble")
	public void contact_is_avaialble() {
		assertEquals(ContactPageTestData.pageUrl, driver.getCurrentUrl());
		// Check Heading
		assertEquals(ContactPageTestData.pageHeading, ContactPage.heading(driver).getText());
		driver.close();
	}

}
