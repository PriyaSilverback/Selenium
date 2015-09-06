package Utilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;


public class TestDataInputs {

	
	//Browsers:
	public static WebDriver driver = new FirefoxDriver();	
	
	//QA Urls:	
	public static String  Console_Url = " https://qa.silverbackmdm.com/admin";
	public static String  qa_ssp = " https://qa.silverbackmdm.com/ssp";
	public static String  qa = " https://qa.silverbackmdm.com";
	public static String  qa_loginUsername = "admin";
	public static String  qa_loginPswd = "S1lverb@ck";
	public static String qaEmail = "Silverbackuser@gmail.com";
	public static String qaPswd = "S1lverb@ck";
	
	//Inputs to Android and SAFE devices: 
	public static String  Console_Activate_Url = "https://qa.silverbackmdm.com/activate";
	
	//AD Users:
	public static String  AD_User1 = "sb1@silverback.com";
	public static String  AD_User1Pswd = "S1lverb@ck";
	
	public static String  AD_User2 = "sb2@silverback.com";
	public static String  AD_User2Pswd = "S1lverb@ck";
	
	public static String  AD_User3 = "sb3@silverback.com";
	public static String  AD_User3Pswd = "S1lverb@ck";
	
	public static String  AD_User4 = "sb4@silverback.com";
	public static String  AD_User4Pswd = "S1lverb@ck";
	
	public static String  AD_User5 = "sb5@silverback.com";
	public static String  AD_User5Pswd = "S1lverb@ck";

	
	
	//Wait:	
	
	
	public WebDriverWait ExplicitWait = new WebDriverWait(driver, 10);
	
// Log in to Admin console:
	public static void login_To_QA_AdminConsole_AsAdmin ()
	{
		
		driver.get(Console_Url);
		driver.findElement(By.id("Username")).sendKeys(qa_loginUsername);
		driver.findElement(By.id("Password")).sendKeys(qa_loginPswd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	//Create Local Users	
	public static void create_A_Local_User(String vlocalUsername, String vlocaluserPassword, String emailLocaluser) throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='/admin/Users']")).click(); 		//Clicks USERS Tab	
		driver.findElement(By.xpath("//input[@type='button']")).click(); 		// Click 'New Device User'
		driver.findElement(By.id("Username")).sendKeys(vlocalUsername);  
		Thread.sleep(1000);
		driver.findElement(By.id("Username")).sendKeys(Keys.TAB);				// Populate Username field
		Thread.sleep(1000);
		driver.findElement(By.id("FirstName")).sendKeys("Unique"); 				// Populate FirstName field		
		driver.findElement(By.id("LastName")).sendKeys("User"); 	  			// Populate LastName field
		driver.findElement(By.id("EmailAddress")).sendKeys(emailLocaluser); 	// Populate Email Address field		
		driver.findElement(By.id("Password")).sendKeys(vlocaluserPassword); 		
		driver.findElement(By.id("ConfirmPassword")).sendKeys(vlocaluserPassword); 			
		driver.findElement(By.id("saveButton")).click();						// Click Save					
	}

	
	//Create Local Users	
	public static void create_A_Local_UserWithEmailChecked(String vlocalUsername, String vlocaluserPassword, String emailLocaluser) throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='/admin/Users']")).click(); 		//Clicks USERS Tab	
		driver.findElement(By.xpath("//input[@type='button']")).click(); 		// Click 'New Device User'
		driver.findElement(By.id("Username")).sendKeys(vlocalUsername);  
		Thread.sleep(1000);
		driver.findElement(By.id("Username")).sendKeys(Keys.TAB);				// Populate Username field
		Thread.sleep(1000);
		driver.findElement(By.id("FirstName")).sendKeys("Unique"); 				// Populate FirstName field		
		driver.findElement(By.id("LastName")).sendKeys("User"); 	  			// Populate LastName field
		driver.findElement(By.id("EmailAddress")).sendKeys(emailLocaluser); 	// Populate Email Address field		
		driver.findElement(By.id("Password")).sendKeys(vlocaluserPassword); 		
		driver.findElement(By.id("ConfirmPassword")).sendKeys(vlocaluserPassword); 	
		driver.findElement(By.id("//input[@id='EmailUserDetails']")).click();
		driver.findElement(By.id("saveButton")).click();						// Click Save					
	}

	
	//WriteTestData:
	public List<TestCases> writeTestresults=new ArrayList<TestCases>();	
	
	//After Method to write test results:
	@AfterSuite
	public void TearDown() throws IOException, ParserConfigurationException {					
		//testResultXmlUtility.Wr‰iteTestResultToXml("VSO10871_USERSTAB_TC13_RESULTS_Admin_Is_AbleToCreate_A_UserAsLockedOut.html", writeTestresults);//write the test result to xml file with file name TestResult
		new HtmlResultsWriter().writeTestResults(this.getClass().getName() + ".html", writeTestresults);
		driver.quit();
	}
}
