package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSActions {
	IOSDriver driver;
	public IOSActions(IOSDriver driver)
	{
		this.driver=driver;
	}



	public void longPress(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: touchAndHold", 
				ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),"duration",3.0));
	}
	public void scrollToElement(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript(
	        "mobile: scroll",
	        ImmutableMap.of(
	            "elementId", ((RemoteWebElement) element).getId(),
	            "direction", "down",
	            "toVisible", true
	        )
	    );
	}
	public void flingGestureAction(String direction,int speed)
	{
		((JavascriptExecutor) driver).executeScript(
		        "mobile: flingGesture",
		        ImmutableMap.of(
		            "left", 100,
		            "top", 300,
		            "width", 800,
		            "height", 1800,
		            "direction", direction,
		            "speed", speed
		        )
		    );
	}
	public void pinchOpenGestureAction(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 0.75
			));
	}
	public void pinchCloseGestureAction(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 0.75
			));
	}
	public void swipeAction(WebElement element,String direction)
	{

		((JavascriptExecutor)driver).executeScript("mobile: swipe", 
				ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),
			    "direction", direction,
			    "percent", 0.2
			));
	}
	public void dragandDropAction(WebElement source,int endX,int endY)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", endX,
			    "endY", endY
			));
	}
	public void setClipboardText(String text)
	{
		((JavascriptExecutor) driver).executeScript( "mobile: setClipboard",ImmutableMap.of(
		        "content", text,
		        "contentType", "plaintext"));
		
	}
	public String getClipboardText()
	{
		String value = (String) ((JavascriptExecutor) driver)
		        .executeScript("mobile: getClipboard");
		return value;
	}
	public void invokeAppUsingbundleId(String bundleId)
	{
		((JavascriptExecutor) driver).executeScript(
				"mobile: launchApp",
			    ImmutableMap.of(
			        "bundleId",bundleId
			    )
			);
	}
	
	
	
}