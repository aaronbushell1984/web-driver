package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverUtilities.DriverUtilities;
import functions.NumberHandler;
import functions.TableHandler;
import pageObjects.InvestorsHighlightsPage;
import pageObjects.UniversitiesPage;
import testData.InvestorsHighlightsPageTestData;

public class Test_Investors_Highlights {
	
	WebDriver driver;
	WebElement tableBody;
	List<WebElement> trs;
	WebElement revenueRow;
	List<WebElement> revenueColumnTDs;
	List<WebElement> percentChangeColumnTDs;
//	Actions actions;
//	WebDriverWait wait;
//	JavascriptExecutor jsExecutor;

	@Before
	public void setUp() {
		
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.get(InvestorsHighlightsPageTestData.pageUrl);
		tableBody = InvestorsHighlightsPage.tableBody(driver);
		trs = TableHandler.getTRs(tableBody);
		
	}
	
	@Test
	public void test_financial_highlights() {
		
		// Step 1 - get revenue row
		revenueRow = TableHandler.getRow(trs, InvestorsHighlightsPageTestData.revenueRowNumber);
		// Get TDs
		revenueColumnTDs = TableHandler.getTDs(revenueRow);
		// Get revenue and convert to float
		Double revenue20 = NumberHandler.getDoubleFromCurrency(revenueColumnTDs.get(InvestorsHighlightsPageTestData.revenueColumn20Number).getText());
		Double revenue21 = NumberHandler.getDoubleFromCurrency(revenueColumnTDs.get(InvestorsHighlightsPageTestData.revenueColumn21Number).getText());
		// Check revenue 20 is more than 21
		assertTrue(revenue20 > revenue21);
		
		// Step 2 - get % change column TDs
		percentChangeColumnTDs = TableHandler.getColumnTDs(tableBody, InvestorsHighlightsPageTestData.hasHeader, InvestorsHighlightsPageTestData.percentChangeColumnNumber);
		// initialize counter
		int numberPositive = 0;
		// count TDs which are positive
		for (WebElement data : percentChangeColumnTDs) {
			 if (NumberHandler.checkPositiveNumberString(data.getText())) {
				 numberPositive ++;
			 };
		}
		assertEquals(InvestorsHighlightsPageTestData.percentChangePostiveNumber, numberPositive);
		
		// Step 3 - initialize list for negative % changes
		List<Double> negativePercentageChanges = new ArrayList<Double>();
		// populate list with negatives and convert to number
		for (WebElement data : percentChangeColumnTDs) {
			 if (NumberHandler.checkNegativeNumberString(data.getText())) {
				 negativePercentageChanges.add(NumberHandler.getDoubleFromCurrency(data.getText()));
			 };
		}
		// check the highest number matches test data
		assertEquals(InvestorsHighlightsPageTestData.highestNegativePercentageChange, Collections.min(negativePercentageChanges));

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
