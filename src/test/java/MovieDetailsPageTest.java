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

public class MovieDetailsPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);


        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testHomePageElements(){

        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();

        WebElement poster = driver.findElement(By.className("poster"));
        poster.click();

        WebElement title = driver.findElement(By.className("movie-title"));
        Assert.assertTrue(title.isDisplayed(),"Title element is present");

        WebElement review = driver.findElement(By.className("movie-review-container"));
        Assert.assertTrue(review.isDisplayed(),"Review element is present");

        WebElement overview = driver.findElement(By.className("movie-overview"));
        Assert.assertTrue(overview.isDisplayed(),"Review element is present");

        WebElement playbutton = driver.findElement(By.className("play-button"));
        Assert.assertTrue(playbutton.isDisplayed(),"Review element is present");


    }
    @Test(priority = 2)
    public void testPopularPageElement(){
        WebElement popular = driver.findElement(By.linkText("Popular"));
        popular.click();

        WebElement movie = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/li[4]"));
        movie.click();

        WebElement title = driver.findElement(By.className("movie-title"));
        Assert.assertTrue(title.isDisplayed(),"Title element is present");

        WebElement review = driver.findElement(By.className("movie-review-container"));
        Assert.assertTrue(review.isDisplayed(),"Review element is present");

        WebElement overview = driver.findElement(By.className("movie-overview"));
        Assert.assertTrue(overview.isDisplayed(),"Review element is present");

        WebElement playbutton = driver.findElement(By.className("play-button"));
        Assert.assertTrue(playbutton.isDisplayed(),"Review element is present");

    }

}
