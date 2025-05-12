package JiggysProjects.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import JiggysProjects.TestComponents.BaseTest;
import JiggysProjects.TestComponents.Retry;
import JiggysProjects.pageobjects.CartPage;
import JiggysProjects.pageobjects.CheckoutPage;
import JiggysProjects.pageobjects.ConfirmationPage;
import JiggysProjects.pageobjects.LandingPage;
import JiggysProjects.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		// WebDriverManager.chromedriver().setup();
		landingPage.loginApplication("jamesmensah@busy.com", "Pa$$wrd");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		// WebDriverManager.chromedriver().setup();

		String productName = "ZARA COAT 3";

		LandingPage landingPage = launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication("bankuandeba@busy.com", "Pa$$w0rd");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}
