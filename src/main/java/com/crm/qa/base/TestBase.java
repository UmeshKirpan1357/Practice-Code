package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utils.TestUtil;

public class TestBase {
	private static Logger log = LogManager.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		log.info("Properties object created");
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\config\\configuration.properties");
			prop.load(fis);
			log.info("Propertied file loaded into property objec");
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome Driver Initiated");
			
		} 
		else if(browserName.equals("FF")) 
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("url"));
		
	}
	public String failed(String screenShotName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String destinationDir=currentDir + "/screenshots/" + SimpleDateFormat.getDateTimeInstance() + ".png";
		FileUtils.copyFile(scrFile, new File(destinationDir));
		return destinationDir;
	}
}
