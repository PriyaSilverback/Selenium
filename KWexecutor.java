
//////////////////////////////////////////////////////////////
//////// My Keywords from the Excel                   ////
////////////////////////////////////////////////////////////


package Utilities;
import org.openqa.selenium.WebDriver;


public class KWexecutor {
	public static String vKW;
	public static String vxPath;
	public static String vData;
	public static String vBrowser;
	static WebDriver driver;
	public static String vVerifyError;

	
	
	public static String call_KW() throws Exception {
		
		
		vVerifyError = "NA"; //This is declared to capture any errors from the verify text KW's
		//Call the corresponding Keyword function
		
		if (vKW.equalsIgnoreCase("openBrowser")){
			Utilities.CustomKeyWords.openBrowser(driver, vData);
		}
		if (vKW.equalsIgnoreCase("quitBrowser")){
			Utilities.CustomKeyWords.quitBrowser();
		}
		if (vKW.equalsIgnoreCase("closeBrowser")){
			Utilities.CustomKeyWords.closeBrowser();
		}
		
		if (vKW.equalsIgnoreCase("navigateBrowser")){
			Utilities.CustomKeyWords.navigateBrowser(driver, vData);
		}
		if(vKW.equalsIgnoreCase("clickElement")){
			Utilities.CustomKeyWords.clickElement(driver, vxPath);
			
		}
		
		if (vKW.equalsIgnoreCase("enterText")) {
			Utilities.CustomKeyWords.enterText(driver, vxPath, vData);
		}
		if (vKW.equalsIgnoreCase("verifyText")){
			vVerifyError = Utilities.CustomKeyWords.verifyText(driver, vxPath, vData);
			System.out.println("Test is a " + vVerifyError );
		}
		if (vKW.equalsIgnoreCase("verifyElement")){
			vVerifyError = Utilities.CustomKeyWords.verifyElement(driver, vxPath, vData);
			System.out.println("Test is a " + vVerifyError );
		}
		
		if (vKW.equalsIgnoreCase("verifyTitle")){
			vVerifyError = Utilities.CustomKeyWords.verifyTitle(driver, vData);
			System.out.println("Test is a " + vVerifyError );
		}
		
		if (vKW.equalsIgnoreCase("verifyLinkText")){
			vVerifyError = Utilities.CustomKeyWords.verifyLinkText(driver, vxPath, vData);
			System.out.println("Test is a " + vVerifyError );
		}
		
		if (vKW.equalsIgnoreCase("defaultvaluelist")){
			vVerifyError = Utilities.CustomKeyWords.defaultvaluelist(driver, vxPath, vData);
			System.out.println("Test is a " + vVerifyError );
		}
		
		
		if (vKW.equalsIgnoreCase("flexigridempty")){
			vVerifyError = Utilities.CustomKeyWords.flexigridempty(driver, vxPath);
			System.out.println("Test is a " + vVerifyError );
		}
		
		if (vKW.equalsIgnoreCase("validationErrors")){

			vVerifyError = Utilities.CustomKeyWords.validationErrors(driver, vxPath, vData) ;
			System.out.println("Validation errors on the console did not match the expected results " + vVerifyError);
			}
		
		if (vKW.equalsIgnoreCase("Keyboardenterkey")){
			Utilities.CustomKeyWords.Keyboardenterkey(driver, vxPath);					
		}
		if (vKW.equalsIgnoreCase("Keyboardenterkey2")){
			Utilities.CustomKeyWords.Keyboardenterkey2(driver, vxPath);					
		}
		

		if (vKW.equalsIgnoreCase("readText")){
			Utilities.CustomKeyWords.readText(driver, vxPath);					
		}				
		if (vKW.equalsIgnoreCase("selectList")){
			Utilities.CustomKeyWords.selectList(driver, vxPath, vData);
		}
		if (vKW.equalsIgnoreCase("selectListbyid")){
			Utilities.CustomKeyWords.selectListbyid(driver, vxPath, vData);
		}
		if (vKW.equalsIgnoreCase("checkBox")){
			Utilities.CustomKeyWords.checkBox(driver, vxPath);
		}
		if (vKW.equalsIgnoreCase("uncheckBox")){
			Utilities.CustomKeyWords.uncheckBox(driver, vxPath);
		}
		if (vKW.equalsIgnoreCase("closeBrowser")){
			Utilities.CustomKeyWords.closeBrowser();
		}
					
	  if(vKW.equalsIgnoreCase("waitTime")){
		  Utilities.CustomKeyWords.waitTime(2000);
			}
	
	  if (vKW.equalsIgnoreCase("doubleclick")){
		  Utilities.CustomKeyWords.doubleclick(driver, vxPath);
			}
	  if (vKW.equalsIgnoreCase(" closeAlertAndGetItsText")){
		  Utilities.CustomKeyWords. closeAlertAndGetItsText(driver, vData);					
		}
	  if (vKW.equalsIgnoreCase("uploadFile")){
		  Utilities.CustomKeyWords.uploadFile(driver, vxPath, vData);
			}
	  
	  /*if (vKW.equals("navigate_to")){
		// Initializing my Browser that we wish to work with
		if (vBrowser.equals("IE")) {
			myD = new InternetExplorerDriver();
		}
		if (vBrowser.equals("FF")) {
			myD = new FirefoxDriver();
		}
		if (vBrowser.equals("HTML")) {
			myD = new HtmlUnitDriver();
		}
		navigate_to(myD, vIP1);
	}
			*/	  
						
	return vVerifyError;
	}

}

