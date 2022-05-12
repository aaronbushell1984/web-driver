package stepDefinitionFiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import driverUtilities.DriverUtilities;
import functions.Screenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ContactPage;
import pageObjects.NavBar;
import testData.ContactPageTestData;
import testData.HomePageTestData;

public class IncompleteDetailsStepDefinition {

	WebDriver driver;

	@Given("User attempts to contact FDM online")
	public void user_attempts_to_contact_fdm_online() {
		// Opens the browser
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver();

		// Maximize browser
		driver.manage().window().maximize();

		// Load the website Home page
		driver.get(HomePageTestData.pageUrl);

		// Click the CONTACT link
		NavBar.contactLink(driver).click();

	}

	@When("Incomplete information is provided")
	public void incomplete_information_is_provided() throws IOException {

		// Step 2 Select Department
		Select departmentField = new Select(ContactPage.departmentDropDownList(driver));
		departmentField.selectByVisibleText(ContactPageTestData.departmentDropDownTextIt);
		// Take screenshot
		Screenshot.takeScreenshot(driver, "DepartmentShot");
		// Check Option
		assertEquals(ContactPageTestData.departmentDropDownTextIt,
				ContactPage.selectedDepartmentOption(driver).getText());

		// Step 3 Enter First Name
		ContactPage.firstNameField(driver).sendKeys(ContactPageTestData.firstName);
		// Check name entered
		assertEquals(ContactPageTestData.firstName, ContactPage.firstNameField(driver).getAttribute("value"));

		// Step 4 Enter email
		ContactPage.emailField(driver).sendKeys(ContactPageTestData.emailAddress);
		// Check email
		assertEquals(ContactPageTestData.emailAddress, ContactPage.emailField(driver).getAttribute("value"));

		// Step 5 Enter phone number
		ContactPage.phoneNumberField(driver).sendKeys(ContactPageTestData.phoneNumber);
		// Check number
		assertEquals(ContactPageTestData.phoneNumber, ContactPage.phoneNumberField(driver).getAttribute("value"));

		// Step 6 Enter message
		ContactPage.messageField(driver).sendKeys(ContactPageTestData.message);
		// Check message
		assertEquals(ContactPageTestData.message, ContactPage.messageField(driver).getAttribute("value"));
		// Step 7 Click submit and display warning
		ContactPage.submitButton(driver).submit();
		// Take screenshot
		Screenshot.takeScreenshot(driver, "LastNameMissingWarningShot");
	}

	@Then("A warning is provided")
	public void a_warning_is_provided() {
		// Check warning is displayed with correct message and have stayed on same page
		assertTrue(ContactPage.lastNameError(driver).isDisplayed());
		assertTrue(ContactPage.lastNameError(driver).getText().equals(ContactPageTestData.lastNameError));
		assertEquals(ContactPageTestData.pageUrl, driver.getCurrentUrl());
		driver.close();
	}

}
