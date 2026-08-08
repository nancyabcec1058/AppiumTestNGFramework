package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Android.CartPage;
import PageObjects.Android.FormPage;
import PageObjects.Android.ProductCataloguePage;
import TestUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import utils.AndroidActions;

public class E_commerce_test_Android_dataParam extends AndroidBaseTest {
//cd C:\Users\nancy\AppData\Local\Android\Sdk\platform-tools** and give **adb install C:\Users\nancy\Downloads\APKFiles\resources\General-Store.apk

	
//	  @BeforeMethod public void preSetup() {
//	  
//	  AndroidActions actions=new AndroidActions(driver);
//	  actions.invokePackageActivity( "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity");
//	  }
	  @BeforeMethod(alwaysRun = true)
	    public void preSetup() {

	        driver.terminateApp("com.androidsample.generalstore");
            driver.activateApp("com.androidsample.generalstore");
            FormPage formPage = new FormPage(driver);
	        formPage.waitforVisibilityOfFormPage();
	    }
	 
	@Test(groups= {"Smoke"})
	public void validateErrorMessage() throws InterruptedException {
		FormPage formPage = new FormPage(driver);
		String message = formPage.validateErrorMessage();
		Assert.assertEquals(message, "Please enter your name");
		
	}

	@Test(dataProvider="getData")
	public void login(String name,String gender,String country) {
		FormPage formPage = new FormPage(driver);
		ProductCataloguePage product = new ProductCataloguePage(driver);
		CartPage cartPage = new CartPage(driver);
		formPage.waitforVisibilityOfFormPage();
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountry(country);
		formPage.selectShop();

	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Nandini Singh", "female", "Bhutan" }, { "Ravi Singh", "male", "Canada" } };
	}

}
