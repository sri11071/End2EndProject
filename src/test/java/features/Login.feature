Feature: Application Login 

Scenario Outline: Login with user details 
	Given Intialize Driver 
	Given Open application "http://www.qaclickacademy.com/" url 
	Given close popup and click login link 
	When User entered <username> and password <password> and login 
	Then User redirects to portal Login page 	
	Examples: 
		|username	|password	|
		|test99@gmail.com	|123456	|
		|test9922@gmail.com	 |123456 |