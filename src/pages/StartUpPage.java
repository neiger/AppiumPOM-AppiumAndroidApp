package pages;




import org.openqa.selenium.support.PageFactory;

import code.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class StartUpPage extends BasePage{

	public StartUpPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	// Find elements Startup Page

	@AndroidFindBy(xpath="//android.widget.TextView[@text='QApp']")
	private MobileElement qAppText;
	
	//@AndroidFindBy(id="com.avantica.qapp:id/greeting_imageView")
	@AndroidFindBy(className="android.widget.ImageView")
	private MobileElement qAppIcon;
	
	//@AndroidFindBy(id="com.avantica.qapp:id/greeting_button_log_in")
	@AndroidFindBy(xpath="//android.widget.Button[@text='SIGN IN']")
	private MobileElement signInBtn;
	
	//@AndroidFindBy(id="com.avantica.qapp:id/greeting_button_sign_up")
	@AndroidFindBy(xpath="//android.widget.Button[@text='SIGN UP']")
	private MobileElement signUpBtn;
	
	
	
	/******************Sign Up Button second screen*/
	@AndroidFindBy(id="com.avantica.qapp:id/sign_up_button_email")
	private MobileElement signUpEmailBtn;
	
	//Prompt button for contacts permissions//
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private MobileElement prompt;
	
	
	/////////////////////////////
	public boolean verifyLoads() {
		return waitForElementToBeVisible(qAppText) && waitForElementToBeVisible(qAppIcon)  && waitForElementToBeVisible(signInBtn) && waitForElementToBeVisible(signUpBtn);
	}
	
	public SignInPage clickSignInPage(){
		signInPrompt();
		return new SignInPage(driver);
	}
	
	public SignUpPage clickSignUp(){
		signUpPrompt();
		return new SignUpPage(driver);
	}
	
	// Submethods for Page constructions
	private boolean signInPrompt() {
		return clickElement(signInBtn) && clickElement(prompt);
	}
	
	private boolean signUpPrompt() {
		return clickElement(signUpBtn) && clickElement(signUpEmailBtn) && clickElement(prompt);
	}
}