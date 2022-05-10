package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	
	public static WebElement departmentDropDownList(WebDriver driver) {
		return driver.findElement(By.id("department"));
	}

	public static WebElement firstNameField(WebDriver driver) {
		return driver.findElement(By.id("firstname"));
	}
	
	public static WebElement lastNameField(WebDriver driver) {
		return driver.findElement(By.id("lastname"));
	}
	
	public static WebElement emailField(WebDriver driver) {
		return driver.findElement(By.id("email"));
	}
	
	public static WebElement phoneNumberField(WebDriver driver) {
		return driver.findElement(By.id("contact"));
	}
	
	public static WebElement messageField(WebDriver driver) {
		return driver.findElement(By.id("message"));
	}
	
	public static WebElement submitButton(WebDriver driver) {
		return driver.findElement(By.id("contact_email"));
	}

	public static WebElement heading(WebDriver driver) {
		return driver.findElement(By.cssSelector("h1"));
	}

	public static WebElement selectedDepartmentOption(WebDriver driver) {
		Select departmentField = new Select(ContactPage.departmentDropDownList(driver));
		return departmentField.getFirstSelectedOption();
	}

	public static WebElement lastNameError(WebDriver driver) {
		return driver.findElement(By.id("lastname-error"));
	}

}
