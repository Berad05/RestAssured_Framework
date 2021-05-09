Feature: Validating Plcae Api
@Smoke
Scenario Outline: Validate Place is added using AddPlace Api

Given User is having AddPlace Api with "<name>" "<address>" "<language>"
When User calls "AppPlaceApi" with http "Post" request
Then The Api call get success with statusCode 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place created maps to "<name>" using "GetPlaceApi" resource

Examples:

|name			     |address	        |language|
|Saoji Dhabha        |Krishna Colony    |English|
#|Christanand Hospital|Christanand Chowk |Marathi|
@Regression
Scenario: Validate Delete place API
Given User is having Delete Place Api
When User calls "DeletePlaceApi" with http "Post" request
Then The Api call get success with statusCode 200
And "status" in response body is "OK"
