package CucumberMaven.CucumberMaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;


public class CucumberRunner{
	
	String winHandleBefore;
	TETRApages newWindow;
	public static final Logger logger = LogManager.getLogger("CucumberRunner");
	public String username="Administrator";
	public String password="QWdF94";
	public String link ="https://trial.rapidstack.com:9443/bokaton/reports.jsp?AppName=launch";
	public String linkWithSessionID = "https://trial.rapidstack.com:9443/bokaton/reports.jsp?AppName=launch&session=8675309";

	 WebDriver driver =null;
//	@Given("^I have logged into the LaunchReport web application$")
//	public void i_have_logged_into_the_LaunchReport_web_application() throws Throwable {
//	
//		 driver=new FirefoxDriver();
//	     driver.navigate().to(link);
//	     driver.findElement(By.name("UserName")).sendKeys(username);
//	     driver.findElement(By.name("Password")).sendKeys(password);
//	     driver.findElement(By.cssSelector("input[value=Login]")).click();
//	     driver.manage().window().maximize();
//	     
//	}
	
	@Given("^I have logged into the LaunchReport web application using my session ID$")
	public void i_have_logged_into_the_LaunchReport_web_application_using_my_session_ID() throws Throwable {
	
		 driver=new FirefoxDriver();
	     driver.navigate().to(linkWithSessionID);
	     driver.manage().window().maximize();
	     
	}

	@And("^I have selected the R(\\d+) - Installation Fitness Report$")
	public void i_have_selected_the_R_Installation_Fitness_Report(int arg1) throws Throwable {
	
		//Store the current window handle
		winHandleBefore = driver.getWindowHandle();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Installation Fitness Report"))); 
		driver.findElement(By.partialLinkText("Installation Fitness Report")).click();
		
		
	}

	@And("^I have selected two values from each prompt$")
		public void i_have_selected_two_values_from_each_prompt() throws Throwable {
		 for(String winHandle : driver.getWindowHandles()){
	            driver.switchTo().window(winHandle);
	     }
		 
		newWindow=new TETRApages(driver, 10);
	    // Click on  service component search
	    newWindow.click_services_component();
	    
	   //Get values for service component search
	    Thread.sleep(5000);
        Assert.assertTrue(((TETRApages) newWindow).selected_Component_Choices_display()==true);
        newWindow.selectedList(0);
        newWindow.add_Component_Choices();
        Thread.sleep(1000);
        newWindow.hide_Component_Choices_List();
        
            
        // Click on  search file types
        Thread.sleep(1000);
        newWindow.search_file_Types();
        
        //Get values for File Types
        Thread.sleep(5000);
        Assert.assertTrue(((TETRApages) newWindow).selected_File_Types()==true);
        newWindow.selectedList(1);
        newWindow.add_File_Types();
        Thread.sleep(1000);
        newWindow.hide_File_Type_List();
        
     // Click on  MAJCOM  search
        Thread.sleep(1000);
	    newWindow.search_MAJCOM();
	    
	    //Get values for MAJCOM search
        Thread.sleep(5000);
        Assert.assertTrue(((TETRApages) newWindow).selected_MAJCOM()==true);
        newWindow.selectedList(3);
        newWindow.add_MAJCOM();
        Thread.sleep(1000);
        newWindow.hide_MAJCOM();
        
        // Click on  installation search
        Thread.sleep(1000);
        newWindow.search_Installation();
        
        //Get values for Installation
        Thread.sleep(5000);
        Assert.assertTrue(((TETRApages) newWindow).selected_Installation()==true);
        newWindow.selectedList(2);
        newWindow.add_Installation();
        Thread.sleep(1000);
        newWindow.hide_Installation();
            
       
	}

	@And("^I have run the report$")
	public void i_have_run_the_report() throws Throwable {
	  
		 // Choose XLS
		Thread.sleep(1000);
		newWindow.clickChooseXLS();
		
		// Click run report
        Thread.sleep(2000);
        newWindow.clickRunReport();
	}

	@And("^I have downloaded the xls version of the report$")
	public void i_have_downloaded_the_xls_version_of_the_report() throws Throwable {
		
	}

	@When("^I click Back twice$")
	public void i_click_Back_twice() throws Throwable {
	  
	// Click Back
    Thread.sleep(1000);
    newWindow.firstBack();
    
    //second Back
    Thread.sleep(1000);
    newWindow.secondBack();
    
    //Close the new window, if that window no more required
    //driver.close();

    //Switch back to original browser (first window)
    driver.switchTo().window(winHandleBefore);
    
	}

	@Then("^I see that I am able to download the pdf version of R(\\d+) - MAJCOM Fitness Report$")
	public void i_see_that_I_am_able_to_download_the_pdf_version_of_R_MAJCOM_Fitness_Report(int arg1) throws Throwable {
	  
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("MAJCOM Fitness Report"))); 
		driver.findElement(By.partialLinkText("MAJCOM Fitness Report")).click();
		
		 String mainWindow = driver.getWindowHandle();
	        //Switch to new window opened
	        for(String winHandle : driver.getWindowHandles()){
	            driver.switchTo().window(winHandle);
	        }

	        // Perform the actions on new window
	        
        TETRApages newWindowMAJCOM=new TETRApages(driver, 10);
        Thread.sleep(5000);
        newWindowMAJCOM.pdfChoose();
        Thread.sleep(5000);
        driver.switchTo().window(mainWindow);
        // driver.close();
        driver.quit();
	        
	}


}
