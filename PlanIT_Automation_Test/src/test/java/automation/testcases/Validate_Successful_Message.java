package automation.testcases;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import reusablemethods.base.TestBase;
import reusablemethods.pages.Homepage_to_Contactpage;
import reusablemethods.pages.Validate_errors_are_gone_page;

public class Validate_Successful_Message extends TestBase {

	@Test(priority=2,invocationCount = 5)

	public void validateSuccess() throws Exception {
		
		//Opening Browser
		configBrowser();

		// Navigating to Contact page from Home page
		Homepage_to_Contactpage hc = new Homepage_to_Contactpage(driver);
		hc.contactPage();

		// Populating contact form with mandetory fields
		Validate_errors_are_gone_page ve = new Validate_errors_are_gone_page(driver);
		ve.mandetoryFields();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		// Submitting the form with valid mandetory input
		ve.clickSubmitt();
		
		// Verifying the successful submission message
		String actualsucessful = driver.findElement(By.xpath("//strong[contains(@class,'ng-binding')]")).getText().substring(0, 6);
		String expectedsuccessfulmes = "Thanks";
		assertEquals(actualsucessful, expectedsuccessfulmes);
		
		//Closing Browser
		closeBrowser();

	}

}
