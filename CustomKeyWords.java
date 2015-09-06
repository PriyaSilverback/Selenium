//////////////////////////////////////////////////////////////
//////// My custom Keyword Functions                     ////
////////////////////////////////////////////////////////////

package Utilities;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.*;

public class CustomKeyWords {
	//static WebDriver driver;
	
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////BROWSERS//////////////////////////////////

	// 1. OPEN Browser
	public static void openBrowser(WebDriver driver, String vType) {
		// purpose : Opens a browser; timeout 30s is hardcoded, if want, can
		// send as an input
		// input : browser ; output : N/A
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// 2. Navigate Browser
	public static void navigateBrowser(WebDriver driver, String Data) {
		// purpose : Navigates a browser; timeout
		// input : browser ; output : N/A
		// driver.get(Data);
		driver.navigate().to(Data);
	}

	// 3. Close Browser
	public static void closeBrowser() {
		WebDriver driver;
		driver = new FirefoxDriver();
		// purpose : closes a browser
		// input : browser ; output : N/A
		driver.close();
	}

	// 4. Quit browser
	public static void quitBrowser() {
		WebDriver driver;
		driver = new FirefoxDriver();
		// purpose : closes a browser
		// input : browser ; output : N/A
			driver.quit();
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// //////////CLICK's/////////////////////////////////////
	// 1. click a link
	public static void linkClick(WebDriver driver, String Text) {
		// purpose : Click on a link specified
		// input :link text ; output : N/A
		driver.findElement(By.linkText(Text)).click();
	}

	// 2. click css element
	public static void clickElementbycss(WebDriver driver, String xPath) { // B'coz im going to
															// get an o/p, I
															// changed void to
															// String to return
															// the data
		// Purpose: Click any element on the AUT
		// input: driver, xPath; output: NIl

		driver.findElement(By.cssSelector(xPath)).click(); // sometimes click
															// may not work, so
															// I write a code to
															// send enter
		// driver.findElement(By.cssSelector("img[alt='Tag']")).click();
	} //

	// 3. click element
	public static void clickElement(WebDriver driver,String xPath) { // B'coz im going to get an
													// o/p, I changed void to
													// String to return the data
		// Purpose: Click any element on the AUT
		// input: driver, xPath ; output: NIl

		driver.findElement(By.xpath(xPath)).click(); // sometimes click may not
														// work, so I write a
														// code to send enter

		// driver.findElement(By.xpath(xPath)).sendKeys("\n"); //\n is enter key
	}

	// 4. Doubleclick Action
	public static void doubleclick(WebDriver driver, String xPath) {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(xPath))).doubleClick().build().perform();
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// /////////////////READ/ENTER/GET////////////////////
	// 1. Read
	public static String readText(WebDriver driver, String xPath) { // B'coz im going to get an
													// o/p, I changed void to
													// String to return the data
		// Purpose: read text from any field.
		// input: driver, xPath; Output : Data
		return driver.findElement(By.xpath(xPath)).getText(); // returns
																// whatever
																// comes here
	}

	// 2.Enter text
	public static void enterText(WebDriver driver, String xPath, String Data) {
		// Purpose: Enter text into a edit field
		// input: xPath, Data ; Output : Nil
		driver.findElement(By.xpath(xPath)).clear();// some applications already
													// have a default values in
													// edit field, so this line
													// is to clear the default
													// path
		driver.findElement(By.xpath(xPath)).sendKeys(Data);

	}

	// 3. Get list of elements from a dynamic page
	public static void getlist(WebDriver driver, String xpathwithouttag) {

		List<WebElement> allElements = driver.findElements(By.xpath(xpathwithouttag));

		for (WebElement element : allElements) {
			System.out.println(element.getText());
		}
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// //////////////VERIFY//////////////////////////////////////////
	// 1. verify Title
	public static String verifyTitle(WebDriver driver, String vTitle) {
		// Purpose: verify title of the page
		// input: Title ; Output : Nil
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (vTitle.equalsIgnoreCase(driver.getTitle())) { // getTitle is a
															// method to get
															// title, no xpath
															// required

			return "pass";

		} else {
			return "Fail";
		}
	}

	// 2. verify Text
	public static String verifyText(WebDriver driver, String xPath, String vText) {
		// Purpose:Verify Text
		// input: xPath, Data ; Output : Nil
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String appText = driver.findElement(By.xpath(xPath)).getText();
		if (vText.equalsIgnoreCase(appText)){ // returns whatever comes here

			return "Pass";

		} else {
			return "Fail, Text returned does not match expected" + appText;
		}
	}
	// 2. verify Text
		public static String verifyTextByid(WebDriver driver, String vid, String vText) {
			// Purpose:Verify Text
			// input: xPath, Data ; Output : Nil
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String appText = driver.findElement(By.id(vid)).getText();
			if (vText.equalsIgnoreCase(appText)){ // returns whatever comes here

				return "Pass";

			} else {
				return "Fail, Text returned does not match expected" + appText;
			}
		}

	// 3. verify Title linktext
	public static String verifyLinkText(WebDriver driver, String lText, String vText) {
		// Purpose: Enter text into a edit field
		// input: xPath, Data; Output : Nil
		if (vText.equalsIgnoreCase(driver.findElement(By.linkText(lText)).getText())) { // returns whatever comes here

			return "pass";

		} else {
			return "Fail" ;//, the expected value does not match the actual";
		}
	}

	// 4. Verify css element
	public static String verifyElementbycss(WebDriver driver, String xPath, String vText) {
		// Purpose: Enter text into a edit field
		// input: xPath, Data ; Output : Nil
		if (vText.equalsIgnoreCase(driver.findElement(By.cssSelector(xPath)).getText())) { // returns whatever comes here

			return "pass";

		} else {
			return "Fail";
		}
	}

	// 5. Verify Element
	public static String verifyElement(WebDriver driver, String xPath, String vText) {
		// Purpose: Enter text into a edit field
		// input: xPath, Data ; Output : Nil

		if (vText.equalsIgnoreCase(driver.findElement(By.xpath(xPath))
				.getText())) { // returns whatever comes here

			return "pass";

		} else {
			return "Fail";
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////// CHECKBOX's////////////////////////////////////////

	// 1. Checks a checkbox
	public static void checkBox(WebDriver driver, String xPath) { // this has to be checked.
		// Purpose: checks a checkbox
		// i/p: driver, xPath
		// o/p: NIl

		// Is it checked?
		if (driver.findElement(By.xpath(xPath)).isSelected()) {
			// then click

			System.out.println("checked");
		} else {
			driver.findElement(By.xpath(xPath)).click();
			System.out.println("Now checked");

		}
	}
	public static String verifyCheckBox(WebDriver driver, String xPath) { // this has to be checked.
		// Purpose: checks a checkbox
		// i/p: driver, xPath
		// o/p: NIl

		// Is it checked?
		if (driver.findElement(By.xpath(xPath)).isSelected()) {
			// then click

			return "Pass";
		} else {
			
			return "Fail";

		}
		
	}
	
	public static String verifyUnCheckBox(WebDriver driver, String xPath) { // this has to be checked.
		// Purpose: checks a checkbox
		// i/p: driver, xPath
		// o/p: NIl

		// Is it checked?
		if (driver.findElement(By.xpath(xPath)).isSelected()) {
			// then click

			return "Pass";
		} else {
			
			return "Fail";

		}
		
	}
	
	

	// 2. Unchecks a checkbox
	public static void uncheckBox(WebDriver driver, String xPath) { // this has to be checked.
		// Purpose: unchecks a checkbox
		// i/p: driver, xPath
		// o/p: NIl

		// Is it checked?
		if (driver.findElement(By.xpath(xPath)).isSelected()) {
			// then click to uncheck
			driver.findElement(By.xpath(xPath)).click();
			System.out.println("unchecked");
		} else {

			System.out.println("Already unchecked");

		}
	}

	// 3. verifies whether a checkbox is checked or not
	public static String verify_checkBoxchecked(WebDriver driver, String xPath) { // this has to
																// be checked.
		// Purpose: checks a checkbox
		// i/p: driver, xPath
		// o/p: NIl

		if (driver.findElement(By.xpath(xPath)).isSelected()) {

			return "Pass";

		} else {
			return "Fail";

		}
	}

	// 4. Verify if the checkbox is present
	public static String verify_checkBoxpresent(WebDriver driver, String xPath) { // this has to
																// be checked.
		// Purpose: checks a checkbox
		// i/p: driver, xPath
		// o/p: NIl

		// Is it checked?

		if (driver.findElement(By.xpath(xPath)).isDisplayed()) {
			// then click

			return "Pass";

		} else {
			return "Fail";

		}
	}

	// 5. Verifies unchecked checkbox
	public static String verify_uncheckBox(WebDriver driver, String xPath) { // this has to be checked.
			if (driver.findElement(By.xpath(xPath)).isSelected()) {
			return "Fail";

		} else {
			return "Pass";

		}
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String defaultvaluelist(WebDriver driver, String xPath, String Data) {
		// Purpose : Verifies the default value

		String Appvalue = driver.findElement(By.xpath(xPath)).getText();

		if (Data.equalsIgnoreCase(Appvalue)) {
			return "Pass"; //Default Value in the dropdown list is
		} else {

			// return "Fail: The Default value is incorrect";
			return "Fail";

		}

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static String validationErrors(WebDriver driver, String xPath, String Validationtext) {

		String AppError = driver.findElement(By.xpath(xPath)).getText();
		System.out.println("validation error text from xpath is " + AppError);

		if (Validationtext.equalsIgnoreCase(AppError)) {
			return "pass";
		} else {
			return "fail";
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////Elements Present/Visible/Not
	// visible/////////////////////////////////////
	// 1. Element present
	public static String element_present(WebDriver driver, String fxPath) {
		try {
			WebElement Element = driver.findElement(By.xpath(fxPath));
			System.out.println("element present from console is " + Element);

			if (Element.isDisplayed()) {
				return "Pass";
			} else {
				return "Fail";
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found");
			System.out.println("Error is " + e);
			return "Fail";
		}
	}

	public static String element_present1(WebDriver driver, String fxPath) {
	
			WebElement Element = driver.findElement(By.xpath(fxPath));
			System.out.println("element present from console is " + Element);

			if (Element.isDisplayed()) {
				return "Pass";
			} else {
				return "Fail";
			}
		
	}
	// 2. Element Not Present
	public static String element_Notpresent(WebDriver driver, String fxPath) {
		try {
			WebElement Element = driver.findElement(By.xpath(fxPath));
			System.out.println("element present from console is " + Element);

			if (Element.isDisplayed()) {
				return "Fail";
			} else {
				return "Pass";
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found");
			System.out.println("Error is " + e);
			return "Pass";
		}
	}

	// 3.Method to check if an element is visible =1 ; invisible = 0;  //input[@name='__RequestVerificationToken']
	public static String invisibleElement(WebDriver driver, String xPath) {

		if (driver.findElements(By.xpath(xPath)).size() != 0) {
			return "Fail" ; //+ "Element is Present";
		} else {
			return "Pass";
		}
	}
	
	// 4.Method to check if an element is visible by css or no. 1 if element present,
	// else zero
	public static String invisibleElementbyCSS(WebDriver driver, String csspath) {

		if (driver.findElements(By.cssSelector(csspath)).size() != 0) {
			return "Fail" ; //+ "Element is Present";
		} else {
			return "Pass";
		}
	}

	
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void uploadFile(WebDriver driver, String fid, String filepath) {

		WebElement El = driver.findElement(By.id(fid));
		El.sendKeys(filepath);

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ////Select//////
	// 1. Select list from a drop down
	public static void selectList(WebDriver driver, String xPath, String Data) {
		// Purpose: Select from a drop down list
		// i/p: driver, xPath, Data
		// o/p: NIl

		Select myList = new Select(driver.findElement(By.xpath(xPath)));// creating
																		// memory
																		// in
																		// myList
		myList.selectByVisibleText(Data);
		myList = null; // clears the memory in my list

	}

	// 2.. Select List by ID
	public static void selectListbyid(WebDriver driver, String xPath, String Data) {
		// Purpose: Select from a drop down list
		// i/p: driver, xPath, Data
		// o/p: NIl

		Select myList = new Select(driver.findElement(By.id(xPath)));// creating
																		// memory
																		// in
																		// myList
		myList.selectByVisibleText(Data);
		myList = null; // clears the memory in my list

	}

	public static void selectListbyname(WebDriver driver, String name, String Data) {
		// Purpose: Select from a drop down list
		// i/p: driver, xPath, Data
		// o/p: NIl

		Select myList = new Select(driver.findElement(By.name(name)));// creating
																		// memory
																		// in
																		// myList
		myList.selectByVisibleText(Data);
		myList = null; // clears the memory in my list

	}

	// 3. Gives the total elements from the downdown list
	public static void list_select_value(WebDriver driver, String xpath,String Data) {
		// Purpose : Gives the total elements in the drop down list

		WebElement myValue = driver.findElement(By.xpath(xpath));
		java.util.List<WebElement> myL = myValue.findElements(By.tagName("option")); 																					
		// The above line will list all the elements
		System.out.println("size of items in drop down is" + myL.size());
		for (int i = 0; i < myL.size(); i++) {
			System.out.println("Value in the item" + i + "is"+ myL.get(i).getText());
			if (myL.get(i).getText().equalsIgnoreCase(Data)) {
				myL.get(i).click();
			}
		}

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// ///////////WAITS//////////////////
	// 1. Waits for a certain time
	public static void waitTime(long lTime) throws Exception {
		// Purpose: it will wait for a certain amount of time.
		// i/p: time in milli seconds
		// o/p: NIl

		Thread.sleep(lTime);

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///ALERT BOXES////
	// 1. Accept alert box
	public static void alertBoxaccept(WebDriver driver) {
		Alert myAlert = driver.switchTo().alert();
		myAlert.accept();
	}

	// 2. Dismiss Alert box
	public static void alertBoxdismiss(WebDriver driver) {
		Alert myAlert = driver.switchTo().alert();
		myAlert.dismiss();
	}

	// 3. Method: To verify text from an alert box
	public static String closeAlertAndGetItsText(WebDriver driver, String txt) {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
	
	
	 public static String isAlertPresent(WebDriver driver, String Txt) {
	        Alert myAlert = driver.switchTo().alert();
	        	String alertText = myAlert.getText();
	            if(alertText.equalsIgnoreCase(Txt)) {
	            return "Pass";
	            //return alertText;
	        } else {
	            // Modal dialog showed
	            //return "Alert was not present";
	        	return "Fail";
	        }
	    }

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// ///Keyboard keys
	// 1. Enter Key
	public static void Keyboardenterkey(WebDriver driver, String Path) {
		driver.findElement(By.xpath(Path)).sendKeys(Keys.ENTER);
	}

	// 2. Return (same as enter while some apps accept return instead of enter
	// from the keyboard

	public static void Keyboardenterkey2(WebDriver driver, String Path) {
		driver.findElement(By.xpath(Path)).sendKeys(Keys.RETURN);
	}
	
	public static void Keyboardscrolldown(WebDriver driver, String Path) {
		driver.findElement(By.xpath(Path)).sendKeys(Keys.ARROW_DOWN);
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// /////////Flexigrid size////////////
	public static String flexigridempty(WebDriver driver, String xPath) {
		int size = driver.findElements(By.xpath(xPath)).size();// The above line will return 0 if there is no rows else it will return the number of rows present

		if (size > 0) {
			return "Fail" + "Flexigrid is not empty";
		} else {
			return "Pass" + "Flexigrid is empty";
		}
	}

	/////// split a value from a number
	

	public String getNumber(String fPrice) {
		// IT should strip the $ sign, the , sign and the end * out of the number and return just the number
		// Ex $10,998* should return 10998
		String[] f1 = fPrice.split("\\$");
		
		String f2 = f1[1]; // We are taking off the second item.
		
		String[] f3 = f2.split(",");
		
		String f4 = f3[0] + f3[1];
		
		String[] f5 = f4.split("\\*");
		
		// System.out.println("Value of the number is " + f5[0]);
		
		return f5[0];
	}

	
	//////////////////////////////SORT/////////////////////////////////////////////
	
	public String myAscending(int[] f1){
		// Returns Pass if the array is in ascending order. Else Fail
		
		int ascLen = f1.length;
		String status = "Sort Pass"; // Default assumption is it is sorted ascending. Hence pass.
		
		
		for (int i=0;i<f1.length-1; i++) {
			if (f1[i]<=f1[i+1]) {
				System.out.println("True for : " + i);
				System.out.println(f1[i] + " ----- " + f1[i+1]);
			} else {
				status = "Sort Fail";
				System.out.println("False for : " + i);
				System.out.println(f1[i] + " ----- " + f1[i+1]);
				return status; 
			}
		}
		
		return "Sort Pass";
	}
}