package stepDefinitions;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class BorrowingEstimate {

	WebDriver driver;
	
	@Given("^user is already on Lender page$")
	public void user_already_on_borrow_lender_page(){
		//System.setProperty("webdriver.chrome.driver","/Users/gauravdabli/Downloads/Software-Zipfiles/chromedriver");
		System.setProperty("webdriver.gecko.driver","/Users/gauravdabli/Downloads/Software-Zipfiles/geckodriver");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	}
	
	// need to complete
	@When("^Applicant type is Single$")
	public void select_user_type(){
		WebElement applicant_type = driver.findElement(By.id("application_type_single"));
		applicant_type.click();
		//String text = applicant_type.getText();
		//Assert.assertEquals("Single", text);
	}
	
	//need to complete
	@When("^no dependents$")
	public void select_dependents(){
		
		Select dependents = new Select(driver.findElement(By.xpath("//select[@title='Number of dependants']")));
		dependents.selectByIndex(0);
		
	}
	
	//need to complete
	@When("^buying a home$")
	public void select_property_type(){
		WebElement home_type = driver.findElement(By.id("borrow_type_home"));
		home_type.click();
	}
	
	@When("^income is eighty thousand$")
	public void select_income() throws Throwable{
		List<WebElement> lineItemDivs = driver.findElements(By.cssSelector(".input__wrapper"));
		for (WebElement div : lineItemDivs)
		{
		    if (div.findElements(By.cssSelector("[aria-labelledby='q2q1']")).size() > 0)
		    {
		        div.findElement(By.tagName("input")).sendKeys("80000");
		    }
		}	 
	}
	
	
	@When("^other income is ten thousand$")
	public void select_other_income() throws Throwable{
		List<WebElement> lineItemDivs = driver.findElements(By.cssSelector(".input__wrapper"));
		for (WebElement div : lineItemDivs)
		{
		    if (div.findElements(By.cssSelector("[aria-labelledby='q2q2']")).size() > 0)
		    {
		        div.findElement(By.tagName("input")).sendKeys("10000");
		    }
		}
	}
	
	
	@When("^living expenses fivehundred$")
	public void select_living_expenses() throws Throwable{
		List<WebElement> lineItemDivs = driver.findElements(By.cssSelector(".input__wrapper"));
		for (WebElement div : lineItemDivs)
		{
		    if (div.findElements(By.cssSelector("[aria-labelledby='q3q1']")).size() > 0)
		    {
		        div.findElement(By.tagName("input")).sendKeys("500");
		    }
		}
	}
	
	
	@When("^current homeloan repayments$")
	public void select_homeloan_repayments() throws Throwable{
		List<WebElement> lineItemDivs = driver.findElements(By.cssSelector(".input__wrapper"));
		for (WebElement div : lineItemDivs)
		{
		    if (div.findElements(By.cssSelector("[aria-labelledby='q3q2']")).size() > 0)
		    {
		        div.findElement(By.tagName("input")).sendKeys("0");
		    }
		}
	}
	
	
	@When("^other loan repayments$")
	public void select_otherloan_repayments() throws Throwable{
		List<WebElement> lineItemDivs = driver.findElements(By.cssSelector(".input__wrapper"));
		for (WebElement div : lineItemDivs)
		{
		    if (div.findElements(By.cssSelector("[aria-labelledby='q3q3']")).size() > 0)
		    {
		        div.findElement(By.tagName("input")).sendKeys("100");
		    }
		}
	}
	
	@When("^other commitments$")
	public void select_commitments() throws Throwable{
		List<WebElement> lineItemDivs = driver.findElements(By.cssSelector(".input__wrapper"));
		for (WebElement div : lineItemDivs)
		{
		    if (div.findElements(By.cssSelector("[aria-labelledby='q3q4']")).size() > 0)
		    {
		        div.findElement(By.tagName("input")).sendKeys("0");
		    }
		}
	}
	
	@When("^creditcard limit ten thousand$")
	public void select_credicardlimit() throws Throwable{
		List<WebElement> lineItemDivs = driver.findElements(By.cssSelector(".input__wrapper"));
		for (WebElement div : lineItemDivs)
		{
		    if (div.findElements(By.cssSelector("[aria-labelledby='q3q5']")).size() > 0)
		    {
		        div.findElement(By.tagName("input")).sendKeys("10000");
		    }
		}
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
	
	
}
