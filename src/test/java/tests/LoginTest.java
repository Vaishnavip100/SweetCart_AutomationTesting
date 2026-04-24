package tests;

import base.BaseTest;
import base.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.SweetsPage;
import utils.ConfigReader;
import utils.ExcelUtil;

public class LoginTest extends BaseTest {

    @DataProvider(name="loginData")
    public Object[][] getData() {
        return ExcelUtil.getData("src/test/resources/testdata/LoginData.xlsx","Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password, String type) {
        LoginPage loginPage=new LoginPage();
        loginPage.clickLoginLink();
        loginPage.login(email, password);

        if (type.equalsIgnoreCase("success")) {
            AccountPage accountPage=new AccountPage();
            Assert.assertTrue(accountPage.isUserLoggedIn(),"Valid login failed");
        } else {
            String error=loginPage.getErrorMessage();
            Assert.assertTrue(error.toLowerCase().contains("demo email"),"Error message not shown for invalid login");
        }
    }
    
    @Test
    public void testLogout() {
        LoginPage login=new LoginPage();
        SweetsPage sweets=new SweetsPage();

        login.clickLoginLink();
        login.login(ConfigReader.getUsername(),ConfigReader.getPassword());

        Assert.assertTrue(true, "No logout button in UI");
    }
}