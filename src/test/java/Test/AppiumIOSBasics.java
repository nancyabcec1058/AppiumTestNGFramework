package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.IOS.AlertViews;
import PageObjects.IOS.HomePage;
import TestUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
public class AppiumIOSBasics extends IOSBaseTest{
   @Test
	public void IOSBasicTest() throws MalformedURLException, FileNotFoundException, URISyntaxException  {

	   HomePage homePage=new HomePage(driver);
	   AlertViews alertViews=new AlertViews(driver);
	   homePage.selectAlertViews();
	   alertViews.filltextEntryPopup("Hello");
	   String confirmMessageText=alertViews.getConfirmMessageText();
	   Assert.assertEquals(confirmMessageText, "A message should be a short, complete sentence.");
	   alertViews.closeConfirmMessage();
		
	
		
	}
}