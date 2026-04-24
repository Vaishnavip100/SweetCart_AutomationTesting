package pages;

import base.BasePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {
	private By logoutBtn=By.linkText("Logout");
	private By welcomeText=By.xpath("//*[contains(text(),'Welcome back')]");
	
    private By accountLink=By.linkText("Account");
    
    private By orderSection=By.xpath("//*[contains(text(),'Previous Orders')]");
    
    private By orderDates=By.xpath("//table//tbody/tr/td[2]");
    
    private By orderRows=By.xpath("//table//tbody/tr");
    private By orderTotals=By.xpath("//table//tbody/tr/td[4]");
    private By orderTable=By.xpath("//table");

	public boolean isUserLoggedIn() {
	    return isDisplayed(welcomeText);
	}
	
    public void logout() {
        click(logoutBtn);
    }
    
    public void clickAccountLink() {
        click(accountLink);
    }
    
    public List<WebElement> getOrderTotals() {
        return getElements(orderTotals);
    }
    
    public String getWelcomeText() {
        return getText(welcomeText);
    }

    public boolean isOrderSectionDisplayed() {
        return isDisplayed(orderSection);
    }

    public List<WebElement> getOrderRows() {
        return getElements(orderRows);
    }

    public List<WebElement> getOrderDates() {
        return getElements(orderDates);
    }

    public List<String> getOrderTotalsText() {
        waitForVisibility(orderTable);
        List<WebElement> totals=driver.findElements(By.xpath("//table//tbody/tr/td[4]"));
        return totals.stream().map(e -> e.getText().trim()).toList();
    }
}