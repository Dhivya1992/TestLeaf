package org.testleaf.lead.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Createleadfinalpractice {

	public static void main(String[] args) 
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
	  driver.findElementByLinkText("Create Lead").click();
	  driver.findElementById("createLeadForm_companyName").sendKeys("Letzconnect");
	  driver.findElementById("createLeadForm_firstName").sendKeys("Dvya");
	  driver.findElementById("createLeadForm_lastName").sendKeys("G.P");
	  driver.findElementByXPath("//input[@value='Create Lead']").click();
	  
	}

}
