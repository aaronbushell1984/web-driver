package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestorsHighlightsPage {

	public static WebElement tableBody(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"section_3\"]/div/div[1]/div/table/tbody"));
	}

}
