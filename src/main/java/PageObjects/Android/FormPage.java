package PageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FormPage extends AndroidActions{
	AndroidDriver driver;
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement name;
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
	private WebElement femalegender;
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]")
	private WebElement malegender;
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryOption;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	@AndroidFindBy(xpath="//android.widget.Toast[@text=\"Please enter your name\"]")
	private WebElement toastErrorMessage;
	
public void setNameField(String username)
{
	name.sendKeys(username);
	driver.hideKeyboard();
}
public void setGender(String gender)
{
	if(gender.contains("female"))
		femalegender.click();
	else
		malegender.click();
}

public void waitforVisibilityOfFormPage() {
    waitForvisibilityOfElement(name);
}

public String validateErrorMessage()
{
	return toastErrorMessage.getAttribute("name");
	}
public void setCountry(String countryName)
{
	countryOption.click();
	scrollToElement(countryName);
    driver.findElement(By.xpath("//android.widget.TextView[@text=\""+countryName+"\"]")).click();

}
public void selectShop()
{
	shopButton.click();
}
}
