package api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReport;
	ExtentTest extentTest;

	@BeforeTest
	public void startReporter(ITestContext testContext) {

		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/reports/extentReport.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);

		extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
		extentSparkReporter.config().setReportName("Test Report");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL,result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getTestName());
		}
		else {
			extentTest.log(Status.SKIP, result.getTestName());
		}
	}

	@AfterTest
	public void tearDown(ITestContext testContext) {
		//to write or update test information to the reporter
		extentReport.flush();
	}
}
