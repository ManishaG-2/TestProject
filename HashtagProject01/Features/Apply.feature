Feature: Apply Now
  

  
  Scenario: Successful apply with valid Credentials
    Given User Launch Chrome browser
    When User open URL "https://www.hashtag-ca.com/careers/apply?jobCode=QAE001" 
    And scroll down the page
    And User enter the details in mandatory fields
    And Click on Apply Now button
    Then User can view confirmation message "Application Submitted Successfully."
    And Close browser
   
    
    Scenario: Apply with Blank field
    Given User Launch Chrome browser
    When User open URL "https://www.hashtag-ca.com/careers/apply?jobCode=QAE001" 
    And scroll down the page
    When User does not enter the details in mandatory fields
    And Click on Apply Now button
    Then User can view message "This field may not be blank."
    And Close browser
    
    Scenario: Apply with Left Resume field empty
    Given User Launch Chrome browser
    When User open URL "https://www.hashtag-ca.com/careers/apply?jobCode=QAE001" 
    And scroll down the page
    When User leave the Resume field blank
    And Click on Apply Now button
    Then User can view message "No file was submitted."
    And Close browser
    
 
    
    Scenario Outline: Apply with Data Driven
    Given User Launch Chrome browser
    When User open URL "https://www.hashtag-ca.com/careers/apply?jobCode=QAE001"
    And scroll down the page
    When User does enter the details "<Name>","<Phone>","<Email>","<Experience>","<Notice Period>","<Description>"
    And Click on Apply Now button
    Then User can view confirmation message "Application Submitted Successfully."
    
    Examples:
       |Name    |Phone      |Email         |Experience| Notice_Period| Description  | 
       |John    |8989562321 |john@gmail.com|  4       |   30         | Software Test Engineer|
       |Mike    |5456987512 |mike@gmail.com|  5      |    15        | Automation Test Engineer| 
       
    
  
  
   
  