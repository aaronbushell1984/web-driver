package stepDefinitionFiles;

import org.openqa.selenium.WebDriver;

import driverUtilities.DriverUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseStepDefinition {

	protected WebDriver driver = null;

	@Before
	public void setUp() throws Exception {
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
