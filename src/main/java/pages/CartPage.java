package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = ".cart-item")
    private WebElement cartItem;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart() {
        return cartItem.isDisplayed();
    }
}
