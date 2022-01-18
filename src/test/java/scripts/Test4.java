package scripts;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.ProductSearchPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Test4 {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe" );
        driver = new FirefoxDriver();
        baseUrl = "http://magento-demo.lexiconn.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void close() throws Exception {
        driver.close();
    }

    @Step("Add product to cart")
    @Parameters({"itemParam","priceParam","colorParam","sizeParam"})
    @Test
    public void testAddToCart(String product, String price, String color, String size){
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        ProductSearchPage productSearchPage = homePage.search(product);
        ProductPage productPage = productSearchPage.clickProduct(product);
        assertEquals(productPage.getPrice(), price);
        productPage.setItemOptions(color,size);
        productPage.addToCart();
    }
}
