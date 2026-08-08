package TestUtils;

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

public class IOSBaseTest {

	public IOSDriver driver;
	public AppiumDriverLocalService service;
	@BeforeClass
	public void configureAppium(String appKey) throws MalformedURLException, URISyntaxException, FileNotFoundException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\nancy\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		XCUITestOptions options=new XCUITestOptions();
		options.setDeviceName("iPhone 15");
		options.setPlatformVersion("17");
		options.setPlatformName("iOS");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		//options.setApp("C:\\Users\\nancy\\eclipse-workspace\\AppiumJavaFramework\\src\\test\\java\\Resources"+ prop.getProperty(appKey));
		options.setApp("C:\\Users\\nancy\\eclipse-workspace\\AppiumJavaFramework\\src\\test\\java\\Resources\\UIKitCatalog.app");
		driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@AfterClass
	public void tearDown()
	{

		driver.quit();
		service.stop();
	}
	
	
}