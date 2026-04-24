package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import utils.ConfigReader;

import org.openqa.selenium.WebElement;
import java.util.List;

public class AccountTest extends BaseTest {

	@Test
	public void accountAndOrderHistory() {
	    LoginPage login=new LoginPage();
	    AccountPage account=new AccountPage();

	    login.clickLoginLink();
	    login.login(ConfigReader.getUsername(),ConfigReader.getPassword());

	    //Verify username after login
	    Assert.assertTrue(account.isUserLoggedIn(),"User not logged in / Account page not loaded");
	    //Verify the order history section is present
	    Assert.assertTrue(account.isOrderSectionDisplayed(),"Order history section is not visible");

	    List<WebElement> rows=account.getOrderRows();

	    Assert.assertTrue(rows.size() > 0,"No order history rows found");

	    for (int i=0;i<rows.size();i++) {
	        String rowText=rows.get(i).getText().replace("\n", " ").trim();
	        
	        //Verify each order history row 
	        Assert.assertTrue(rowText.matches(".*\\d{4}.*"),"Date missing in row: " + i);
	        Assert.assertTrue(rowText.matches(".*\\d+\\.\\d+.*"),"Total missing in row: " + i);
	    }
	}
}