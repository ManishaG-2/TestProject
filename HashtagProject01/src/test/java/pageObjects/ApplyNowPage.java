package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyNowPage {
	
	public WebDriver driver;
	
	public ApplyNowPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "name") WebElement txtName;
	
	@FindBy(name = "number") WebElement txtPhone;
	
	@FindBy(name = "experience") WebElement txtExperince;
	
	@FindBy(name = "form-control hash-input") WebElement txtDescription;
	
	@FindBy(xpath = "//input[@type = 'email']") WebElement txtEmail;

	@FindBy(xpath = "//input[@name= 'notice_time']") WebElement txtNoticePeriod;
	
	@FindBy(xpath = "//input[@type= 'file']") WebElement uploadFile;
	
	@FindBy(xpath = "//*[contains(text(),'APPLY NOW')]") WebElement applyBtn;

	
	public void setName(String name)
	{
		txtName.sendKeys(name);
	}
	
	public void setPhone(String phone)
	{
		txtPhone.sendKeys(phone);
	}
	
	public void setExperience(String experience )
	{
		txtExperince.sendKeys(experience);
	}
	
	public void setDescription(String description) 
	{
		txtDescription.sendKeys(description);
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setNoticePeriod(String noticePeriod) 
	{
		txtNoticePeriod.sendKeys(noticePeriod);
	}
	
	public void uploadResume(String Resume) 
	{
		uploadFile.sendKeys(Resume);
		
	}
	
	public void ClickApplyBtn()
	{
		applyBtn.click();
		
	}
	
	
}
