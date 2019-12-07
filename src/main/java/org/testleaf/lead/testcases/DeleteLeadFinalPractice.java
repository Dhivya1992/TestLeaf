package org.testleaf.lead.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteLeadFinalPractice {

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
		  driver.findElementByXPath("//span[text()='Phone']").click();
		  driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("98");
		  driver.findElementByXPath("//button[text()='Find Leads']").click();
		  WebDriverWait wait = new WebDriverWait(driver,70);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]")));
		  WebElement resultinglead = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]");
		  String resultid = resultinglead.getText();
		  Thread.sleep(5000);
		  System.out.println(resultid);
		  resultinglead.click();
		  driver.findElementByXPath("//a[text()='Delete']").click();
		  driver.findElementByLinkText("Find Leads").click();
		  System.out.println("Find leads clciked from delete page");
		  Thread.sleep(5000);
		  
		  driver.findElementByXPath("//input[@name='id']").click();
		  driver.findElementByXPath("//input[@name='id']").sendKeys(resultid);
		  String recordresult = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		  if (recordresult.contains("No records to display"))
		  {
			  System.out.println("the lead is deleted succesfully");
		  }
		  else
		  {
			  System.out.println("the lead is not deleted succesfully");
		  }
		  
		  driver.close();
	}

}
