package code;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	public BaseTest() {
		// TODO Auto-generated constructor stub
	}
	
	//@Parameters({"platformName", "platformVersion", "deviceName", "automationName", "app", "noReset", "url"})
	//String platformName, String platformVersion, String deviceName, String automationName, String app, String noReset, String url
	public AppiumDriver<MobileElement> createMobileDriver() {
		try {
		AppiumDriver<MobileElement> driver;
		
		DesiredCapabilities capability = new DesiredCapabilities();
		
		// Android	
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9"); 
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		//capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capability.setCapability(MobileCapabilityType.APP, "/Users/neiger/Desktop/workspace/qamad.apk");
		capability.setCapability(MobileCapabilityType.NO_RESET, false);
		
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		
		return driver; 
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean destroyDriver(AppiumDriver<MobileElement> driver) {
		try {
		driver.quit();
		return true;
		} catch (Exception e){
			return false;
		}
	}
}