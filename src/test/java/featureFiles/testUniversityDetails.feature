#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@universityPage
Feature: University Page

  @testUniversityDetails
  Scenario Outline: Test University Details
    Given User on homepage
    When User hovers over our work link
    Then Universities link displayed
    When Universities link clicked
    Then User on University page from homepage
    And Page contains key data
    When User scrolls down
    And Slider becomes visible
    And User hovers over university slide
    Then Slide contains university text
    When User clicks left arrow
    And User hovers over high profile slide
    Then Slide contains profile text
    When User scrolls to bottom of screen
    And User clicks brochure link
    And User waits for brochure to load
    Then User on brochure page
    When User navigates back from brochure
    Then User on University Page back from brochure
    When User clicks GB flag
    And Waits for language dropdown
    Then Language dropdown is displayed
    And Deutsch link is displayed
    When User clicks "<language_xpath>" link
    Then User on "<country_url>" page
    And "<Heading>" is correct
    When User navigates back from Universitaeten
    Then User on University page from Universitaeten
    
    Examples: 
    | language_xpath																	| country_url																			| Heading				|
    | //*[@id=\"fdm-location-selector\"]/ul/li[4]/a 	| https://www.fdmgroup.com/de/universitaeten/ 		| Hochschulen		|
    | //*[@id='fdm-location-selector']/ul/li[2]/a 		| https://www.fdmgroup.com/en-us/us-universities/ | Universities 	| 
    
    