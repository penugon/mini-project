package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class PopularPage {
    @FindBy(linkText = "Home") WebElement homeElement;

    @FindBy(linkText = "Popular") WebElement popularele;

    @FindBy(className = "movie-icon-item") WebElement movieElement;


    WebDriver driver;
    WebDriverWait wait;

    public PopularPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void clickHomeLink() {
        homeElement.click();
    }

    public void clickPopularLink() {
        popularele.click();
    }


    public WebElement getJobsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));
        return movieElement;
    }

}
