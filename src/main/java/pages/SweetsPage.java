package pages;

import base.BasePage;
import base.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SweetsPage extends BasePage {
    private By sweetsLink=By.linkText("Sweets");
    private By productCards=By.xpath("//div[contains(@class,'col-lg-3')]");
    private By footer=By.tagName("footer");
    private By addToBasketButtons=By.xpath("//a[contains(@class,'addItem')]");


    private By categoryButton(String category) {
        return By.xpath("//button[normalize-space()='" + category + "']");
    }

    public void openSweetsPage() {
        click(sweetsLink);
        waitForVisibility(productCards);
    }

    public List<WebElement> getAllProducts() {
        return getElements(productCards);
    }

    public void selectCategory(String category) {
        click(categoryButton(category));
        waitForVisibility(productCards);
    }

    public void clickFirstProduct() {
        getElements(productCards).get(0).click();
    }
    
    public void addProductByName(String productName) {
        By addBtn=By.xpath("//a[contains(@class,'addItem') and @data-name='" + productName + "']");
        click(addBtn);
    }

    public void addMultipleProducts(int count) {
        List<WebElement> buttons=getElements(addToBasketButtons);
        for (int i=0;i<count;i++) {
            buttons.get(i).click();
        }
    }

    public void clickAbout() {
        click(By.linkText("About"));
    }

    public void clickNavLink(String name) {
        if (name.equalsIgnoreCase("Basket")) {
            click(By.xpath("//a[contains(text(),'Basket')]"));
            return;
        }
        click(By.linkText(name));
    }

    public boolean isAboutPageOpened() {
        return DriverFactory.getDriver().getCurrentUrl().contains("about");
    }

    public String getAboutHeading() {
        return getElement(By.tagName("h1")).getText();
    }

    public boolean isFooterVisible() {
        return getElement(footer).isDisplayed();
    }

    public String getFooterText() {
        return getElement(footer).getText();
    }
    
    public boolean isNavLinkVisible(String name) {
        if (name.equalsIgnoreCase("Basket")) {
            return getElement(By.xpath("//a[contains(text(),'Basket')]")).isDisplayed();
        }
        return getElement(By.linkText(name)).isDisplayed();
    }
}