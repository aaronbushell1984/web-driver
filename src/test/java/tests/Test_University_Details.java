package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverUtilities.DriverUtilities;
import pageObjects.NavBar;
import pageObjects.UniversitaetenPage;
import pageObjects.UniversitiesPage;
import testData.HomePageTestData;
import testData.UniversitaetenPageTestData;
import testData.UniversityPageTestData;

public class Test_University_Details {
	
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	@Before
	public void setUp() {
		
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.get(HomePageTestData.pageUrl);
		actions = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 120);
		
	}
	
	@Test
	public void test_university_details() {
		
		// Step 1 - Hover our work link
		actions.moveToElement(NavBar.ourWorkLink(driver)).perform();
		// Check Universities link displayed
		assertTrue(NavBar.universitiesLink(driver).isDisplayed());
		
		// Step 2 - Click universities button
		NavBar.universitiesLink(driver).click();
		// Check page is university page
		assertEquals(UniversityPageTestData.pageUrl, driver.getCurrentUrl());
		// Check 90 partnerships displayed
		assertTrue(driver.getPageSource().contains(UniversityPageTestData.partnerships90));
		// Scroll Down
		jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight,900)");
		// Wait for scroll
		wait.until(ExpectedConditions.elementToBeClickable(UniversitiesPage.recruitmentSlickSlide01(driver)));
		// Hover to pause slider
		actions.moveToElement(UniversitiesPage.recruitmentSlickSlide01(driver)).perform();
		// Check slider contains test data
		assertTrue(UniversitiesPage.recruitmentSlickSlide01(driver).getText().contains(UniversityPageTestData.universities480));	
		// Click slider left arrow	
		UniversitiesPage.recruitmentSlickTrackLeftButton(driver).click();
		actions.moveToElement(UniversitiesPage.recruitmentSlickSlide06(driver)).perform();
		// Check slide contains test data	
		assertTrue(UniversitiesPage.recruitmentSlickSlide06(driver).getText().contains(UniversityPageTestData.highProfile200));
		
		
		// Step 3 - scroll down
		jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		// Click brochure 
		UniversitiesPage.brochureLink(driver).click();
		// Wait for pdf load
		wait.until(ExpectedConditions.urlMatches(UniversityPageTestData.pdfUrl));
		// Check pdf available
		assertEquals(UniversityPageTestData.pdfUrl, driver.getCurrentUrl());
		
		// Step 5 - navigate back
		driver.navigate().back();
		// Check page url
		assertEquals(UniversityPageTestData.pageUrl, driver.getCurrentUrl());
		
		// Step 6 - click GB flag button
		UniversitiesPage.gbFlagImg(driver).click();
		// Wait for dropdown
		wait.until(ExpectedConditions.elementToBeClickable(UniversitiesPage.deutschLink(driver)));
		// Check dropdown is displayed
		assertTrue(UniversitiesPage.languageDropdownList(driver).isDisplayed());
		// Check Deutsch link available
		assertTrue(UniversitiesPage.deutschLink(driver).isDisplayed());
		// Click Deutsch link
		UniversitiesPage.deutschLink(driver).click();
		// Check the page url
		assertEquals(UniversitaetenPageTestData.pageUrl, driver.getCurrentUrl());
		// Check the page heading
		assertEquals(UniversitaetenPageTestData.heading, UniversitaetenPage.heading(driver).getText());
		// Check the second page heading
		assertEquals(UniversitaetenPageTestData.heading2, UniversitaetenPage.heading2(driver).getText());
		
		// Step 8 - navigate back
		driver.navigate().back();
		// Check page url
		assertEquals(UniversityPageTestData.pageUrl, driver.getCurrentUrl());
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
