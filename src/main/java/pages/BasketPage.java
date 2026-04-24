package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasketPage extends BasePage {
    private By itemNames=By.cssSelector(".list-group-item h6");
    private By itemPrices=By.cssSelector(".list-group-item span.text-muted");
    private By deleteBtn=By.linkText("Delete Item");
    
    private By menuBtn=By.cssSelector(".navbar-toggler");
    private By basketLink=By.cssSelector("a[href='/basket']");
    private By basketItems=By.cssSelector(".list-group-item");
    
    private By basketCount=By.cssSelector(".badge");


    public void openBasket() {
        if (driver.findElements(menuBtn).size() > 0) {
            try {
                if (driver.findElement(menuBtn).isDisplayed()) {
                    driver.findElement(menuBtn).click();
                }
            } catch (Exception ignored) {}
        }

        click(basketLink);
    }

    public List<WebElement> getItemNames() {
        return getElements(itemNames);
    }

    public List<WebElement> getItemPrices() {
        return getElements(itemPrices);
    }

    public void removeFirstItem() {
        click(deleteBtn);
        driver.switchTo().alert().accept();
    }
    
    public int getItemCount() {
        return driver.findElements(basketItems).size();
    }

    public boolean isBasketEmpty() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver -> getBasketCount() == 0);
    }
    
    public int getBasketCount() {
        String count=driver.findElement(basketCount).getText().trim();
        return Integer.parseInt(count);
    }
}