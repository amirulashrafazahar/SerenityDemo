package Valiram.SerenityDemo;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Valiram.Utility.Retry;
import Valiram.pageObejects.SerenityDemo.LoginPage;
import io.appium.java_client.AppiumBy;

import java.time.Duration;


public class WorkLog extends BaseTest{
	
	
	// Test case for add new WorkLog
	@Test(retryAnalyzer=Retry.class)
	public void newWorkLog() 
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
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		boolean newWorkLogSuccess = driver.findElement(By.xpath("//android.widget.EditText")).isDisplayed();       
        // Assert that login is successful by checking if the element is displayed
        Assert.assertTrue(newWorkLogSuccess, "User should be successfully click add new work log button.");
	
	
	}

	// Test case for verify project selection
	@Test(retryAnalyzer=Retry.class)
	public void VerifyProjectSelection() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickUsernameField();	 
		loginPage.setUsernameFieldCap("admin");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setPasswordField("serenity");
	    
	    // Click on the Login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]")).click();
	    driver.findElement(AppiumBy.accessibilityId("Pay2Flex")).click();
	    
		
		
	    // Assert that login is successful
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    boolean isLoginSuccessful = driver.findElement(By.xpath("//android.widget.EditText")).isDisplayed();
	    Assert.assertTrue(isLoginSuccessful, "Project selection is success");
	}
    
	// Test case for verify tag selection
		@Test(retryAnalyzer=Retry.class)
		public void VerifyTagSelection() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			LoginPage loginPage = new LoginPage(driver);
			loginPage.clickUsernameField();	 
			loginPage.setUsernameFieldCap("admin");	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			loginPage.clickPasswordField();
			loginPage.setPasswordField("serenity");
		    
		    // Click on the Login button
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			loginPage.clickLoginButton();
			
			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]")).click();
		    driver.findElement(AppiumBy.accessibilityId("Pay2Flex")).click();
		    driver.findElement(AppiumBy.accessibilityId("#9812")).click();
	    			
		    // Assert that login is successful
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		    boolean isLoginSuccessful = driver.findElement(By.xpath("//android.widget.EditText")).isDisplayed();
		    Assert.assertTrue(isLoginSuccessful, "Tag selection is success");
		}

    
 // Test case for verify add descrption
		@Test(retryAnalyzer=Retry.class)
		public void VerifyAddDescription() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			LoginPage loginPage = new LoginPage(driver);
			loginPage.clickUsernameField();	 
			loginPage.setUsernameFieldCap("admin");	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			loginPage.clickPasswordField();
			loginPage.setPasswordField("serenity");
		    
		    // Click on the Login button
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			loginPage.clickLoginButton();
			
			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]")).click();
		    driver.findElement(AppiumBy.accessibilityId("Pay2Flex")).click();
		    driver.findElement(AppiumBy.accessibilityId("#9812")).click();
		    driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("test desciption");	    			
		}
    

}

