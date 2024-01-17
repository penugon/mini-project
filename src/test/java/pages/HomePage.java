package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    @FindBy(className = "movies-list-heading") List<WebElement> headElemnets;
    @FindBy(className = "home-movie-play-button") WebElement logoImage;
    @FindBy(className = "contact-us-paragraph") WebElement contactText;

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getLabelTextAt(int index) {
        return headElemnets.get(index).getText();
    }
    public WebElement findAppLogo() {
        return logoImage;
    }
    public String findcontactText(){
        return contactText.getText();
    }


}