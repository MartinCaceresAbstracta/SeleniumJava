package scripts;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Test5 {
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

    @Step("Navigate through navBar")
    @Parameters({"womenParam","menParam","accessoriesParam","homeDecorParam","saleParam","vipParam",
            "womenUrlParam","menUrlParam","accessoriesUrlParam","homeDecorUrlParam","saleUrlParam","vipUrlParam"})
    @Test
    public void testValidateUrls(String women, String men, String accesories, String homeDecor, String sale, String vip,
                                 String womenUrl, String menUrl, String accesoriesUrl, String homeDecorUrl, String saleUrl, String vipUrl){
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        homePage.navBar(women);
        assertEquals(homePage.currentUrl(), womenUrl);
        homePage.navBar(men);
        assertEquals(homePage.currentUrl(), menUrl);
        homePage.navBar(accesories);
        assertEquals(homePage.currentUrl(), accesoriesUrl);
        homePage.navBar(homeDecor);
        assertEquals(homePage.currentUrl(), homeDecorUrl);
        homePage.navBar(sale);
        assertEquals(homePage.currentUrl(), saleUrl);
        homePage.navBar(vip);
        assertEquals(homePage.currentUrl(), vipUrl);
    }
}
