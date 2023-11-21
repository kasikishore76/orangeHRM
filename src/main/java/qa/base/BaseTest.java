package qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeTest(alwaysRun=true)
@Parameters("browser")
	public void initialization(@Optional("chrome")String browser) throws IOException {
		System.out.println("Before suite method called");
		prop = new Properties();
		FileInputStream file = new FileInputStream(new File(".//src/main/java/qa/configs/config.properties"));
		prop.load(file);
//		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options= new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			System.out.println("invalid browser name");
		}
		  Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
		    System.out.println(browserName);
		    String os = cap.getPlatform().toString();
		    System.out.println(os);
		    String v = cap.getVersion().toString();
		    System.out.println(v);
		driver.manage().window().maximize();
		driver.get( prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest(alwaysRun=true)
	public void tearDown() {
		System.out.println("After suite method called");
		driver.quit();
	}

}
