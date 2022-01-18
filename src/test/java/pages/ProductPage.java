package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    private static WebDriver driver;

    public ProductPage(WebDriver driver){
        ProductPage.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "price")
    private WebElement price;

    @FindBy(className = "add-to-cart-buttons")
    private WebElement addToCartBtn;

    @FindBy(className = "success-msg")
    private WebElement successAlert;

    @Step("Check price")
    public String getPrice(){
        return price.getText();
    }

    @Step("Set product options")
    public void setItemOptions(String color, String size){
        Select col = new Select(driver.findElement(By.id("attribute92")));
        col.selectByVisibleText(color);

        Select siz = new Select(driver.findElement(By.id("attribute180")));
        siz.selectByVisibleText(size);
    }

    @Step("Add to Cart")
    public void addToCart(){
        addToCartBtn.click();
        successAlert.isDisplayed();
        successAlert.getText().contains("was added to your shopping cart.");
    }

}