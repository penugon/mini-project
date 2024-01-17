import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;

public class PopularPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    PopularPage popularPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        popularPage = new PopularPage(driver);


        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @Test
    public void testPopularPageUI(){
        popularPage.clickHomeLink();
        popularPage.clickPopularLink();

        Assert.assertTrue(popularPage.getJobsCount().isDisplayed(), "App logo image is not displayed");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}