package Valiram.pageObejects.SerenityDemo;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	AndroidDriver driver;
	
	public LoginPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
	private WebElement usernameField;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement usernameField1;

	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
	private WebElement passwordField;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement passwordField1;
	
	@AndroidFindBy(accessibility="Login")
	private WebElement loginButton;
//	driver.findElement(AppiumBy.accessibilityId("Login")).click();

	public void clickUsernameField() 
	{
		usernameField.click();
	}

	public void setUsernameField(String username) 
	{
		usernameField1.sendKeys(username);
		driver.hideKeyboard();
	}
	
	public void setUsernameFieldCap(String username) 
	{
		usernameField1.sendKeys(username);
		driver.hideKeyboard();
	}
	
	public void setUsernameFieldSpace(String username) 
	{
		usernameField1.sendKeys(username);
		driver.hideKeyboard();
	}
	
	public void setInvalidUsername(String username) 
	{
		usernameField1.sendKeys(username);
		driver.hideKeyboard();
	}
	
	public void setEmptyUsername(String username) 
	{
		usernameField1.sendKeys(username);
		driver.hideKeyboard();
	}
	
	public void clickPasswordField() 
	{
		passwordField.click();
	}
	
	public void setPasswordField(String password) 
	{
		passwordField1.sendKeys(password);
		driver.hideKeyboard();
	}
	
	public void setPasswordFieldSpace(String password) 
	{
		passwordField1.sendKeys(password);
		driver.hideKeyboard();
	}
	
	public void setEmptyPassword(String password) 
	{
		passwordField1.sendKeys(password);
		driver.hideKeyboard();
	}
	
	public void setInvalidPassword(String password) 
	{
		passwordField1.sendKeys(password);
		driver.hideKeyboard();
	}
	
	public void clickLoginButton() 
	{
		loginButton.click();
	}

}
