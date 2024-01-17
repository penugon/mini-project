package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    @FindBy(className = "avatar-img") WebElement accountLogo;

    @FindBy(className = "account-heading") WebElement accountHead;

    @FindBy(xpath = "//p[text() ='Member ship']") WebElement memberHead;

    @FindBy(className = "membership-username") WebElement username;

    @FindBy(className ="membership-password") WebElement password;

    @FindBy(xpath = "//p[text() ='Plan details']") WebElement plandetails;

    @FindBy(className = "plan-paragraph") WebElement paragraph;

    @FindBy(className = "plan-details") WebElement details;

    @FindBy(className = "logout-button") WebElement logout;


    WebDriver driver;
    WebDriverWait wait;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void findAccountPage(){
        accountLogo.click();
    }
    public WebElement findAccountHead(){
        return accountHead;
    }
    public WebElement findMemberHead(){
        return memberHead;
    }
    public WebElement findUserName(){
        return username;
    }
    public WebElement findPassWord(){
        return password;
    }
    public WebElement findPlanDetails(){
        return  plandetails;
    }
    public WebElement findPlanParagraph(){
        return paragraph;
    }
    public WebElement findDetails(){
        return  details;
    }
    public void findLogoutButton(){
        logout.click();
    }
}
