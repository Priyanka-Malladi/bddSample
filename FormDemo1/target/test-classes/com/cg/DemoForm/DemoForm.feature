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
@tag
Feature: validating form demo

Background: user is in form page


Scenario: user enters all valid details
When user gives valid data
Then Display success message

Scenario: user not entering name
When name is empty 
And click submit
Then prompt error message

Scenario: user not selecting gender
When gender not selected
Then prompt error message

Scenario: user not entering address
When address is empty
Then prompt error message

Scenario: user enters invalid mobile number
When mobile number is invalid
|1234|
|9999999999999|
|5648666999|
|0015477567|
| |
Then prompt error message for mobile

Scenario: validating emailId
When user enters invalid email id
|5666|
|johnmichael|
|john@gmail|
|$$$$$$|
| |
Then prompt error message for email

Scenario: 