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

public class HomePage extends IOSActions{
	IOSDriver driver;
	public HomePage(IOSDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITBy(accessibility="Alert Views")
	private WebElement alertViewsOption;
	
	
public void selectAlertViews()
{
	alertViewsOption.click();
}

}
