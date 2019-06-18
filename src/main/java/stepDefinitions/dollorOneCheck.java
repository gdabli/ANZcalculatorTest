package stepDefinitions;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class dollorOneCheck {
	
WebDriver driver;
	
	@Given("^user is already on default page$")
	public void user_already_on_borrow_lender_page(){
		System.setProperty("webdriver.gecko.driver","/Users/gauravdabli/Downloads/Software-Zipfiles/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	}
	
	@When("^user enter dollor one for living expenses$")
	public void select_living_expenses() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q1']"))).sendKeys("1");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q1']"))).getAttribute("value");
		Assert.assertEquals("1", textInsideBox);
	}
	
	
	@And("^income is zero$")
	public void select_income() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q1']"))).sendKeys("0");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q1']"))).getAttribute("value");
		Assert.assertEquals("0", textInsideBox);
			 
	}
	
	@And("^other income is zero$")
	public void select_other_income() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q2']"))).sendKeys("0");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q2']"))).getAttribute("value");
		Assert.assertEquals("0", textInsideBox);

	}
	
	@And("^current homeloan repayments is zero$")
	public void select_homeloan_repayments() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q2']"))).sendKeys("0");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q2']"))).getAttribute("value");
		Assert.assertEquals("0", textInsideBox);
	}
	
	@And("^other loan repayments is zero$")
	public void select_otherloan_repayments() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q3']"))).sendKeys("0");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q3']"))).getAttribute("value");
		Assert.assertEquals("0", textInsideBox);
	}
	
	@And("^other commitments is zero$")
	public void select_commitments() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q4']"))).sendKeys("0");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q4']"))).getAttribute("value");
		Assert.assertEquals("0", textInsideBox);
	}
	
	@And("^creditcard limit is zero$")
	public void select_credicardlimit() throws Throwable{
		driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q5']"))).sendKeys("0");
		String textInsideBox = driver.findElement((By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q5']"))).getAttribute("value");
		Assert.assertEquals("0", textInsideBox);
	}
	
	@Then("^user clicks on estimate$")
	public void verify_estimate() throws InterruptedException{
		driver.findElement(By.xpath("//div[contains(@class,'borrow__calculate text--center clearfix')]")).click();
		String error_message = driver.findElement(By.xpath("//div[@class='box--left text--center']/span[@class='borrow__error__text']")).getAttribute("innerHTML");
		Assert.assertEquals("Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on <b>1800 100 641</b>.", error_message.trim());
	}
	

}
