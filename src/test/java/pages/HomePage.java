package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
    private static WebDriver driver;

    public HomePage(WebDriver driver){
        HomePage.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(className = "label")
    private WebElement cartName;

    @FindBy(id = "search")
    private WebElement searchBar;

    @Step("Select promo")
    public void selectPromo(String page){
        WebElement select_currency = driver.findElement(By.cssSelector("[alt='"+page+"']"));
        select_currency.click();
    }

    @Step("Get current Url")
    public String currentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    @Step("Click navBar option")
    public void navBar(String navOption){
        driver.findElement(By.xpath("//*[text()='"+navOption+"']")).click();
    }

    @Step("Select language")
    public void setSelectLanguage(String language){
        Select lang = new Select(driver.findElement(By.id("select-language")));
        lang.selectByVisibleText(language);
    }

    @Step("Validate cart name")
    public void checkCartName(String name){
        cartName.getText().contains(name);
    }

    @Step("Search article in searchBar")
    public ProductSearchPage search(String product){
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductSearchPage(driver);
    }


}