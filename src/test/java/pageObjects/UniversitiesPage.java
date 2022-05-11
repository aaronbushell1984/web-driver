package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UniversitiesPage {
	
	public static WebElement recruitmentSlickSlide01(WebDriver driver) {
		return driver.findElement(By.id("slick-slide01"));
	}
	
	public static WebElement recruitmentSlickTrackLeftButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"section_2\"]/div/div[2]/div/button[2]"));
	}
	
	public static WebElement recruitmentSlickSlide06(WebDriver driver) {
		return driver.findElement(By.id("slick-slide06"));
	}

	public static WebElement brochureLink(WebDriver driver) {
		return driver.findElement(By.linkText("View our brochure"));
	}
	
	public static WebElement gbFlagImg(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"fdm-location-selector\"]/div/a/img"));
	}
	
	public static WebElement languageDropdownList(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"fdm-location-selector\"]/ul"));
	}
	
	public static WebElement deutschLink(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"fdm-location-selector\"]/ul/li[4]/a"));
	}
	
}
