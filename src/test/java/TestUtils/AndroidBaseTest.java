package TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AndroidBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass(alwaysRun=true)
	public void configureAppium() throws URISyntaxException, IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\nancy\\eclipse-workspace\\AppiumTestNGFramework\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String androidDevice = prop.getProperty("androidDeviceName");

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\nancy\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(Integer.parseInt(port)).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName(androidDevice);
		options.setApp(
				"C:\\Users\\nancy\\eclipse-workspace\\AppiumJavaFramework\\src\\test\\java\\Resources\\General-Store.apk");
		options.setChromedriverExecutable(
				"C:\\Users\\nancy\\Downloads\\Postman_Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	  @AfterClass(alwaysRun = true)
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }

	        if (service != null) {
	            service.stop();
	        }
	    }

}