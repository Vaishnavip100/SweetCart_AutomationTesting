package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailPage;
import pages.SweetsPage;

public class ProductTest extends BaseTest {

    //Product listing
    @Test
    public void productListing() {
        SweetsPage page=new SweetsPage();
        page.openSweetsPage();

        Assert.assertTrue(page.getAllProducts().size() > 1,"Products not displayed");
    }

    //Category filter
    @Test
    public void categoryFilter() {
        SweetsPage page=new SweetsPage();
        page.openSweetsPage();

        int beforeCount=page.getAllProducts().size();
        page.openSweetsPage();

        int afterCount = page.getAllProducts().size();
        Assert.assertEquals(afterCount,beforeCount,"Product list changed unexpectedly");
    }

    //Product details
    @Test
    public void productDetails() {
        SweetsPage page=new SweetsPage();
        page.openSweetsPage();
        page.clickFirstProduct();

        ProductDetailPage detail=new ProductDetailPage();

        Assert.assertTrue(detail.isProductNameDisplayed(), "Name missing");
        Assert.assertTrue(detail.isPriceDisplayed(), "Price missing");
    }

    //Add to basket button
    @Test
    public void addToBasketButton() {
        SweetsPage page=new SweetsPage();
        page.openSweetsPage();
        page.clickFirstProduct();

        ProductDetailPage detail=new ProductDetailPage();
        Assert.assertTrue(detail.isAddToBasketPresent(),"Add to Basket not visible");
    }
}