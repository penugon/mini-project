package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    @FindBy(className = "search-empty-button") WebElement searchEle;
    @FindBy(id = "search") WebElement searchInputField ;
    @FindBy(className = "search-button") WebElement searchmovie;

    @FindBy(className = "search-movies-container") List<WebElement> movieCount;



    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(13));
    }
    public void enterSearchText(String searchtext) {
        searchInputField.sendKeys(searchtext);
    }
    public int getJobsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-movies-container")));
        return movieCount.size();
    }

    public void clickSearchButton() {
        searchEle.click();
    }
    public void clickSearchMovie(){
        searchmovie.click();
    }
    public void search(String searchText) {
        enterSearchText(searchText);
        clickSearchMovie();
    }


}
