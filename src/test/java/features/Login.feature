Feature: Application Login 

Scenario: Login with user details 
	Given Intialize Driver
	Given Open application "http://www.qaclickacademy.com/" url
	Given close popup and click login link
	When User entered "test99@gmail.com" and password "123456" and login
	Then User redirects to portal Login page  
	