package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class BasePage {
    protected WebDriver driver;
 
    @FindBy(xpath = "//a[contains(@href, 'viewAdminModule')]")
    protected WebElement adminTab;
    
    @FindBy(xpath = "//a[contains(@href, 'viewPimModule')]")
    protected WebElement pimTab;
    
    
    @FindBy(className = "oxd-userdropdown")
    protected WebElement userProfile;
    
    @FindBy(linkText = "Logout")
    protected WebElement logoutLink;
 
    public BasePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
        PageFactory.initElements(factory, this);
    }
 
    public void clickUserProfile() {
    	userProfile.click();
    }
    
    public void clickLogoutLink() {
    	logoutLink.click();
    }
    
    public void logout() {
    	clickUserProfile();
    	clickLogoutLink();
    }
    
    public void navigateToTab(WebElement tabName) {
    	tabName.click();
    }
    
//    public void clickAdminTab() {
//        adminTab.click();
//    }
 
    
}
