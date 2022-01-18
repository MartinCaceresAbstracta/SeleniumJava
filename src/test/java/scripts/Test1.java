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

public class Test1 {
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

    @Step("Change language")
    @Parameters({"langParam","cartNameParam"})
    @Test
    public void testLanguage(String language , String cartName) throws Exception {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        homePage.setSelectLanguage(language);
        homePage.checkCartName(cartName);
    }
}
