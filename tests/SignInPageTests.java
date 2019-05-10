package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import code.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.SignInPage;
import pages.StartUpPage;

public class SignInPageTests extends BaseTest {
	
	private AppiumDriver<MobileElement> driver;
	private StartUpPage startUpPage;
	private SignInPage signInPage;
	
	public SignInPageTests() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	// create IOS driver session
	public void setUp() throws Exception {
		driver = createAndroidDriver();		
		startUpPage = new StartUpPage(driver);
		signInPage = startUpPage.clickSignIn();
	}

		
	@Parameters({"usr", "pwd"})
	@Test
	public void ClickSignInBtn(String usr, String pwd) throws InterruptedException{
		//Assert.assertTrue(signInPage.verifyLoads(), "[ERROR]  did not match with expected value");
		Assert.assertTrue(signInPage.doSignIn(usr, pwd), "[ERROR]  did not match with expected value");
	}
	
	  @AfterMethod
	  // deleting driver session created
	  public void deleteDriver() {
		  destroyDriver(driver);
	  }

}