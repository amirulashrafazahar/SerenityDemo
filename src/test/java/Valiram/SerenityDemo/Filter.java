package Valiram.SerenityDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Valiram.Utility.Retry;
import Valiram.pageObejects.SerenityDemo.LoginPage;
import io.appium.java_client.AppiumBy;

import java.time.Duration;
import java.util.List;


public class Filter extends BaseTest{
	
	
	// Test case for filter by project
	@Test(retryAnalyzer=Retry.class)
	public void projectFilter() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Serenity Demo App")));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickUsernameField();	
		loginPage.setUsernameField("admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setPasswordField("serenity");			
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]")).click();
		
		//StaleElementReferenceException issue
		Duration timeout = Duration.ofSeconds(100);
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[1]")));
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[1]")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Pay2Flex")).click();
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]")).click();	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Find all work log elements that have a 'content-desc' attribute
	    List<WebElement> workLogElements = driver.findElements(By.xpath("//android.widget.Button[contains(@content-desc, 'Pay2Flex')]"));

	    // assert each work log item contains 'Pay2Flex' 
	    for (WebElement workLog : workLogElements) {
	        String contentDesc = workLog.getAttribute("content-desc");
	        Assert.assertTrue(contentDesc.contains("Pay2Flex"), "Work log item description does not contain 'Pay2Flex': " + contentDesc);
	    }

	    Assert.assertFalse(workLogElements.isEmpty(), "No work logs found after filtering by 'Pay2Flex'");
	}

	// Test case for filtering by customer
	@Test(retryAnalyzer=Retry.class)
	public void customerFilter() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Serenity Demo App")));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickUsernameField();	
		loginPage.setUsernameField("admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setPasswordField("serenity");			
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]")).click();
		
		//StaleElementReferenceException issue
		Duration timeout = Duration.ofSeconds(100);
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[2]")));
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[2]")).click();
		
		driver.findElement(AppiumBy.accessibilityId("HourlyPro")).click();
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]")).click();	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Find all work log elements that have a 'content-desc' attribute
	    List<WebElement> workLogElements = driver.findElements(By.xpath("//android.widget.Button[contains(@content-desc, 'ProCourse')]"));

	    // assert each work log item contains 'ProCourse' 
	    for (WebElement workLog : workLogElements) {
	        String contentDesc = workLog.getAttribute("content-desc");
	        Assert.assertTrue(contentDesc.contains("ProCourse"), "Work log item description does not contain 'ProCourse': " + contentDesc);
	    }

	    Assert.assertFalse(workLogElements.isEmpty(), "No work logs found after filtering by 'ProCourse'");
	}
    
	// Test case for filter by month
		@Test(retryAnalyzer=Retry.class)
		public void monthFilter() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Serenity Demo App")));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickUsernameField();	
		loginPage.setUsernameField("admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setPasswordField("serenity");			
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]")).click();
		
		//StaleElementReferenceException issue
		Duration timeout = Duration.ofSeconds(100);
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[4]")));
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[4]")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1")).click();
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]")).click();	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Find all work log elements that have a 'content-desc' attribute
	    List<WebElement> workLogElements = driver.findElements(By.xpath("//android.widget.Button[contains(@content-desc, 'Jan')]"));

	    // assert each work log item contains 'Jan' 
	    for (WebElement workLog : workLogElements) {
	        String contentDesc = workLog.getAttribute("content-desc");
	        Assert.assertTrue(contentDesc.contains("Jan"), "Work log item description does not contain 'Jan': " + contentDesc);
	    }

	    Assert.assertFalse(workLogElements.isEmpty(), "No work logs found after filtering by 'Jan'");
	}

    

}

