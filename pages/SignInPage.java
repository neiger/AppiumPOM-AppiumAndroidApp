package pages;




import org.openqa.selenium.support.PageFactory;

import code.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SignInPage extends BasePage{

	public SignInPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// ################################

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign in']")
	private MobileElement qAppText;
	
	@AndroidFindBy(className="android.widget.ImageView")
	private MobileElement qAppIcon;
	
	
	/*Sign In fields*/
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'log_in_email')]")
	private MobileElement emailTxt;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'log_in_password')]")
	private MobileElement pwdTxt;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'log_in_button_login') and @text='SIGN IN WITH EMAIL']")
	private MobileElement signInEmailBtn;
	
	/* Failed sign in message */
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'message')]")
	private MobileElement errorMsg;
	

	// ######### METHODS #######################

	
	public boolean verifyLoads() throws InterruptedException{
		return waitForElementToBeVisible(qAppText) && waitForElementToBeVisible(qAppIcon) && waitForElementToBeVisible(emailTxt) && 
				waitForElementToBeVisible(pwdTxt) && waitForElementToBeVisible(signInEmailBtn);
	}
	
	public boolean doSignIn(String usr, String pwd) {
		return sendKeys(emailTxt, usr) && sendKeys(pwdTxt, pwd) && clickElement(signInEmailBtn);
	}
	
	public boolean verifyLoginErrorMsg(String error) throws InterruptedException {
		//wait(60000);
		return compareTextElementByText(errorMsg, error);
	}
	
}