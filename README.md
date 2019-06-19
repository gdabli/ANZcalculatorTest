# ANZcalculatorTest
This project contains test cases for ANZ borrwing calculator. it has cucumber test with Behavior-Driver Development.

## test case details
1. test case1 (A person with following details..) and case2(clicking start over button..) are part of feature Borrowestimate.feature while test case3(Entering $1....) are part of dolloOneCheck.feature. In the project, these cases will execute in sequential manner from classes BorrowingEstimate.test and dollorOneCheck.java respectively. 

## how to run
1. Clone this project to your local with command `git clone https://github.com/gdabli/ANZcalculatorTest.git`
2. Open the project in Eclipse IDE
3. Run the `TestRunner.java` class with junit test
4. when the project run completed, right click on project and select `refresh`
5. A `test-output` folder will be created in project hierarchy
![alt text](https://raw.github.com/gdabli/Anzcalculator/master/images/image1.png)
6. Expand test-output and right click on index.html. right click on it and select properties. copy the `Location` path from pop up window.
![alt text](https://raw.github.com/gdabli/Anzcalculator/master/images/image2.png)
7. Open your favourite browser and run the path.
8. WOW, now you should be able to get all the test results Feature wise.

## Suggestion on speed up the test for larger test
1. Use of parallelisation tools could also be helpful in bringing down execution time drastically. 
2. Breaking down test cases feature wise is good stretegy. it helps to identify errors promptly.

## Improve reliability
Sometime UI tests can failed unpreditably when automation attempts to hit a button which is not present on webpage. in those cases, we can use driver property to wait until element is not present in the page. for e.g. I have used `WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("borrow__result__text__amount")));`. apart from this, we can also use `thread.sleep()` for certain cases