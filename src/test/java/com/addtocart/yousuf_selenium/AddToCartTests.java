package com.addtocart.yousuf_selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import utils.WebDriverSetup;

public class AddToCartTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSetup.getWebDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @Test(description = "TC1: Add a simple product to the cart", priority = 1)
    public void testAddProductToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToProductPage();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSizeColorAndAddToCart();

        String successMessage = productPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("You added"), "Product was not added to cart.");
    }
    
    @Test(description = "TC5: Try to add a product without selecting size or color" , priority = 2)
    public void testAddProductWithoutSelectingOptions() {
        // Navigate to the product page
        driver.get("https://magento.softwaretestingboard.com/hero-hoodie.html");

        ProductPage productPage = new ProductPage(driver);

        // Try to add the product to the cart without selecting size or color
        productPage.addProductToCart();

        // Verify that an error message is displayed (assuming there's a validation message on the page)
        String errorMessage = productPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("This is a required field."), "Error message not displayed for missing selection.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}