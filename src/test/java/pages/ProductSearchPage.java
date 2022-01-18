package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
    private static WebDriver driver;

    ProductSearchPage(WebDriver driver){
        ProductSearchPage.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Click on product")
    public ProductPage clickProduct(String product){
        WebElement productLink=driver.findElement(By.linkText(product));
        productLink.click();
        return new ProductPage(driver);
    }
}