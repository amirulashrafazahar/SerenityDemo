package Valiram.SerenityDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Valiram.Utility.Retry;
import Valiram.pageObejects.SerenityDemo.LoginPage;
import io.appium.java_client.AppiumBy;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login extends BaseTest{
	
	
	// Test case for valid login credentials
	@Test(retryAnalyzer=Retry.class)
	public void validLoginTest() 
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		boolean isLoginSuccessful = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Work Logs\"]")).isDisplayed();
        
        // Assert that login is successful by checking if the element is displayed
        Assert.assertTrue(isLoginSuccessful, "User should be successfully logged in.");		
	}

	// Test case for login with case insensitive username
	@Test(retryAnalyzer=Retry.class)
	public void caseInsensitivityCheckTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickUsernameField();	 
		loginPage.setUsernameFieldCap("ADMIN");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setPasswordField("serenity");
	    
	    // Click on the Login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();
	    
	    // Assert that login is successful
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    boolean isLoginSuccessful = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Work Logs\"]")).isDisplayed();
	    Assert.assertTrue(isLoginSuccessful, "Login should be successful for case-insensitive username.");
	}

    
 // Test case for login with trimmed credentials
    @Test(retryAnalyzer=Retry.class)
    public void trimmingSpacesInCredentialsTest() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.clickUsernameField();
    	loginPage.setUsernameFieldSpace(" admin ");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setPasswordFieldSpace(" serenity ");
	    
	    // Click on the Login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();

        // Assert that login is successful
        boolean isLoginErrorDisplayed = driver.findElement(AppiumBy.accessibilityId("The username/password couple is invalid.")).isDisplayed();
        Assert.assertTrue(isLoginErrorDisplayed, "An error message should be displayed for invalid username.");
    }

    
 // Test case for invalid username
    @Test(retryAnalyzer=Retry.class)
    public void invalidUsernameTest() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.clickUsernameField();	 
    	loginPage.setUsernameFieldSpace("invalidusername");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setPasswordField("serenity");
	    
	    // Click on the Login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();
        
        // Assert that login fails with an error message
        boolean isLoginErrorDisplayed = driver.findElement(AppiumBy.accessibilityId("The username/password couple is invalid.")).isDisplayed();
        Assert.assertTrue(isLoginErrorDisplayed, "An error message should be displayed for invalid username.");
    }

    
 // Test case for invalid password
    @Test(retryAnalyzer=Retry.class)
    public void invalidPasswordTest() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	LoginPage loginPage = new LoginPage(driver);
		loginPage.clickUsernameField();	
		loginPage.setUsernameField("admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setInvalidPassword("invalidpassword");
	    
	    // Click on the Login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();
        
        // Assert that login fails with an error message
        boolean isLoginErrorDisplayed = driver.findElement(AppiumBy.accessibilityId("The username/password couple is invalid.")).isDisplayed();
        Assert.assertTrue(isLoginErrorDisplayed, "An error message should be displayed for invalid password.");
    }
    
 // Test case for Empty field
    @Test(retryAnalyzer=Retry.class)
    public void emptyFieldsTest() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	LoginPage loginPage = new LoginPage(driver);
		loginPage.clickUsernameField();	  
		loginPage.setEmptyUsername("");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickPasswordField();
		loginPage.setEmptyPassword("");
	    
	    // Click on the Login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage.clickLoginButton();
        
        // Assert that login fails with an error message
        boolean isUsernameErrorDisplayed = driver.findElement(AppiumBy.accessibilityId("Please enter a username")).isDisplayed();
        Assert.assertTrue(isUsernameErrorDisplayed, "An error message should be displayed when the username field is empty.");
        
        boolean isPasswordErrorDisplayed = driver.findElement(AppiumBy.accessibilityId("Please enter a password")).isDisplayed();
        Assert.assertTrue(isPasswordErrorDisplayed, "An error message should be displayed when the password field is empty.");
    }
    

}

