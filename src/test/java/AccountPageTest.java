import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);

        accountPage = new AccountPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @Test
    public void testAccountPageUI(){

        accountPage.findAccountPage();

        Assert.assertTrue(accountPage.findAccountHead().isDisplayed(),"Heading element is not present");

        Assert.assertTrue(accountPage.findMemberHead().isDisplayed(),"Member Heading is not present");

        Assert.assertTrue(accountPage.findUserName().isDisplayed(),"UserName element is not present");

        Assert.assertTrue(accountPage.findPassWord().isDisplayed(),"PassWord element is not present");

        Assert.assertTrue(accountPage.findPlanDetails().isDisplayed(),"PlanDetails heading is not present");

        Assert.assertTrue(accountPage.findPlanParagraph().isDisplayed(),"PlanParagram element is not present");

        Assert.assertTrue(accountPage.findDetails().isDisplayed(),"Details element is present");

        accountPage.findLogoutButton();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
