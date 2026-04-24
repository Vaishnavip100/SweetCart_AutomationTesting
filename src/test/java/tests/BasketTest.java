package tests;

import base.BaseTest;
import base.DriverFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.SweetsPage;

public class BasketTest extends BaseTest {

    //Add product → verify basket count
    @Test
    public void addToBasketCount() {
        SweetsPage sweets=new SweetsPage();
        BasketPage basket=new BasketPage();
        sweets.openSweetsPage();
        sweets.addProductByName("Chocolate Cups");
        Assert.assertEquals(basket.getBasketCount(),1,"Basket count not updated after adding product");
    }

    //Verify product name + price in basket
    @Test
    public void productDetailsInBasket() {
        SweetsPage sweets=new SweetsPage();
        BasketPage basket=new BasketPage();
        sweets.openSweetsPage();

        String productName="Chocolate Cups";
        sweets.addProductByName(productName);
        basket.openBasket();

        String actualName=basket.getItemNames().get(0).getText();

        Assert.assertEquals(actualName,productName,"Product name mismatch in basket");
        Assert.assertTrue(basket.getItemPrices().get(0).getText().contains("£"),"Price not displayed");
    }

    //Remove product → verify empty
    @Test
    public void removeProduct() {
        SweetsPage sweets=new SweetsPage();
        BasketPage basket=new BasketPage();

        sweets.openSweetsPage();
        sweets.addProductByName("Chocolate Cups");

        basket.openBasket();
        basket.removeFirstItem();

        Assert.assertTrue(basket.isBasketEmpty(),"Basket not empty after removing item");
    }

    //Add multiple products → verify count
    @Test
    public void addMultipleProducts() {
        SweetsPage sweets=new SweetsPage();
        BasketPage basket=new BasketPage();

        sweets.openSweetsPage();
        sweets.addProductByName("Chocolate Cups");
        sweets.addProductByName("Sherbert Straws");

        Assert.assertEquals(basket.getBasketCount(), 2);
        basket.openBasket();

        List<String> names=basket.getItemNames().stream().map(WebElement::getText).toList();

        Assert.assertTrue(names.contains("Chocolate Cups"));
        Assert.assertTrue(names.contains("Sherbert Straws"));
    }
}