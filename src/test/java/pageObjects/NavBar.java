package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBar {
	
	public static WebElement contactLink(WebDriver driver) {
		return driver.findElement(By.linkText("CONTACT"));
	}

	public static WebElement ourWorkLink(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-item-1427\"]/a"));
	}

	public static WebElement universitiesLink(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-item-1455\"]/a"));
	}

}
