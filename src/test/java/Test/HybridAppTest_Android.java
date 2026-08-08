package Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Android.CartPage;
import PageObjects.Android.FormPage;
import PageObjects.Android.ProductCataloguePage;
import TestUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.AndroidActions;


public class HybridAppTest_Android extends AndroidBaseTest {
	@Test
	public void AddProducttoCart() throws InterruptedException {
		FormPage formPage=new FormPage(driver);
		ProductCataloguePage product=new ProductCataloguePage(driver);
		CartPage cartPage=new CartPage(driver);
		
		formPage.setNameField("Nandini Singh");
		formPage.setGender("female");
		formPage.setCountry("Bhutan");
		formPage.selectShop();
		
		product.addProductToCartByIndex(0);
		product.addProductToCartByIndex(0);
        product.addToCart();
        
        cartPage.waitForvisibilityOfCart();
		double sumofAllProductPrize=cartPage.addAllProductAmount();
		double totalofAllProductPrize=cartPage.totalProductAmount();
		Assert.assertEquals(sumofAllProductPrize, totalofAllProductPrize);
		
		cartPage.acceptTermsAndConditions();
		cartPage.selectEmailCheckbox();
		cartPage.visitWebsiteforPurchase();

		
		
	}

}
