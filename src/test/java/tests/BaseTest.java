package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.AllureAttachment;

public class BaseTest {

	WebDriver driver;
//	RemoteWebDriver driver;
//	DesiredCapabilities capabilities;
//	String BrowserVersion;
//	String BrowserName;

//	@Parameters({ "browser", "TestedSiteUrl" })
//	@BeforeClass
//	public void setup(String browser, String TestedSiteUrl, ITestContext testContext) throws MalformedURLException {
//		if ("true".equals(System.getProperty("degug"))) {
//			ChromeOptions cOptions = new ChromeOptions();
//			cOptions.addArguments("disable-infobars");
//			driver = new ChromeDriver(cOptions);
//			BrowserVersion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
//			BrowserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
//		} else if (browser.equalsIgnoreCase("firefox")) {
//			capabilities = new DesiredCapabilities();
//			capabilities.setBrowserName("firefox");
//			capabilities.setVersion("86.0");
//			capabilities.setCapability("enableVNC", true);
//			capabilities.setCapability("enableVideo", true);
//			capabilities.setCapability("name", this.getClass().getName());
//			capabilities.setCapability("videoName", this.getClass().getName() + "-"
//			        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss")));
//			capabilities.setCapability("screenResolution", "1280x1024x24");
//			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
//			BrowserVersion = capabilities.getVersion();
//			BrowserName = capabilities.getBrowserName();
//		}
//		testContext.setAttribute("WebDriver", this.driver); // take screen shot
//		driver.get(TestedSiteUrl);
//		System.out.println("run");
//		}


	@Parameters({"browser"})
	@BeforeClass(description = "initializing driver and navigating to tested site url")
	public void setup(@Optional("Chrome") String browser, ITestContext testContext) {
		switch (browser) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "explorer":
				WebDriverManager.iedriver().setup();
				InternetExplorerOptions capabilities = new InternetExplorerOptions();
				capabilities.ignoreZoomSettings();
				driver = new InternetExplorerDriver(capabilities);
				break;
			default:
				throw new IllegalArgumentException("no such browser " + browser);
		}
		driver.manage().window().maximize();
		testContext.setAttribute("WebDriver", this.driver); // take screen shot
		driver.get(utils.Configuration.readProperty("TestedSiteUrl"));
		AllureAttachment.attachURL("https://www.pilots.co.il/");
	}

	@AfterClass(description = "closing driver")
	public void tearDone() {
		driver.quit();
	}

	// This method will run after watch test, it will take screen shot only for
	//tests that failed

	@AfterMethod
	public void failedTest(ITestResult result) {
		// check if the test failed
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
//			result.getname() method will give you current test case name.
//			./ScreenShots/ tell you that, in your current directory, create folder
//				ScreenShots. dot represents current directory
		}

	}
}
