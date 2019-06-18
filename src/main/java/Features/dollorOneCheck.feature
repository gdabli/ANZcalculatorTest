Feature: negative test dollor one form

Scenario: User input dollor one and leaves rest field blank

Given user is already on default page
When user enter dollor one for living expenses
And income is zero
And other income is zero
And current homeloan repayments is zero
And other loan repayments is zero
And other commitments is zero
And creditcard limit is zero
Then user clicks on estimate