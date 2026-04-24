package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage {
    private By productName=By.xpath("//h1 | //h2");
    private By productPrice=By.xpath("//*[contains(text(),'£')]");
    private By addToBasketBtn=By.xpath("//a[contains(@class,'addItem')]");

    public boolean isProductNameDisplayed() {
        return isDisplayed(productName);
    }

    public boolean isPriceDisplayed() {
        return isDisplayed(productPrice);
    }

    public boolean isAddToBasketPresent() {
        return isDisplayed(addToBasketBtn);
    }
}