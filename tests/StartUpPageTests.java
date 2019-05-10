package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import code.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.StartUpPage;

public class StartUpPageTests extends BaseTest{
	
	private AppiumDriver<MobileElement> driver;
	private StartUpPage startUpPage;
	
	@BeforeMethod
	// create IOS driver session
	public void setUp() throws Exception {
		driver = createAndroidDriver();		
		startUpPage = new StartUpPage(driver);
	}

	@Test //(invocationCount = 3) run same test multiple times
	public void ValidateStartUpPage() throws InterruptedException{
		Assert.assertTrue(startUpPage.verifyLoads(), "[ERROR]  StartUp Page was not verified");
	}

	  @AfterMethod
	  // deleting driver session created
	  public void deleteDriver() {
		  destroyDriver(driver);
	  }
	
}