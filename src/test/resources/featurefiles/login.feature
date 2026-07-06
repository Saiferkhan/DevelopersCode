Feature:

Background:
Given User go to the login page


#@valid
Scenario: valid login 
When the user Enter correct username and password
And Click on login button
Then User should see homepage
And user logged successfully

#@invalid
Scenario: invalid login
When the user Enter incorrect username and password
And Click on login button
Then User should not see homepage
And user not logged  successfully
