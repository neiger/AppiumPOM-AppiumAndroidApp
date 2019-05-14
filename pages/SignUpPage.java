package pages;

import org.openqa.selenium.support.PageFactory;

import code.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpPage extends BasePage{

	public SignUpPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	/*Prompt button*/
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private MobileElement prompt;
	
	/******************Sign Up Button*/
	@AndroidFindBy(id="com.avantica.qapp:id/sign_up_button_email")
	private MobileElement signUpEmail;
	
	//Fill fields
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
	
	
	/******************ANOTHER PAGE CAN BE USED */////
	
	public boolean failedSignUp(String usrEmail, String usrPwd, String usrFName, String usrLName) {
		return sendKeys(email, usrEmail) && sendKeys(pwd, usrPwd) && sendKeys(fName, usrFName) && sendKeys(lName, usrLName) && clickElement(signUp);
	}
	
	public boolean validateSignUpErrorMsg(String errorMsg) {
		return verifyTextOnElement(errorMessage, errorMsg) && clickElement(okMsgBtn);
	
	}
}