package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Capabilities {

	public static AndroidDriver Use_DeviceChome_Browser_toEnroll() {		

		//Desired capabilities to run automation code on any Android and Safe devices.	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);   
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); 
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S4");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S5");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note3");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.chrome.AssetBrowserActivity");

		try {
			return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static AndroidDriver Use_DeviceChome_Browser_Note3_ToEnroll() {		

		//Desired capabilities to run automation code on any Android and Safe devices.	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);   
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); 
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note3");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.chrome.AssetBrowserActivity");

		try {
			return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static AndroidDriver Launch_HybridApp_Companion_Android() {		
		
	  	File appDir = new File("src/test/java"); //method to define a file
		File app = new File(appDir, "com.silverbackmdm.epic.companion.ss.apk");
		
	  //Desired capabilities to run automation code on any Android and Safe devices.	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);   
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); 
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S4");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S5");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note3");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
		capabilities.setCapability("noReset", true );
		capabilities.setCapability("noReset","com.silverbackmdm.epic.companion.ss.EpicSSActivity");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());					
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.silverbackmdm.epic.companion.ss.EpicSSActivity");
		
								

		try {
			return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
}
