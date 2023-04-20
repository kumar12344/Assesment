package com.QA_TechM.utils;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.QA_TechM.application.AplicationProp;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QA_TechM_TestBase {

	public static WebDriver driver;
	public static Properties prop; // global variable

	public QA_TechM_TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(AplicationProp.FilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initilization() throws InterruptedException // Initialization method
	{
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", AplicationProp.ChromePath);

			// Use of WebDriver Manager

			WebDriverManager.chromedriver().setup();
			// Create the object of chrome options
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			// DesiredCapabilities c = DesiredCapabilities.htmlUnit();
			// c.setCapability(ChromeOptions.CAPABILITY, options);

			

			
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = new ChromeDriver(options);
			// Pass the options parameter in the chrome driver declaration

		} else if (browserName.equals("fireFox")) {
			// System.setProperty("webDriver.gecko.driver", ApplicationProp.FirefoxPath);

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-gpu");

			driver = new FirefoxDriver(options);
		} else if (browserName.equals("Edge")) {
			// System.setProperty("webdriver.edge.driver", ApplicationProp.MsEdgePath);

			// Use of WebDriver Manager

			WebDriverManager.edgedriver().setup();

			// Create the object of Edge options

			EdgeOptions options = new EdgeOptions();
			

			// options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

			// InternetExplorerOptions options = new InternetExplorerOptions();
			// Add the headless arguments
			// options.addArguments("--headless");
			// options.addArguments("--no-sandbox");
			// options.addArguments("--disable-gpu");

			driver = new EdgeDriver(options);
			

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(TestUtil.implicitlywait,
		// TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PageLoadTimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.implicitlywait));

		driver.get(prop.getProperty("url"));
	}	

	}

