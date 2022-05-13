package stepDefinitionFiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.NavBar;
import pageObjects.UniversitaetenPage;
import pageObjects.UniversitiesPage;
import testData.HomePageTestData;
import testData.UniversityPageTestData;

public class UniversityStepDefinition {
	
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	
	public UniversityStepDefinition(BaseStepDefinition baseStepDefinition) {
		this.driver = baseStepDefinition.driver;
		this.wait = baseStepDefinition.wait;
		this.actions = baseStepDefinition.actions;
		this.jsExecutor = baseStepDefinition.jsExecutor;
	}
	
	@Given("User on homepage")
	public void user_on_homepage() {
		driver.get(HomePageTestData.pageUrl);
	}
	@When("User hovers over our work link")
	public void user_hovers_over_our_work_link() {
		actions.moveToElement(NavBar.ourWorkLink(driver)).perform();
	}
	@Then("Universities link displayed")
	public void universities_link_displayed() {
		assertTrue(NavBar.universitiesLink(driver).isDisplayed());
	}
	@When("Universities link clicked")
	public void universities_link_clicked() {
		NavBar.universitiesLink(driver).click();
	}
	@Then("User on University page from homepage")
	public void user_on_university_page_from_homepage() {
		assertEquals(UniversityPageTestData.pageUrl, driver.getCurrentUrl());
	}
	@Then("Page contains key data")
	public void page_contains_key_data() {
		assertTrue(driver.getPageSource().contains(UniversityPageTestData.partnerships90));
	}
	@When("User scrolls down")
	public void user_scrolls_down() {
		jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight,1050)");
	}
	@When("Slider becomes visible")
	public void slider_becomes_visible() {
		wait.until(ExpectedConditions.elementToBeClickable(UniversitiesPage.recruitmentSlickSlide01(driver)));
	}
	@When("User hovers over university slide")
	public void user_hovers_over_university_slide() {
		actions.moveToElement(UniversitiesPage.recruitmentSlickSlide01(driver)).perform();
	}
	@Then("Slide contains university text")
	public void slide_contains_university_text() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(UniversitiesPage.recruitmentSlickSlide01(driver).getText().contains(UniversityPageTestData.universities480));
	}
	@When("User clicks left arrow")
	public void user_clicks_left_arrow() {
		UniversitiesPage.recruitmentSlickTrackLeftButton(driver).click();
	}
	@When("User hovers over high profile slide")
	public void user_hovers_over_high_profile_slide() {
		actions.moveToElement(UniversitiesPage.recruitmentSlickSlide06(driver)).perform();
	}
	@Then("Slide contains profile text")
	public void slide_contains_profile_text() {
		assertTrue(UniversitiesPage.recruitmentSlickSlide06(driver).getText().contains(UniversityPageTestData.highProfile200));
	}
	@When("User scrolls to bottom of screen")
	public void user_scrolls_to_bottom_of_screen() {
		jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	@When("User clicks brochure link")
	public void user_clicks_brochure_link() {
		UniversitiesPage.brochureLink(driver).click();
	}
	@When("User waits for brochure to load")
	public void user_waits_for_brochure_to_load() {
		wait.until(ExpectedConditions.urlMatches(UniversityPageTestData.pdfUrl));
	}
	@Then("User on brochure page")
	public void user_on_brochure_page() {
		assertEquals(UniversityPageTestData.pdfUrl, driver.getCurrentUrl());
	}
	@When("User navigates back from brochure")
	public void user_navigates_back_from_brochure() {
		driver.navigate().back();
	}
	@Then("User on University Page back from brochure")
	public void user_on_university_page_back_from_brochure() {
		assertEquals(UniversityPageTestData.pageUrl, driver.getCurrentUrl());
	}
	@When("User clicks GB flag")
	public void user_clicks_gb_flag() {
		UniversitiesPage.gbFlagImg(driver).click();
	}
	@When("Waits for language dropdown")
	public void waits_for_language_dropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(UniversitiesPage.deutschLink(driver)));
	}
	@Then("Language dropdown is displayed")
	public void language_dropdown_is_displayed() {
		assertTrue(UniversitiesPage.languageDropdownList(driver).isDisplayed());
	}
	@Then("Deutsch link is displayed")
	public void deutsch_link_is_displayed() {
		assertTrue(UniversitiesPage.deutschLink(driver).isDisplayed());
	}
	@When("User clicks {string} link")
	public void user_clicks_link(String language_xpath) {
		UniversitiesPage.linkByXpathString(driver, language_xpath).click();
	}
	@Then("User on {string} page")
	public void user_on_page(String country_url) {
		assertEquals(country_url, driver.getCurrentUrl());
	}
	@Then("{string} is correct")
	public void heading_is_correct(String heading) {
		assertEquals(heading, UniversitaetenPage.heading2(driver).getText());
	}
	@When("User navigates back from Universitaeten")
	public void user_navigates_back_from_universitaeten() {
		driver.navigate().back();
	}
	@Then("User on University page from Universitaeten")
	public void user_on_university_page_from_universitaeten() {
		assertEquals(UniversityPageTestData.pageUrl, driver.getCurrentUrl());
	}

}
