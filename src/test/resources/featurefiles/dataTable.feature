Feature: User signup

Scenario: Validate the signup page with valid data

Given User is on the homepage
When User click on signup and login link
And User enter valid name and email

|name  |email           |
|saifer3|abcd125@gmail.com|
 
And User click on signup button
Then User navigate to enter account information
When User fill the required details

|password	|firstname |lastname |zipcode |day	|month	|year	|country	|state |City  |MobileNO |Address  |
|abcd@123	|saifer	   |khan	 |250434  |22   |06		|2026	|India		|UP	   |Meerut|903213455|Meerut	  |

And User click on create account button 
Then User should create account successfully
