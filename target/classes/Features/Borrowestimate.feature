Feature: Borrowing estimate feature

Scenario: verify the borrowing estimate for new applicant

Given user is already on Lender page
When Applicant type is Single
When no dependents
When buying a home
When income is eighty thousand
When other income is ten thousand
When living expenses fivehundred
When current homeloan repayments
When other loan repayments
When other commitments
When creditcard limit ten thousand
And user clicks on estimate button
Then user clicks on start over
Then income turn default
Then other income turn default
Then living expenses turn default
Then current homeloan repayments turn default
Then otherloan repayments turn default
Then other commitments turn default
Then cardlimit turn default



