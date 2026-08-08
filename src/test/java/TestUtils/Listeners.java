package TestUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import utils.AndroidActions;

public class Listeners implements ITestListener{
	ExtentReports extent=ExtentReporter.getReportObject();
	ExtentTest test;
	AppiumDriver driver;
	@Override
    public void onTestStart(ITestResult result) {
       test=extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	try {
			driver=(AppiumDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
       test.fail(result.getThrowable());
       try {
		test.addScreenCaptureFromPath(AndroidActions.getScreenshotPath(result.getMethod().getMethodName(),driver));
	} catch (IOException e) {
		e.printStackTrace();
	}
    }

	@Override
    public void onTestSkipped(ITestResult result) {
       // System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
      //  System.out.println("Test failed but within success percentage");
    }

    @Override
    public void onStart(ITestContext context) {
       // System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
       extent.flush();
    }

}
