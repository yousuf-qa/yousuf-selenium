package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	 @FindBy(linkText = "Hero Hoodie")
	    private WebElement productLink;

	    public HomePage(WebDriver driver) {
	        super(driver);
	    }

	    public void navigateToProductPage() {
	        productLink.click();
	    }
}
