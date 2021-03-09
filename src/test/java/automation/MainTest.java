package automation;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import scripts.*;

public class MainTest {

	private static WebDriver driver;
	private static WebDriverHelper browser;
	private static LogHelper logger;
	private static ExtentReports report;
	public static ExtentTest extentTest;

	@BeforeClass
	public static void beforeClass() {
		// Initialize report
		String extentReportFile = System.getProperty("user.dir") + "/target/report.html";
		File reportFile = new File(extentReportFile);
		if (reportFile.exists()) {
			reportFile.delete();
		}
		report = new ExtentReports(extentReportFile, false);
		logger = new LogHelper();

		logger.log("Framework initialized successfully");
	}

	@Before
	public void beforeTest() {
		// Initialize driver
		browser = new WebDriverHelper();
		driver = browser.generateWebDriver();
	}

	@Test
	public void login() throws Exception {
		extentTest = report.startTest("Login", "Do login and check profile data");
		logger.log("Starting running test: LOGIN");
		new Login(browser, driver).runTest();
	}

	@Test
	public void searchTrial() throws Exception {
		String searchText = "trial";
		extentTest = report.startTest("Search '" + searchText + "'", "Search text and check results: " + searchText);
		logger.log("Starting running test: SEARCH '" + searchText + "'");
		new Search(browser, driver).runTest(searchText);
	}

	@Test
	public void searchApi() throws Exception {
		String searchText = "api";
		extentTest = report.startTest("Search '" + searchText + "'", "Search text and check results: " + searchText);
		logger.log("Starting running test: SEARCH '" + searchText + "'");
		new Search(browser, driver).runTest(searchText);
	}

	@Test
	public void downloadWindowsProduct() throws Exception {
		String platform = "Windows";
		extentTest = report.startTest("Download " + platform, "Download product for platform: " + platform);
		logger.log("Starting running test: DOWNLOAD PRODUCT: " + platform);
		new Download(browser, driver).runTest(platform);
	}

	@Test
	public void downloadMacProduct() throws Exception {
		String platform = "Mac";
		extentTest = report.startTest("Download " + platform, "Download product for platform: " + platform);
		logger.log("Starting running test: DOWNLOAD PRODUCT: " + platform);
		new Download(browser, driver).runTest(platform);
	}

	@Test
	public void downloadLinuxProduct() throws Exception {
		String platform = "Linux";
		extentTest = report.startTest("Download " + platform, "Download product for platform: " + platform);
		logger.log("Starting running test: DOWNLOAD PRODUCT: " + platform);
		new Download(browser, driver).runTest(platform);
	}

	@Rule
	public TestWatcher watcher = new TestWatcher() {
		@Override
		protected void failed(Throwable e, Description description) {
			extentTest.log(LogStatus.FAIL, e.getMessage());
		}

		@Override
		protected void succeeded(Description description) {
			extentTest.log(LogStatus.PASS, "Test passed successfully");
		}
	};

	@After
	public void afterTest() {
		report.endTest(extentTest);
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterClass
	public static void afterClass() {
		report.flush();
		logger.log("Tests execution finished");
	}

}
