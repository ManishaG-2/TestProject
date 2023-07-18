package HashtagProject;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyNowPageScript {

	WebDriver driver;
	
	@BeforeTest
	public void initSetup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
	
	
		driver.get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor jse =(JavascriptExecutor) driver;
	    jse.executeScript("window.scrollBy(0,500)");
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[name='name']")));
		
	}

	
	@Test
	public void applyNow() 
	{
		
		
		WebElement name = driver.findElement(By.xpath("//input[@name = 'name']"));
		name.sendKeys("Manisha Ghangale");
		
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("8788212851");
		
		WebElement email = driver.findElement(By.xpath("//input[@type = 'email']"));
		email.sendKeys("ghangalemanisha07@gmail.com");

		
		WebElement uploadResume = driver.findElement(By.xpath("//input[@type= 'file']"));
		uploadResume.sendKeys("D:\\Software Testing Stuff\\RESUME\\Manisha_G Resume.pdf");
	
	
		WebElement description = driver.findElement(By.xpath("//textarea[@name= 'description']"));
		description.sendKeys("Automation Test Engineer having 3.6 year Experience");
	
		WebElement applyNow = driver.findElement(By.xpath("//button[contains(text(), 'APPLY NOW')]"));
		applyNow.click();
	}
	
	 @AfterClass
	 public void tearDown()
	 {
		driver.close();
	 }
	
}
