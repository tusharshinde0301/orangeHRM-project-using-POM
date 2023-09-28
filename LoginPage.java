package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(name = "username")
    private WebElement usernameInput;
 
    @FindBy(name = "password")
    private WebElement passwordInput;
 
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    private WebDriverWait wait;
 
    public LoginPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    private void goToLoginPage() {
    	this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
 
    private void setUsername(String username) {
    	wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
    	usernameInput.clear();
        usernameInput.sendKeys(username);
    }
 
    private void setPassword(String password) {
    	wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
    	passwordInput.clear();
        passwordInput.sendKeys(password);
    }
 
    private void clickLoginButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
    
    public void login(String username, String password) {
    	goToLoginPage();
    	setUsername(username);
    	setPassword(password);
    	clickLoginButton();
    	
    }
}
