package org.testleaf.lead.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Editleadfinaltestcase {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	      ChromeDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.get("http://leaftaps.com/opentaps/control/main");
		  driver.findElementById("username").sendKeys("DemoSalesManager");
		  driver.findElementById("password").sendKeys("crmsfa");
		  driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		  driver.findElementByLinkText("CRM/SFA").click();
		  driver.findElementByXPath("//a[text()='Leads']").click();
		  driver.findElementByLinkText("Find Leads").click();
		  Thread.sleep(3000);
		  driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("dvya");
		  driver.findElementByXPath("//button[text()='Find Leads']").click();
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  WebElement firstResult = driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]");
		  firstResult.click();
		  String title = "View Lead";
		  String currentTitle = driver.getTitle();
		  if(currentTitle.contains(title))
		  {
			  System.out.println("the title is : " + currentTitle);
		  }
		  else
		  {
			  System.out.println("the title is wrong: " + currentTitle);
		  }
		  
		  driver.findElementByXPath("//a[text()='Edit']").click();;
		  String changeName = "LC";
		  WebElement updateCompanyName = driver.findElementById("updateLeadForm_companyName");
		  updateCompanyName.clear();
		  updateCompanyName.sendKeys(changeName);
		  driver.findElementByXPath("//input[@value='Update']").click();
		  String companyName = driver.findElementById("viewLead_companyName_sp").getText();
		  if(companyName.contains(changeName))
		  {
			  System.out.println("The company name is verified and is correct : " + companyName);
		  }
		  else
		  {
			  System.out.println("The company name is verified and is incorrect : " + companyName);
		  }
		  
		  driver.quit();
	}

}
