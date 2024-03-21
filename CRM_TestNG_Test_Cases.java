package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PepperCloud 
{

    WebDriver driver;

    @BeforeTest
    public void setup() 
    {
        // Initialize WebDriver
    	  System.setProperty("webdriver.chrome.driver", "C:/Users/Supporting files/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHomepageTitle() 
    {
        // Navigate to the website
        driver.get("https://demo.peppercloud.com/login");

        // Get the page title
        String SalesCRMloginPepperCloudCRM = driver.getTitle();

        // Assert the expected title
        Assert.assertEquals(SalesCRMloginPepperCloudCRM, "Sales CRM login | Pepper Cloud CRM");
    }

    @Test
    public void testLoginFunctionality() throws InterruptedException
    {
        // Navigate to the login page
        driver.get("https://demo.peppercloud.com/login");

        // Enter username and password 
        driver.findElement(By.name("username")).sendKeys("qa-tester@peppercloud.io");
	driver.findElement(By.className("pc-login-btn")).click();
	driver.findElement(By.name("password")).sendKeys("Demo_PC*123");
		
        // Submit login form
	driver.findElement(By.className("pc-login-btn")).click();
        Thread.sleep(20000);
    }
    @Test
    public void testCreateUserFunctionality() throws InterruptedException 
    {
        // Test Create User Functionality
	//driver.findElement(By.xpath("//button[@id='LF1']")).click();
        try 
	{
	    // Perform some action on the element
            WebElement element = driver.findElement(By.cssSelector("a[href='/assets/images/b76e263709bf6cb12108.svg#pc-add-symbol']"));
	    element.click();
	} 
	catch (NoSuchElementException e) 
	{
	    // Handle the exception
	    System.out.println("Element not found: " + e.getMessage());
	}
    }

    @AfterTest
    public void tearDown() 
    {
        driver.quit();
    }
}
