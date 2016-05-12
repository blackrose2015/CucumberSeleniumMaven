Feature: Run automation to check for Launchworks
  
Scenario: Test report

  Given I have logged into the LaunchReport web application using my session ID
	  And I have selected the R12 - Installation Fitness Report
	  And I have selected two values from each prompt
	  And I have run the report
	  And I have downloaded the xls version of the report
  When I click Back twice
  Then I see that I am able to download the pdf version of R13 - MAJCOM Fitness Report
