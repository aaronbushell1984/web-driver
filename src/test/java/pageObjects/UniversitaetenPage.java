package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UniversitaetenPage {
	
	public static WebElement heading(WebDriver driver) {
		return driver.findElement(By.cssSelector("h1"));
	}
	
	public static WebElement heading2(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"section_2\"]/div/div/h1"));
	}
	
}
