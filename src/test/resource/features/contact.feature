Feature: Contact
	User should be able to contact admin
	
Scenario: User should be able to login with valid credentials
	Given Load home page
	When Enter name "Pierre"
	And Enter email "pierre@gmail.com"
	And Enter phone "01724567805778"
	And Enter subject "contacting"
	And Enter message "Hello there! your contact form sucks!!!"
	And CLick Submit button
	Then we see successful message
	

