package PageObjects.IOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import utils.AndroidActions;
import utils.IOSActions;

public class AlertViews extends IOSActions{
	IOSDriver driver;
	public AlertViews(IOSDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITBy(iOSClassChain="**/XCUIElementTypeStaticText[`label='Text Entry'`]")
	private WebElement textEntryOption;
	@iOSXCUITBy(iOSClassChain="**/XCUIElementTypeCell")
	private WebElement alertTextBox;
	@iOSXCUITBy(accessibility="OK")
	private WebElement acceptPopup;
	@iOSXCUITBy(iOSNsPredicate="type=='XCUIElementTypeStaticText' AND value BEGINSWITH[C] `Confirm`")
	private WebElement confirmMenuItem;
	@iOSXCUITBy(iOSNsPredicate="label=='Confirm'")
	private WebElement submit;
	@iOSXCUITBy(xpath="//*[contains(@name,'message')]")
	private WebElement messageText;
	@iOSXCUITBy(accessibility="Confirm")
	private WebElement confirm;
	
public void filltextEntryPopup(String text)
{
	textEntryOption.click();
	alertTextBox.sendKeys(text);
	acceptPopup.click();
	
}
public String getConfirmMessageText()
{
	confirmMenuItem.click();
	return messageText.getText();
	
	
}
public void closeConfirmMessage()
{
	
	confirm.click();
	
}
}
