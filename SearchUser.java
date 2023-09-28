package userpage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.UsersPage;
import tests.BaseTest;

public class SearchUser extends BaseTest {
	UsersPage usersPage;
	
	@Test(dataProvider = "Username-Provider")
	public void searchUser(String username, boolean result) {
		usersPage = new UsersPage(driver);
		Assert.assertEquals(usersPage.searchUser(username), result);
	}
	
	@DataProvider (name = "Username-Provider")
	public Object[][] getData() {
        return new Object[][]{
                {"Admin", true},
                {"tushar", false},
                {"Alice.Duval", true}
                
                
        };
    }

}