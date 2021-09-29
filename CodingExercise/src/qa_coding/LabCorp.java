package qa_coding;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LabCorp {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\16467\\Downloads\\New Driver\\NewDriver\\chromedriver_win32 (3)\\chromedriver.exe");
		
		 	ChromeDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        
	      //1. Start the test by opening a browser to www.labcorp.com 
	        
	        driver.get("https://www.google.com/");
	      
	        driver.findElement(By.name("q")).sendKeys("LabCorp");
	       
	        driver.findElement(By.name("btnK")).click();
	       
	        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3")).click();
	       
	        String title = driver.getTitle();
	       
	        System.out.println("Title is "+ title);
          
	        boolean titleStatus = title.contains("Global Life Sciences Leader in Diagnostics and Drug Development");
         
	       if(titleStatus) 
	      {
	    	  System.out.println("You are landed on a right page");
	      }
	        
	       else 
	       {
	    	  System.out.println("You are landed on a wrong page");
	      }
	        
	       
	      String mainWindow = driver.getWindowHandle(); // get the current window handle
	       
	     //2.Find and click Careers link
	      
	       
	       WebElement wb =   driver.findElementByXPath("//*[@id=\"topofpage\"]/div/footer/div[1]/div/div[1]/div/nav[1]/ul/li[3]/a");
	       
	       JavascriptExecutor js = ((JavascriptExecutor) driver);
	       
	       js.executeScript("arguments[0].click();", wb);
	       
	       TimeUnit.SECONDS.sleep(3);
	       
	       
	       //3.Search for any position (that is currently active on the site) example “QA Test Automation Developer”
	       
	       ArrayList<String> newWindow = new ArrayList<String>(driver.getWindowHandles());
	      
	       driver.switchTo().window(newWindow.get(1));
	       
	       
	       driver.findElementById("gdpr-button").click();
	       TimeUnit.SECONDS.sleep(3);
	       
	       
	       WebElement wbBody = driver.findElementByCssSelector("body");
	       
	       wbBody.sendKeys(Keys.PAGE_DOWN);
	       
	       driver.findElementByXPath("//input[@type='search']").sendKeys("QA Analyst");
	       TimeUnit.SECONDS.sleep(3);
	      
	       //4.Select and browse to the position 
            
	       driver.findElementByLinkText("QA Analyst 1").click();
	       TimeUnit.SECONDS.sleep(3);
	       
	       wbBody = driver.findElementByCssSelector("body");
	       wbBody.sendKeys(Keys.PAGE_DOWN);
	       
	       driver.findElementByXPath("//*[@id=\"search-results-list\"]/ul/li[2]/a/h2").click();
	       TimeUnit.SECONDS.sleep(3);
	       
	       wbBody = driver.findElementByCssSelector("body");
	       wbBody.sendKeys(Keys.PAGE_DOWN);
	       
	       //5. Add assertions to confirm
	      // Job Title
	      // Job Location
	     //  Job Id 
	     //  Any 3 other assertions of your choice (could be text in the requirements / introduction)
	      // Example: (Text in quotes “” from below example should be updated by candidate to match that in the position chosen for the automation solution):

	     //  Confirm first sentence of third paragraph under Description/Introduction as “The right candidate for this role will participate in the test automation technology development and best practice models.” 
	      // Confirm second bullet point under Management Support as “Prepare test plans, budgets, and schedules.” 
	      // Confirm third requirement as “5+ years of experience in QA automation development and scripting.” 
	      // Confirm first suggested automation tool to be familiar with contains “Selenium” 

	       //Job Title
	         String JobTitle = driver.findElementByXPath("//*[@id=\"content\"]/div[3]/section[2]/h1").getText();
	         
	         System.out.println("Job title is: " +JobTitle);
	        
	        boolean JobTitleStatus= JobTitle.contains("QA Analyst");
	        
	        Assert.assertEquals(JobTitleStatus, true, "Job title did not match.");
	        
			/*
			 * if(titleStatus1) { System.out.println("Job title verified."); }
			 * 
			 * else { System.out.println("Job title not mismatched."); }
			 */
	       
	     
	        //Location
	        String location = driver.findElementByXPath("//*[@id='content']/div[3]/section[2]/div[1]/span[1]").getText();
	         
	         System.out.println("Location is: " +location);
	        
	        boolean locationStatus= location.contains("Burlington, North Carolina");
	        
	        Assert.assertEquals(locationStatus, true, "Location did not match.");
	        
			/*
			 * if(locationStatus) { System.out.println("Location verified."); }
			 * 
			 * else { System.out.println("Location mismatched."); }
			 */
	        
	        //Job ID
	        String jobID = driver.findElementByXPath("//*[@id='content']/div[3]/section[2]/div[1]/span[2]").getText();
	         
	         System.out.println("Job ID is: " +jobID);
	        
	        boolean jobIDStatus= jobID.contains("21-89970");
	        
	        Assert.assertEquals(jobIDStatus, true, "Job ID did not match.");

	        
			/*
			 * if(jobIDStatus) { System.out.println("Job ID verified."); }
			 * 
			 * else { System.out.println("Job ID mismatched."); }
			 */
	       
	       
	        wbBody.sendKeys(Keys.PAGE_DOWN);
	        
	        //Any 3 other assertions of your choice
	        //1st assertion in Introduction
	        String introductionTxt = driver.findElementByXPath("//*[@id='content']/div[3]/section[2]/div[2]/div[1]/p[1]").getText();
	         
	         System.out.println("Introduction text is: " + introductionTxt);
	        
	        boolean introductionTxtStatus= introductionTxt.contains("The Quality Analyst will be responsible for supporting projects and activities related to quality assurance, quality improvement, quality training, and other responsibilities of the Quality Assurance department.");
	        
	        Assert.assertEquals(introductionTxtStatus, true, "Introduction text did not match.");
	        
	        
	        //2nd assertion in Job Responsibilities
	        String responsibilityTxt = driver.findElementByXPath("//*[@id='content']/div[3]/section[2]/div[2]/div[1]/ul/li[4]").getText();
	         
	         System.out.println("Responsibility text is: " + responsibilityTxt);
	        
	        boolean responsibilityTxtStatus= responsibilityTxt.contains("Schedule and conduct regular QA audits and inspections of assigned departments and facilities and perform audit reports");
	        
	        Assert.assertEquals(responsibilityTxtStatus, true, "Responsibility text did not match.");
	       
	        
	        //3rd assertion in Job Requirements
	        String requirementTxt = driver.findElementByXPath("//*[@id='content']/div[3]/section[2]/div[2]/div[2]/span/div[1]/ul/li[3]").getText();
	         
	         System.out.println("Requirements text is: " + requirementTxt);
	        
	        boolean requirementTxtStatus= requirementTxt.contains("Previous experience with an electronic data management system is a plus (i.e. MasterControl)");
	        
	        Assert.assertEquals(requirementTxtStatus, true, "Requirements text did not match.");
	        TimeUnit.SECONDS.sleep(3);
	        
	        driver.quit();
	

	}

}
