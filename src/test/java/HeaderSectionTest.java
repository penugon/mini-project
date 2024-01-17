import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

import java.time.Duration;

public class HeaderSectionTest {
    public WebDriver driver;
    LoginPage loginPage;


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);



        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));


    }

    @Test(priority = 1)
    public void testHeaderSectionUi() {
        WebElement app = driver.findElement(By.className("website-logo"));
        Assert.assertTrue(app.isDisplayed(), "App logo is not displayed");
        WebElement home = driver.findElement(By.xpath("//a[text() ='Home']"));
        home.click();
        WebElement popular = driver.findElement(By.xpath("//a[text() ='Popular']"));
        popular.click();
        WebElement search = driver.findElement(By.className("search-empty-button"));
        search.click();
        driver.navigate().back();
        WebElement account = driver.findElement(By.className("avatar-img"));
        account.click();

    }
    @Test(priority = 2)
    public void testHeaderSectionFunctionlities(){
        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();
        WebElement popular = driver.findElement(By.linkText("Popular"));
        popular.click();
        String expected = "https://qamoviesapp.ccbp.tech/popular";
        String current = driver.getCurrentUrl();
        Assert.assertEquals(expected,current,"URLs do not match");
        WebElement account = driver.findElement(By.className("avatar-img"));
        account.click();
        String expected1 = "https://qamoviesapp.ccbp.tech/account";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(expected1, actual,"URLs do not match");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
