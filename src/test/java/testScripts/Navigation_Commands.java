package testScripts;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import driverUtilities.DriverUtilities;


public class Navigation_Commands {

	@Test
	public void navigationCommands() {
		DriverUtilities myDriverUtilities = new DriverUtilities();
		WebDriver driver = myDriverUtilities.getDriver();

		System.out.println("Start the Test Case");

		// Load the website - http://www.bbc.co.uk
		driver.get("http://www.bbc.co.uk");
		System.out.println("\nLoad the website - http://www.bbc.co.uk");

		// Refresh the page
		driver.navigate().refresh();
		System.out.println("\nRefresh the page");

		// Load the website - http://www.fdmgroup.com
		driver.get("http://www.fdmgroup.com");
		System.out.println("\nLoad the website - http://www.fdmgroup.com");

		// Go back to the website - http://www.bbc.co.uk
		driver.navigate().back();
		System.out.println("\nGo back to the website - http://www.bbc.co.uk");

		// Go forward to the website - http://www.fdmgroup.com
		driver.navigate().forward();
		System.out.println("\nGo forward to the website - http://www.fdmgroup.com");

		// Close the browser window
		driver.close();
		System.out.println("\nClose the browser window");

		System.out.println("\nEnd of Test Case \"Navigation Commands\"");
	}

}
