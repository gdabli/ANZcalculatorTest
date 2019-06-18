package stepDefinitions;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BorrowingEstimate {

	WebDriver driver;
	
	@Given("^user is already on Lender page$")
	public void user_already_on_borrow_lender_page(){
		System.setProperty("webdriver.gecko.driver","/Users/gauravdabli/Downloads/Software-Zipfiles/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	}
	
	@When("^Applicant type is Single$")
	public void select_user_type(){
		WebElement applicant_type = driver.findElement(By.id("application_type_single"));
		applicant_type.click();
	}
	
	@When("^no dependents$")
	public void select_dependents(){
		Select dependents = new Select(driver.findElement(By.xpath("//select[@title='Number of dependants']")));
		dependents.selectByIndex(0);	
	}
	
	@When("^buying a home$")
	public void select_property_type(){
		WebElement home_type = driver.findElement(By.id("borrow_type_home"));
		home_type.click();
	}
	
	@When("^income is eighty thousand$")
	public void select_income() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q1']"))).sendKeys("80000");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q1']"))).getAttribute("value");
		Assert.assertEquals("80,000", textInsideBox);
			 
	}
	
	@When("^other income is ten thousand$")
	public void select_other_income() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q2']"))).sendKeys("10000");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q2']"))).getAttribute("value");
		Assert.assertEquals("10,000", textInsideBox);

	}
	
	
	@When("^living expenses fivehundred$")
	public void select_living_expenses() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q1']"))).sendKeys("500");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q1']"))).getAttribute("value");
		Assert.assertEquals("500", textInsideBox);
	}
	
	
	@When("^current homeloan repayments$")
	public void select_homeloan_repayments() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q2']"))).sendKeys("0");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q2']"))).getAttribute("value");
		Assert.assertEquals("0", textInsideBox);
	}
	
	
	@When("^other loan repayments$")
	public void select_otherloan_repayments() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q3']"))).sendKeys("100");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q3']"))).getAttribute("value");
		Assert.assertEquals("100", textInsideBox);
	}
	
	@When("^other commitments$")
	public void select_commitments() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q4']"))).sendKeys("0");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q4']"))).getAttribute("value");
		Assert.assertEquals("0", textInsideBox);
	}
	
	@When("^creditcard limit ten thousand$")
	public void select_credicardlimit() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q5']"))).sendKeys("10000");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q5']"))).getAttribute("value");
		Assert.assertEquals("10,000", textInsideBox);
	}
	
	
	@And("^user clicks on estimate button$")
	public void verify_estimate() throws InterruptedException{
		driver.findElement(By.xpath("//div[contains(@class,'borrow__calculate text--center clearfix')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("borrow__result__text__amount")));
		Thread.sleep(2000);
		String amount = driver.findElement(By.xpath("//*[@class='borrow__result__text']/.//span[contains(@class,'borrow__result__text__amount')]")).getAttribute("innerHTML");
		Assert.assertEquals("$467,000", amount);
	}
	
	@Then("^user clicks on start over$")
	public void clear_form(){
		driver.findElement((By.xpath("//div[@class='box--right']/button[@class='start-over']"))).click();
		
	}
	
	@And("^check your income goes default$")
	public void check_yourincome_turn_default(){
		WebElement element = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q1']")));
		String textInsideBox = element.getAttribute("value");
		Assert.assertEquals("0", textInsideBox);
	}
	
	
	
	
}
