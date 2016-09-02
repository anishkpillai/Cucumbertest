package com.google;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchDefinitions {
	
	public static WebDriver driver;
	
	@Given("^I navigate to Home Page$")
	public void i_navigate_to_Home_Page() {
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.google.com");
	}

	@When("^I search for keyword \"(.*?)\"$")
	public void i_search_for_keyword_apple(String searchWord)  {
		driver.findElement(By.name("q")).sendKeys(searchWord+Keys.ENTER);
	}

	@Then("^I see search results with \"(.*?)\"$")
	public void i_see_search_results_with_apple(String searchWord)  {
	    Assert.assertTrue("Verify Search results page", driver.getPageSource().contains(searchWord));
	}
	
	@Then("^I close the browser$")
	public void i_close_the_browser() {
	   driver.quit();
	}


}
