package stepDefinitionFiles;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverUtilities.DriverUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseStepDefinition {

	protected WebDriver driver = null;
	protected WebDriverWait wait = null;
	protected JavascriptExecutor jsExecutor = null;
	protected Actions actions = null;

	@Before
	public void setUp() throws Exception {
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 120);
		actions = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
