package com.crm.qa.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: naveen reddy')]")
	public WebElement nameLabel;
	
	@FindBy(xpath="(//*[contains(text(),'Contacts')])[1]")
	public WebElement contactsLink;
	
	
	
	@FindBy(xpath="(//*[contains(text(),'Tasks')])[1]")
	public WebElement tasksLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[13]/a")
	public WebElement docButton;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[13]/ul/li[1]/a")
	public WebElement newDocumentlink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[5]/a")
	public WebElement dealsLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[5]/ul/li[1]/a")
	public WebElement newDealslink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[14]/a")
	public WebElement formslink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[14]/ul/li/a")
	public WebElement newFormLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[8]/a")
	public WebElement CallLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[8]/ul/li[1]/a")
	public WebElement NewCallLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[15]/a")
	public WebElement reportLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[3]/a")
	public WebElement comapnieslink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[3]/ul/li[2]/a")
	public WebElement combinedForm;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[3]/ul/li[3]/a")
	public WebElement fullForm;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[12]/a")
	public WebElement campaignLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[12]/ul/li[5]/a")
	public WebElement smsCampaigns;
	
	@FindBy(xpath="//a[contains(text(),'Calendar')]")
	public WebElement CalendarLink;
	
	@FindBy(xpath="//a[contains(text(),'Week View')]")
	public WebElement WeekView;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']/ul/li[2]/a")
	public WebElement signUp;
	
	
   public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
   
   public String verifyHomePageTitle(){
	   
	   return driver.getTitle();
	   
   }
   
   public boolean verifyUserName(){
	   
	   return nameLabel.isDisplayed();
	   
	   
   }
   
   public ContactsPage clickOnContactsLink(){
	   
	   contactsLink.click();
	   return new ContactsPage();
   }
   
   public DealsPage clickOnDealsLink(){
	   dealsLink.click();	 
	   return new DealsPage();
   }
   
   
   public DealsPage goToNewDeal(){
		
		Actions actions = new Actions(driver);
		actions.moveToElement(dealsLink).perform();
		
		actions.moveToElement(newDealslink).click().build().perform();
		return new DealsPage();
	}
   
   public DealsPage clickOnTasksLink(){
	   dealsLink.click();	 
	   return new DealsPage();
   }
   
   public DocPage clickOnDocLink() {
	   
	   Actions actions = new Actions(driver);
		
		actions.moveToElement(docButton).build().perform();
		
		actions.moveToElement(newDocumentlink).click().build().perform();
	   
	   return new DocPage();
	   
   }
   
   public FormPage clickOnForm(){
	   
	 Actions actions = new Actions(driver);
		
		actions.moveToElement(formslink).build().perform();
		
		actions.moveToElement(newFormLink).click().build().perform();
	   
	   
	  // JavascriptExecutor jse = (JavascriptExecutor)driver;
	  // jse.executeScript("document.getElementByXpath('newFormLink').click();");
	  
	   return new FormPage();
	   
	   
   }
   
   
   public NewCallPage ClickOnNewCallLink() throws InterruptedException{
	   
	   Actions actions = new Actions(driver);
		
		actions.moveToElement(CallLink).build().perform();
		
		Thread.sleep(1000);
		
		actions.moveToElement(NewCallLink).click().build().perform();
		
		return new NewCallPage();
   }
   
   public void ReportsLink(){
	   
	   reportLink.click();
	      
	  
   }
   
   public CompaniesPage combinedLink() throws InterruptedException{
	   
	   Actions actions = new Actions(driver);
		
		actions.moveToElement(comapnieslink).build().perform();
		
		Thread.sleep(5000);
		
		actions.moveToElement(combinedForm).click().build().perform();
		
		return new CompaniesPage();
		
   }
   
   
   public FullFormPage gotoFullFormPage() throws InterruptedException{
	   Actions actions = new Actions(driver);
	   
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.moveToElement(comapnieslink).build().perform();
		
		Thread.sleep(5000);
		
           actions.moveToElement(fullForm).click().build().perform();
		
		return new FullFormPage();
		
   }
   
   public void gotoCampaignspages() throws InterruptedException {   
      Actions actions = new Actions(driver);   
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.moveToElement(campaignLink).build().perform();	
		Thread.sleep(5000);
		actions.moveToElement(smsCampaigns).click().build().perform();
		
   }
   
   public void selectingDynamically(){
	   
	   Actions actions = new Actions(driver);   
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.moveToElement(campaignLink).build().perform();	
		
		String before_Path= "//*[@id='navmenu']/ul/li[12]/ul/li[";
		String after_Path = "]/a";
		
		for(int i=1;i<=10;i++){
			
			String fullpath = driver.findElement(By.xpath(before_Path + i + after_Path)).getText();
			WebElement wb = driver.findElement(By.xpath(before_Path + i + after_Path));
			
			if(fullpath.equals("after_Path")){
				Actions action = new Actions(driver);   
				action.moveToElement(wb).click();
				//driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[12]/ul/li["+i+"]/a")).click();
			}
		}
   }
   
   public CalendarPage gotoCalendarWeekView(){
	   
	   Actions actions = new Actions(driver);   
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.moveToElement(CalendarLink).build().perform();
		actions.moveToElement(WeekView).click().build().perform();
		
		return new CalendarPage();
   }
public SignUpPage gotoSignUpPage(){
	signUp.click();
	return new SignUpPage();
	
}
	
   
	
	
	
	

}
