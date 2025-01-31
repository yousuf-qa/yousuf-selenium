package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

	@FindBy(id = "product-addtocart-button")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[@class='message-success success message']/div")
	private WebElement successMessage;

	@FindBy(xpath = "//div[@class='mage-error']")
	private WebElement errorMessage;

	// Size selection (small)
	@FindBy(id = "option-label-size-143-item-167")
	private WebElement smallSizeOption;

	// Color selection (for example, the first color option)
	@FindBy(id = "option-label-color-93-item-53")
	private WebElement colorOption;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	// Select size and color before adding product to cart
	public void selectSizeAndColor() {
		// Select the small size
		smallSizeOption.click();

		// Select the color (adjust if you need a different color)
		colorOption.click();
	}

	// Click on Add to Cart button
	public void addProductToCart() {
		addToCartButton.click();
	}

	// Get success message after adding to cart
	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(successMessage)); // Wait until the success message is visible
		return successMessage.getText();
	}

	// Get error message when size or color is not selected
	public String getErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(errorMessage)); // Wait until the error message is visible
		return errorMessage.getText();
	}

	// Method that will first select size and color, then add to cart
	public void selectSizeColorAndAddToCart() {
		selectSizeAndColor();
		addProductToCart();
	}
}
