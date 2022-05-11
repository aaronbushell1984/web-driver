package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import driverUtilities.DriverUtilities;
import testData.InvestorsHighlightsPageTestData;

public class Test_Investors_Highlights {
	
	WebDriver driver;
//	Actions actions;
//	WebDriverWait wait;
//	JavascriptExecutor jsExecutor;

	@Before
	public void setUp() {
		
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.get(InvestorsHighlightsPageTestData.pageUrl);
//		actions = new Actions(driver);
//		jsExecutor = (JavascriptExecutor) driver;
//		wait = new WebDriverWait(driver, 120);
		
	}
	
	@Test
	public void test_financial_highlights() {
		
		// Step 1 -
		
		
		// Step 2 - 
		
		
		// Step 3 - 


	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
