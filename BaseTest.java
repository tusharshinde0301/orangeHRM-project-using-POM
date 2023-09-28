package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class BaseTest {
    protected WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        Assert.assertEquals(
        		driver.getCurrentUrl(),
        		"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
        		"After Login user is suppose to come on dashboard page");
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
