import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);

        homePage = new HomePage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @Test
    public void textHeadingSection() {
        Assert.assertEquals(homePage.getLabelTextAt(0), "Trending Now", " First head text does not match");

        Assert.assertEquals(homePage.getLabelTextAt(1), "Originals", "Second head text does not match");

        Assert.assertTrue(homePage.findAppLogo().isDisplayed(), "App logo image is not displayed");

        Assert.assertEquals(homePage.findcontactText(),"Contact Us","Text doesn't match");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
