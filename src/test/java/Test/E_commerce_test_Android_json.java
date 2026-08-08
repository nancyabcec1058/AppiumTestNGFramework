package Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
import utils.jsonReader;

public class E_commerce_test_Android_json extends AndroidBaseTest {
//cd C:\Users\nancy\AppData\Local\Android\Sdk\platform-tools** and give **adb install C:\Users\nancy\Downloads\APKFiles\resources\General-Store.apk

	@BeforeMethod(alwaysRun = true)
	public void preSetup() {

		driver.terminateApp("com.androidsample.generalstore");
        driver.activateApp("com.androidsample.generalstore");

		FormPage formPage = new FormPage(driver);
		formPage.waitforVisibilityOfFormPage();
	}

	@Test(dataProvider = "getData", groups = { "Smoke" })
	public void fillForm(HashMap<String, String> input) {
		FormPage formPage = new FormPage(driver);
		ProductCataloguePage product = new ProductCataloguePage(driver);
		CartPage cartPage = new CartPage(driver);
		formPage.waitforVisibilityOfFormPage();

		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountry(input.get("country"));
		formPage.selectShop();

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		jsonReader utils = new jsonReader();

		List<HashMap<String, String>> data = utils.getJsonData(
				"C:\\Users\\nancy\\eclipse-workspace\\AppiumTestNGFramework\\src\\test\\java\\TestData\\eCommerce.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
