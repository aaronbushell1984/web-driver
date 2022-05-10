package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBar {
	
	public static WebElement contactLink(WebDriver driver) {
		return driver.findElement(By.linkText("CONTACT"));
	}

}
