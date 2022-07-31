package automation.testcases;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import reusablemethods.base.TestBase;
import reusablemethods.pages.Verify_items_page;

public class Verify_itemsincart extends TestBase {

	@Test(priority = 3)
	public  void verifyItemsinCart() throws Exception {
		configBrowser();
		// Expected values for subtotal
		String StuffedFrog = "$21.98";
		String FluffyBunny = "$49.95";
		String ValentineBear = "$44.97";

		// Expected values for prices
		String StuffedFrogprice = "$10.99";
		String FluffyBunnyprice = "$9.99";
		String ValentineBearprice = "$14.99";

		// Expected value for Total
		double price = 116.9;

		// Adding items to the cart
		Verify_items_page vi = new Verify_items_page(driver);
		vi.itemsVerify();
		vi.addingItems();
		vi.addingToCart();

		// Actual subtotal for each product
		String Stuffedfrogitems = driver.findElement(By.xpath("//*[contains(.,'Stuffed Frog')]//td[4]")).getText();
		String ValentineBearitems = driver.findElement(By.xpath("//*[contains(.,'Valentine Bear')]//tr[3]//td[4]")).getText();
		String Fluffybunnyitems = driver.findElement(By.xpath("//*[contains(.,'Fluffy Bunny')]//tr[2]//td[4]")).getText();

		// verifying the Subtotal for each product is correct
		assertEquals(Stuffedfrogitems, StuffedFrog);
		assertEquals(ValentineBearitems, ValentineBear);
		assertEquals(Fluffybunnyitems, FluffyBunny);

		// Actual prices for each product
		String StuffedFrogprices = driver.findElement(By.xpath("//*[contains(.,'Stuffed Frog')]//td[2]")).getText();
		String FluffyBunnyprices = driver.findElement(By.xpath("//*[contains(.,'Fluffy Bunny')]//tr[2]//td[2]")).getText();
		String ValentineBearprices = driver.findElement(By.xpath("//*[contains(.,'Valentine Bear')]//tr[3]//td[2]")).getText();

		// Verifying price for each product
		assertEquals(StuffedFrogprice, StuffedFrogprices);
		assertEquals(FluffyBunnyprice, FluffyBunnyprices);
		assertEquals(ValentineBearprice, ValentineBearprices);

		// Actual total prices
		double StuffedFrogpricesValue = Double.valueOf(Stuffedfrogitems.substring(1));
		double FluffyBunnypricesValue = Double.valueOf(Fluffybunnyitems.substring(1));
		double ValentineBearpricesValue = Double.valueOf(ValentineBearitems.substring(1));
		double totalprice = StuffedFrogpricesValue + FluffyBunnypricesValue + ValentineBearpricesValue;

		// Verifying the total price
		assertEquals(price, totalprice);
		closeBrowser();

	}
}
