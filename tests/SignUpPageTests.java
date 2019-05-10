package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import code.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.SignUpPage;
import pages.StartUpPage;

public class SignUpPageTests extends BaseTest{
	
	private AppiumDriver<MobileElement> driver;
	private StartUpPage startUpPage;
	private SignUpPage signUpPage;
	
	public SignUpPageTests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	// create IOS driver session
	public void setUp() throws Exception {
		driver = createAndroidDriver();		
		startUpPage = new StartUpPage(driver);
		signUpPage = startUpPage.clickSignUp();
	}

	@Parameters({"usr", "pwd", "fName", "lName", "error"})
	@Test
	public void ClickSignUpBtn(String usr, String pwd, String fName, String lName, String errorMsg){
		//Assert.assertTrue(signUpPage.verifyLoads(), "[ERROR]  did not match with expected value");
		Assert.assertTrue(signUpPage.doSignUp(usr, pwd, fName, lName), "[ERROR]  did not match with expected value");
		//Assert.assertTrue(signUpPage.validateSignUpErrorMsg(errorMsg), "[ERROR]  did not match with expected value");
	}
	
	  @AfterMethod
	  // deleting driver session created
	  public void deleteDriver() {
		  destroyDriver(driver);
	  }

}
