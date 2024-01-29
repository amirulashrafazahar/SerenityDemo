package Valiram.SerenityDemo;


import java.net.MalformedURLException;
import java.net.URL;


import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeMethod
	public void ConfigureAppium() throws MalformedURLException
	{
//		service = new AppiumServiceBuilder().withAppiumJS(new File("\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 7 Pro");
		options.setApp("\\Users\\User\\eclipse-workspace\\SerenityDemo\\src\\test\\java\\resources\\Serenity Demo_1.0.2_apkcombo.com.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
//		service.stop();
	}
}
