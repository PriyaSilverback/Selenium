package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class profileBrowserinputs {
		
	public static FirefoxProfile profile = new FirefoxProfile();	
	public static  WebDriver Driver = new FirefoxDriver(profile);
    
    
	public static void profileBrowser() {
		
		profile.setPreference("browser.download.folderList", 2); //2 downlaods without prompt to save
	    profile.setPreference("browser.download.dir", System.getProperty("user.home") + "/Downloads"); //Setting the path for the export to download to downloads folder on any user's machine
	    profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
	    profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/html,application/xhtml+xml,application/xml,image/jpg, text/csv, text/html, Binary, text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf,application/octet-stream, application/octet-stream");       
	   
	}

	
	
    
      	    
	//QA Urls:	
		public static String  Console_Url = "https://qa.silverbackmdm.com/admin";
		public static String  qa_ssp = " https://qa.silverbackmdm.com/ssp";
		public static String  qa = " https://qa.silverbackmdm.com";
		public static String  qa_loginUsername = "admin";
		public static String  qa_loginPswd = "S1lverb@ck";
		
		//Inputs to Android and SAFE devices: 
		public static String  Console_Activate_Url = "https://qa.silverbackmdm.com/activate";
		public WebDriverWait ExplicitWait = new WebDriverWait(Driver, 10);
    
		// Log in to Admin console:
		public static void login_To_QA_AdminConsole_AsAdmin ()
		{
			
			Driver.get(Console_Url);
			Driver.findElement(By.id("Username")).sendKeys(qa_loginUsername);
			Driver.findElement(By.id("Password")).sendKeys(qa_loginPswd);
			Driver.findElement(By.xpath("//input[@type='submit']")).click();
		}	
		
		
		//WriteTestData:
		public List<TestCases> writeTestresults=new ArrayList<TestCases>();	
		
		//After Method to write test results:
		@AfterSuite
		public void TearDown() throws IOException, ParserConfigurationException {					
			//testResultXmlUtility.Wr‰iteTestResultToXml("VSO10871_USERSTAB_TC13_RESULTS_Admin_Is_AbleToCreate_A_UserAsLockedOut.html", writeTestresults);//write the test result to xml file with file name TestResult
			new HtmlResultsWriter().writeTestResults(this.getClass().getName() + ".html", writeTestresults);
			//Driver.quit();
		}
	
		
}