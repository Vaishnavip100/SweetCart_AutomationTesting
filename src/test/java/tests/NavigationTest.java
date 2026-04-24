package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SweetsPage;

public class NavigationTest extends BaseTest {

	@Test
	public void navigationAndStaticContent() {
	    SweetsPage sweets=new SweetsPage();
	    sweets.openSweetsPage();

	    //Verify navigation links
	    Assert.assertTrue(sweets.isNavLinkVisible("Sweets"), "Sweets link not visible");
	    Assert.assertTrue(sweets.isNavLinkVisible("About"), "About link not visible");
	    Assert.assertTrue(sweets.isNavLinkVisible("Login"), "Login link not visible");
	    Assert.assertTrue(sweets.isNavLinkVisible("Basket"), "Basket link not visible");
	    sweets.clickNavLink("About");

	    //Validate navigation
	    Assert.assertTrue(sweets.isAboutPageOpened(),"About page not opened");

	    //Verify heading
	    String heading = sweets.getAboutHeading();
	    Assert.assertTrue(heading != null && heading.trim().length() > 0,"Heading is empty");

	    //Verify footer
	    Assert.assertTrue(sweets.isFooterVisible(),"Footer not visible");
	    Assert.assertTrue(sweets.getFooterText().trim().length() > 0,"Footer text is empty");
	}
}