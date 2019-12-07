package org.testleaf.lead.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuplicateLeadFinalPractise {

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
	  driver.findElementByXPath("//a[text()='Find Leads']").click();
	  driver.findElementByXPath("//span[text()='Email']").click();
	  driver.findElementByXPath("//span[text()='Email']").click();
	  driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("sthesiva88@gmail.com");
	  driver.findElementByXPath("//button[text()='Find Leads']").click();
	  WebDriverWait wait = new WebDriverWait(driver,70);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a)[1]")));
	  WebElement firstRecord = driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a)[1]");
	  Thread.sleep(9000);
	  String firstRecordText = firstRecord.getText();
	  System.out.println("The name of the first record is : " + firstRecordText);
	  firstRecord.click();
	  driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
	  String title = driver.getTitle();
	  if(title.contains("Duplicate"))
	  {
		  System.out.println("the title is verified and correct : " + title);
	  }
	  else
	  {
		  System.out.println("the title is wrong : " + title);
	  }
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Create Lead']")));
	  driver.findElementByXPath("//input[@value='Create Lead']").click();
	  Thread.sleep(5000);
	  WebElement secondRecord = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']");
	  String secondRecordText = secondRecord.getText();
	  System.out.println(secondRecordText);
	  if(secondRecordText.contains(firstRecordText))
	  {
		  System.out.println("The name is same");
	  }
	  else
	  {
		  System.out.println("The name is not same");
	  }
	  driver.close();
	}

}
