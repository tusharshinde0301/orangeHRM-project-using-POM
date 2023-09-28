package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends BasePage {
	
	@FindBy(xpath="//label[text()='Username']/../..//input")                
	private WebElement searchUsernameTxt;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchUserBtn;
	
	private WebDriverWait wait;

	public UsersPage(WebDriver driver) {
		super (driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	private void enterUsername(String username) {
		wait.until(ExpectedConditions.elementToBeClickable(searchUsernameTxt));
		searchUsernameTxt.clear();
		searchUsernameTxt.sendKeys(username);
	}
	
	private void clickSearchBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(searchUserBtn));
		searchUserBtn.click();
		
	}
	
	public boolean searchUser(String username) {
		navigateToTab(adminTab);
		enterUsername(username);
		clickSearchBtn();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (username.equals(driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[2]/div")).getText())) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}

}
 