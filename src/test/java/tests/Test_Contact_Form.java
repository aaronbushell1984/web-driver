package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import driverUtilities.DriverUtilities;
import functions.Screenshot;
import junit.framework.Assert;
import pageObjects.ContactPage;
import pageObjects.NavBar;
import testData.ContactPageTestData;
import testData.HomePageTestData;


@SuppressWarnings("deprecation")
public class Test_Contact_Form {
	
	WebDriver driver;
	
	@Before
	public void preConditions() {	
		// Opens the browser
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver();
		
		// Maximize browser
		driver.manage().window().maximize();
		
		// Notification
		System.out.println("Start the Test Cases");
		
		// Load the website Home page
		driver.get(HomePageTestData.pageUrl);
		System.out.println("\nLoad the website - " + HomePageTestData.pageUrl);
	}

	@Test
	public void incorrectDetailsTest() throws IOException {
		
		// Step 1 Click the CONTACT link
		NavBar.contactLink(driver).click();
		// Check Url
		Assert.assertEquals(ContactPageTestData.pageUrl, driver.getCurrentUrl());
		// Check Heading
		Assert.assertEquals(ContactPageTestData.pageHeading, ContactPage.heading(driver).getText());
		
		// Step 2 Select Department
		Select departmentField = new Select(ContactPage.departmentDropDownList(driver));
		departmentField.selectByVisibleText(ContactPageTestData.departmentDropDownTextIt);
		// Take screenshot
		Screenshot.takeScreenshot(driver, "DepartmentShot");
		// Check Option
		Assert.assertEquals(ContactPageTestData.departmentDropDownTextIt, ContactPage.selectedDepartmentOption(driver).getText());
		
		// Step 3 Enter First Name
		ContactPage.firstNameField(driver).sendKeys(ContactPageTestData.firstName);
		// Check name entered
		Assert.assertEquals(ContactPageTestData.firstName, ContactPage.firstNameField(driver).getAttribute("value"));
		
		// Step 4 Enter email
		ContactPage.emailField(driver).sendKeys(ContactPageTestData.emailAddress);
		// Check email
		Assert.assertEquals(ContactPageTestData.emailAddress, ContactPage.emailField(driver).getAttribute("value"));
		
		// Step 5 Enter phone number
		ContactPage.phoneNumberField(driver).sendKeys(ContactPageTestData.phoneNumber);
		// Check number
		Assert.assertEquals(ContactPageTestData.phoneNumber, ContactPage.phoneNumberField(driver).getAttribute("value"));
		
		// Step 6 Enter message
		ContactPage.messageField(driver).sendKeys(ContactPageTestData.message);
		// Check message
		Assert.assertEquals(ContactPageTestData.message, ContactPage.messageField(driver).getAttribute("value"));




	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
