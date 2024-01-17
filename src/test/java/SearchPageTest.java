import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PopularPage;
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);


        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @DataProvider
    public Object[][] MovieCountData() {
        return new Object[][] {
                {"Titanic"},
                {"Avatar"},
                {"venom"},
                {"Clifford"}
        };
    }

    @Test(dataProvider = "MovieCountData")
    public void testSearchFunctionality(String searchText){

        searchPage.clickSearchButton();

        searchPage.search(searchText);

        System.out.println(searchPage.getJobsCount());

    }

}