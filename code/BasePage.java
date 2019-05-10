package code;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class BasePage {

	//protected WebDriver driver;
	protected AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;
	
	public BasePage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10); 
	}
	
	
	protected boolean clickElement(MobileElement element) {
		try {
			// using explicit wait to wait for element
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// method to send text
	protected boolean sendKeys(MobileElement element, String text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// method to wait for the visibility of an element
	protected boolean waitForElementToBeVisible(MobileElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// method to verify text on a certain element
	protected boolean verifyTextOnElement(MobileElement element, String text) {
		try {
			waitForElementToBeVisible(element);
			return wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver arg0)
				{
					//System.out.println(element.getText());
					return element.getText().contains(text);
				}
			});
			
		} catch (Exception e) {
			return false;
		}
	}
	
	/*// method to find an specific element
	protected MobileElement findElement(By element) {	// presenceOfElement
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e)	{
			return null;
		}
	}*/
	
	//will get any text present on a field
	protected String getTextOnField(MobileElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			String link = element.getAttribute("value"); 
			return link;
		} catch (Exception e) {
			return null;
		}
	}
	
	protected boolean isEnabled(MobileElement element) {
		try {
			return element.isEnabled();
		} catch (Exception e){
			return false;
		}
	}
	
}