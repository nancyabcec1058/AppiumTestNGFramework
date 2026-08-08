package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{
		this.driver=driver;
	}

	public void longPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
	}
	public void scrollToElement(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));

	}

	public void scrollToEndAction() {
		boolean scrollmore;
		do {
			scrollmore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));
		} while (scrollmore);
	}

	public void flingGestureAction(String direction, int speed) {
		((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of("left", 100, "top", 300,
				"width", 800, "height", 1800, "direction", direction, "speed", speed));
	}

	public void pinchOpenGestureAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));
	}

	public void pinchCloseGestureAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));
	}

	public void swipeAction(WebElement element, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile:swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", 0.2));
	}

	public void dragandDropAction(WebElement source, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(), "endX", endX, "endY", endY));
	}

	public void setClipboardText(String text) {
		((JavascriptExecutor) driver).executeScript("mobile: setClipboard",
				ImmutableMap.of("content", text, "contentType", "plaintext"));

	}

	public String getClipboardText() {
		String value = (String) ((JavascriptExecutor) driver).executeScript("mobile: getClipboard");
		return value;
	}

	public void invokePackageActivity(String packageActivityName) {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of("intent", packageActivityName));
	}

	public WebElement waitForvisibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	
public Double getFormattedDoubleAmount(String prize)
{
	Double amount=Double.parseDouble(prize);
	return amount;
}

public static String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException
{
	File source=driver.getScreenshotAs(OutputType.FILE);
	String destination="C:\\Users\\nancy\\eclipse-workspace\\AppiumTestNGFramework\\reports\\"+testCaseName+".png";
    FileUtils.copyFile(source, new File(destination));
			return destination;
}
}
