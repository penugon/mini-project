import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLoginPageUI(){

        Assert.assertTrue(loginPage.findLoginAppLogo().isDisplayed(), "App logo image is not displayed");

        Assert.assertEquals(loginPage.getLoginLogo(),"Login","Login head text does not match");

        Assert.assertEquals(loginPage.getLabelTextAt(0), "USERNAME", "Username label text does not match");

        Assert.assertEquals(loginPage.getLabelTextAt(1), "PASSWORD", "Password label text does not match");

        loginPage.clickOnLoginButton();

    }
    @Test(priority = 1)
    public void testLoginWithEmptyInputs() {
        loginPage.clickOnLoginButton();

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid",
                "Error text with empty input fields does not match");
    }

    @Test(priority = 2)
    public void testLoginWithEmptyUsername() {
        loginPage.loginToApplication("", "rahul@2021");

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid",
                "Error text with empty username do not match");
    }
    @Test(priority = 3)
    public void testLoginWithEmptyPassword() {
        loginPage.loginToApplication("rahul", "");

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid",
                "Error text with empty password do not match");
    }

    @Test(priority = 4)
    public void testLoginWithInvalidCreds() {
        loginPage.loginToApplication("rahul", "rahul");

        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "*username and password didn't match",
                "Error text with invalid password do not match");
    }

    @Test(priority = 5)
    public void testLoginWithValidCreds() {
        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");

    }
}
