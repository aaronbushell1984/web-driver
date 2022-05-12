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
  Scenario: Test University Detials
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
    When User clicks Deutsch link
    Then User on Universitaeten page
    And Heading one is correct
    And Heading two is correct
    When User navigates back from Universitaeten
    Then User on University page from Universitaeten

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
