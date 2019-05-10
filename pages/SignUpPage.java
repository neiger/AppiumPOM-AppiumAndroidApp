package pages;

import org.openqa.selenium.support.PageFactory;

import code.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage extends BasePage{

	public SignUpPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

		
	//Fill fields Sign Up form
	@AndroidFindBy(id="com.avantica.qapp:id/sign_up_email_email")
	private MobileElement email;

	@AndroidFindBy(id="com.avantica.qapp:id/sign_up_email_password")
	private MobileElement pwd;
	
	@AndroidFindBy(id="com.avantica.qapp:id/sign_up_email_first_name")
	private MobileElement fName;
	
	@AndroidFindBy(id="com.avantica.qapp:id/sign_up_email_last_name")
	private MobileElement lName;
	
	@AndroidFindBy(id="com.avantica.qapp:id/sign_up_email_button_register")
	private MobileElement signUp;
	
	@AndroidFindBy(id="android:id/message")
	private MobileElement errorMessage;
	
	@AndroidFindBy(id="android:id/button1")
	private MobileElement okMsgBtn;
	

	/******************Methods*/////
	
	
	public boolean verifyLoads() {
		return waitForElementToBeVisible(email) && waitForElementToBeVisible(pwd) && waitForElementToBeVisible(fName) && waitForElementToBeVisible(lName);
	}
	
	public boolean doSignUp(String usrEmail, String usrPwd, String usrFName, String usrLName) {
		return sendKeys(email, usrEmail) && sendKeys(pwd, usrPwd) && sendKeys(fName, usrFName) && sendKeys(lName, usrLName) && clickElement(signUp);
	}
	
	public boolean validateSignUpErrorMsg(String errorMsg) {
		return verifyTextOnElement(errorMessage, errorMsg) && clickElement(okMsgBtn);
	}
}