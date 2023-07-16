package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.ApplyNowPage;

public class Steps {
	
	WebDriver driver;
	public ApplyNowPage anp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		anp = new ApplyNowPage(driver);
	}

	@When("User open URL {string}")
	public void user_open_url(String url) 
	{
	    driver.get(url);;
	}
	
	@And("scroll down the page")
	public void scroll_down_the_page()
	{
	    JavascriptExecutor jse =(JavascriptExecutor) driver;
	    jse.executeScript("window.scrollBy(0,1000)");
	}

	@And("User enter the details in mandatory fields")
	public void user_enter_the_details_in_mandatory_fields()
	{
	   anp.setName("Manisha");
	   anp.setPhone("8788212851");
	   anp.setExperience("4");
	   anp.setEmail("ghangalemanisha07@gmail.com");
	   anp.setNoticePeriod("15");
	   anp.setDescription("Automation Test Engineer");
	   anp.uploadResume("D:\\Software Testing Stuff\\RESUME\\Manisha_G Resume.pdf");
	}

	@When("Click on Apply Now button")
	public void click_on_apply_now_button()
	{
	   anp.ClickApplyBtn();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg)
	{
	   Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Application Submitted Successfully."));
		
	}

	
	
	@When("User does not enter the details in mandatory fields")
	public void user_does_not_enter_the_details_in_mandatory_fields()
	{
		   anp.setName("");
		   anp.setPhone("");
		   anp.setExperience("4");
		   anp.setEmail("ghangalemanisha07@gmail.com");
		   anp.setNoticePeriod("15");
		   anp.setDescription("");
		   anp.uploadResume("D:\\Software Testing Stuff\\RESUME\\Manisha_G Resume.pdf");
	}
	
	@Then("User can view message {string}")
	public void user_can_view_message(String msg) 
	{
		 Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("This field may not be blank."));
	}
	
	@When("User does enter the details {string},{string},{string},{string},{string},{string}")
	public void user_does_enter_the_details_d_software_testing_stuff_resume_manisha_resume2_pdf(String name, String Phone, String Email, String Experience, String Notice_Period, String Description) {
		   anp.setName(name);
		   anp.setPhone(Phone);
		   anp.setEmail(Email);
		   anp.setExperience(Experience);
		   anp.setNoticePeriod(Notice_Period);
		   anp.setDescription(Description);
	}
	
	@When("User leave the Resume field blank")
	public void user_leave_the_resume_field_blank() {
	    anp.uploadResume("");
	}
	
	@Then("Close browser")
	public void close_browser()
	{
	    driver.close();
	}
	
	
   }
