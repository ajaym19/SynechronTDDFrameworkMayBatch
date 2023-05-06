package com.synechron.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public void initialization() {
		readPropertyFile();
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		captureScreenshot("load");
				
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	public void readPropertyFile() {
		String propFilePath = "./src/main/java/com/synechron/config/config.properties";
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void captureScreenshot(String tcName) {
		TakesScreenshot scrnshot = (TakesScreenshot) driver;
		//   "./Screenshot/tcName.png"
		//"./Screenshot/" + tcName + ".png"
		String screenshotFilePath = "./Screenshot/" + tcName + ".png";
		File file = scrnshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(screenshotFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
