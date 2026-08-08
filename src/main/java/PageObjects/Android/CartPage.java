package PageObjects.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class CartPage extends AndroidActions{
	AndroidDriver driver;
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Cart\"]")
	private WebElement Cart;
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]")
	private List<WebElement> productPrizes;
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalProductPrize;
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement btnTermsAndConditions;
	@AndroidFindBy(id="android:id/button1")
	private WebElement closeTermsAndConditions;
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkbox;
	@AndroidFindBy(className="android.widget.Button")
	private WebElement btnVisitWebsiteforPurchase;
public void waitForvisibilityOfCart()
{
	waitForvisibilityOfElement(Cart);
}


public Double addAllProductAmount() throws InterruptedException
{
	Double sum = 0.0;
int prodCount=productPrizes.size();
for (int i = 0; i < prodCount; i++) {
	String prize = productPrizes.get(i).getText().substring(1);
	Double amount=Double.parseDouble(prize);
	sum+=amount;
}
return sum;
}
public Double totalProductAmount()
{
	String totalAmount=totalProductPrize.getText().substring(1).trim();
	Double totAmount=getFormattedDoubleAmount(totalAmount);
	return totAmount;
}
public void acceptTermsAndConditions()
{

	longPress(btnTermsAndConditions);
	closeTermsAndConditions.click();
}
public void selectEmailCheckbox()
{
	checkbox.click();
}
public void visitWebsiteforPurchase() throws InterruptedException
{
	btnVisitWebsiteforPurchase.click();
	Thread.sleep(10000);
}
}
